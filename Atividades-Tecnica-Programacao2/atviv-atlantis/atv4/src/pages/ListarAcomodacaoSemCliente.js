import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import Acomodacao from '../entidades/Acomodacao';

function ListarAcomodacoesSemCliente() {
    const navigate = useNavigate();
    const acomodacoesSemCliente = Acomodacao.listarAcomodacoes().filter(acomodacao => !acomodacao.usuario);

    const handleAlocarCliente = (idAcomodacao) => {
        navigate(`/alocarCliente/${idAcomodacao}`);
    };

    return (
        <div>
            <h2>Acomodações sem Cliente</h2>
            <ul>
                {acomodacoesSemCliente.map(acomodacao => (
                    <li key={acomodacao.id}>
                        {acomodacao.nome}
                        <button onClick={() => handleAlocarCliente(acomodacao.id)}>Alocar Cliente</button>
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

export default ListarAcomodacoesSemCliente;
