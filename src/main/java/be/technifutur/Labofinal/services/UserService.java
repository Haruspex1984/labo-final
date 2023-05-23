package be.technifutur.Labofinal.services;

import be.technifutur.Labofinal.models.DTO.UserDTO;
import be.technifutur.Labofinal.models.forms.UserForm;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

    UserDTO updateUser(String username, UserForm form, HttpServletRequest request) throws Exception;
}
