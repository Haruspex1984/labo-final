package be.technifutur.Labofinal.models.forms;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Data
public class CinemaForm {

    @NotBlank
    private String name;

    @NotBlank
    @Pattern(regexp = "^\\d{10}$")
    private String phoneNumber;

    @NotBlank
    private String address;

    @NotBlank
    private String imageURL;

    @Positive
    private double defaultPrice;



}
