package suai.vladislav.moscowhack.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import suai.vladislav.moscowhack.ecohack.park.Park;
import suai.vladislav.moscowhack.repositories.ParkRepository;

import java.util.ArrayList;

@Service
@Slf4j
@RequiredArgsConstructor

public class ParkService {
    private final ParkRepository parkRepository;

    public ArrayList<Park> getAllParks() {
        return (ArrayList<Park>) parkRepository.findAll();
    }
}