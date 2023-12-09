package com.autobots.automanager.dto;

import com.autobots.automanager.enumeracoes.TipoVeiculo;

public record VeiculoDTO(
    Long id,
    TipoVeiculo tipo,
    String modelo,
    String placa
) {}
