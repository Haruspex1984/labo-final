package be.technifutur.Labofinal.controllers;

import be.technifutur.Labofinal.models.DTO.AuthDTO;
import be.technifutur.Labofinal.models.DTO.UserDTO;
import be.technifutur.Labofinal.models.forms.LoginForm;
import be.technifutur.Labofinal.models.forms.RegisterForm;
import be.technifutur.Labofinal.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthDTO login(@RequestBody @Valid LoginForm form) {
        return authService.login(form);
    }

    @PostMapping("/register")
    private UserDTO register(@RequestBody @Valid RegisterForm form) {
        return authService.register(form);
    }

}
