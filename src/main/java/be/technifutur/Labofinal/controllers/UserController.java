package be.technifutur.Labofinal.controllers;

import be.technifutur.Labofinal.models.DTO.UserDTO;
import be.technifutur.Labofinal.models.forms.UserForm;
import be.technifutur.Labofinal.services.UserService;
import be.technifutur.Labofinal.utils.JWTProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;
    private final JWTProvider jwt;

    public UserController(UserService userService, JWTProvider jwt, HttpServletRequest http, JWTProvider jwt1) {
        this.userService = userService;
        this.jwt = jwt1;
    }


    @PatchMapping("/{username}/update")
    public UserDTO updateUser(@RequestBody UserForm form, @PathVariable String username, HttpServletRequest request) throws Exception {
        return userService.updateUser(username, form, request);
    }
}

