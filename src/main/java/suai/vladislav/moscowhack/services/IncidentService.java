package suai.vladislav.moscowhack.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import suai.vladislav.moscowhack.ecohack.incident.Incident;
import suai.vladislav.moscowhack.ecohack.incident.IncidentPhoto;
import suai.vladislav.moscowhack.ecohack.incident.IncidentType;
import suai.vladislav.moscowhack.ecohack.incident.ThreatDegree;
import suai.vladislav.moscowhack.repositories.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class IncidentService {
    private final ThreadRepository threadRepository;
    private final IncidentRepository incidentRepository;
    private final IncidentSourceRepository incidentSourceRepository;
    private final IncidentTypeRepository incidentTypeRepository;
    private final IncidentPhotoRepository incidentPhotoRepository;

    public Optional<Incident> getIncidentById(Integer id) {
        return incidentRepository.findById(id);
    }

    public ArrayList<Incident> getIncidents() {
        return (ArrayList<Incident>) incidentRepository.findAll();
    }

    public Optional<Incident> saveIncident(List<MultipartFile> file,
                                           Integer incidentTypeId,
                                           Integer threadDegreeId,
                                           Integer sourceId,
                                           String comment,
                                           Float latitude,
                                           Float longitude
    ) {
        Incident incident = new Incident(
                incidentSourceRepository.findById(sourceId),
                threadRepository.findById(threadDegreeId),
                incidentTypeRepository.findById(incidentTypeId),
                latitude,
                longitude,
                comment
        );
        try {
            incident = incidentRepository.save(incident);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        for (MultipartFile multipartFile : file) {
            IncidentPhoto photo = new IncidentPhoto();
            try {
                photo.setData(multipartFile.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            photo.setIncident(incidentRepository.findById(incident.getId()).orElseThrow());
            incidentPhotoRepository.save(photo);
        }
        return incidentRepository.findById(incident.getId());
    }

    public ArrayList<IncidentType> getIncidentTypes() {
        return (ArrayList<IncidentType>) incidentTypeRepository.findAll();
    }

    public ArrayList<ThreatDegree> getThreatDegrees() {
        return (ArrayList<ThreatDegree>) threadRepository.findAll();
    }

    public List<Integer> getIncidentPhotoIdsByIncidentId(Integer incidentId) {
        List<Integer> incidentPhotosIds = incidentPhotoRepository.getIncidentPhotoIdsByIncidentId(incidentId);
        return incidentPhotosIds;
    }
}
