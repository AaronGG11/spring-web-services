package com.ks.pruebas;

import lombok.*;

import javax.persistence.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Person
{
    private Integer id;
    private String prefijo;
    private String nombre;
    private Integer edad;
    private String email;
}
