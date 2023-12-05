package com.autobots.automanager.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.modelo.EnderecoAtualizador;
import com.autobots.automanager.repositorios.EnderecoRepositorio;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoControle {
    @Autowired
    private EnderecoRepositorio repositorio;

    @GetMapping("/{id}")
    public Endereco obterEndereco(@PathVariable long id) {
        return repositorio.findById(id).orElse(null);
    }

    @GetMapping("/enderecos")
    public List<Endereco> obterEnderecos() {
        return repositorio.findAll();
    }

    @PostMapping("/cadastro")
    public void cadastrarEndereco(@RequestBody Endereco endereco) {
        repositorio.save(endereco);
    }
    
    @PutMapping("/atualizar")
    public void atualizarEndereco(@RequestBody Endereco atualizacao) {
        Endereco endereco = repositorio.getById(atualizacao.getId());
        EnderecoAtualizador atualizador = new EnderecoAtualizador();
        atualizador.atualizar(endereco, atualizacao);
        
        repositorio.save(endereco);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirEndereco(@PathVariable Long id) {
        repositorio.deleteById(id);
    }
}
