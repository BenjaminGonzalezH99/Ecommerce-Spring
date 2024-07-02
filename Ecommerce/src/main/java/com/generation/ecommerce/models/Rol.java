package com.generation.ecommerce.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "Roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Rol_id")
    private Long id;

    @Column(name="Rol_nombre")
    private String nombre;

    @Column(name="Rol_Tipo")
    @Enumerated(EnumType.STRING)
    private ERol tipo;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    //getter & setter
}