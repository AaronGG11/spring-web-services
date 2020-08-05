package com.example.test.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.persistence.*;

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
    //@Column(name = "ID", columnDefinition = "INT")
    private Integer ID;

    private String prefijo;

    //@Column(name = "nombre", columnDefinition = "VARCHAR(255)")
    private String nombre;

    //@Column(name = "edad", columnDefinition = "VARCHAR(255)")
    private Integer edad;
}
