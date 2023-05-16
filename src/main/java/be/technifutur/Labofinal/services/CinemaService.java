package be.technifutur.Labofinal.services;

import be.technifutur.Labofinal.models.DTO.CinemaDTO;
import be.technifutur.Labofinal.models.forms.CinemaForm;

import java.util.List;

public interface CinemaService {

    List<CinemaDTO> getAll();

    CinemaDTO getOne(Long id);

    void deleteCinema(Long id);

    CinemaDTO newCinema(CinemaForm form);


}
