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
    private CinemaDTO cinemaDTO;
    private int remainingSeats;



    public static SessionDTO fromEntity(Session entity){
        if(entity == null){
            return null;
        }

        return SessionDTO.builder()
                .movieDTO(MovieDTO.fromEntity(entity.getMovie()))
                .cinemaDTO(CinemaDTO.fromEntity(entity.getCinema()))
                .roomNumber(entity.getRoom().getNumber())
                .dateTime(entity.getDateTime())
                .remainingSeats(entity.getRemainingSeats())
                .build();
    }
}
