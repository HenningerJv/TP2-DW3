import React, { useState, useEffect } from 'react';
import Acomodacao from '../entidades/Acomodacao';
import { Link } from 'react-router-dom';

function ListarAcomodacoes() {
    const [acomodacoes, setAcomodacoes] = useState([]);

    useEffect(() => {
        const listaAcomodacoes = Acomodacao.listarAcomodacoes();
        setAcomodacoes(listaAcomodacoes);
    }, []);

    const handleExcluirAcomodacao = (id) => {
        Acomodacao.excluirAcomodacao(id);
        console.log(`Acomodação com ID ${id} foi removida.`);
        setAcomodacoes(acomodacoes.filter(acomodacao => acomodacao.id !== id));
    };

    return (
        <div>
            <h2>Lista de Acomodações</h2>
            <ul>
                {acomodacoes.map((acomodacao) => (
                    <li key={acomodacao.id}>
                        <strong>Nome:</strong> {acomodacao.nome}, <strong>Camas de Solteiro:</strong> {acomodacao.camaSolteiro}, <strong>Camas de Casal:</strong> {acomodacao.camaCasal},
                        <strong>Suíte:</strong> {acomodacao.suite}, <strong>Climatização:</strong> {acomodacao.climatizacao ? 'Sim' : 'Não'}, <strong>Garagem:</strong> {acomodacao.garagem}
                        {' '}
                        <Link to={`/alterarAcomodacao/${acomodacao.id}`}>
                            <button>Alterar</button>
                        </Link>
                        {' '}
                        <button onClick={() => handleExcluirAcomodacao(acomodacao.id)}>Excluir</button>
                    </li>
                ))}
            </ul>
            <br></br>
            <Link to="/">
                <button>Voltar para a Home</button>
            </Link>
        </div>
    );
}

export default ListarAcomodacoes;
