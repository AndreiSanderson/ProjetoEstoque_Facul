package visao.visaoteste;

import java.util.ArrayList;

import dominio.ClasseProduto;
import servico.ClasseProdutoServico;

public class ClasseProdutoVisao {

    private ClasseProdutoServico srv;

    public ClasseProdutoVisao(){
        this.srv = new ClasseProdutoServico();
    }
    
    public void Exibir(){
        ArrayList<ClasseProduto> lista = this.srv.Navegar();
        System.out.println("=====================================================");
        for (ClasseProduto alvo : lista) {
            this.Imprimir(alvo);
        }
    }



    public void Imprimir(ClasseProduto alvo){
        System.out.println("Classe de produto: ");
        System.out.println("Código: " +alvo.getCodigo());
        System.out.println("Descrição: " +alvo.getDescricao());
        System.out.println("Data de inclusão: " +alvo.getDataDeInclusao());
        System.out.println("====================================================");
    }

    public void ImprimirPorLinha(ClasseProduto alvo){
        String mensagem = "";
        mensagem += "Classe de produto: ";
        mensagem += "Código: " +alvo.getCodigo() +" | ";
        mensagem += "Descrição: " +alvo.getDescricao()+" | ";
        mensagem += "Data de inclusão: " +alvo.getDataDeInclusao()+" | ";
        System.out.println(mensagem);
    }

    
    public void ImprimirPorLinha(int chave){
        ClasseProduto alvo = this.srv.Ler(chave);
        this.ImprimirPorLinha(alvo);
    }


    public void Criar(ClasseProduto novo){
        this.srv.Adicionar(novo);
    }

    public void Editar(int chave, ClasseProduto alt){
        ClasseProduto alvo = this.srv.Ler(chave);
        if (alvo != null){
            alvo.setDescricao(alt.getDescricao());
        }else{
            System.out.println("Item não localizado.");
        }
    }

    public void Remover(int chave){
        ClasseProduto alvo = this.srv.Ler(chave);
        if (alvo != null){
            this.srv.Deletar(chave);
        }else{
            System.out.println("Item não localizado.");
        }
    }
}
