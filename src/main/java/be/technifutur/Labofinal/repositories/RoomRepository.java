package be.technifutur.Labofinal.repositories;

import be.technifutur.Labofinal.models.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface RoomRepository extends JpaRepository<Room,Long> {

    Room findByCinemaIdAndId(Long cinemaId,Long id);
    Set<Room> findAllByCinemaId(Long cinemaId);


}
