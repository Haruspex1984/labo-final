package be.technifutur.Labofinal.services.impl;

import be.technifutur.Labofinal.models.DTO.CinemaDTO;
import be.technifutur.Labofinal.models.entities.Cinema;
import be.technifutur.Labofinal.models.forms.CinemaForm;
import be.technifutur.Labofinal.repositories.CinemaRepository;
import be.technifutur.Labofinal.services.CinemaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

private final CinemaRepository cinemaRepository;


    public CinemaServiceImpl(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public List<CinemaDTO> getAll() {
        return cinemaRepository.findAll().stream().map(CinemaDTO::fromEntity).toList();
    }

    @Override
    public CinemaDTO getOne(Long id) {
        return cinemaRepository.findById(id).map(CinemaDTO::fromEntity).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void deleteCinema(Long id) {
        try{
        cinemaRepository.deleteById(id);
        }catch (DataIntegrityViolationException e) {
            System.out.println("Ce cinéma ne peut pas être supprimé, des séances y sont encore prévues");
        }

    }

    @Override
    public CinemaDTO newCinema(CinemaForm form) {
        Cinema cinema = new Cinema();
        cinema.setName(form.getName());
        cinema.setAddress(form.getAddress());
        cinema.setDefaultPrice(form.getDefaultPrice());
        cinema.setPhoneNumber(form.getPhoneNumber());
        cinema.setImageURL(form.getImageURL());
        cinemaRepository.save(cinema);
        return CinemaDTO.fromEntity(cinema);
    }
}
