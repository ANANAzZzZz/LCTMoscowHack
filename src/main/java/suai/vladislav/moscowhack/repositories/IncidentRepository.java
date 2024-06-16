package suai.vladislav.moscowhack.repositories;

import org.springframework.data.repository.CrudRepository;
import suai.vladislav.moscowhack.ecohack.incident.Incident;

import java.util.Optional;

public interface IncidentRepository extends CrudRepository<Incident, Integer> {
    public Optional<Incident> findById(int id);
}
