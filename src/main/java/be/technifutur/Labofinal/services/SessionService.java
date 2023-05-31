package be.technifutur.Labofinal.services;

import be.technifutur.Labofinal.models.DTO.SessionDTO;
import be.technifutur.Labofinal.models.entities.Session;

import java.util.List;

public interface SessionService {
    List<SessionDTO> findAllByCinema(Long id);

    List<SessionDTO> findAllByMovie(Long id);

    void deleteOneByIdAndCinemaId(Long id, Long cinemaId);


}
