import React from 'react';
import { useNavigate, Link } from 'react-router-dom';

function TipoCliente() {
    const navigate = useNavigate();

    const handleRedirect = (tipoCadastro) => {
        navigate(`/cadastroTitular/${tipoCadastro}`);
    };

    return (
        <div>
            <h2>Selecionar Tipo de Cadastro</h2>
            <p>Escolha o tipo de cadastro:</p>
            <div>
                <button onClick={() => handleRedirect('titular')}>Cadastro Titular</button>
                <button onClick={() => handleRedirect('dependente')}>Cadastro Dependente</button>
            </div>
            <br></br>
            <Link to="/">
                <button>Voltar para a Home</button>
            </Link>
        </div>
    );
}

export default TipoCliente;
