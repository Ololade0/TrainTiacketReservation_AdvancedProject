package online.train.onlinetrain.controller;
import online.train.onlinetrain.service.DistanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class DistanceController {

        private final DistanceService distanceService;

        public DistanceController(DistanceService distanceService) {
            this.distanceService = distanceService;
        }

        @GetMapping("/distance")
        public double getDistance(
                @RequestParam double startLat,
                @RequestParam double startLon,
                @RequestParam double endLat,
                @RequestParam double endLon) {
            return distanceService.calculateDistance(startLat, startLon, endLat, endLon);
        }
    }
