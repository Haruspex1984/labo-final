package be.technifutur.Labofinal.models.DTO;

import be.technifutur.Labofinal.models.entities.Cinema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CinemaDTO {

    private String name;
    private String address;
    private String phoneNumber;
    private double defaultPrice;
    private int roomsQuantity;
    private String imageURL;

    public static CinemaDTO fromEntity(Cinema entity){
        if(entity == null){
            return null;
        }

        return CinemaDTO.builder()
                .name(entity.getName())
                .address(entity.getAddress())
                .defaultPrice(entity.getDefaultPrice())
                .phoneNumber(entity.getPhoneNumber())
                .roomsQuantity(entity.getRooms().size())
                .imageURL(entity.getImageURL())
                .build();

    }
}
