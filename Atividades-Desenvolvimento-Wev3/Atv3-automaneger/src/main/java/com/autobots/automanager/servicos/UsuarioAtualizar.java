package com.autobots.automanager.servicos;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.repositorios.RepositorioUsuario;
import com.autobots.automanager.dto.DadosAtualizaUsuario;
import com.autobots.automanager.entitades.Usuario;

@Service
public class UsuarioAtualizar {
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Transactional
	public Boolean atualizar(DadosAtualizaUsuario dadosAtualizacao) {
		Optional<Usuario> optionalUsuario = repositorioUsuario.findById(dadosAtualizacao.id());
		if(optionalUsuario.isPresent()) {
			Usuario usuario = optionalUsuario.get();
			if(!dadosAtualizacao.nome().isBlank()) {
				usuario.setNome(dadosAtualizacao.nome());
			}
			if(!dadosAtualizacao.nomeSocial().isBlank()) {
				usuario.setNomeSocial(dadosAtualizacao.nomeSocial());
			}
			return true;
		}
		return false;
	}
}
