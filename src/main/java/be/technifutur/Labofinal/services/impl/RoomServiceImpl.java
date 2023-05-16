package be.technifutur.Labofinal.services.impl;

import be.technifutur.Labofinal.models.DTO.RoomDTO;
import be.technifutur.Labofinal.models.entities.Cinema;
import be.technifutur.Labofinal.models.entities.Room;
import be.technifutur.Labofinal.models.entities.Seat;
import be.technifutur.Labofinal.models.forms.RoomForm;
import be.technifutur.Labofinal.repositories.CinemaRepository;
import be.technifutur.Labofinal.repositories.RoomRepository;
import be.technifutur.Labofinal.repositories.SeatRepository;
import be.technifutur.Labofinal.services.RoomService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository repository;
    private final SeatRepository seatRepository;
    private final CinemaRepository cinemaRepository;

    public RoomServiceImpl(RoomRepository repository, SeatRepository seatRepository, CinemaRepository cinemaRepository) {
        this.repository = repository;
        this.seatRepository = seatRepository;
        this.cinemaRepository = cinemaRepository;
    }


    @Override
    public RoomDTO toEntity(RoomForm form) {

        Cinema cinema = cinemaRepository.findById(form.getCinemaId()).orElseThrow();
        Set<Room> rooms = cinema.getRooms();
        int maxValue = rooms.stream()
                .mapToInt(Room::getNumber)
                .max()
                .orElse(0);


        Room room = new Room();

        Set<Seat> seats = new LinkedHashSet<>();

        room.setNumber(maxValue + 1);
        room.setCapacity(form.getCapacity());
        room.setCinemaId(form.getCinemaId());
        room.setSeats(seats);
        rooms.add(room);

        room = repository.save(room);


        for (int i = 0; i < form.getCapacity(); i++) {
            Seat seat = new Seat();
            seat.setRoomId(room.getId());
            seat.setAvailable(true);
            seat.setNumber(i);
            seats.add(seat);
            seatRepository.save(seat);
        }

        cinemaRepository.save(cinema);


        return RoomDTO.fromEntity(room);
    }
}
