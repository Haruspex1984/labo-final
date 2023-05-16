package be.technifutur.Labofinal.models.DTO;


import be.technifutur.Labofinal.models.entities.Room;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDTO {


    private int number;

    private int capacity;

    private Long cinemaId;


    public static RoomDTO fromEntity(Room entity){
        if(entity == null){
            return null;
        }

        return RoomDTO.builder()
                .capacity(entity.getCapacity())
                .number(entity.getNumber())
                .cinemaId(entity.getCinemaId())
                .build();
    }


}
