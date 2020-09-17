package com.aaron.springboot.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.aaron.springboot.app.models.entity.Usuario;



@RepositoryRestResource(path="usuarios")
public interface UsuarioDao extends PagingAndSortingRepository<Usuario, Long>
{
	public Usuario findByUsername(String username);
	
	@Query(value="select u from Usuario u where u.username=?1") // jpa
	public Usuario obtenerPorUsuario(String usuario);
}
