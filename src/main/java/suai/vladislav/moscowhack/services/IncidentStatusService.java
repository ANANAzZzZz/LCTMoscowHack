package suai.vladislav.moscowhack.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import suai.vladislav.moscowhack.ecohack.incident.Incident;
import suai.vladislav.moscowhack.ecohack.incident.IncidentStatus;
import suai.vladislav.moscowhack.ecohack.incident.IncidentStatusXIncident;
import suai.vladislav.moscowhack.ecohack.user.User;
import suai.vladislav.moscowhack.ecohack.user.UserRepository;
import suai.vladislav.moscowhack.repositories.IncidentRepository;
import suai.vladislav.moscowhack.repositories.IncidentStatusRepository;
import suai.vladislav.moscowhack.repositories.IncidentStatusXIncidentRepository;
import suai.vladislav.moscowhack.requests.IncidentCrossUserRequest;
import suai.vladislav.moscowhack.requests.IncidentStatusRequest;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class IncidentStatusService {
    private final IncidentStatusRepository incidentStatusRepository;
    private final UserRepository userRepository;
    private final IncidentStatusXIncidentRepository incidentStatusXIncidentRepository;
    private final IncidentRepository incidentRepository;

    public String saveIncidentStatus(IncidentStatusRequest incidentStatusRequest) {
        IncidentStatus incidentStatus = (new IncidentStatus(
                incidentStatusRequest.getTitle(),
                incidentStatusRequest.getDescription(),
                userRepository.findById(incidentStatusRequest.getEmployeeId())
        ));

        try {
            int incidentStatusId = saveIncidentStatus(incidentStatus);

            IncidentStatusXIncident incidentStatusXIncident = new IncidentStatusXIncident(
                    incidentStatusRepository.findById(incidentStatusId),
                    incidentRepository.findById(incidentStatusRequest.getIncidentId())
            );
            incidentStatusXIncidentRepository.save(incidentStatusXIncident);

            return "Incident status successfully added";
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "Error while saving Incident status";
    }

    public int saveIncidentStatus(IncidentStatus incidentStatus) {
        incidentStatusRepository.save(incidentStatus);
        return incidentStatus.getId();
    }

    public String saveEmployeeXIncident(IncidentCrossUserRequest request) {
//        IncidentCrossUser incidentCrossUser = new IncidentCrossUser(
//                userRepository.findById(request.getEmployeeId()),
//                incidentRepository.findById(request.getIncidentId())
//        );
        try {
            Optional<User> user = userRepository.findById(request.getEmployeeId());
            Optional<Incident> incident = incidentRepository.findById( request.getIncidentId());

            incident.get().getUser().add(user.get());

            incidentRepository.save(incident.get());

//            System.out.println(userRepository.save(user.get()));

            return "Employee successfully assigned to Incident";
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "Error assigning employee to Incident";
    }
}
