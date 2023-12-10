export default class Cliente {
  constructor(id, nome, nomeSocial, dataNascimento, tipoCliente) {
    this.id = id;
    this.nome = nome;
    this.nomeSocial = nomeSocial;
    this.dataNascimento = dataNascimento;
    this.tipoCliente = tipoCliente;
  }

  static clientes = [];
  static proximoId = 1;

  static adicionarCliente(nome, nomeSocial, dataNascimento, tipoCliente) {
    const novoCliente = new Cliente(Cliente.proximoId++, nome, nomeSocial, dataNascimento, tipoCliente);
    Cliente.clientes.push(novoCliente);
  }

  static listarClientes() {
    return Cliente.clientes;
  }

  static alterarCliente(id, nome, nomeSocial, dataNascimento) {
    const cliente = Cliente.clientes.find(c => c.id === id);
    if (cliente) {
      cliente.nome = nome;
      cliente.nomeSocial = nomeSocial;
      cliente.dataNascimento = dataNascimento;
    }
  }

  static excluirCliente(id) {
    Cliente.clientes = Cliente.clientes.filter(cliente => cliente.id !== id);
  }

  static encontrarClientePorId(id) {
    return Cliente.clientes.find(cliente => cliente.id === id);
  }
}
