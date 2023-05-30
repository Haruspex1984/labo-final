package be.technifutur.Labofinal.utils;


import be.technifutur.Labofinal.models.entities.*;
import be.technifutur.Labofinal.repositories.*;
import org.springframework.beans.factory.InitializingBean;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class DataInit implements InitializingBean {

    private final MovieRepository movieRepository;
    private final CinemaRepository cinemaRepository;
    private final RoomRepository roomRepository;
    private final SeatRepository seatRepository;
    private final SessionRepository sessionRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;


    public DataInit(MovieRepository movieRepository, CinemaRepository cinemaRepository, RoomRepository roomRepository, SeatRepository seatRepository, SessionRepository sessionRepository, UserRepository userRepository, PasswordEncoder encoder) {
        this.movieRepository = movieRepository;
        this.cinemaRepository = cinemaRepository;
        this.roomRepository = roomRepository;
        this.seatRepository = seatRepository;
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;

        this.encoder = encoder;
    }

    @Override
    public void afterPropertiesSet() throws Exception {


        Movie movie = new Movie();
        Set<Genre> genres = new LinkedHashSet<>();

        movie.setTitle("Titanic");
        movie.setDirector("James Cameron");
        movie.setDescription("Une aristocrate de dix-sept ans tombe amoureuse d'un artiste pauvre au grand coeur à bord du luxueux Titanic.");
        movie.setImax(false);
        movie.setAdultsOnly(false);

        genres.add(Genre.ROMANCE);
        genres.add(Genre.HISTORIC);
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
        seat.setAvailable(true);
        seatRepository.save(seat);

        for (int i = 1; i < 10; i++) {
            seat = new Seat();
            seat.setNumber(i);
            seat.setRoomId(1L);
            seat.setAvailable(true);
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
        cinema.setAddress("Rue du palais 10, 4000 Liège");
        cinema.setPhoneNumber("0498284520");
        cinema.setDefaultPrice(6.5);
        cinema.setImageURL("https://www.francebleu.fr/s3/cruiser-production/2020/12/ec98151a-c089-4030-ae79-2a9f43031aa1/1200x680_index.jpg");

        cinemaRepository.save(cinema);

        Session session = new Session();
        session.setCinema(cinemaRepository.findById(1L).orElseThrow());
        session.setRoom(roomRepository.findByCinemaIdAndId(1L, 1L));
        session.setMovie(movieRepository.findById(1L).orElseThrow());
        session.setDateTime(LocalDateTime.now());
        session.setRemainingSeats(session.getRoom().getCapacity());
        sessionRepository.save(session);

        Set<String> roles = new HashSet<>();
        roles.add("ADMIN");
        roles.add("USER");

        User user = new User();
        user.setFirstname("Benjamin");
        user.setLastname("Renard");
        user.setUsername("user");
        user.setPassword(encoder.encode("pass"));
        user.setEmailAddress("b.renard84@gmail.com");
        user.setRoles(roles);

        userRepository.save(user);

        roles = new HashSet<>();
        roles.add("USER");
        user = new User();
        user.setFirstname("Olivia");
        user.setLastname("Wolff");
        user.setUsername("user2");
        user.setPassword(encoder.encode("pass"));
        user.setEmailAddress("lilouwolff@gmail.com");
        user.setRoles(roles);

        userRepository.save(user);


    }
}
