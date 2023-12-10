import './App.css';
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import TipoCliente from './pages/TipoCliente';
import CadastroClienteTitular from './pages/ClienteTitularCadastro';
import ListaClientes from './pages/ListarCliente';
import AlterarCliente from './pages/AlterarCliente';

function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route exact path="/tipoCliente" element={<TipoCliente />} />
          <Route exact path="/cadastroTitular/:tipoCliente" element={<CadastroClienteTitular />} />
          <Route exact path="/listarClientes" element={<ListaClientes/>} />
          <Route exact path="/alterarCliente/:id" element={<AlterarCliente />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
