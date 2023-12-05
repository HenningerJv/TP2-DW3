package com.autobots.automanager.modelo.Links;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.TelefoneControle;
import com.autobots.automanager.entidades.Telefone;

@Component
public class AdicionadorLinkTelefone implements AdicionadorLink<Telefone>{
	
	@Override
    public void adicionarLink(List<Telefone> lista) {
        for (Telefone telefone : lista) {
            adicionarLinksTelefone(telefone);
        }
    }

    @Override
    public void adicionarLink(Telefone objeto) {
    	adicionarLinksTelefone(objeto);
    }

    private void adicionarLinksTelefone(Telefone telefone) {
        long id = telefone.getId();

        Link linkProprio = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(TelefoneControle.class)
                        .obterTelefone(id))
                .withSelfRel();
        telefone.add(linkProprio);

        Link linkExcluir = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(TelefoneControle.class)
                        .excluirTelefone(id))
                .withRel("excluir");
        telefone.add(linkExcluir);

        Link linkTelefones = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(TelefoneControle.class)
                        .obterTelefones())
                .withRel("telefones");
        telefone.add(linkTelefones);
    }
}
