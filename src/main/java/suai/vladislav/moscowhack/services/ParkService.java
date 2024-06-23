package suai.vladislav.moscowhack.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import suai.vladislav.moscowhack.ecohack.park.Park;
import suai.vladislav.moscowhack.repositories.ParkPhotoRepository;
import suai.vladislav.moscowhack.repositories.ParkRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor

public class ParkService {
    private final ParkRepository parkRepository;
    private final ParkPhotoRepository parkPhotoRepository;

    public ArrayList<Park> getAllParks() {
        return (ArrayList<Park>) parkRepository.findAll();
    }

    public Optional<Park> getParkById(Integer id) {
        return parkRepository.findById(id);
    }

    public void savePark(List<Park> park) {
        parkRepository.saveAll(park);
    }

    public List<Integer> getParkPhotoIdByParkId(Integer parkId) {
        List<Integer> parkPhotosIds = parkPhotoRepository.findByParkId(parkId);
        return parkPhotosIds;
    }
}