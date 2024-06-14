package suai.vladislav.moscowhack.repositories;

import org.springframework.data.repository.CrudRepository;
import suai.vladislav.moscowhack.ecohack.park.Park;
import suai.vladislav.moscowhack.ecohack.route.Route;

import java.util.ArrayList;
import java.util.Optional;

public interface RouteRepository extends CrudRepository<Route, Long> {
    ArrayList<Route> findAllByIdEquals(Integer id);
    Optional<Route> findById(Integer id);
}
