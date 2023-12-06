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

import com.autobots.automanager.servicos.AssociarUsuarioEmpresa;
import com.autobots.automanager.servicos.EmpresaAtualizar;
import com.autobots.automanager.servicos.EmpresaListar;
import com.autobots.automanager.dto.DadosListaEmpresa;
import com.autobots.automanager.dto.DadosObterEmpresa;
import com.autobots.automanager.dto.DadosAtualizaEmpresa;
import com.autobots.automanager.entitades.Empresa;
import com.autobots.automanager.repositorios.RepositorioEmpresa;

@RestController
@RequestMapping("/empresa")
public class EmpresaControle {
	
	@Autowired
    private RepositorioEmpresa repositorioEmpresa;
	
	@Autowired
	private EmpresaListar empresaListar;
	
	@Autowired
	private EmpresaAtualizar empresaAtualizar;
	
	@Autowired
    private AssociarUsuarioEmpresa AssociarUsuarioEmpresa;
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosObterEmpresa> pegarEmpresa(@PathVariable long id){
		DadosObterEmpresa empresa = empresaListar.obterEmpresa(id);
		if(empresa != null) {
			return ResponseEntity.ok(empresa);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/listar")
    public ResponseEntity<List<DadosListaEmpresa>> listarEmpresas() {
		List<DadosListaEmpresa> listaEmpresa = empresaListar.listarTodos();
		return ResponseEntity.ok(listaEmpresa);
    }
	
	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastrarEmpresa(@RequestBody Empresa empresa) {
		repositorioEmpresa.save(empresa);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/atualizar")
	@Transactional
    public ResponseEntity<?> atualizarEmpresa(@RequestBody DadosAtualizaEmpresa empresaAtualizada) {
		Boolean existe = empresaAtualizar.atualizar(empresaAtualizada);
        if (existe) {
        	return ResponseEntity.ok().build();
        }else {
        	return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluirEmpresa(@PathVariable long id) {
    	repositorioEmpresa.deleteById(id);
		return ResponseEntity.ok().build();
    }
    
    @PostMapping("/{idEmpresa}/associar-usuario/{idUsuario}")
    public ResponseEntity<?> associarUsuarioEmpresa(@PathVariable long idEmpresa, @PathVariable long idUsuario) {
        boolean associado = AssociarUsuarioEmpresa.associarUsuarioEmpresa(idUsuario, idEmpresa);
        if (associado) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
