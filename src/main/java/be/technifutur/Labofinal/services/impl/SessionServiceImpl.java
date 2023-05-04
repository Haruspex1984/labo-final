package be.technifutur.Labofinal.services.impl;

import be.technifutur.Labofinal.models.DTO.SessionDTO;
import be.technifutur.Labofinal.models.entities.Session;
import be.technifutur.Labofinal.repositories.SessionRepository;
import be.technifutur.Labofinal.services.SessionService;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public SessionDTO findAllByCinema(Long id) {
        Session session = sessionRepository.findAllByCinemaId(id);
        return SessionDTO.fromEntity(session);
    }
}
