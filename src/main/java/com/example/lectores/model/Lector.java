package com.example.lectores.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author BRITNEY
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Lector {
    private int idlector;
    private String nombres;
    private String apellidos;
    private String correo;
}
