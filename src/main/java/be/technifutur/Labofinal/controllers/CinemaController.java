package be.technifutur.Labofinal.controllers;

import be.technifutur.Labofinal.models.DTO.CinemaDTO;
import be.technifutur.Labofinal.services.CinemaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/all")
    public List<CinemaDTO> getAll(){
        return cinemaService.getAll();
    }

    @GetMapping("/{id}")
    public CinemaDTO getOne(@PathVariable Long id){
        return cinemaService.getOne(id);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteMovie(@PathVariable Long id){
        cinemaService.deleteCinema(id);
    }

}
