import React, { useState, useEffect } from 'react';
import Cliente from '../entidades/Cliente';
import { Link, useParams, useNavigate } from 'react-router-dom';

function AlterarCliente() {
    const [nome, setNome] = useState('');
    const [nomeSocial, setNomeSocial] = useState('');
    const [dataNascimento, setDataNascimento] = useState('');
    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        const clientes = Cliente.listarClientes();
        const cliente = clientes.find(cliente => cliente.id === parseInt(id, 10));

        if (cliente) {
            setNome(cliente.nome);
            setNomeSocial(cliente.nomeSocial);
            setDataNascimento(cliente.dataNascimento);
        }
    }, [id]);

    const handleAlterarCliente = () => {
        Cliente.alterarCliente(parseInt(id, 10), nome, nomeSocial, dataNascimento);
        navigate('/listarClientes');
    };

    return (
        <div>
            <div>
                <h2>Alterar Cliente</h2>
                <label>
                    Nome:
                    <input type="text" value={nome} onChange={(e) => setNome(e.target.value)} />
                </label>
                <label>
                    Nome Social:
                    <input type="text" value={nomeSocial} onChange={(e) => setNomeSocial(e.target.value)} />
                </label>
                <label>
                    Data de Nascimento:
                    <input type="date" value={dataNascimento} onChange={(e) => setDataNascimento(e.target.value)} />
                </label>
                <button onClick={handleAlterarCliente}>Finalizar Alteração</button>

                <Link to="/listarClientes">
                    <button>Cancelar</button>
                </Link>
            </div>
            <br></br>
            <Link to="/">
                <button>Voltar para a Home</button>
            </Link>
        </div>
    );
}

export default AlterarCliente;
