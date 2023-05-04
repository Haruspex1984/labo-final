package be.technifutur.Labofinal.controllers;

import be.technifutur.Labofinal.models.DTO.SessionDTO;
import be.technifutur.Labofinal.services.SessionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/{id}/all")
    public SessionDTO getAllByCinema(@PathVariable Long id){
        return sessionService.findAllByCinema(id);
    }
}
