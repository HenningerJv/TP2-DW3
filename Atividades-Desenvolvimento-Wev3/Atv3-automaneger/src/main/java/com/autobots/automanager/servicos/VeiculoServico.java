package com.autobots.automanager.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.dto.VeiculoDTO;
import com.autobots.automanager.entitades.Veiculo;

import com.autobots.automanager.repositorios.RepositorioVeiculo;

@Service
public class VeiculoServico {
	
	@Autowired
    private RepositorioVeiculo repositorioVeiculo;

	public VeiculoDTO obterVeiculoPorId(long id) {
        Optional<Veiculo> veiculoOptional = repositorioVeiculo.findById(id);
        if (veiculoOptional.isPresent()) {
            Veiculo veiculo = veiculoOptional.get();
            VeiculoDTO veiculoDTO = mapToVeiculoDTO(veiculo);
            return veiculoDTO;
        }
        return null;
    }
	
	private VeiculoDTO mapToVeiculoDTO(Veiculo veiculo) {
        return new VeiculoDTO(
            veiculo.getId(),
            veiculo.getTipo(),
            veiculo.getModelo(),
            veiculo.getPlaca()
        );
    }
}
