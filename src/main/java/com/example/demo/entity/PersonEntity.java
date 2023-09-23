package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "persona")
@Data
public class PersonEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private  Long id_persona;

@Column(name = "nombre")
@NotNull
    private String nombre;

    @Column(name = "correo")
    @NotNull
    private String correo;

    @Column(name = "apellido")
    @NotNull
    private String apellido;

}
