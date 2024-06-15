package suai.vladislav.moscowhack.repositories;

import org.springframework.data.repository.CrudRepository;
import suai.vladislav.moscowhack.ecohack.incident.Incident;

public interface IncidentRepository extends CrudRepository<Incident, Integer> {
}
