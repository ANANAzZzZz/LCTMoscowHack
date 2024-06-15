package suai.vladislav.moscowhack.repositories;

import org.springframework.data.repository.CrudRepository;
import suai.vladislav.moscowhack.ecohack.incident.IncidentSource;

import java.util.Optional;

public interface IncidentSourceRepository extends CrudRepository<IncidentSource, Integer> {
    @Override
    Optional<IncidentSource> findById(Integer id);
}
