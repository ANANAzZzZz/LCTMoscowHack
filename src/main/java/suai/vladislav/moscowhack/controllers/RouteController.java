package suai.vladislav.moscowhack.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import suai.vladislav.moscowhack.ecohack.park.Park;
import suai.vladislav.moscowhack.ecohack.route.Route;
import suai.vladislav.moscowhack.services.ParkService;
import suai.vladislav.moscowhack.services.RouteService;

import java.util.ArrayList;

@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class RouteController {
    private final RouteService routeService;

    @GetMapping("/routes")
    public ArrayList<Route> getRoutes() {

        return routeService.getRoutes();
    }

    @GetMapping("/routesByParkId")
    public ArrayList<Route> getParkById(@RequestParam int id) {
        return routeService.getRoutesByParkId(id);
    }
}
