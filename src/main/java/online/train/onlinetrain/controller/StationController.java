package online.train.onlinetrain.controller;

import online.train.onlinetrain.dao.model.Station;
import online.train.onlinetrain.dao.model.TrainClass;
import online.train.onlinetrain.dto.response.TrainClassResponse;
import online.train.onlinetrain.service.StationService;
import online.train.onlinetrain.service.TrainClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/station")
public class StationController {


    @Autowired
    private StationService stationService;



    @PostMapping("/addstation")
    public ResponseEntity<?> saveTrainClasses(@RequestBody Station station) {
        Station savedStation = stationService.addStation(station);
        return new ResponseEntity<>(savedStation, HttpStatus.CREATED);

    }
}