package be.technifutur.Labofinal.services;

import be.technifutur.Labofinal.models.DTO.RoomDTO;
import be.technifutur.Labofinal.models.entities.Room;
import be.technifutur.Labofinal.models.forms.RoomForm;

public interface RoomService {


    RoomDTO toEntity(RoomForm form);




}
