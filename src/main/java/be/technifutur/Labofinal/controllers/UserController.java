package be.technifutur.Labofinal.controllers;
import be.technifutur.Labofinal.models.DTO.UserDTO;
import be.technifutur.Labofinal.models.forms.UserForm;
import be.technifutur.Labofinal.services.UserService;
import be.technifutur.Labofinal.utils.JWTProvider;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService, JWTProvider jwt, HttpServletRequest http) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public UserDTO getOneByUsername(@PathVariable String username) throws Exception {
            return userService.findOneByUsername(username);

    }




    @PatchMapping("/{username}/update")
    public UserDTO updateUser(Authentication auth, @RequestBody UserForm form, @PathVariable String username) throws Exception {
        return userService.updateUser(username, form, auth);
    }
}

