package be.technifutur.Labofinal.services.impl;

import be.technifutur.Labofinal.models.DTO.SessionDTO;
import be.technifutur.Labofinal.models.entities.Cinema;
import be.technifutur.Labofinal.models.entities.Session;
import be.technifutur.Labofinal.models.forms.SessionForm;
import be.technifutur.Labofinal.repositories.CinemaRepository;
import be.technifutur.Labofinal.repositories.RoomRepository;
import be.technifutur.Labofinal.repositories.SessionRepository;
import be.technifutur.Labofinal.services.SessionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;
    private final CinemaRepository cinemaRepository;
    private final RoomRepository roomRepository;

    public SessionServiceImpl(SessionRepository sessionRepository, CinemaRepository cinemaRepository, RoomRepository roomRepository) {
        this.sessionRepository = sessionRepository;
        this.cinemaRepository = cinemaRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public List<SessionDTO> findAllByCinema(Long id) {
        return sessionRepository.findAllByCinemaId(id).stream().map(SessionDTO::fromEntity).toList();
    }

    @Override
    public SessionDTO newSession(SessionForm form) {
        Session session = new Session();
        session.setDateTime(form.getDateTime());
        Cinema cinema = cinemaRepository.findById(form.getCinemaId()).orElseThrow();
        session.setCinema(cinema);











        return null;
    }

    @Override
    public List<SessionDTO> findAllByMovie(Long id) {
        return sessionRepository.findAllByMovieId(id).stream().map(SessionDTO::fromEntity).toList();
    }

    @Override
    @Transactional
    public void deleteOneByIdAndCinemaId(Long id, Long cinemaId) {
        sessionRepository.deleteByIdAndCinemaId(id,cinemaId);
    }


}
