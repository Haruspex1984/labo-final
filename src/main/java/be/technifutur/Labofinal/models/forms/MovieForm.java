package be.technifutur.Labofinal.models.forms;

import be.technifutur.Labofinal.models.entities.Genre;
import be.technifutur.Labofinal.models.entities.Movie;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
public class MovieForm {

    @NotNull
    private String title;

    @NotNull
    private String director;

    @NotNull
    private int length;

    private boolean isAdultsOnly;

    private boolean isImax;

    @NotNull
    private LocalDate releaseDate;

    @NotNull
    private String imageURL;

    @NotNull
    private String[] genres;


    public Movie toEntity(){
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDirector(director);
        movie.setLength(length);
        movie.setAdultsOnly(isAdultsOnly);
        movie.setImax(isImax);
        movie.setReleaseDate(releaseDate);
        movie.setImageURL(imageURL);

        Set<Genre> setGenres = new LinkedHashSet<>();

        for (String genre:genres
             ) {
            setGenres.add(Genre.valueOf(genre));
        }

        movie.setGenres(setGenres);
        return movie;
    }





}
