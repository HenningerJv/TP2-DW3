import React, { useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import Acomodacao from '../entidades/Acomodacao';
import Cliente from '../entidades/Cliente';

function AlocarClienteAcomodacao() {
  const { idAcomodacao } = useParams();
  const navigate = useNavigate();

  const [clienteSelecionado, setClienteSelecionado] = useState('');
  const clientesDisponiveis = Cliente.listarClientes().filter(cliente => !cliente.acomodacao);

  const handleAlocarCliente = () => {
    if (clienteSelecionado) {
      Acomodacao.alocarCliente(Number(idAcomodacao), Number(clienteSelecionado));
      navigate('/listarAcomodacoesSemCliente');
    }
  };

  return (
    <div>
      <h2>Alocar Cliente à Acomodação</h2>
      <p>Selecione um cliente para a acomodação:</p>
      <select value={clienteSelecionado} onChange={(e) => setClienteSelecionado(e.target.value)}>
        <option value="">Selecione um cliente</option>
        {clientesDisponiveis.map(cliente => (
          <option key={cliente.id} value={cliente.id}>{cliente.nome}</option>
        ))}
      </select>
      <br />
      <button onClick={handleAlocarCliente}>Alocar</button>
    </div>
  );
}

export default AlocarClienteAcomodacao;
