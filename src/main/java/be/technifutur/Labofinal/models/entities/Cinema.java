package be.technifutur.Labofinal.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cinema_id", nullable = false)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private String imageURL;


    @Column(nullable = false)
    private String address;

    @Column(nullable = false,name = "phone_number",unique = true)
    private String phoneNumber;

    @Column(nullable = false, name = "default_price")
    private double defaultPrice;
    
    @OneToMany(orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Set<Room> rooms = new LinkedHashSet<>();

}
