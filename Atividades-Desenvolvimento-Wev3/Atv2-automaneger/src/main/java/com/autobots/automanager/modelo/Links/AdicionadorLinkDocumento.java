package com.autobots.automanager.modelo.Links;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controles.DocumentoControle;
import com.autobots.automanager.entidades.Documento;

@Component
public class AdicionadorLinkDocumento implements AdicionadorLink<Documento> {

    @Override
    public void adicionarLink(List<Documento> lista) {
        for (Documento documento : lista) {
            adicionarLinksDocumento(documento);
        }
    }

    @Override
    public void adicionarLink(Documento objeto) {
        adicionarLinksDocumento(objeto);
    }

    private void adicionarLinksDocumento(Documento documento) {
        long id = documento.getId();

        Link linkProprio = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(DocumentoControle.class)
                        .obterDocumento(id))
                .withSelfRel();
        documento.add(linkProprio);

        Link linkExcluir = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(DocumentoControle.class)
                        .excluirDocumento(id))
                .withRel("excluir");
        documento.add(linkExcluir);

        Link linkDocumentos = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(DocumentoControle.class)
                        .obterDocumentos())
                .withRel("documentos");
        documento.add(linkDocumentos);
    }
}
