package online.train.onlinetrain.service;

import online.train.onlinetrain.dao.model.Station;
import online.train.onlinetrain.dao.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class StationServiceImpl implements StationService{

    @Autowired
    private StationRepository stationRepository;

    public Station addStation(Station station){
        Station addStation = Station.builder()
                .stationName(station.getStationName())
                .build();
        return stationRepository.save(addStation);
    }
}
