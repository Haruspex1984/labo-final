package be.technifutur.Labofinal.utils;


import be.technifutur.Labofinal.models.entities.*;
import be.technifutur.Labofinal.repositories.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class DataInit implements InitializingBean {

    private final MovieRepository movieRepository;
    private final CinemaRepository cinemaRepository;
    private final RoomRepository roomRepository;
    private final SeatRepository seatRepository;
    private final SessionRepository sessionRepository;

    public DataInit(MovieRepository movieRepository, CinemaRepository cinemaRepository, RoomRepository roomRepository, SeatRepository seatRepository, SessionRepository sessionRepository) {
        this.movieRepository = movieRepository;
        this.cinemaRepository = cinemaRepository;
        this.roomRepository = roomRepository;
        this.seatRepository = seatRepository;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Movie movie = new Movie();
        Set<Genre> genres = new LinkedHashSet<>();

        movie.setTitle("Titanic");
        movie.setDirector("James Cameron");
        movie.setImax(false);
        movie.setAdultsOnly(false);

        genres.add(Genre.ROMANCE);
        genres.add(Genre.HISTORY);
        movie.setGenres(genres);
        movie.setLength(180);
        movie.setReleaseDate(LocalDate.of(1998, 1, 7));
        movie.setImageURL("https://barrettjacksoncdn.azureedge.net/staging/carlist/items/Fullsize/Automobilia/46452/46452_Auto_Front_3-4_Web.jpg");
        movieRepository.save(movie);

        Seat seat = new Seat();
        Set<Seat> seats = new LinkedHashSet<>();

        seat.setNumber(0);
        seats.add(seat);
        seat.setRoomId(1L);
        seatRepository.save(seat);

        for (int i = 1; i < 11; i++) {
           seat = new Seat();
           seat.setNumber(i);
           seat.setRoomId(1L);
           seats.add(seat);
           seatRepository.save(seat);
        }



        Room room = new Room();
        room.setCapacity(10);
        room.setNumber(1);
        room.setCinemaId(1L);
        room.setSeats(seats);

        Set<Room> rooms = new LinkedHashSet<>();
        rooms.add(room);

        roomRepository.save(room);

        Cinema cinema = new Cinema();
        cinema.setRooms(rooms);
        cinema.setName("Kinépolis");
        cinema.setAddress("Liège");
        cinema.setPhoneNumber("0498284520");
        cinema.setDefaultPrice(6.5);

        cinemaRepository.save(cinema);

        Session session = new Session();
        session.setCinema(cinemaRepository.findById(1L).orElseThrow());
        session.setRoom(roomRepository.findByCinemaIdAndId(1L,1L));
        session.setMovie(movieRepository.findById(1L).orElseThrow());
        session.setDateTime(LocalDateTime.now());
        sessionRepository.save(session);



    }
}
