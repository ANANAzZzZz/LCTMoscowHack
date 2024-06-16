package suai.vladislav.moscowhack.repositories;

import org.springframework.data.repository.CrudRepository;
import suai.vladislav.moscowhack.ecohack.route.RouteInformation;

public interface RouteInformationRepository extends CrudRepository<RouteInformation, Integer> {
    RouteInformation findById(int id);
}
