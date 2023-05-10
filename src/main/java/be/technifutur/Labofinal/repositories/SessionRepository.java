package be.technifutur.Labofinal.repositories;
import be.technifutur.Labofinal.models.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface SessionRepository extends JpaRepository<Session,Long> {
    Session findAllByCinemaId(Long cinemaId);

    @Modifying
    void deleteByIdAndCinemaId(Long id,Long cinemaId);


}
