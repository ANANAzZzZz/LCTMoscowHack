package suai.vladislav.moscowhack.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import suai.vladislav.moscowhack.ecohack.park.Park;
import suai.vladislav.moscowhack.ecohack.route.Route;
import suai.vladislav.moscowhack.ecohack.route.RouteInformation;
import suai.vladislav.moscowhack.repositories.RouteInformationRepository;
import suai.vladislav.moscowhack.repositories.RouteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RouteService {
    private final RouteRepository routeRepository;
    private final RouteInformationRepository routeInformationRepository;

    public ArrayList<Route> getRoutes() {
        return (ArrayList<Route>) routeRepository.findAll();
    }

    public ArrayList<Route> getRoutesByParkId(Integer id) {
        return (ArrayList<Route>) routeRepository.findAllByIdEquals(id);
    }

    public void saveRoute(List<Route> routes) {
        routeRepository.saveAll(routes);
    }

//    public RouteInformation getRouteInformationById(Integer id) {
//        return routeRepository.findById(id).get().getRouteInformation();
//    }
}