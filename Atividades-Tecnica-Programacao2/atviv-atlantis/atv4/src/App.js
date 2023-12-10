import './App.css';
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import TipoCliente from './pages/TipoCliente';
import CadastroClienteTitular from './pages/ClienteCadastro';
import ListaClientes from './pages/ListarCliente';
import AlterarCliente from './pages/AlterarCliente';
import CadastroAcomodacao from './pages/AcomodacaoCadastro';
import ListarAcomodacoes from './pages/ListarAcomodacoes';
import AlterarAcomodacao from './pages/AlterarAcomodacao';

function App() {
  return (
    <Router>
      <div>
        <Routes>
          {/* Cliente */}
          <Route exact path="/" element={<Home />} />
          <Route exact path="/tipoCliente" element={<TipoCliente />} />
          <Route exact path="/cadastroTitular/:tipoCliente" element={<CadastroClienteTitular />} />
          <Route exact path="/listarClientes" element={<ListaClientes/>} />
          <Route exact path="/alterarCliente/:id" element={<AlterarCliente />} />
          {/* Acomodação */}
          <Route exact path="/criar-acomodacao" element={<CadastroAcomodacao />} />
          <Route exact path="/listarAcomodacoes" element={<ListarAcomodacoes />} />
          <Route exact path="/alterarAcomodacao/:id" element={<AlterarAcomodacao />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
