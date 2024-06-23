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
import java.util.List;
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
    @GetMapping("/getParkPhotoIdsByParkId")
    public ResponseEntity<List<Integer>> getParkPhotoIdsByParkId(@RequestParam Integer parkId) {
        return ResponseEntity.ok(parkService.getParkPhotoIdsByParkId(parkId));
    }
}
