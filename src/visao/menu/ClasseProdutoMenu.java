package visao.menu;

import java.util.ArrayList;
import dominio.ClasseProduto;
import servico.ClasseProdutoServico;
import visao.Menuzao;
import visao.Util;
import java.time.LocalDate;

public class ClasseProdutoMenu extends BaseMenu{

    private ClasseProdutoServico srv;

    Menuzao menuzao = new Menuzao();

    public ClasseProdutoMenu(){
        super();
        this.srv = new ClasseProdutoServico();
    }

    @Override
    public void ExibirMenu() {
        int opcao = 0;         
        while (opcao != 9){
            Util.LimparConsole();
            System.out.println("Cadastro de Classes de Produto");
            System.out.println("1 - Listar");
            System.out.println("2 - Localizar");
            System.out.println("3 - Adicionar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("9 - Sair");
            System.out.print("Selecione uma opção: ");

            try {
            opcao = this.scanner.nextInt();
            switch (opcao) {
                case 1:
                    this.Listar();  
                    break;
                case 2:
                    this.Localizar();
                    break;
                case 3:
                    this.Adicionar();        
                    break;
                case 4:
                    this.Atualizar();
                    break;
                case 5:
                    this.Remover();        
                    break;
                case 9:
                    this.menuzao.ExibirMenuzao();
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
                }    
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Clique <ENTER> para continuar...");
                this.scanner.nextLine();
                this.scanner.nextLine();
            }
        }
    }

    @Override
    public void Listar() {
        Util.LimparConsole();
        System.out.println("listando");
        try {
            ArrayList<ClasseProduto> lista = this.srv.Navegar();
            System.out.println("=====================================================");
            for (ClasseProduto alvo : lista) {
                this.ImprimirPorLinha(alvo);
            }   
        } catch (Exception e) {
            System.out.println("Erro: " +e.getMessage());
            System.out.println("Clique <ENTER> para continuar...");
            this.scanner.nextLine();
            this.scanner.nextLine();
        }
        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.LimparConsole();      
        System.out.println("Localizando");
        System.out.print("Informe o código da classe de produto: ");
        int cod = this.scanner.nextInt();
        try {
            ClasseProduto cp = this.srv.Ler(cod);
            if(cp != null){
                this.ImprimirPorLinha(cp);
            }else{
                System.out.println("PROBLEMA - Classe de Produto não encontrada!");
            }
        } catch (Exception e) {
            System.out.println("Erro: " +e.getMessage());
            System.out.println("Clique <ENTER> para continuar...");
            this.scanner.nextLine();
            this.scanner.nextLine();
        }
        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
        Util.LimparConsole();      
        System.out.println("Adicionando");

        System.out.print("Informe a descrição do novo produto: ");
        String descricao = this.scanner.next();

        ClasseProduto cp = new ClasseProduto();
        cp.setDescricao(descricao);
        cp.setDataDeInclusao(LocalDate.now());
        try {
            if(this.srv.Adicionar(cp) != null){
                System.out.println("Classe de produto adicionada com sucesso!");
            }else{
                System.out.println("PROBLEMA - Erro ao adicionar uma nova classe produto!");
            }  
        } catch (Exception e) {
            System.out.println("Erro: " +e.getMessage());
            System.out.println("Clique <ENTER> para continuar...");
            this.scanner.nextLine();
            this.scanner.nextLine();
        }
        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.LimparConsole();      
        System.out.println("Atualizando");

        System.out.print("Informe o código da classe de produto: ");
        int cod = this.scanner.nextInt();
        try {
            ClasseProduto cp = this.srv.Ler(cod);
            if(cp != null){
                System.out.print("Informe a nova Descrição: ");
                String descricao = this.scanner.next();
                cp.setDescricao(descricao);
                if(this.srv.Editar(cp) != null){
                    System.out.println("Alteração realizada com sucesso!");
                }else{
                    System.out.println("PROBLEMA - Não foi possível realizar a alteração solicitada!");
                }
            }else{
            System.out.println("PROBLEMA - Classe de Produto não encontrada!");
        }
    } catch (Exception e) {
        System.out.println("Erro: " +e.getMessage());
        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Remover() {
        Util.LimparConsole();      
        System.out.println("Removendo");
        System.out.print("Informe o código da classe de produto: ");
        int cod = this.scanner.nextInt();
        try {
            ClasseProduto cp = this.srv.Ler(cod);
            if(cp != null){
                if(this.srv.Deletar(cod) != null){
                    System.out.println("Classe de produto excluída com sucesso!");
                }else{
                    System.out.println("PROBLEMA - Classe de produto não foi excluída!");
                }
            }else{
                System.out.println("PROBLEMA - Classe de Produto não encontrada!");
            }  
        } catch (Exception e) {
            System.out.println("Erro: " +e.getMessage());
            System.out.println("Clique <ENTER> para continuar...");
            this.scanner.nextLine();
            this.scanner.nextLine();
        }
        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    private void ImprimirPorLinha(ClasseProduto alvo){
    String mensagem = "";
    mensagem += "Classe de produto: ";
    mensagem += "Código: " +alvo.getCodigo() +" | ";
    mensagem += "Descrição: " +alvo.getDescricao()+" | ";
    mensagem += "Data de inclusão: " +alvo.getDataDeInclusao();
    System.out.println(mensagem);
    }
    
}
