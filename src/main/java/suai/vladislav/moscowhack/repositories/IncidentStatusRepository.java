package suai.vladislav.moscowhack.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import suai.vladislav.moscowhack.ecohack.incident.IncidentStatus;

import java.util.Optional;


public interface IncidentStatusRepository extends CrudRepository<IncidentStatus, Integer> {
    public Optional<IncidentStatus> findById(int id);
}
