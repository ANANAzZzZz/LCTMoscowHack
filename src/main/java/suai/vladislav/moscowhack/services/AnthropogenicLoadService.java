package suai.vladislav.moscowhack.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import suai.vladislav.moscowhack.ecohack.hike.HikeGroup;
import suai.vladislav.moscowhack.ecohack.route.Route;

import java.time.Duration;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AnthropogenicLoadService {

    public Float averageRouteTravelTime(List<HikeGroup> groups) {
        Duration duration;
        int hours = 0;
        for(HikeGroup group : groups ) {
            duration = Duration.between(group.getStartTime(), group.getEndTime());
            hours += duration.toHoursPart();
        }
        System.out.println(hours);
        System.out.println(hours/groups.size());
        return (float) (hours/groups.size());
    }

    public Float averageCountMembersInHikeGroups(List<HikeGroup> groups) {
        int allMembersInGroups = 0;
        for(HikeGroup group : groups ) {
            allMembersInGroups += group.getMembersCount();
        }
        System.out.println(allMembersInGroups);
        System.out.println(allMembersInGroups/groups.size());
        return (float) (allMembersInGroups/groups.size());
    }

    public Float BaseAnthropogenicLoad(Route route, List<HikeGroup> hikeGroups) {
        return (
                (route.getLength()/ route.getOptimalDistanceBetweenGroups())
                        * (24/averageRouteTravelTime(hikeGroups))
                        * averageCountMembersInHikeGroups(hikeGroups));
    }
}
