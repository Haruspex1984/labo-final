package be.technifutur.Labofinal.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false,name = "email")
    private String emailAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles = new LinkedHashSet<>();










}
