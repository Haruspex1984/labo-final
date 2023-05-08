package be.technifutur.Labofinal.controllers;

import be.technifutur.Labofinal.models.DTO.SessionDTO;
import be.technifutur.Labofinal.services.SessionService;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{id}/delete")
    public void deleteOneByIdAndCinemaId(@PathVariable Long id, @RequestParam ("cinemaId") Long cinemaId){
        sessionService.deleteOneByIdAndCinemaId(cinemaId,id);
    }
}
