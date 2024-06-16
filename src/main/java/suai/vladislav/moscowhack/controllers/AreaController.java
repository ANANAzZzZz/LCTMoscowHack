package suai.vladislav.moscowhack.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import suai.vladislav.moscowhack.ecohack.route.Area;
import suai.vladislav.moscowhack.services.AreaService;

import java.util.ArrayList;


@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class AreaController {
    private final AreaService areaService;

    @GetMapping("/areas")
    public ResponseEntity<ArrayList<Area>> getAreas() {
        return ResponseEntity.ok(areaService.getAreas());
    }
}
