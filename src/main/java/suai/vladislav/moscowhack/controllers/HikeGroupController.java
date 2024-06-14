package suai.vladislav.moscowhack.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.jackson.JsonComponentModule;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import suai.vladislav.moscowhack.ecohack.hike.HikeGroup;
import suai.vladislav.moscowhack.requests.HikeGroupRequest;
import suai.vladislav.moscowhack.requests.HikeInviteOpenGroup;
import suai.vladislav.moscowhack.requests.HikeRequestOpenGroup;
import suai.vladislav.moscowhack.responses.HikeGroupResponse;
import suai.vladislav.moscowhack.responses.StartTimeToAndTimeResponse;
import suai.vladislav.moscowhack.services.HikeGroupService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class HikeGroupController {
    private final HikeGroupService hikeGroupService;

    @PostMapping("/createHikeGroup")
    public ResponseEntity<String> saveHikeGroup(
            @RequestBody HikeGroupRequest request) {
        return ResponseEntity.ok(hikeGroupService.saveHikeGroup(request));
    }

    @PostMapping("/requestHikeGroup")
    public ResponseEntity<String>  requestHikeGroup (
            @RequestBody HikeRequestOpenGroup request
    ) {
        return ResponseEntity.ok(hikeGroupService.requestHikeGroup(request));
    }

    @PostMapping("/inviteHikeGroup")
    public ResponseEntity<String>  inviteHikeGroup (
            @RequestBody HikeInviteOpenGroup request
    ) {
        return ResponseEntity.ok(hikeGroupService.inviteHikeGroup(request));
    }

    private int findGroupsBetweenTimes(LocalDateTime startTime, LocalDateTime endTime, Integer routeId) {
        return hikeGroupService.allMembersCountInThisRouteWithSpecifiedTime(
                hikeGroupService.findGroupsFromStartTimeToEndTime(startTime, endTime, routeId));
    }


    @GetMapping("/allRoutesOnAGivingDateTime")
    public ResponseEntity<StartTimeToAndTimeResponse> allRoutesOnAGivingDateTime (
            @RequestParam Integer routeId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime
    ) {
        StartTimeToAndTimeResponse startTimeToAndTimeResponse = new StartTimeToAndTimeResponse(
                findGroupsBetweenTimes(startTime, startTime.plusHours(1), routeId),
                findGroupsBetweenTimes(startTime.plusHours(1), startTime.plusHours(2), routeId),
                findGroupsBetweenTimes(startTime.plusHours(2), startTime.plusHours(3), routeId),
                findGroupsBetweenTimes(startTime.plusHours(3), startTime.plusHours(4), routeId),
                findGroupsBetweenTimes(startTime.plusHours(4), startTime.plusHours(5), routeId),
                findGroupsBetweenTimes(startTime.plusHours(5), startTime.plusHours(6), routeId),
                findGroupsBetweenTimes(startTime.plusHours(6), startTime.plusHours(7), routeId),
                findGroupsBetweenTimes(startTime.plusHours(7), startTime.plusHours(8), routeId),
                findGroupsBetweenTimes(startTime.plusHours(8), startTime.plusHours(9), routeId),
                findGroupsBetweenTimes(startTime.plusHours(9), startTime.plusHours(10), routeId),
                findGroupsBetweenTimes(startTime.plusHours(10), startTime.plusHours(11), routeId)
        );
        return ResponseEntity.ok(startTimeToAndTimeResponse);
    }

}
