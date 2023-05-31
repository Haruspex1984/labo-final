package be.technifutur.Labofinal.controllers;

import be.technifutur.Labofinal.models.DTO.SessionDTO;
import be.technifutur.Labofinal.services.SessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
@CrossOrigin("*")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/cinema/{cinemaId}/all")
    public List<SessionDTO>getAllByCinema(@PathVariable Long cinemaId){
        return sessionService.findAllByCinema(cinemaId);
    }

    @GetMapping("/movie/{movieId}/all")
    public List<SessionDTO>getAllByMovie(@PathVariable Long movieId){
        return sessionService.findAllByMovie(movieId);
    }



    @DeleteMapping("/{id}/delete")
    public void deleteOneByIdAndCinemaId(@PathVariable Long id, @RequestParam ("cinemaId") Long cinemaId){
        sessionService.deleteOneByIdAndCinemaId(cinemaId,id);
    }
}
