package suai.vladislav.moscowhack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import suai.vladislav.moscowhack.ecohack.incident.IncidentPhoto;
import suai.vladislav.moscowhack.ecohack.park.ParkPhoto;
import suai.vladislav.moscowhack.repositories.IncidentPhotoRepository;
import suai.vladislav.moscowhack.repositories.ParkPhotoRepository;
import suai.vladislav.moscowhack.services.IncidentService;
import suai.vladislav.moscowhack.services.ParkService;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@RequestMapping("/api/v1")
@RestController
public class ImageController {

    @Autowired
    private ParkPhotoRepository parkPhotoRepository;
    @Autowired
    private ParkService parkService;
    @Autowired
    private IncidentService incidentService;
    @Autowired
    private IncidentPhotoRepository incidentPhotoRepository;

    @PostMapping("/uploadParkPhoto")
    public ResponseEntity<String> uploadParkPhoto(
            @RequestParam("image") MultipartFile file,
            @RequestParam("parkId") Integer parkId
    ) {
        try {
            ParkPhoto photo = new ParkPhoto();
            photo.setData(file.getBytes());
            photo.setPark(parkService.getParkById(parkId).orElseThrow());
            parkPhotoRepository.save(photo);
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Failed to upload image");
        }
    }

    @PostMapping("/uploadIncidentPhoto")
    public ResponseEntity<String> uploadIncidentPhoto(
            @RequestParam("image") MultipartFile file,
            @RequestParam("parkId") Integer incidentId
    ) {
        try {
            IncidentPhoto photo = new IncidentPhoto();
            photo.setData(file.getBytes());
            photo.setIncident(incidentService.getIncidentById(incidentId).orElseThrow());
            incidentPhotoRepository.save(photo);
            return ResponseEntity.ok("Image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Failed to upload image");
        }
    }

    @GetMapping("/getParkPhoto/{parkPhotoId}")
    public ResponseEntity<byte[]> getParkPhoto(@PathVariable Integer parkPhotoId) {
        Optional<ParkPhoto> parkPhoto = parkPhotoRepository.findById(parkPhotoId);

        if (parkPhoto.isPresent()) {
            ParkPhoto photo = parkPhoto.get();
            byte[] imageData = photo.getData();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getIncidentPhoto/{incidentPhotoId}")
    public ResponseEntity<byte[]> getIncidentPhoto(@PathVariable Integer incidentPhotoId) {
        Optional<IncidentPhoto> incidentPhoto = incidentPhotoRepository.findById(incidentPhotoId);

        if (incidentPhoto.isPresent()) {
            IncidentPhoto photo = incidentPhoto.get();
            byte[] imageData = photo.getData();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
