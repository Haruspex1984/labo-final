package be.technifutur.Labofinal.controllers;

import be.technifutur.Labofinal.models.DTO.UserSessionDTO;
import be.technifutur.Labofinal.models.forms.UserSessionForm;
import be.technifutur.Labofinal.services.UserSessionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-session")
public class UserSessionController {

    private final UserSessionService userSessionService;

    public UserSessionController(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public UserSessionDTO newUserSession(@RequestBody UserSessionForm form){
        return userSessionService.newUserSession(form);
    }

}
