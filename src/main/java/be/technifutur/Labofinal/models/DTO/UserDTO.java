package be.technifutur.Labofinal.models.DTO;
import be.technifutur.Labofinal.models.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private String firstname;
    private String lastname;

    public static UserDTO fromEntity(User entity){
        if(entity == null){
            return null;
        }
        return UserDTO.builder()
                .firstname(entity.getFirstname())
                .lastname(entity.getLastname())
                .build();
    }
}
