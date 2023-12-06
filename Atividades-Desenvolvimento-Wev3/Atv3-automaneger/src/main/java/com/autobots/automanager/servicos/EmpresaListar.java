package com.autobots.automanager.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.repositorios.RepositorioEmpresa;
import com.autobots.automanager.dto.DadosListaEmpresa;
import com.autobots.automanager.dto.DadosObterEmpresa;
import com.autobots.automanager.entitades.Empresa;

@Service
public class EmpresaListar {
	@Autowired
	private RepositorioEmpresa repositorio_empresa;
	
	public List<DadosListaEmpresa> listarTodos() {
		List<Empresa> empresas = repositorio_empresa.findAll();
		List<DadosListaEmpresa> listaEmpresas = new ArrayList<DadosListaEmpresa>();
		empresas.forEach((empresa)->{
			listaEmpresas.add(
					new DadosListaEmpresa(
							empresa.getId(),
							empresa.getRazaoSocial(),
							empresa.getNomeFantasia(),
							empresa.getTelefones(),
							empresa.getEndereco(),
							empresa.getCadastro()));
		});
		return listaEmpresas;
	}
	
	public DadosObterEmpresa obterEmpresa(Long id) {
		Optional<Empresa> Opempresa = repositorio_empresa.findById(id);
		if(Opempresa.isPresent()) {
			Empresa empresa = Opempresa.get();
			DadosObterEmpresa dadosEmpresa = new DadosObterEmpresa(
							empresa.getId(),
							empresa.getRazaoSocial(),
							empresa.getNomeFantasia(),
							empresa.getTelefones(),
							empresa.getEndereco(),
							empresa.getCadastro(),
							empresa.getMercadorias(),
							empresa.getServicos());
			return dadosEmpresa;
		}
		return null;
	}
}
