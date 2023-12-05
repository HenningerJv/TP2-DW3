package com.autobots.automanager.controles;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.modelo.DocumentoAtualizador;
import com.autobots.automanager.modelo.Links.AdicionadorLinkDocumento;
import com.autobots.automanager.repositorios.DocumentoRepositorio;

@RestController
@RequestMapping("/documento")
public class DocumentoControle {
    @Autowired
    private DocumentoRepositorio repositorio;
    
    @Autowired
	private AdicionadorLinkDocumento adicionadorLink;

    @GetMapping("/{id}")
    public ResponseEntity<Documento> obterDocumento(@PathVariable long id) {
        Documento documento = repositorio.findById(id).orElse(null);
        if (documento == null) {
			ResponseEntity<Documento> resposta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(documento);
			ResponseEntity<Documento> resposta = new ResponseEntity<Documento>(documento, HttpStatus.OK);
			return resposta;
		}
    }

    @GetMapping("/documentos")
    public ResponseEntity<List<Documento>> obterDocumentos() {
        List<Documento> documentos = repositorio.findAll();
        if (documentos.isEmpty()) {
			ResponseEntity<List<Documento>> resposta = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			return resposta;
		} else {
			adicionadorLink.adicionarLink(documentos);
			ResponseEntity<List<Documento>> resposta = new ResponseEntity<>(documentos, HttpStatus.OK);
			return resposta;
		}
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrarDocumento(@RequestBody Documento documento) {        
        HttpStatus status = HttpStatus.CONFLICT;
		if (documento.getId() == null) {
	        repositorio.save(documento);
			status = HttpStatus.CREATED;
		}
		return new ResponseEntity<>(status);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizarDocumento(@RequestBody Documento atualizacao) {
    	HttpStatus status = HttpStatus.CONFLICT;
        List<Documento> documentos = repositorio.findAll();
		if (documentos != null) {
			 DocumentoAtualizador atualizador = new DocumentoAtualizador();
			atualizador.atualizar(documentos, List.of(atualizacao));
			repositorio.saveAll(documentos);
			status = HttpStatus.OK;
		} else {
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(status);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirDocumento(@PathVariable Long id) {
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

