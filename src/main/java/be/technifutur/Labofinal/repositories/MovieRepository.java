package be.technifutur.Labofinal.repositories;

import be.technifutur.Labofinal.models.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
