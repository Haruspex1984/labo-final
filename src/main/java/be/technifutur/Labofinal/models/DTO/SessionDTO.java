package be.technifutur.Labofinal.models.DTO;

import be.technifutur.Labofinal.models.entities.Session;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SessionDTO {

    private LocalDateTime dateTime;
    private Long cinemaId;
    private Long movieId;
    private Long roomId;


    public static SessionDTO fromEntity(Session entity){
        if(entity == null){
            return null;
        }

        return SessionDTO.builder()
                .cinemaId(entity.getCinema().getId())
                .movieId(entity.getMovie().getId())
                .roomId(entity.getRoom().getId())
                .dateTime(entity.getDateTime())
                .build();
    }
}
