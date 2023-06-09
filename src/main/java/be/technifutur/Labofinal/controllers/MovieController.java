package be.technifutur.Labofinal.controllers;


import be.technifutur.Labofinal.models.DTO.MovieDTO;
import be.technifutur.Labofinal.models.forms.MovieForm;
import be.technifutur.Labofinal.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public List<MovieDTO> getAll(){
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<MovieDTO> getOne(@PathVariable Long id){
        return movieService.getOne(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDTO newMovie(@RequestBody MovieForm form){
        return movieService.newMovie(form);
    }

    @PatchMapping("/{id}/update")
    public void modifyMovie(@RequestBody MovieForm form,@PathVariable Long id){
        movieService.modifyMovie(form,id);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
    }

    @GetMapping("/{cinemaId}/movies")
    public List<MovieDTO> findMoviesByCinema(@PathVariable Long cinemaId){
        return movieService.findAllbyCinema(cinemaId);
    }
}
