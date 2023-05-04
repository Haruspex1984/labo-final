package be.technifutur.Labofinal.services;

import be.technifutur.Labofinal.models.DTO.MovieDTO;
import be.technifutur.Labofinal.models.forms.MovieForm;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieDTO> getAll();
    Optional<MovieDTO> getOne(Long id);
    MovieDTO newMovie(MovieForm form);
    MovieDTO modifyMovie(MovieForm form, Long id);
    void deleteMovie(Long id);
}
