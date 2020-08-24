package com.formacionbdi.springboot.app.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker // MEDIANTE UN HILO SEPARADO SE ENCARGA DE LA COMUNICACION, ENVUELVE RIBBON 
@EnableEurekaClient
// @RibbonClient(name="servicio-productos") con eureka ya no es necesario
@EnableFeignClients //nos permite inyectar los clientes en los controles, con eureka si es necesario ya que se habilita como cliente, ribbon es automatico en eureka
@SpringBootApplication
public class SpringbootServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioItemApplication.class, args);
	}

}
