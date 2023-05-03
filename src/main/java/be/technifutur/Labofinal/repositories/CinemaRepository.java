package be.technifutur.Labofinal.repositories;

import be.technifutur.Labofinal.models.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema,Long> {
}
