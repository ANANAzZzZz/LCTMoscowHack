package suai.vladislav.moscowhack.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import suai.vladislav.moscowhack.ecohack.park.Park;
import suai.vladislav.moscowhack.ecohack.route.Area;
import suai.vladislav.moscowhack.ecohack.route.Route;
import suai.vladislav.moscowhack.repositories.AreaRepository;
import suai.vladislav.moscowhack.repositories.RouteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AreaService {
    private final AreaRepository areaRepository;

    public ArrayList<Area> getAreas() {
        return (ArrayList<Area>) areaRepository.findAll();
    }

//    public ArrayList<Route> getRoutesByParkId(Integer id) {
//        return (ArrayList<Route>) routeRepository.findAllByIdEquals(id);
//    }

    public void saveArea(Area areas) {
        areaRepository.save(areas);
    }
}