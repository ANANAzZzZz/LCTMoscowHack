package suai.vladislav.moscowhack.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import suai.vladislav.moscowhack.ecohack.incident.IncidentPhoto;

import java.util.List;

public interface IncidentPhotoRepository extends CrudRepository<IncidentPhoto, Integer> {


    @Query(nativeQuery=true, value="SELECT incident_photo.id FROM incident_photo WHERE incidentid = ?1 ")
    List<Integer> getIncidentPhotoIdsByIncidentId(Integer incidentId);
}
