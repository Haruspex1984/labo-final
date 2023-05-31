package be.technifutur.Labofinal.repositories;
import be.technifutur.Labofinal.models.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session,Long> {
    List<Session> findAllByCinemaId(Long cinemaId);

    List<Session> findAllByMovieId(Long MovieId);

    @Modifying
    void deleteByIdAndCinemaId(Long id,Long cinemaId);


}
