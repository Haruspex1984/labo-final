package be.technifutur.Labofinal.repositories;

import be.technifutur.Labofinal.models.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,Long> {
}
