package online.train.onlinetrain.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Service
public class DistanceService {

    @Value("${ors.api.key}")
    private String apiKey;

    @Value("${ors.base.url}")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public double calculateDistance(double startLat, double startLon, double endLat, double endLon) {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl + "/v2/directions/driving-car")
                .queryParam("api_key", apiKey)
                .toUriString();

        // Define the request payload
        Map<String, Object> requestPayload = Map.of(
                "coordinates", new double[][]{{startLon, startLat}, {endLon, endLat}},
                "units", "km"
        );

        // Make the request
        Map<String, Object> response = restTemplate.postForObject(url, requestPayload, Map.class);

        if (response != null && response.containsKey("routes")) {
            List<Map<String, Object>> routes = (List<Map<String, Object>>) response.get("routes");
            if (!routes.isEmpty()) {
                Map<String, Object> route = routes.get(0);
                Map<String, Object> summary = (Map<String, Object>) route.get("summary");
                return (double) summary.get("distance");
            }
        }

        throw new RuntimeException("Unable to calculate distance");
    }
}
