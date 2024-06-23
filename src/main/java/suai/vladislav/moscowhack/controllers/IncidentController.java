package suai.vladislav.moscowhack.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import suai.vladislav.moscowhack.ecohack.incident.Incident;
import suai.vladislav.moscowhack.ecohack.incident.IncidentType;
import suai.vladislav.moscowhack.ecohack.incident.ThreatDegree;
import suai.vladislav.moscowhack.requests.IncidentCrossUserRequest;
import suai.vladislav.moscowhack.requests.IncidentRequest;
import suai.vladislav.moscowhack.requests.IncidentStatusRequest;
import suai.vladislav.moscowhack.services.IncidentService;
import suai.vladislav.moscowhack.services.IncidentStatusService;

import java.util.ArrayList;

@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class IncidentController {
    private final IncidentService incidentService;
    private final IncidentStatusService incidentStatusService;

    @GetMapping("/incidents")
    public ArrayList<Incident> getIncidents() {
        return incidentService.getIncidents();
    }

    @PostMapping("/addIncident")
    public Incident addIncident(@RequestBody IncidentRequest request) {
        return incidentService.saveIncident(request);
    }

    @PostMapping("/updateIncidentStatus")
    public ResponseEntity<String> updateIncidentStatus(@RequestBody IncidentStatusRequest request) {
        return ResponseEntity.ok(incidentStatusService.saveIncidentStatus(request));
    }

    @PostMapping("/assignEmployeeToSolveIncident")
    public ResponseEntity<String> assignEmployeeToSolveIncident(@RequestBody IncidentCrossUserRequest request) {
        return ResponseEntity.ok(incidentStatusService.saveEmployeeXIncident(request));
    }

    @GetMapping("/incidentTypes")
    public ArrayList<IncidentType> getIncidentTypes() {
        return incidentService.getIncidentTypes();
    }

    @GetMapping("/threatDegrees")
    public ArrayList<ThreatDegree> getThreatDegrees() {
        return incidentService.getThreatDegrees();
    }
}
