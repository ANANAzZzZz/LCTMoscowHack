package suai.vladislav.moscowhack.repositories;

import org.springframework.data.repository.CrudRepository;
import suai.vladislav.moscowhack.ecohack.incident.IncidentType;

import java.util.Optional;

public interface IncidentTypeRepository extends CrudRepository<IncidentType, Integer> {
    @Override
    Optional<IncidentType> findById(Integer id);
}
