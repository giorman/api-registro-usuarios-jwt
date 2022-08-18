package com.registro.usuario.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String lastname;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String telephone;

    @Getter
    @Setter
    @JsonBackReference
    private String password;

}
