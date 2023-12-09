package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.dto.DadosListaMercadoria;
import com.autobots.automanager.repositorios.RepositorioMercadoria;
import com.autobots.automanager.servicos.MercadoriaListar;
import com.autobots.automanager.entitades.Mercadoria;

@RestController
@RequestMapping("/mercadorias")
public class MercadoriaControle {

	@Autowired
	private RepositorioMercadoria repositorioMercadoria;
	
	@Autowired
	private MercadoriaListar mercadoriaListar;
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosListaMercadoria> pegarMercadoria(@PathVariable long id){
		DadosListaMercadoria mercadoria = mercadoriaListar.obterMercadoria(id);
		if(mercadoria != null) {
			return ResponseEntity.ok(mercadoria);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/listar")
    public ResponseEntity<List<DadosListaMercadoria>> listarMercadorias() {
		List<DadosListaMercadoria> listaMercadoria = mercadoriaListar.listarTodos();
		return ResponseEntity.ok(listaMercadoria);
    }
	
	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastrarUsuario(@RequestBody Mercadoria mercadoria) {
		repositorioMercadoria.save(mercadoria);
		return ResponseEntity.ok().build();
	}
}
