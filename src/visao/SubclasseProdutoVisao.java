package visao;

import java.time.LocalDate;

import dominio.SubClasseProduto;

public class SubclasseProdutoVisao {
    public void ExibirSub(){
        SubClasseProduto sp1 = new SubClasseProduto(1, "patinho", LocalDate.now(), 1);
        System.out.println("Subclasse de Produto:");
        System.out.println("Codigo: " + sp1.getCodigo());
        System.out.println("Descrição: " + sp1.getDescricao());
        System.out.println("Data de Inclusão: " + sp1.getDataDeInclusao());
        System.out.println("Codigo Classe: " + sp1.getCodigoClasse());
        System.out.println();
    }
}