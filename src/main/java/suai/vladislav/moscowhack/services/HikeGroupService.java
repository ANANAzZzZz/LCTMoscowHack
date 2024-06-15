package suai.vladislav.moscowhack.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suai.vladislav.moscowhack.ecohack.hike.HikeGroup;
import suai.vladislav.moscowhack.ecohack.hike.HikeGroupXUser;
import suai.vladislav.moscowhack.ecohack.hike.HikeInvite;
import suai.vladislav.moscowhack.ecohack.hike.HikeRequest;
import suai.vladislav.moscowhack.ecohack.user.UserRepository;
import suai.vladislav.moscowhack.repositories.*;
import suai.vladislav.moscowhack.requests.HikeGroupRequest;
import suai.vladislav.moscowhack.requests.HikeGroupXUserRequest;
import suai.vladislav.moscowhack.requests.HikeInviteOpenGroup;
import suai.vladislav.moscowhack.requests.HikeRequestOpenGroup;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j

public class HikeGroupService {
    private final HikeGroupRepository hikeGroupRepository;
    private final UserRepository userRepository;
    private final RouteRepository routeRepository;
    private final HikeRequestRepository hikeRequestRepository;
    private final HikeInviteOpenGroupRepository hikeInviteOpenGroupRepository;
    private final HikeGroupXUserRepository hikeGroupXUserRepository;

    @Autowired
    public HikeGroupService(HikeGroupRepository hikeGroupRepository, UserRepository userRepository, RouteRepository routeRepository, HikeRequestRepository hikeRequestRepository, HikeInviteOpenGroupRepository hikeInviteOpenGroupRepository, HikeGroupXUserRepository hikeGroupXUserRepository) {
        this.hikeGroupRepository = hikeGroupRepository;
        this.userRepository = userRepository;
        this.routeRepository = routeRepository;
        this.hikeRequestRepository = hikeRequestRepository;
        this.hikeInviteOpenGroupRepository = hikeInviteOpenGroupRepository;
        this.hikeGroupXUserRepository = hikeGroupXUserRepository;
    }

    public String saveHikeGroup(HikeGroupRequest hikeGroupRequest) {
        HikeGroup hikeGroup = new HikeGroup(
                hikeGroupRequest.getMembersCount(),
                hikeGroupRequest.getStartTime(),
                hikeGroupRequest.getEndTime(),
                hikeGroupRequest.getIsPrivate(),
                hikeGroupRequest.getPassword(),
                userRepository.findById(hikeGroupRequest.getCreatorId()),
                routeRepository.findById(hikeGroupRequest.getRouteId()));
        try {
            hikeGroupRepository.save(hikeGroup);
            return "HikeGroup saved";
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "HikeGroup not saved";
    }

    public String requestHikeGroup(HikeRequestOpenGroup hikeRequestOpenGroup) {
        HikeRequest hikeRequest = new HikeRequest(
                userRepository.findById(hikeRequestOpenGroup.getUserId()),
                userRepository.findById(hikeRequestOpenGroup.getCreatorId()),
                hikeGroupRepository.findById(hikeRequestOpenGroup.getHikeGroupId()));
        try {
            hikeRequestRepository.save(hikeRequest);
            return "HikeRequest was created";
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "HikeRequest was not created";
    }

    public String inviteHikeGroup(HikeInviteOpenGroup hikeInviteOpenGroup) {
        HikeInvite hikeInvite = new HikeInvite(
                userRepository.findById(hikeInviteOpenGroup.getUserId()),
                userRepository.findById(hikeInviteOpenGroup.getCreatorId()),
                hikeGroupRepository.findById(hikeInviteOpenGroup.getHikeGroupId()));
        try {
            hikeInviteOpenGroupRepository.save(hikeInvite);
            return "HikeInvite was created";
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "HikeInvite was not created";
    }

    public List<Integer> findGroupsFromStartTimeToEndTime
            (
                    LocalDateTime startTime,
                    LocalDateTime endTime,
                    Integer routeId
            ) {
        return hikeGroupRepository.findGroupsFromStartTimeToEndTime(startTime, endTime, routeId);
    }

    public Integer allMembersCountInThisRouteWithSpecifiedTime(List<Integer> times) {
        int allMembersCountInThisRouteWithSpecifiedTime = 0;
        for (Integer time : times) {
            allMembersCountInThisRouteWithSpecifiedTime += time;
        }
        return allMembersCountInThisRouteWithSpecifiedTime;
    }


    public String addUserInHikeGroup(HikeGroupXUserRequest request) {
        HikeGroupXUser hikeGroupXUser = new HikeGroupXUser(
                hikeGroupRepository.findById(request.getHikeGroupId()),
                userRepository.findById(request.getUserId())
        );
        try {
            hikeGroupXUserRepository.save(hikeGroupXUser);
            return "HikeGroupXUser was created";
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "HikeGroupXUser was not created";
    }

}
