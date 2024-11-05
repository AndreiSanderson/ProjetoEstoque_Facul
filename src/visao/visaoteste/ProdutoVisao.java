package visao.visaoteste;

import java.util.ArrayList;

import dominio.Produto;
import servico.ProdutoServico;

public class ProdutoVisao {
    private ProdutoServico srv;

    public ProdutoVisao(){
        this.srv = new ProdutoServico();
    }
    
    public void Exibir(){
        ArrayList<Produto> lista = this.srv.Navegar();
        System.out.println("=====================================================");
        for (Produto alvo : lista) {
            this.Imprimir(alvo);
        }
    }

    public void Imprimir(Produto alvo){
        System.out.println("Produto: ");
        System.out.println("Código: " +alvo.getCodigo());
        System.out.println("Descrição: " +alvo.getDescricao());
        System.out.println("Data de inclusão: " +alvo.getDataDeInclusao());
        System.out.println("Código de SubClasse: " +alvo.getCodigoSubClasse());
        System.out.println("Valor: "+alvo.getValor());
        System.out.println("====================================================");
    }

    public void ImprimirPorLinha(Produto alvo){
        String mensagem = "";
        mensagem += "Classe de produto: ";
        mensagem += "Código: " +alvo.getCodigo() +" | ";
        mensagem += "Descrição: " +alvo.getDescricao()+" | ";
        mensagem += "Data de inclusão: " +alvo.getDataDeInclusao()+" | ";
        mensagem += "Código de SubClasse: " +alvo.getCodigoSubClasse() + "|";
        mensagem += "Valor: " +alvo.getValor() +"|";
        System.out.println(mensagem);
    }
    
    public void ImprimirPorLinha(int chave){
        Produto alvo = this.srv.Ler(chave);
        this.ImprimirPorLinha(alvo);
    }

    public void Criar(Produto novo){
        this.srv.Adicionar(novo);
    }

    public void Editar(int chave, Produto alt){
        Produto alvo = this.srv.Ler(chave);
        if (alvo != null){
            alvo.setDescricao(alt.getDescricao());
            alvo.setValor(alt.getValor());
        }else
            System.out.println("Item não localizado.");
        }

    public void Remover(int chave){
        Produto alvo = this.srv.Ler(chave);
        if (alvo != null){
            this.srv.Deletar(chave);
        }else{
            System.out.println("Item não localizado.");
        }
    }
}
