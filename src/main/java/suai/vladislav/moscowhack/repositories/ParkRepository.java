package suai.vladislav.moscowhack.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import suai.vladislav.moscowhack.ecohack.park.Park;
import suai.vladislav.moscowhack.ecohack.route.Route;

import java.util.ArrayList;
import java.util.Optional;

public interface ParkRepository extends CrudRepository<Park, Integer> {
    Optional<Park> findById(Integer id);
}
