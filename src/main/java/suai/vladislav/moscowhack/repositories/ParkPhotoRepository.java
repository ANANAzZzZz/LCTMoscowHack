package suai.vladislav.moscowhack.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import suai.vladislav.moscowhack.ecohack.park.ParkPhoto;

import java.util.List;

public interface ParkPhotoRepository extends CrudRepository<ParkPhoto, Integer> {

    @Query(nativeQuery=true, value="SELECT park_photo.id FROM park_photo WHERE parkid = ?1 ")
    List<Integer> getParkPhotoIdsByParkId(Integer parkId);
}
