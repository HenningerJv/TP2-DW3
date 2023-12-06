package com.autobots.automanager.controles;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.dto.DadosAtualizaEmpresa;
import com.autobots.automanager.dto.DadosListaUsuario;
import com.autobots.automanager.dto.DadosObterUsuario;
import com.autobots.automanager.dto.DadosAtualizaUsuario;

import com.autobots.automanager.entitades.Usuario;
import com.autobots.automanager.repositorios.RepositorioUsuario;
import com.autobots.automanager.servicos.UsuarioAtualizar;
import com.autobots.automanager.servicos.UsuarioListar;

@RestController
@RequestMapping("/usuario")
public class UsuarioControle {
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	@Autowired
	private UsuarioListar usuarioListar;
	
	@Autowired
	private UsuarioAtualizar usuarioAtualizar;
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosObterUsuario> pegarUsuario(@PathVariable long id){
		DadosObterUsuario usuario = usuarioListar.obterUsuario(id);
		if(usuario != null) {
			return ResponseEntity.ok(usuario);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/listar")
    public ResponseEntity<List<DadosListaUsuario>> listarEmpresas() {
		List<DadosListaUsuario> listaUsuario = usuarioListar.listarTodos();
		return ResponseEntity.ok(listaUsuario);
    }
	
	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastrarUsuario(@RequestBody Usuario usuario) {
		repositorioUsuario.save(usuario);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/atualizar")
	@Transactional
    public ResponseEntity<?> atualizarUsuario(@RequestBody DadosAtualizaUsuario usuarioAtualizada) {
		Boolean existe = usuarioAtualizar.atualizar(usuarioAtualizada);
        if (existe) {
        	return ResponseEntity.ok().build();
        }else {
        	return ResponseEntity.badRequest().build();
        }
    }
	
	@DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirUsuario(@PathVariable long id) {
    	repositorioUsuario.deleteById(id);
		return ResponseEntity.ok().build();
    }
}
