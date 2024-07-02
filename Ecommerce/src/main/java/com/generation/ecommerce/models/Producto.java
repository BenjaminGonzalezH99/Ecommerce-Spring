package com.generation.ecommerce.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "Productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Prod_id")
    private Long id;

    @Column(name="Prod_nombre")
    private String nombreProducto;

    @Column(name="Prod_Stock")
    private Integer stockProducto;

    @Column(name="Prod_Precio")
    private Double precioProducto;

    @ManyToMany
    @JoinTable(
            name = "productos_categorias",
            joinColumns = @JoinColumn(name = "Prod_id"),
            inverseJoinColumns = @JoinColumn(name = "Cat_id")
    )
    private List<Categoria> categorias;
    //getter & setter
}