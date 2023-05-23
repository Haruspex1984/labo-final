package be.technifutur.Labofinal.models.DTO;

import be.technifutur.Labofinal.models.entities.Session;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SessionDTO {

    private LocalDateTime dateTime;
    private MovieDTO movieDTO;
    private int roomNumber;
    private Long cinemaId;
    private int remainingSeats;



    public static SessionDTO fromEntity(Session entity){
        if(entity == null){
            return null;
        }

        return SessionDTO.builder()
                .movieDTO(MovieDTO.fromEntity(entity.getMovie()))
                .roomNumber(entity.getRoom().getNumber())
                .dateTime(entity.getDateTime())
                .cinemaId(entity.getCinema().getId())
                .remainingSeats(entity.getRemainingSeats())
                .build();
    }
}
