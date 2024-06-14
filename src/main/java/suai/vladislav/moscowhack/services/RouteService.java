package suai.vladislav.moscowhack.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import suai.vladislav.moscowhack.ecohack.route.Route;
import suai.vladislav.moscowhack.ecohack.route.RouteInformation;
import suai.vladislav.moscowhack.ecohack.route.RouteTime;
import suai.vladislav.moscowhack.repositories.RouteInformationRepository;
import suai.vladislav.moscowhack.repositories.RouteRepository;
import suai.vladislav.moscowhack.repositories.RouteTimeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RouteService {
    private final RouteRepository routeRepository;
    private final RouteInformationRepository routeInformationRepository;
    private final RouteTimeRepository routeTimeRepository;

    public ArrayList<Route> getRoutes() {
        return (ArrayList<Route>) routeRepository.findAll();
    }

    public ArrayList<Route> getRoutesByParkId(Integer id) {
        return routeRepository.findAllByIdEquals(id);
    }

}