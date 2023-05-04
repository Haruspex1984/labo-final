package be.technifutur.Labofinal.repositories;

import be.technifutur.Labofinal.models.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {
    Session findAllByCinemaId(Long cinemaId);
}
