package com.autobots.automanager.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.dto.VeiculoDTO;
import com.autobots.automanager.entitades.Veiculo;
import com.autobots.automanager.repositorios.RepositorioVeiculo;
import com.autobots.automanager.servicos.VeiculoServico;

@RestController
@RequestMapping("/veiculos")
public class VeiculoControle {
	@Autowired
    private VeiculoServico veiculoServico;
	
	@Autowired
    private RepositorioVeiculo repositorioVeiculo;
	
	@GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> obterVeiculoPorId(@PathVariable long id) {
        VeiculoDTO veiculo = veiculoServico.obterVeiculoPorId(id);
        if (veiculo != null) {
            return ResponseEntity.ok(veiculo);
        }
        return ResponseEntity.notFound().build();
    }
	
	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastrarVeiculo(@RequestBody Veiculo veiculo) {
		repositorioVeiculo.save(veiculo);
		return ResponseEntity.ok().build();
	}
	
}
