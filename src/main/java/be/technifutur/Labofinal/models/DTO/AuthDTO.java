package be.technifutur.Labofinal.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthDTO {


    private String username;
    private String token;

}
