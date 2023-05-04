package be.technifutur.Labofinal.controllers;


import be.technifutur.Labofinal.models.DTO.MovieDTO;
import be.technifutur.Labofinal.models.forms.MovieForm;
import be.technifutur.Labofinal.services.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
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

}
