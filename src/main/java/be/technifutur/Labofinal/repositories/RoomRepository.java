package be.technifutur.Labofinal.repositories;

import be.technifutur.Labofinal.models.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
