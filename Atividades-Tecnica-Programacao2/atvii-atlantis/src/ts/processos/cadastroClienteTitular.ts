import Processo from "../abstracoes/processo";
import Armazem from "../dominio/armazem";
import Cliente from "../modelos/cliente";
import CadastrarDocumentosCliente from "./cadastrarDocumentosCliente";
import CadastroEnderecoTitular from "./cadastroEnderecoTitular";
import CadastroClienteDependente from "./cadastroClienteDependente";

export default class CadastroClienteTitular extends Processo {
    processar(): void {
        console.log('Iniciando o cadastro de um novo cliente...')
        let nome = this.entrada.receberTexto('Qual o nome do novo cliente?')
        let nomeSocial = this.entrada.receberTexto('Qual o nome social do novo cliente?')
        let dataNascimento = this.entrada.receberData('Qual a data de nascimento?')
        let cliente = new Cliente(nome, nomeSocial, dataNascimento)
        this.opcao = this.entrada.receberNumero('Possui Dependentes?')
        while (this.execucao) {
            console.log(`Opções:`);
            console.log(`1 - Sim`);
            console.log(`2 - Não`);
            switch (this.opcao) {
                case 1:
                    this.processo = new CadastroClienteDependente()
                    this.processo.processar()
                    break;
                case 2:
                    console.log('Sem dependentes. Ok')
                default:
                    console.log('Opção não entendida :(')
            }
        }

        this.processo = new CadastroEnderecoTitular(cliente)
        this.processo.processar()

        this.processo = new CadastrarDocumentosCliente(cliente)
        this.processo.processar()

        let armazem = Armazem.InstanciaUnica
        armazem.Clientes.push(cliente)

        console.log('Finalizando o cadastro do cliente...')
    }
}