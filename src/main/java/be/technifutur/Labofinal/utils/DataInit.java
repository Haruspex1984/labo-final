package be.technifutur.Labofinal.utils;


import be.technifutur.Labofinal.models.entities.Genre;
import be.technifutur.Labofinal.models.entities.Movie;
import be.technifutur.Labofinal.repositories.MovieRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInit implements InitializingBean {

    private final MovieRepository movieRepository;

    public DataInit(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Movie movie = new Movie();
        movie.setTitle("Titanic");
        movie.setDirector("James Cameron");
        movie.setImax(false);
        movie.setAdultsOnly(false);

        Set<Genre> genres = new HashSet<>();
        genres.add(Genre.ROMANCE);
        genres.add(Genre.HISTORY);
        movie.setGenres(genres);
        movie.setLength(180);
        movie.setReleaseDate(LocalDate.of(1998,1,7));
        movie.setImageURL("https://barrettjacksoncdn.azureedge.net/staging/carlist/items/Fullsize/Automobilia/46452/46452_Auto_Front_3-4_Web.jpg");
        movieRepository.save(movie);

    }
}
