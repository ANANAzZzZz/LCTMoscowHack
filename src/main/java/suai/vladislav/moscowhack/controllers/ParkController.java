package suai.vladislav.moscowhack.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import suai.vladislav.moscowhack.ecohack.park.Park;
import suai.vladislav.moscowhack.pojo.Response;
import suai.vladislav.moscowhack.services.ParkService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Optional;


@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class ParkController {
    private final ParkService parkService;

    @GetMapping("/parks")
    public ResponseEntity<ArrayList<Park>> getParks() {
        return ResponseEntity.ok(parkService.getAllParks());
    }

    @GetMapping("/findParkById")
    public Optional<Park> getParkById(@RequestParam int id) {
        return parkService.getParkById(id);
    }

    @GetMapping("/loadParks")
    public void fillParksInDb() {
//        try {
//            HttpResponse httpResponse = callGraphQLService("https://green-button.empedokl.com/api/graphql", "{ areasList { borderColor, color, id, name, points} }");
//            String actualResponse = IOUtils.toString(httpResponse.getEntity().getContent(), StandardCharsets.UTF_8.name());
//            ObjectMapper objectMapper = new ObjectMapper();
//            Response parsedResponse = objectMapper.readValue(actualResponse, Response.class);
//            parkService.savePark(parsedResponse.getData().getAreasList());

//        } catch (URISyntaxException | IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
