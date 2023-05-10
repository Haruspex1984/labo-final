package be.technifutur.Labofinal.services.impl;

import be.technifutur.Labofinal.models.DTO.MovieDTO;
import be.technifutur.Labofinal.models.entities.Genre;
import be.technifutur.Labofinal.models.entities.Movie;
import be.technifutur.Labofinal.models.forms.MovieForm;
import be.technifutur.Labofinal.repositories.MovieRepository;
import be.technifutur.Labofinal.services.MovieService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {


    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDTO> getAll() {
        return movieRepository.findAll().stream().map(MovieDTO::fromEntity).toList();
    }

    @Override
    public Optional<MovieDTO> getOne(Long id) {
        return movieRepository.findById(id).map(MovieDTO::fromEntity);
    }

    @Override
    public MovieDTO newMovie(@Valid MovieForm form) {
        Movie movie = form.toEntity();
        movieRepository.save(movie);
        return MovieDTO.fromEntity(movie);
    }

    @Override
    public MovieDTO modifyMovie(@Valid MovieForm form, Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        movie.setTitle(form.getTitle());
        movie.setDirector(form.getDirector());
        movie.setLength(form.getLength());
        movie.setReleaseDate(form.getReleaseDate());
        movie.setImax(form.isImax());
        movie.setAdultsOnly(form.isAdultsOnly());
        movie.setImageURL(form.getImageURL());

        Set<Genre> genres = new LinkedHashSet<>();

        for (String genre: form.getGenres()
        ) {
            genres.add(Genre.valueOf(genre));
        }

        movie.setGenres(genres);

        movieRepository.save(movie);
        return MovieDTO.fromEntity(movie);
    }

    @Override
    public List<MovieDTO> findAllbyCinema(Long cinemaId) {
        return movieRepository.findMoviesByCinemaId(cinemaId).stream().map(MovieDTO::fromEntity).toList();
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }


}
