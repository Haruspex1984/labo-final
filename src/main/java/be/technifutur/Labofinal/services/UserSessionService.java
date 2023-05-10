package be.technifutur.Labofinal.services;

import be.technifutur.Labofinal.models.DTO.UserSessionDTO;
import be.technifutur.Labofinal.models.forms.UserSessionForm;

public interface UserSessionService {

    UserSessionDTO newUserSessionDTO(UserSessionForm form);

}
