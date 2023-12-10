class Acomodacao {
  constructor(
    id,
    nome,
    camaSolteiro,
    camaCasal,
    suite,
    climatizacao,
    garagem,
    usuario
  ) {
    this.id = id;
    this.nome = nome;
    this.camaSolteiro = camaSolteiro;
    this.camaCasal = camaCasal;
    this.suite = suite;
    this.climatizacao = climatizacao;
    this.garagem = garagem;
    this.usuario = usuario;
  }

  static acomodacoes = [];
  static proximoId = 1;
  
    static adicionarAcomodacao(nome, camaSolteiro, camaCasal, suite, climatizacao, garagem) {
      const novaAcomodacao = new Acomodacao(
        Acomodacao.proximoId++,
        nome,
        camaSolteiro,
        camaCasal,
        suite,
        climatizacao,
        garagem
      );
      Acomodacao.acomodacoes.push(novaAcomodacao);
    }
  
    static listarAcomodacoes() {
      return Acomodacao.acomodacoes;
    }
  
    static encontrarAcomodacaoPorId(id) {
      return Acomodacao.acomodacoes.find(acomodacao => acomodacao.id === id);
    }
  
    static atualizarAcomodacao(id, nome, camaSolteiro, camaCasal, suite, climatizacao, garagem) {
      const acomodacao = Acomodacao.encontrarAcomodacaoPorId(id);
      if (acomodacao) {
        acomodacao.nome = nome;
        acomodacao.camaSolteiro = camaSolteiro;
        acomodacao.camaCasal = camaCasal;
        acomodacao.suite = suite;
        acomodacao.climatizacao = climatizacao;
        acomodacao.garagem = garagem;
      }
    }
  
    static excluirAcomodacao(id) {
      Acomodacao.acomodacoes = Acomodacao.acomodacoes.filter(acomodacao => acomodacao.id !== id);
    }

    static alocarUsuario(idAcomodacao, idUsuario) {
      const acomodacao = Acomodacao.encontrarAcomodacaoPorId(idAcomodacao);
      if (acomodacao) {
        acomodacao.usuario = idUsuario;
      }
    }
  }
  
  export default Acomodacao;
  