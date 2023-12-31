package com.autobots.automanager.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.modelo.DocumentoAtualizador;
import com.autobots.automanager.repositorios.DocumentoRepositorio;

@RestController
@RequestMapping("/documento")
public class DocumentoControle {
    @Autowired
    private DocumentoRepositorio repositorio;

    @GetMapping("/{id}")
    public Documento obterDocumento(@PathVariable long id) {
        return repositorio.findById(id).orElse(null);
    }

    @GetMapping("/documentos")
    public List<Documento> obterDocumentos() {
        return repositorio.findAll();
    }

    @PostMapping("/cadastro")
    public void cadastrarDocumento(@RequestBody Documento documento) {
        repositorio.save(documento);
    }

    @PutMapping("/atualizar")
    public void atualizarDocumento(@RequestBody Documento atualizacao) {
        List<Documento> documentos = repositorio.findAll();
        DocumentoAtualizador atualizador = new DocumentoAtualizador();
        atualizador.atualizar(documentos, List.of(atualizacao));
        
        repositorio.saveAll(documentos);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirDocumento(@PathVariable Long id) {
        repositorio.deleteById(id);
    }
}

