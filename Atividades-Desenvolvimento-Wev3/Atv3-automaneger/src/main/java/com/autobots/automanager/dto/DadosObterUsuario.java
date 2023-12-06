package com.autobots.automanager.dto;

import com.autobots.automanager.entitades.Endereco;
import com.autobots.automanager.entitades.Telefone;
import com.autobots.automanager.enumeracoes.PerfilUsuario;
import java.util.Set;

public record DadosObterUsuario(
	Long id,
    String nome,
    String nomeSocial,
    Set<PerfilUsuario> perfis,
    Set<Telefone> telefones,
    Endereco endereco
) {}
