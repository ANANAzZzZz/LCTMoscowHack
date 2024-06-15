package suai.vladislav.moscowhack.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import suai.vladislav.moscowhack.ecohack.incident.Incident;
import suai.vladislav.moscowhack.repositories.IncidentRepository;
import suai.vladislav.moscowhack.repositories.IncidentSourceRepository;
import suai.vladislav.moscowhack.repositories.IncidentTypeRepository;
import suai.vladislav.moscowhack.repositories.ThreadRepository;
import suai.vladislav.moscowhack.requests.IncidentRequest;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class IncidentService {
    private final ThreadRepository threadRepository;
    private final IncidentRepository incidentRepository;
    private final IncidentSourceRepository incidentSourceRepository;
    private final IncidentTypeRepository incidentTypeRepository;

    public Optional<Incident> getIncidentById(Integer id) {
        return incidentRepository.findById(id);
    }

    public ArrayList<Incident> getIncidents() {
        return (ArrayList<Incident>) incidentRepository.findAll();
    }

    public String saveIncident(IncidentRequest incidentRequest) {
        Incident incident = incidentRepository.save(new Incident(
                        incidentSourceRepository.findById(incidentRequest.getSourceId()),
                        threadRepository.findById(incidentRequest.getThreadDegreeId()),
                        incidentTypeRepository.findById(incidentRequest.getIncidentTypeId()),
                        incidentRequest.getLatitude(),
                        incidentRequest.getLongitude(),
                        incidentRequest.getComment()
                )
        );

        try {
            incidentRepository.save(incident);
            return "Incident successfully added";
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "Error while saving Incident";
    }

}
