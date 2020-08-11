package com.example.test.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
public class Person
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    private String prefijo;

    @NotEmpty
    @Size(min = 2, max = 50, message = "Longitud [2-50]")
    private String nombre;

    @NotNull
    @Min(value = 0, message = "Edad minima 0 años")
    @Max(value = 60, message = "Edad maxima 60 años")
    @PositiveOrZero
    private Integer edad;

    @NotEmpty
    @Email
    private String email;
}


// https://javaee.github.io/javaee-spec/javadocs/javax/validation/constraints/package-summary.html
