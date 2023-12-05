package com.autobots.automanager.modelo.Links;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.DocumentoControle;
import com.autobots.automanager.controles.EnderecoControle;
import com.autobots.automanager.entidades.Endereco;

@Component
public class AdicionadorLinkEndereco implements AdicionadorLink<Endereco> {

	@Override
    public void adicionarLink(List<Endereco> lista) {
		for (Endereco endereco : lista) {
			adicionarLinksEndereco(endereco);
        }
	}
	
	@Override
    public void adicionarLink(Endereco objeto) {
		adicionarLinksEndereco(objeto);
    }

	private void adicionarLinksEndereco(Endereco endereco) {
		long id = endereco.getId();

        Link linkProprio = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(EnderecoControle.class)
                        .obterEndereco(id))
                .withSelfRel();
        endereco.add(linkProprio);

        Link linkExcluir = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(EnderecoControle.class)
                        .excluirEndereco(id))
                .withRel("excluir");
        endereco.add(linkExcluir);

        Link linkEnderecos = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(EnderecoControle.class)
                        .obterEnderecos())
                .withRel("enderecos");
        endereco.add(linkEnderecos);
    }
}
