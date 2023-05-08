package be.technifutur.Labofinal.services;

import be.technifutur.Labofinal.models.DTO.SessionDTO;
import be.technifutur.Labofinal.models.entities.Session;

public interface SessionService {
    SessionDTO findAllByCinema(Long id);

    void deleteOneByIdAndCinemaId(Long id, Long cinemaId);


}
