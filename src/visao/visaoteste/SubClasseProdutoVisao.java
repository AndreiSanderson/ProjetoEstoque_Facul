package visao.visaoteste;

import java.util.ArrayList;

import dominio.SubClasseProduto;
import servico.SubClasseProdutoServico;

public class SubClasseProdutoVisao {
    
    private SubClasseProdutoServico srv;

    public SubClasseProdutoVisao(){
        this.srv = new SubClasseProdutoServico();
    }
    
    public void Exibir(){
        ArrayList<SubClasseProduto> lista = this.srv.Navegar();
        System.out.println("=====================================================");
        for (SubClasseProduto alvo : lista) {
            this.Imprimir(alvo);
        }
    }



    public void Imprimir(SubClasseProduto alvo){
        System.out.println("Classe de produto: ");
        System.out.println("Código: " +alvo.getCodigo());
        System.out.println("Descrição: " +alvo.getDescricao());
        System.out.println("Data de inclusão: " +alvo.getDataDeInclusao());
        System.out.println("====================================================");
    }

    public void ImprimirPorLinha(SubClasseProduto alvo){
        String mensagem = "";
        mensagem += "SubClasse de Produto: ";
        mensagem += "Código: " +alvo.getCodigo() +" | ";
        mensagem += "Descrição: " +alvo.getDescricao()+" | ";
        mensagem += "Data de inclusão: " +alvo.getDataDeInclusao()+" | ";
        mensagem += "Codigo da Classe" +alvo.getCodigoClasse() +"|";
        System.out.println(mensagem);
    }

    
    public void ImprimirPorLinha(int chave){
        SubClasseProduto alvo = this.srv.Ler(chave);
        this.ImprimirPorLinha(alvo);
    }


    public void Criar(SubClasseProduto novo){
        this.srv.Adicionar(novo);
    }

    public void Editar(int chave, SubClasseProduto alt){
        SubClasseProduto alvo = this.srv.Ler(chave);
        if (alvo != null){
            alvo.setDescricao(alt.getDescricao());
        }else{
            System.out.println("Item não localizado.");
        }
    }

    public void Remover(int chave){
        SubClasseProduto alvo = this.srv.Ler(chave);
        if (alvo != null){
            this.srv.Deletar(chave);
        }else{
            System.out.println("Item não localizado.");
        }
    }
}
