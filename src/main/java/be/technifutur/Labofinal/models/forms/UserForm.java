package be.technifutur.Labofinal.models.forms;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserForm {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]\\w{3,14}$")
    private String password;

    @Pattern(regexp = "^\\d{10}$")
    private String phoneNumber;

    @Email
    @NotBlank
    private String email;

}
