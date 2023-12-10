import React, { useState, useEffect } from 'react';
import Cliente from '../entidades/Cliente';
import { Link } from 'react-router-dom';

function ListarCliente() {
    const [clientesTitulares, setClientesTitulares] = useState([]);
    const [clientesDependentes, setClientesDependentes] = useState([]);

    useEffect(() => {
        const clientes = Cliente.listarClientes();
        const titulares = clientes.filter(cliente => cliente.tipoCliente === 'titular');
        const dependentes = clientes.filter(cliente => cliente.tipoCliente === 'dependente');
        setClientesTitulares(titulares);
        setClientesDependentes(dependentes);
    }, []);

    const handleExcluirCliente = (id) => {
        Cliente.excluirCliente(id);
        console.log(`Cliente com ID ${id} foi removido.`);

        setClientesTitulares(clientesTitulares.filter(cliente => cliente.id !== id));
        setClientesDependentes(clientesDependentes.filter(cliente => cliente.id !== id));
    };

    return (
        <div>
            <h2>Lista de Clientes</h2>

            <div>
                <h3>Titulares</h3>
                <ul>
                    {clientesTitulares.map((cliente) => (
                        <li key={cliente.id}>
                            <strong>Nome:</strong> {cliente.nome}, <strong>Nome Social:</strong> {cliente.nomeSocial}, <strong>Data de Nascimento:</strong> {cliente.dataNascimento}
                            {' '}
                            <Link to={`/alterarCliente/${cliente.id}`}>
                                <button>Alterar</button>
                            </Link>
                            {' '}
                            <button onClick={() => handleExcluirCliente(cliente.id)}>Excluir</button>
                        </li>
                    ))}
                </ul>
            </div>

            <div>
                <h3>Dependentes</h3>
                <ul>
                    {clientesDependentes.map((cliente) => (
                        <li key={cliente.id}>
                            <strong>Nome:</strong> {cliente.nome}, <strong>Nome Social:</strong> {cliente.nomeSocial}, <strong>Data de Nascimento:</strong> {cliente.dataNascimento}
                            {' '}
                            <Link to={`/alterarCliente/${cliente.id}`}>
                                <button>Alterar</button>
                            </Link>
                            {' '}
                            <button onClick={() => handleExcluirCliente(cliente.id)}>Excluir</button>
                        </li>
                    ))}
                </ul>
            </div>

            <br></br>
            <Link to="/">
                <button>Voltar para a Home</button>
            </Link>
        </div>
    );
}

export default ListarCliente;
