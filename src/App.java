import dominio.ClasseProduto;
import visao.menu.ClasseProdutoMenu;
import visao.visao2.ClasseProdutoVisao;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        
        ClasseProdutoMenu menuzinho = new ClasseProdutoMenu();
        menuzinho.ExibirMenu();
        

        /*ClasseProdutoVisao visao = new ClasseProdutoVisao();

        //Imprimir tudo
        System.out.println("Imprimindo tudo");
        visao.Exibir();

        //Criar nova instancia
        System.out.println("Criando nova instancia");
        ClasseProduto novo = new ClasseProduto(0, "Teste", LocalDate.now());
        visao.Criar(novo);
        visao.ImprimirPorLinha(novo);

        
        //Imprimir tudo
        System.out.println("Imprimindo tudo");
        visao.Exibir();

        //Editar instância recém adicionada.
        System.out.println("Alterando instancia");
        ClasseProduto alterado = new ClasseProduto();
        alterado.setCodigo(0);
        alterado.setDescricao("Teste de alteração");
        alterado.setDataDeInclusao(LocalDate.now());
        visao.Editar(6, alterado);
        visao.ImprimirPorLinha(6);
        
        System.out.println("Imprimindo tudo");
        visao.Exibir();

        //remover item 6
        System.out.println("Removendo");
        visao.Remover(6);

        System.out.println("Imprimindo tudo");
        visao.Exibir();*/
    }
}
