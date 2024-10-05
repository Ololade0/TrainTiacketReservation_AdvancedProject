package online.train.onlinetrain.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SeatResponse {
    private Long seatId;              // Unique identifier for the seat
    private int seatNumber;           // Seat number
    private String seatStatus;        // Status of the seat (e.g., UNOCCUPIED, OCCUPIED)
}

