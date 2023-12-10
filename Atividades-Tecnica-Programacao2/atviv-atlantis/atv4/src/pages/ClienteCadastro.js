import React, { useState } from 'react';
import Cliente from '../entidades/Cliente';
import { Link, useParams, useNavigate } from 'react-router-dom';

function CadastroClienteTitular() {
    const { tipoCliente } = useParams();
    const [nome, setNome] = useState('');
    const [nomeSocial, setNomeSocial] = useState('');
    const [dataNascimento, setDataNascimento] = useState('');
    const navigate = useNavigate();

    const handleSubmit = () => {
        Cliente.adicionarCliente(nome, nomeSocial, dataNascimento, tipoCliente); // Passar o tipo de cliente ao adicionar o cliente
        navigate('/listarClientes');
    };

    return (
        <div>
            <div>
                <h2>Cadastro de Cliente {tipoCliente}</h2>
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
                <button onClick={handleSubmit}>Finalizar Cadastro</button>
            </div>
            <br></br>
            <Link to="/">
                <button>Voltar para a Home</button>
            </Link>
        </div>
    );
}

export default CadastroClienteTitular;
