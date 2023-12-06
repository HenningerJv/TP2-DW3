package com.autobots.automanager.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.repositorios.RepositorioUsuario;
import com.autobots.automanager.dto.DadosListaUsuario;
import com.autobots.automanager.dto.DadosObterUsuario;
import com.autobots.automanager.entitades.Usuario;


@Service
public class UsuarioListar {
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	public List<DadosListaUsuario> listarTodos() {
		List<Usuario> usuarios = repositorioUsuario.findAll();
		List<DadosListaUsuario> listaUsuarios = new ArrayList<DadosListaUsuario>();
		usuarios.forEach((usuario)->{
			listaUsuarios.add(new DadosListaUsuario(usuario.getId(), usuario.getNome(), usuario.getNomeSocial()));					
		});
		return listaUsuarios;
	}
	
	public DadosObterUsuario obterUsuario(Long id) {
		Optional<Usuario> Opusuario = repositorioUsuario.findById(id);
		if(Opusuario.isPresent()) {
			Usuario usuario = Opusuario.get();
			DadosObterUsuario dadosUsuario = new DadosObterUsuario(id, usuario.getNome(), usuario.getNomeSocial(),
					usuario.getPerfis(), usuario.getTelefones(), usuario.getEndereco());
			return dadosUsuario;
		}
		return null;
	}
}
