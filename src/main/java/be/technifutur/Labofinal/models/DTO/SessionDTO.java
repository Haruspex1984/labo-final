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
    private Long roomId;


    public static SessionDTO fromEntity(Session entity){
        if(entity == null){
            return null;
        }

        return SessionDTO.builder()
                .movieDTO(MovieDTO.fromEntity(entity.getMovie()))
                .roomId(entity.getRoom().getId())
                .dateTime(entity.getDateTime())
                .build();
    }
}
