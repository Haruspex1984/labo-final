package be.technifutur.Labofinal.models.DTO;

import be.technifutur.Labofinal.models.entities.Genre;
import be.technifutur.Labofinal.models.entities.Movie;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class MovieDTO {

    private Long id;
    private String title;
    private String director;
    private String description;
    private int length;
    private boolean isAdultOnly;
    private boolean isImax;
    private String imageURL;
    private LocalDate releaseDate;
    private Set<Genre> genres;


    public static MovieDTO fromEntity(Movie entity){

        if(entity == null){
            return null;
        }

        return MovieDTO.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .title(entity.getTitle())
                .director(entity.getDirector())
                .length(entity.getLength())
                .genres(entity.getGenres())
                .imageURL(entity.getImageURL())
                .isAdultOnly(entity.isAdultsOnly())
                .isImax(entity.isImax())
                .releaseDate(entity.getReleaseDate())
                .build();
    }
}
