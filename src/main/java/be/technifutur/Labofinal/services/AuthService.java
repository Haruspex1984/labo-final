package be.technifutur.Labofinal.services;

import be.technifutur.Labofinal.models.DTO.AuthDTO;
import be.technifutur.Labofinal.models.DTO.UserDTO;
import be.technifutur.Labofinal.models.forms.LoginForm;
import be.technifutur.Labofinal.models.forms.RegisterForm;
import be.technifutur.Labofinal.utils.exceptions.InvalidCredentialsException;
import be.technifutur.Labofinal.utils.exceptions.UsernameAlreadyExistsException;

public interface AuthService {

AuthDTO login(LoginForm form) throws InvalidCredentialsException;

UserDTO register(RegisterForm form) throws UsernameAlreadyExistsException;

}
