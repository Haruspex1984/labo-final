package be.technifutur.Labofinal.services.impl;

import be.technifutur.Labofinal.models.DTO.UserSessionDTO;
import be.technifutur.Labofinal.models.entities.Seat;
import be.technifutur.Labofinal.models.entities.Session;
import be.technifutur.Labofinal.models.entities.UserSession;
import be.technifutur.Labofinal.models.forms.UserSessionForm;
import be.technifutur.Labofinal.repositories.SessionRepository;
import be.technifutur.Labofinal.repositories.UserRepository;
import be.technifutur.Labofinal.repositories.UserSessionRepository;
import be.technifutur.Labofinal.services.UserSessionService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserSessionServiceImpl implements UserSessionService {

    private final UserSessionRepository userSessionRepository;
    private final SessionRepository sessionRepository;
    private final UserRepository userRepository;

    public UserSessionServiceImpl(UserSessionRepository userSessionRepository, UserRepository userRepository, SessionRepository sessionRepository, UserRepository userRepository1) {
        this.userSessionRepository = userSessionRepository;
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserSessionDTO newUserSession(UserSessionForm form) {
        UserSession userSession = form.toEntity();
        userSession.setSession(sessionRepository.findById(form.getSessionId()).orElseThrow());
        Session session = userSession.getSession();
        userSession.setUser(userRepository.findByUsername(form.getUsername()).orElseThrow());
        userSession.setPrice(
                form.getSeatsQuantity() * userSession.getSession().getCinema().getDefaultPrice()
        );
        Set<Seat> seats = userSession.getSession().getRoom().getSeats()
                .stream().limit(form.getSeatsQuantity()).peek(o -> o.setAvailable(false)).collect(Collectors.toSet());

        session.setRemainingSeats(session.getRemainingSeats() - form.getSeatsQuantity());
        userSession.setSeats(seats);
        userSessionRepository.save(userSession);
        return UserSessionDTO.fromEntity(userSession);

    }
}
