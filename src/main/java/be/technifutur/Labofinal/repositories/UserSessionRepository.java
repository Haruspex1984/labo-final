package be.technifutur.Labofinal.repositories;

import be.technifutur.Labofinal.models.entities.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSessionRepository extends JpaRepository<UserSession,Long> {
}
