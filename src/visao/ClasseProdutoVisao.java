package visao;

import java.util.ArrayList;

import dominio.ClasseProduto;
import fakedb.ClasseProdutoFakeDB;

public class ClasseProdutoVisao {
    public void Exibir(){
        
        ClasseProdutoFakeDB fakeDB = new ClasseProdutoFakeDB();
        ArrayList<ClasseProduto> tabelaProduto = fakeDB.getTabela();
        for (ClasseProduto cp : tabelaProduto) {
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
