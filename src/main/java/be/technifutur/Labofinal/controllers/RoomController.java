package be.technifutur.Labofinal.controllers;

import be.technifutur.Labofinal.models.DTO.RoomDTO;
import be.technifutur.Labofinal.models.forms.RoomForm;
import be.technifutur.Labofinal.services.RoomService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/new")
    public RoomDTO newRoom(@RequestBody @Valid RoomForm form){
        return roomService.toEntity(form);
    }





}
