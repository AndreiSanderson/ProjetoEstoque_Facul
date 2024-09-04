package visao;

import java.util.ArrayList;

import dominio.ClasseProduto;
import repositorio.ClasseProdutoRepo;

public class ClasseProdutoVisao {
    public void Exibir(){
        ClasseProdutoRepo repo = new ClasseProdutoRepo();
        ArrayList<ClasseProduto> lista = repo.Browse();
        for (ClasseProduto cp : lista) {
            this.Imprimir(cp);            
        }
    }

    private void Imprimir(ClasseProduto alvo){
        System.out.println("Classe de produto: ");
        System.out.println("Código: " +alvo.getCodigo());
        System.out.println("Descrição: " +alvo.getDescricao());
        System.out.println("Data de inclusão: " +alvo.getDataDeInclusao());
        System.out.println();
    }
}
