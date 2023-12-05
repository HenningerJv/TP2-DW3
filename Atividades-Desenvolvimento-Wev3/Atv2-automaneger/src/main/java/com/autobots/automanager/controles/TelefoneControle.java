package com.autobots.automanager.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.modelo.TelefoneAtualizador;
import com.autobots.automanager.modelo.Links.AdicionadorLinkTelefone;
import com.autobots.automanager.repositorios.TelefoneRepositorio;

import java.util.List;

@RestController
@RequestMapping("/telefone")
public class TelefoneControle {
	@Autowired
    private TelefoneRepositorio repositorio;

	@Autowired
	private AdicionadorLinkTelefone adicionadorLink;
	
    @GetMapping("/{id}")
    public ResponseEntity<Telefone> obterTelefone(@PathVariable long id) {
        Telefone telefone = repositorio.findById(id).orElse(null);
        if (telefone == null) {
			ResponseEntity<Telefone> resposta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(telefone);
			ResponseEntity<Telefone> resposta = new ResponseEntity<Telefone>(telefone, HttpStatus.OK);
			return resposta;
		}
    }

    @GetMapping("/telefones")
    public ResponseEntity<List<Telefone>> obterTelefones() {
        List<Telefone> telefones = repositorio.findAll();
        if (telefones.isEmpty()) {
			ResponseEntity<List<Telefone>> resposta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(telefones);
			ResponseEntity<List<Telefone>> resposta = new ResponseEntity<>(telefones, HttpStatus.OK);
			return resposta;
		}
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrarTelefone(@RequestBody Telefone telefone) {
    	HttpStatus status = HttpStatus.CONFLICT;
		if (telefone.getId() == null) {
	        repositorio.save(telefone);
			status = HttpStatus.CREATED;
		}
		return new ResponseEntity<>(status);
    }
    
    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizarTelefone(@RequestBody Telefone atualizacao) {
    	HttpStatus status = HttpStatus.CONFLICT;
        List<Telefone> telefones = repositorio.findAll();
		if (telefones != null) {
			 TelefoneAtualizador atualizador = new TelefoneAtualizador();
			atualizador.atualizar(telefones, List.of(atualizacao));
			repositorio.saveAll(telefones);
			status = HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(status);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirTelefone(@PathVariable Long id) {
    	HttpStatus status = HttpStatus.BAD_REQUEST;
		if (repositorio.existsById(id)) {
			repositorio.deleteById(id);
			status = HttpStatus.OK;
		}else {
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(status);
    }
}
