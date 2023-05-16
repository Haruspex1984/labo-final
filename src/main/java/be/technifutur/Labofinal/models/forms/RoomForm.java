package be.technifutur.Labofinal.models.forms;

import be.technifutur.Labofinal.models.DTO.RoomDTO;
import be.technifutur.Labofinal.models.entities.Room;
import be.technifutur.Labofinal.models.entities.Seat;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class RoomForm {

    private int capacity;
    private Long cinemaId;

}
