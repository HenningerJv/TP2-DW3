package com.autobots.automanager.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entitades.Usuario;
import com.autobots.automanager.entitades.Empresa;
import com.autobots.automanager.repositorios.RepositorioEmpresa;
import com.autobots.automanager.repositorios.RepositorioUsuario;

@Service
public class AssociarUsuarioEmpresa {
	
	@Autowired
	private RepositorioEmpresa repositorioEmpresa;
	
	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	public boolean associarUsuarioEmpresa(Long idUsuario, Long idEmpresa) {
        Usuario usuario = repositorioUsuario.findById(idUsuario).orElse(null);
        Empresa empresa = repositorioEmpresa.findById(idEmpresa).orElse(null);

        if (usuario != null && empresa != null) {
            empresa.getUsuarios().add(usuario);
            repositorioEmpresa.save(empresa);
            return true;
        }
        return false;
    }
}
