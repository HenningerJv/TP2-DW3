package com.autobots.automanager.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.repositorios.RepositorioMercadoria;
import com.autobots.automanager.entitades.Mercadoria;
import com.autobots.automanager.dto.DadosListaMercadoria;

@Service
public class MercadoriaListar {
	@Autowired
	private RepositorioMercadoria repositorioMercadoria;
	
	public List<DadosListaMercadoria> listarTodos() {
		List<Mercadoria> mercadorias = repositorioMercadoria.findAll();
		List<DadosListaMercadoria> listaMercadorias = new ArrayList<DadosListaMercadoria>();
		mercadorias.forEach((mercadoria)->{
			listaMercadorias.add(
					new DadosListaMercadoria(
							mercadoria.getId(),
							mercadoria.getValidade(),
					        mercadoria.getFabricao(),
					        mercadoria.getCadastro(),
					        mercadoria.getNome(),
					        mercadoria.getQuantidade(),
					        mercadoria.getValor(),
					        mercadoria.getDescricao()
			));
		});
		return listaMercadorias;
	}
	
	public DadosListaMercadoria obterMercadoria(Long id) {
		Optional<Mercadoria> Opmercadoria = repositorioMercadoria.findById(id);
		if(Opmercadoria.isPresent()) {
			Mercadoria mercadoria = Opmercadoria.get();
			DadosListaMercadoria dadosMercadoria = new DadosListaMercadoria(
					mercadoria.getId(),
					mercadoria.getValidade(),
			        mercadoria.getFabricao(),
			        mercadoria.getCadastro(),
			        mercadoria.getNome(),
			        mercadoria.getQuantidade(),
			        mercadoria.getValor(),
			        mercadoria.getDescricao());
			return dadosMercadoria;
		}
		return null;
	}
}
