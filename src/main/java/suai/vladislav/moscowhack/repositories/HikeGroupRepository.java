package suai.vladislav.moscowhack.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import suai.vladislav.moscowhack.ecohack.hike.HikeGroup;
import suai.vladislav.moscowhack.responses.HikeGroupResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface HikeGroupRepository extends CrudRepository<HikeGroup, Integer> {
    List<HikeGroup> findByRouteIdAndStartTime(Integer routeId, LocalDateTime startTime);

    @Query(nativeQuery=true, value="SELECT hike_group.members_count FROM hike_group WHERE route_id = ?3 " +
            "AND ((start_time >= ?1 OR end_time >= ?2) " +
            "AND (start_time <= ?1 OR end_time <= ?2)) ")
    List<Integer> findGroupsFromStartTimeToEndTime(LocalDateTime start_time, LocalDateTime end_time, Integer route_id);

    @Query(nativeQuery=true, value="SELECT * FROM hike_group WHERE route_id = ?2 " +
            "AND (start_time <= ?1 OR end_time >= ?1) ")
    List<HikeGroup> findGroupsSpecifiedTime(LocalDateTime specifiedTime, Integer route_id);

    @Query(nativeQuery=true, value="SELECT * FROM hike_group WHERE route_id = ?2 " +
            "AND (start_time <= ?1 OR end_time >= ?1) ")
    List<HikeGroup> findGroupsSpecifiedDay(LocalDate specifiedDay, Integer route_id);

    @Query(nativeQuery=true, value="SELECT * FROM hike_group WHERE route_id = ?3 " +
            "AND ((start_time >= ?1 OR end_time >= ?2) " +
            "AND (start_time <= ?1 OR end_time <= ?2)) ")
    List<HikeGroup> findGroupsSpecifiedWeek(LocalDate startWeekDay, LocalDate currentDay, Integer route_id);

    @Query(nativeQuery=true, value="SELECT * FROM hike_group WHERE route_id = ?3 " +
            "AND ((start_time >= ?1 OR end_time >= ?2) " +
            "AND (start_time <= ?1 OR end_time <= ?2)) ")
    List<HikeGroup> findGroupsSpecifiedMonth(LocalDate startWeekDay, LocalDate currentDay, Integer route_id);

    List<HikeGroup> findAllByRouteId(Integer routeId);
}
