package visao;

import java.time.LocalDate;

import dominio.SubclasseProduto;

public class SubclasseProdutovisao {
    public void ExibirSub(){
        SubclasseProduto sp1 = new SubclasseProduto(1, "patinho", LocalDate.now(), 1);
        System.out.println("Subclasse de Produto:");
        System.out.println("Codigo: " + sp1.getCodigo());
        System.out.println("Descrição: " + sp1.getDescricao());
        System.out.println("Data de Inclusão: " + sp1.getDataDeInclusao());
        System.out.println("Codigo Classe: " + sp1.getCodigoClasse());
    }
}
