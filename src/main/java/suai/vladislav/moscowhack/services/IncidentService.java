package suai.vladislav.moscowhack.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import suai.vladislav.moscowhack.ecohack.incident.Incident;
import suai.vladislav.moscowhack.ecohack.park.Park;
import suai.vladislav.moscowhack.repositories.IncidentRepository;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class IncidentService {
    private final IncidentRepository incidentRepository;

    public Optional<Incident> getIncidentById(Integer id) {
        return incidentRepository.findById(id);
    }
}
