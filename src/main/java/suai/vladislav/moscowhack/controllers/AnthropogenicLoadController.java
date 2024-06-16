package suai.vladislav.moscowhack.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import suai.vladislav.moscowhack.ecohack.hike.HikeGroup;
import suai.vladislav.moscowhack.ecohack.route.LengthDayLight;
import suai.vladislav.moscowhack.ecohack.route.Route;
import suai.vladislav.moscowhack.repositories.HikeGroupRepository;
import suai.vladislav.moscowhack.repositories.RouteRepository;
import suai.vladislav.moscowhack.responses.BaseAnthropogenicLoadForMonthResponse;
import suai.vladislav.moscowhack.responses.HikeGroupResponse;
import suai.vladislav.moscowhack.services.AnthropogenicLoadService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class AnthropogenicLoadController {
    private final AnthropogenicLoadService anthropogenicLoadService;
    private final HikeGroupRepository hikeGroupRepository;
    private final RouteRepository routeRepository;

    @GetMapping("/baseAnthropogenicLoadInSpecifiedTime")
    public ResponseEntity<Float> baseAnthropogenicLoadInSpecifiedTime(
            @RequestParam Integer routeId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime
    ) {
        Route route = routeRepository.findById(routeId).orElse(null);
        List<HikeGroup> hikeGroups = hikeGroupRepository.findGroupsSpecifiedTime(localDateTime, routeId);
        if (route == null || hikeGroups.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(
                anthropogenicLoadService
                        .BaseAnthropogenicLoad(
                                route,
                                hikeGroups));
    }

    @GetMapping("/baseAnthropogenicLoadInSpecifiedDay")
    public ResponseEntity<Float> baseAnthropogenicLoadInSpecifiedDay(
            @RequestParam Integer routeId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate
    ) {
        Route route = routeRepository.findById(routeId).orElse(null);
        List<HikeGroup> hikeGroups = hikeGroupRepository.findGroupsSpecifiedDay(localDate, routeId);
        if (route == null || hikeGroups.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(
                anthropogenicLoadService
                        .BaseAnthropogenicLoad(
                                route,
                                hikeGroups));
    }

    @GetMapping("/baseAnthropogenicLoadForLastWeek")
    public ResponseEntity<Float> baseAnthropogenicLoadForLastWeek(
            @RequestParam Integer routeId
    ) {
        Route route = routeRepository.findById(routeId).orElse(null);
        List<HikeGroup> hikeGroups = hikeGroupRepository.findGroupsSpecifiedWeek(
                LocalDate.now().minusDays(7),
                LocalDate.now(),
                routeId);
        if (route == null || hikeGroups.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(
                anthropogenicLoadService
                        .BaseAnthropogenicLoad(
                                route,
                                hikeGroups));
    }

    @GetMapping("/baseAnthropogenicLoadForMonth")
    public ResponseEntity<BaseAnthropogenicLoadForMonthResponse> baseAnthropogenicLoadForMonth(
            @RequestParam Integer routeId,
            @RequestParam Integer monthNumber
    ) {
        Route route = routeRepository.findById(routeId).orElse(null);
        LocalDate currentDate = LocalDate.of(Year.now().getValue(), monthNumber, 1);
        List<HikeGroup> hikeGroupsFirstItem;
        List<HikeGroup> hikeGroupsSecondItem;
        Float medianLoadFirstItem = 0f;
        Float medianLoadSecondItem = 0f;
        Integer hikeGroupMedianValue = 0;
        Integer hikeGroupMainMedianValue = 0;
        Integer HikeGroupMedianValueCurrenMonth = 0;
        List<HikeGroup> hikeGroupForCurrentBCC = hikeGroupRepository.findGroupsSpecifiedMonth(
                currentDate,
                currentDate.plusDays(currentDate.lengthOfMonth()),
                routeId);
        for (HikeGroup hikeGroup : hikeGroupForCurrentBCC) {
            HikeGroupMedianValueCurrenMonth += hikeGroup.getMembersCount();
        }
        HikeGroupMedianValueCurrenMonth /= hikeGroupForCurrentBCC.size();
        assert route != null;
        Integer currentBCC = Math.round(anthropogenicLoadService.BaseAnthropogenicLoadForMonth(
                route,
                hikeGroupForCurrentBCC,
                LengthDayLight.values()[monthNumber - 1],
                currentDate.lengthOfMonth()));

        for (int i = 1; i < 5; i++) {
            hikeGroupsFirstItem = hikeGroupRepository.findGroupsSpecifiedMonth(
                    currentDate.minusYears(i),
                    currentDate.minusYears(i).plusDays(currentDate.lengthOfMonth()),
                    routeId);

            for (HikeGroup hikeGroup : hikeGroupsFirstItem) {
                hikeGroupMedianValue += hikeGroup.getMembersCount();
            }
            hikeGroupMedianValue = hikeGroupMedianValue / hikeGroupsFirstItem.size();
            hikeGroupMainMedianValue += hikeGroupMedianValue;
            hikeGroupsSecondItem = hikeGroupRepository.findGroupsSpecifiedMonth(
                    currentDate.minusYears(i).plusMonths(1),
                    currentDate.minusYears(i).plusMonths(1).plusDays(currentDate.lengthOfMonth()),
                    routeId);
            if (hikeGroupsFirstItem.isEmpty() || hikeGroupsSecondItem.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            medianLoadFirstItem += anthropogenicLoadService.BaseAnthropogenicLoadForMonth(
                    route,
                    hikeGroupsFirstItem,
                    LengthDayLight.values()[monthNumber - 1],
                    currentDate.lengthOfMonth());

            medianLoadSecondItem += anthropogenicLoadService.BaseAnthropogenicLoadForMonth(
                    route,
                    hikeGroupsSecondItem,
                    LengthDayLight.values()[monthNumber],
                    currentDate.plusMonths(1).lengthOfMonth());
        }
        Integer periodChangeBCC = Math.abs((int) (((medianLoadFirstItem/5) - (medianLoadSecondItem/5))/2));
        BaseAnthropogenicLoadForMonthResponse response = new BaseAnthropogenicLoadForMonthResponse(
                route.getLength(),
                routeRepository.findById(routeId).orElseThrow().getOptimalDistanceBetweenGroups(),
                Math.abs(LengthDayLight.values()[monthNumber - 1].length - LengthDayLight.values()[monthNumber].length),
                1
                ,Math.abs(((hikeGroupMainMedianValue/5) - HikeGroupMedianValueCurrenMonth)/2),
                currentDate.lengthOfMonth(),
                currentBCC,
                periodChangeBCC
        );
        return ResponseEntity.ok(response);
    }
}
