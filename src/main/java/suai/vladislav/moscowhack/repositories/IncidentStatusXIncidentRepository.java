package suai.vladislav.moscowhack.repositories;

import org.springframework.data.repository.CrudRepository;
import suai.vladislav.moscowhack.ecohack.incident.IncidentStatusXIncident;

import java.util.Optional;

public interface IncidentStatusXIncidentRepository extends CrudRepository<IncidentStatusXIncident, Integer> {
    public Optional<IncidentStatusXIncident> findById(int id);
}
