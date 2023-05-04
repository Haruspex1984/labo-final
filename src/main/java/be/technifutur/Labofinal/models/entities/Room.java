package be.technifutur.Labofinal.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private Long cinemaId;


    @OneToMany
    private Set<Seat> seats = new LinkedHashSet<>();

}
