package suai.vladislav.moscowhack.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import suai.vladislav.moscowhack.ecohack.hike.HikeGroup;
import suai.vladislav.moscowhack.ecohack.route.Route;
import suai.vladislav.moscowhack.repositories.HikeGroupRepository;
import suai.vladislav.moscowhack.repositories.RouteRepository;
import suai.vladislav.moscowhack.services.AnthropogenicLoadService;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
}
