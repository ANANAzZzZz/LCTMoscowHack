package suai.vladislav.moscowhack.repositories;

import org.springframework.data.repository.CrudRepository;
import suai.vladislav.moscowhack.ecohack.park.Park;

public interface ParkRepository extends CrudRepository<Park, Long> {
}
