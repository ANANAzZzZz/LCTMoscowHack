package suai.vladislav.moscowhack.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import suai.vladislav.moscowhack.ecohack.park.Park;
import suai.vladislav.moscowhack.ecohack.route.Area;
import suai.vladislav.moscowhack.pojo.Response;
import suai.vladislav.moscowhack.services.AreaService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static suai.vladislav.moscowhack.GraphQLCaller.callGraphQLService;

@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class AreaController {
    private final AreaService areaService;

//    @GetMapping("/loadAreas")
//    public void fillRoutes() {
//        try {
//            HttpResponse httpResponse = callGraphQLService("https://green-button.empedokl.com/api/graphql", "query { parkInfo(id: \"638f25e2400559793e2ddc80\") { cuts { id name pos text }defaultCoord defaultZoom description geometry id image name pos price purposeOfVisit subname ticketName } }");
//            String actualResponse = IOUtils.toString(httpResponse.getEntity().getContent(), StandardCharsets.UTF_8.name());
//            ObjectMapper objectMapper = new ObjectMapper();
//            Response parsedResponse = objectMapper.readValue(actualResponse, Response.class);
//            areaService.saveArea(parsedResponse.getData().getParkInfo());
//
//        } catch (URISyntaxException | IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @GetMapping("/areas")
    public ResponseEntity<ArrayList<Area>> getAreas() {
        return ResponseEntity.ok(areaService.getAreas());
    }
}
