package suai.vladislav.moscowhack.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import suai.vladislav.moscowhack.ecohack.park.Park;
import suai.vladislav.moscowhack.services.ParkService;

import java.util.ArrayList;

@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class ParkController {
    private final ParkService parkService;

    @GetMapping("/parks")
    public ArrayList<Park> getParks() {
        return parkService.getAllParks();
    }
}
