package com.ciberfarma.dawi_tema05.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_proveedor")
@Data
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idproveedor;

    @Column(name = "nombre_rs")
    private String nombre;

    private String telefono;

    private String email;
}
