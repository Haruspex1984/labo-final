package be.technifutur.Labofinal.models.DTO;

import be.technifutur.Labofinal.models.entities.UserSession;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSessionDTO {

    private double price;
    private UserDTO userDTO;
    private int seatsQuantity;



    public static UserSessionDTO fromEntity(UserSession entity){
        if(entity == null){
            return null;
        }
        return UserSessionDTO.builder()
                .price(entity.getPrice())
                .userDTO(UserDTO.fromEntity(entity.getUser()))
                .seatsQuantity(entity.getSeats().size())
                .build();
    }
}
