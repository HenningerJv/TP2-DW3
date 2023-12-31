package com.autobots.automanager.dto;

import java.util.Date;
import java.util.Set;

import com.autobots.automanager.entitades.Endereco;
import com.autobots.automanager.entitades.Mercadoria;
import com.autobots.automanager.entitades.Servico;
import com.autobots.automanager.entitades.Telefone;

public record DadosObterEmpresa(
		Long id,
		String razaoSocial,
		String nomeFantasia,
		Set<Telefone> telefones,
		Endereco endereco,
		Date cadastro,
		Set<Mercadoria> mercadorias,
		Set<Servico> servicos
		) {
	
}