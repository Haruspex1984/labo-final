package be.technifutur.Labofinal.services;

import be.technifutur.Labofinal.models.DTO.CinemaDTO;

import java.util.List;

public interface CinemaService {

    List<CinemaDTO> getAll();

    CinemaDTO getOne(Long id);

    void deleteCinema(Long id);


}
