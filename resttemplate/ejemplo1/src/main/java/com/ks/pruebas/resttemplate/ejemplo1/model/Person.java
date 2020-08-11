package com.ks.pruebas.resttemplate.ejemplo1.model;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Person
{
    private Integer ID;
    private String prefijo;
    private String nombre;
    private Integer edad;
    private String email;
}


// https://javaee.github.io/javaee-spec/javadocs/javax/validation/constraints/package-summary.html
