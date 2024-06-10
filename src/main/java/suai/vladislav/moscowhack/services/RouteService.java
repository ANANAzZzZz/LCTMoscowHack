package suai.vladislav.moscowhack.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import suai.vladislav.moscowhack.ecohack.route.Route;
import suai.vladislav.moscowhack.repositories.RouteRepository;

import java.util.ArrayList;

@Service
@Slf4j
@RequiredArgsConstructor
public class RouteService {
    private final RouteRepository routeRepository;

    public ArrayList<Route> getRoutes() {
        return (ArrayList<Route>) routeRepository.findAll();
    }

    public ArrayList<Route> getRoutesByParkId(Integer id) {
        return (ArrayList<Route>) routeRepository.findAllByIdEquals(id);
    }
}