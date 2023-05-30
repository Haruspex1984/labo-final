package be.technifutur.Labofinal.repositories;

import be.technifutur.Labofinal.models.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Query("SELECT DISTINCT m FROM Movie m " +
            "INNER JOIN Session s ON m = s.movie " +
            "INNER JOIN Cinema c ON s.cinema = c " +
            "WHERE c.id = :cinemaId")
    List<Movie> findMoviesByCinemaId(@Param("cinemaId") Long cinemaId);





}
