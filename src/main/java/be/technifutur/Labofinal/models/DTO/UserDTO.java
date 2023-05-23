package be.technifutur.Labofinal.models.DTO;
import be.technifutur.Labofinal.models.entities.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private String firstname;
    private String lastname;
    private String username;
    private String phoneNumber;
    private String email;

    public static UserDTO fromEntity(User entity){
        if(entity == null){
            return null;
        }
        return UserDTO.builder()
                .firstname(entity.getFirstname())
                .lastname(entity.getLastname())
                .username(entity.getUsername())
                .phoneNumber(entity.getPhoneNumber())
                .email(entity.getEmailAddress())
                .build();
    }
}
