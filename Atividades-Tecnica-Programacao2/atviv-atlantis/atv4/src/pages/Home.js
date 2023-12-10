import React from 'react';
import { Link } from 'react-router-dom';

function Home() {
  return (
    <div>
      <h2>Menu Principal</h2>
      <div>
        <p>Por favor, selecione uma opção...</p>
        <hr />
        <p>Opções para cliente:</p>
        <Link to="/tipoCliente"><button>Cadastrar cliente</button></Link>
        <Link to="/listarClientes"><button>Listar/Editar cliente(s)</button></Link>
        <hr />
        <p>Opções para gestão:</p>
        <Link to="/criar-acomodacao"><button>Criar acomodação</button></Link>
        <Link to="/listarAcomodacoes"><button>Listar acomodações</button></Link>
        <Link to="/listarAcomodacoesSemCliente"><button>Acomodar clientes aos quartos</button></Link>
        <hr />
      </div>
    </div>
  );
}

export default Home;
