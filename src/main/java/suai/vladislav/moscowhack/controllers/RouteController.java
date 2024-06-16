package suai.vladislav.moscowhack.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import suai.vladislav.moscowhack.ecohack.route.Route;
import suai.vladislav.moscowhack.ecohack.route.RouteInformation;
import suai.vladislav.moscowhack.pojo.Response;
import suai.vladislav.moscowhack.services.RouteService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import static suai.vladislav.moscowhack.GraphQLCaller.callGraphQLService;

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

    @GetMapping("/routeInformationById")
    public RouteInformation routeInformationById(@RequestParam int id) {
        return routeService.getRouteInformationById(id);
    }

//    @GetMapping("/loadRoutes")
//    public void fillRoutes() {
//        try {
//            HttpResponse httpResponse = callGraphQLService("https://green-button.empedokl.com/api/graphql", "query { tracksListByPark(id: \"638f25e2400559793e2ddc80\") { color description id name onMap paths} }");
//            String actualResponse = IOUtils.toString(httpResponse.getEntity().getContent(), StandardCharsets.UTF_8.name());
//            ObjectMapper objectMapper = new ObjectMapper();
//            Response parsedResponse = objectMapper.readValue(actualResponse, Response.class);
//            routeService.saveRoute(parsedResponse.getData().getTracksListByPark());
//
//        } catch (URISyntaxException | IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
