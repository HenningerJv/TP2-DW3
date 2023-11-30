import Processo from "../abstracoes/processo";
import DiretorSolteiroSimples from "../diretores/diretorSolteiroSimples";
import DiretorSolteiroMais from "../diretores/diretorSolteiroMais";
import DiretorCasalSimples from "../diretores/diretorCasalSimples";
import DiretorFamiliaSimples from "../diretores/diretorFamiliaSimples";
import DiretorFamiliaSuper from "../diretores/diretorFamiliaSuper";
import DiretorFamiliaMais from "../diretores/diretorFamiliaMais";
import Armazem from "../dominio/armazem";
import Acomodacao from "../modelos/acomodacao";

export default class CadastroAcomodacoes extends Processo {
    private acomodacoes: Acomodacao[]
    constructor() {
        super()
        this.acomodacoes = Armazem.InstanciaUnica.Acomodacoes
    }
    processar(): void {
        let diretorSolteiroSimples = new DiretorSolteiroSimples()
        this.acomodacoes.push(diretorSolteiroSimples.construir())
    }
    processamento(): void {
        let diretorSolteiroMais = new DiretorSolteiroMais()
        this.acomodacoes.push(diretorSolteiroMais.construir())
    }
    construcao(): void {
        let diretorCasalSimples = new DiretorCasalSimples()
        this.acomodacoes.push(diretorCasalSimples.construir())
    }
    ocupacao(): void {
        let diretorFamiliaSimples = new DiretorFamiliaSimples()
        this.acomodacoes.push(diretorFamiliaSimples.construir())
    }
    cadastro(): void {
        let diretorFamiliaMais = new DiretorFamiliaMais()
        this.acomodacoes.push(diretorFamiliaMais.construir())
    }
    colocacao(): void {
        let diretorFamiliaSuper = new DiretorFamiliaSuper()
        this.acomodacoes.push(diretorFamiliaSuper.construir())
    }
}