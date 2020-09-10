package com.formacionbdi.springboot.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.aaron.springboot.app.commons.models.entity"}) // ya que esta en otro paquete
public class SpringbootServicioProductosApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(SpringbootServicioProductosApplication.class, args);
	}

}
