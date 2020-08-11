package com.example.jdbc_templete_1.model;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Table
@EntityScan
public class Person
{
    private Integer id;
    private String nombre;
    private Integer edad;
}
