package visao;

import java.util.ArrayList;

import dominio.ClasseProduto;
import servico.ClasseProdutoServico;

public class ClasseProdutoVisao {
    public void Exibir(){
        //ClasseProdutoRepositorio repo = new ClasseProdutoRepositorio();
        //ArrayList<ClasseProduto> lista = repo.Browse();
        ClasseProdutoServico srv = new ClasseProdutoServico();
        ArrayList<ClasseProduto> lista = srv.Navegar();
        System.out.println("=====================================================");
        for (ClasseProduto cp : lista) {
            this.Imprimir(cp);            
        }
    }

    private void Imprimir(ClasseProduto alvo){
        System.out.println("Classe de produto: ");
        System.out.println("Código: " +alvo.getCodigo());
        System.out.println("Descrição: " +alvo.getDescricao());
        System.out.println("Data de inclusão: " +alvo.getDataDeInclusao());
        System.out.println("====================================================");
    }
}
