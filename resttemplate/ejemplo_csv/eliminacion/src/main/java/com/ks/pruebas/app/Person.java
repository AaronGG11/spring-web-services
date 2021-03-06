package com.ks.pruebas.app;

import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Person
{
    private Integer ID;
    private String prefijo;
    private String nombre;
    private Integer edad;
    private String email;
}
