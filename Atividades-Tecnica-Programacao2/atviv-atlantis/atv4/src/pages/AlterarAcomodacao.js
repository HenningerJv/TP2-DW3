import React, { useState, useEffect } from 'react';
import { useParams, Link, useNavigate } from 'react-router-dom';
import Acomodacao from '../entidades/Acomodacao';

function AlterarAcomodacao() {
    const { id } = useParams();
    const navigate = useNavigate();

    const [nome, setNome] = useState('');
    const [camaSolteiro, setCamaSolteiro] = useState(0);
    const [camaCasal, setCamaCasal] = useState(0);
    const [suite, setSuite] = useState(0);
    const [climatizacao, setClimatizacao] = useState(false);
    const [garagem, setGaragem] = useState(0);

    useEffect(() => {
        const acomodacao = Acomodacao.listarAcomodacoes().find(ac => ac.id === parseInt(id));
        if (acomodacao) {
            setNome(acomodacao.nome);
            setCamaSolteiro(acomodacao.camaSolteiro);
            setCamaCasal(acomodacao.camaCasal);
            setSuite(acomodacao.suite);
            setClimatizacao(acomodacao.climatizacao);
            setGaragem(acomodacao.garagem);
        }
    }, [id]);

    const handleSubmit = () => {
        // Lógica para alterar a acomodação aqui
        Acomodacao.atualizarAcomodacao(parseInt(id), nome, camaSolteiro, camaCasal, suite, climatizacao, garagem);
        navigate('/listarAcomodacoes');
    };

    return (
        <div>
            <h2>Alterar Acomodação</h2>
            <label>
                Nome:
                <input type="text" value={nome} onChange={(e) => setNome(e.target.value)} />
            </label>
            <label>
                Camas de Solteiro:
                <input type="number" value={camaSolteiro} onChange={(e) => setCamaSolteiro(parseInt(e.target.value))} />
            </label>
            <label>
                Camas de Casal:
                <input type="number" value={camaCasal} onChange={(e) => setCamaCasal(parseInt(e.target.value))} />
            </label>
            <label>
                Suíte:
                <input type="number" value={suite} onChange={(e) => setSuite(parseInt(e.target.value))} />
            </label>
            <label>
                Climatização:
                <input type="checkbox" checked={climatizacao} onChange={(e) => setClimatizacao(e.target.checked)} />
            </label>
            <label>
                Garagem:
                <input type="number" value={garagem} onChange={(e) => setGaragem(parseInt(e.target.value))} />
            </label>
            <button onClick={handleSubmit}>Atualizar Acomodação</button>
            <br></br>
            <Link to="/listarAcomodacoes">
                <button>Voltar para a Lista de Acomodações</button>
            </Link>
        </div>
    );
}

export default AlterarAcomodacao;
