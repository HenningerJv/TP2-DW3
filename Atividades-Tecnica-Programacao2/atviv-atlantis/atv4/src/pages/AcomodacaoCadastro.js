import React, { useState } from 'react';
import Acomodacao from '../entidades/Acomodacao';
import { useNavigate } from 'react-router-dom';

function CadastroAcomodacao() {
  const [nome, setNome] = useState('');
  const [camaSolteiro, setCamaSolteiro] = useState(0);
  const [camaCasal, setCamaCasal] = useState(0);
  const [suite, setSuite] = useState(0);
  const [climatizacao, setClimatizacao] = useState(false);
  const [garagem, setGaragem] = useState(0);

  const navigate = useNavigate();

  const handleSubmit = () => {
    Acomodacao.adicionarAcomodacao(nome, camaSolteiro, camaCasal, suite, climatizacao, garagem);
    navigate('/listarAcomodacoes');
  };

  return (
    <div>
      <div>
        <h2>Cadastro de Acomodação</h2>
        <label>
          Nome:
          <input type="text" value={nome} onChange={(e) => setNome(e.target.value)} />
        </label>
        <label>
          Camas de Solteiro:
          <input type="number" value={camaSolteiro} onChange={(e) => setCamaSolteiro(e.target.value)} />
        </label>
        <label>
          Camas de Casal:
          <input type="number" value={camaCasal} onChange={(e) => setCamaCasal(e.target.value)} />
        </label>
        <label>
          Suíte:
          <input type="number" value={suite} onChange={(e) => setSuite(e.target.value)} />
        </label>
        <label>
          Climatização:
          <input type="checkbox" checked={climatizacao} onChange={(e) => setClimatizacao(e.target.checked)} />
        </label>
        <label>
          Garagem:
          <input type="number" value={garagem} onChange={(e) => setGaragem(e.target.value)} />
        </label>
        <button onClick={handleSubmit}>Finalizar Cadastro</button>
      </div>
    </div>
  );
}

export default CadastroAcomodacao;
