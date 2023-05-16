package be.technifutur.Labofinal.models.forms;

import be.technifutur.Labofinal.models.entities.Room;
import be.technifutur.Labofinal.models.entities.Seat;
import be.technifutur.Labofinal.models.entities.UserSession;
import be.technifutur.Labofinal.repositories.SessionRepository;
import be.technifutur.Labofinal.repositories.UserRepository;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UserSessionForm {


    private String username;

    private Long sessionId;

    private int seatsQuantity;


    public UserSession toEntity() {
        return new UserSession();
    }
}
