package com.generation.ecommerce.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "Usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="User_id")
    private Long id;

    @Column(name="User_nombre")
    private String nombre;

    @Column(name="User_apellido")
    private String apellido;

    @Column(name="User_correo")
    private String correo;

    @Column(name="User_password")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "User_id"),
            inverseJoinColumns = @JoinColumn(name = "Rol_id")
    )
    private List<Rol> roles;


    //getter & setter
}