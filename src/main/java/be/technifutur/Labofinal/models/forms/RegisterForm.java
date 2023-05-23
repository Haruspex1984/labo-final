package be.technifutur.Labofinal.models.forms;

import be.technifutur.Labofinal.models.entities.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegisterForm {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String email;








}
