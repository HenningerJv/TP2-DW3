package com.autobots.automanager.servicos;

import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.dto.DadosAtualizaEmpresa;
import com.autobots.automanager.entitades.Empresa;
import com.autobots.automanager.repositorios.RepositorioEmpresa;

@Service
public class EmpresaAtualizar {
	
	@Autowired
	private RepositorioEmpresa repositorioEmpresa;
	
	@Transactional
	public Boolean atualizar(DadosAtualizaEmpresa dadosAtualizacao) {
		Optional<Empresa> optionalEmpresa = repositorioEmpresa.findById(dadosAtualizacao.id());
		if(optionalEmpresa.isPresent()) {
			Empresa empresa = optionalEmpresa.get();
			if(!dadosAtualizacao.nomeFantasia().isBlank()) {
				empresa.setNomeFantasia(dadosAtualizacao.nomeFantasia());
			}
			if(!dadosAtualizacao.razaoSocial().isBlank()) {
				empresa.setRazaoSocial(dadosAtualizacao.razaoSocial());
			}
			return true;
		}
		return false;
	}
}
