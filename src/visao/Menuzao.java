package visao;

import java.util.Scanner;

import visao.menu.ClasseProdutoMenu;
import visao.menu.ClienteMenu;
import visao.menu.CursoMenu;
import visao.menu.FornecedorMenu;
import visao.menu.FuncionarioMenu;
import visao.menu.LivroMenu;
import visao.menu.ProdutoMenu;
import visao.menu.SubClasseProdutoMenu;
import visao.menu.VeiculoMenu;

public class Menuzao {
    public Menuzao(){
    }
    public void ExibirMenuzao(){
        Menuzao menuzao = new Menuzao();
        ClasseProdutoMenu classeProdutoMenu = new ClasseProdutoMenu();
        SubClasseProdutoMenu subClasseProdutoMenu = new SubClasseProdutoMenu();
        ProdutoMenu produtoMenu = new ProdutoMenu();
        ClienteMenu clienteMenu = new ClienteMenu();
        CursoMenu cursoMenu = new CursoMenu();
        FornecedorMenu fornecedorMenu = new FornecedorMenu();
        FuncionarioMenu funcionarioMenu = new FuncionarioMenu();
        LivroMenu livroMenu = new LivroMenu();
        VeiculoMenu veiculoMenu = new VeiculoMenu();
        int opcao = 0;
        Scanner scanner = new Scanner(System.in);
        Util.LimparConsole();
        System.out.println("Por gentileza, informe qual modulo deseja utilizar:");
        System.out.printf("========================\n1 - Classe Produto\n========================\n2 - SubClasse Produto\n========================\n3 - Produto\n========================\n4 - Cliente\n========================\n5 - Curso\n========================\n6 - Fornecedor\n========================\n7 - Funcionario\n========================\n8 - Livro\n========================\n9 - Veiculo\n========================\n0 - Sair\n========================\n");
        try {
            opcao = scanner.nextInt();
            switch (opcao) {
            case 1:
                classeProdutoMenu.ExibirMenu();;  
                break;
            case 2:
                subClasseProdutoMenu.ExibirMenu();
                break;
            case 3:
                produtoMenu.ExibirMenu();
                break;
            case 4:
                clienteMenu.ExibirMenu();
                break;
            case 5:
                cursoMenu.ExibirMenu();
                break;
            case 6:
                fornecedorMenu.ExibirMenu();
                break;
            case 7:
                funcionarioMenu.ExibirMenu();
                break;
            case 8:
                livroMenu.ExibirMenu();
                break;
            case 9:
                veiculoMenu.ExibirMenu();
                break;
            case 0:
                System.out.println("Encerrando...");
                break;
            default:
                System.out.println("Opção Inválida!");
                break;
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            System.out.println("Clique <ENTER> para continuar...");
            scanner.nextLine();
            scanner.nextLine();
            menuzao.ExibirMenuzao();
        }
    scanner.close();
    }
}
