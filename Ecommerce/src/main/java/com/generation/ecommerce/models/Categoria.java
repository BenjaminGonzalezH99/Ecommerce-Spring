package com.generation.ecommerce.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "Categorias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Cat_id")
    private Long id;

    @Column(name="Cat_nombre")
    private String nombreCategoria;


    @Enumerated(EnumType.STRING)
    private ECategoria eCategoria;

    @ManyToMany(mappedBy = "categorias")
    private List<Producto> productos;

    // getters y setters
}


