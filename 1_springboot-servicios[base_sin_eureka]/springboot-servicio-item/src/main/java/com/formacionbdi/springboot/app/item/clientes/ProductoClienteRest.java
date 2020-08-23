package com.formacionbdi.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formacionbdi.springboot.app.item.models.Producto;

@FeignClient(name = "servicio-productos") // se declara que es un cliente feign, el nombre es el mismo que el nombre de servicio
public interface ProductoClienteRest {
	
	@GetMapping("/listar") // indicamos la ruta para consumir el servicio del json pero convertidos a objetos
	public List<Producto> listar();
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id);

}
