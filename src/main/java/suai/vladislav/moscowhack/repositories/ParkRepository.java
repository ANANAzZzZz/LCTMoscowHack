package suai.vladislav.moscowhack.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import suai.vladislav.moscowhack.ecohack.park.Park;
import suai.vladislav.moscowhack.ecohack.route.Route;

import java.util.ArrayList;

public interface ParkRepository extends CrudRepository<Park, Long> {
    ArrayList<Park> findAllByIdEquals(Integer id);
}
