package suai.vladislav.moscowhack.repositories;

import org.springframework.data.repository.CrudRepository;
import suai.vladislav.moscowhack.ecohack.incident.ThreatDegree;

import java.util.Optional;

public interface ThreadRepository extends CrudRepository<ThreatDegree, Integer> {
    Optional<ThreatDegree> findById(Integer id);
}
