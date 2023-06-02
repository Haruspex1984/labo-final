package be.technifutur.Labofinal.models.forms;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SessionForm {

    private LocalDateTime dateTime;
    private Long cinemaId;
    private Long roomId;
    private Long movieId;

}
