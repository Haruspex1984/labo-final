package be.technifutur.Labofinal.services;

import be.technifutur.Labofinal.models.DTO.AuthDTO;
import be.technifutur.Labofinal.models.DTO.UserDTO;
import be.technifutur.Labofinal.models.forms.LoginForm;
import be.technifutur.Labofinal.models.forms.RegisterForm;

public interface AuthService {

AuthDTO login(LoginForm form);

UserDTO register(RegisterForm form);

}
