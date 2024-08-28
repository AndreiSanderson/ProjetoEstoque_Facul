package visao;

import java.time.LocalDate;

import dominio.Produto;

public class Produtovisao {
    public void ExibirProduto(){
        Produto p1 = new Produto(1, "Bife", LocalDate.now(), 1, 25.50);
        System.out.println("Produto");
        System.out.println("Codigo: " +p1.getCodigo());
        System.out.println("descrição: " +p1.getDescricao());
        System.out.println("Data: " +p1.getDataDeInclusao());
        System.out.println("Codigo Subclasee: " +p1.getCodigoSubClasse());
        System.out.println("Valor: " +p1.getValor());
        System.out.println();
    }
}