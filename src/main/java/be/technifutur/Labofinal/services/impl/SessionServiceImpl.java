package be.technifutur.Labofinal.services.impl;

import be.technifutur.Labofinal.models.DTO.MovieDTO;
import be.technifutur.Labofinal.models.DTO.SessionDTO;
import be.technifutur.Labofinal.models.entities.Session;
import be.technifutur.Labofinal.repositories.SessionRepository;
import be.technifutur.Labofinal.services.SessionService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public List<SessionDTO> findAllByCinema(Long id) {
        return sessionRepository.findAllByCinemaId(id).stream().map(SessionDTO::fromEntity).toList();
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
