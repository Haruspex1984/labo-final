package be.technifutur.Labofinal.models.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false,unique = true)
    private String title;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int length;

    @Column(nullable = false)
    private boolean isAdultsOnly;

    @Column(nullable = false)
    private boolean isImax;

    @Column(nullable = false)
    private String imageURL;

    @Column(nullable = false)
    private LocalDate releaseDate;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Genre> genres = new LinkedHashSet<>();



}
