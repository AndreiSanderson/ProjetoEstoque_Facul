package visao.menu;

import java.time.LocalDate;
import java.util.ArrayList;

import dominio.SubClasseProduto;
import servico.SubClasseProdutoServico;
import visao.Menuzao;
import visao.Util;

public class SubClasseProdutoMenu extends BaseMenu{
    Menuzao menuzao = new Menuzao();
    private SubClasseProdutoServico srv;

    public SubClasseProdutoMenu(){
        super();
        this.srv = new SubClasseProdutoServico();
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
                System.out.println("Erro: " +e.getMessage());
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
            ArrayList<SubClasseProduto> lista = this.srv.Navegar();
            System.out.println("=====================================================");
            for (SubClasseProduto alvo : lista) {
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
        System.out.print("Informe o código da SubClasse de Produto: ");
        int cod = this.scanner.nextInt();
        try {
            SubClasseProduto scp = this.srv.Ler(cod);
            if(scp != null){
                this.ImprimirPorLinha(scp);
            }else{
                System.out.println("PROBLEMA - SubClasse de Produto não encontrada!");
            }
        } catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
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
        System.out.print("Informe a descrição da SubClasse de produto: ");
        String descricao = this.scanner.next();
        System.out.print("Informe o Código da Classe: ");
        int codigoClasse = this.scanner.nextInt();
        SubClasseProduto scp = new SubClasseProduto();
        scp.setDescricao(descricao);
        scp.setCodigoClasse(codigoClasse);
        scp.setDataDeInclusao(LocalDate.now());
        try {
            if(this.srv.Adicionar(scp) != null){
                System.out.println("SubClasse de Produto adicionada com sucesso!");
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
        System.out.print("Informe o código da SubClasse de Produto: ");
        int cod = this.scanner.nextInt();
        try {
            SubClasseProduto scp = this.srv.Ler(cod);
            if(scp != null){
                System.out.print("Informe a nova Descrição: ");
                String descricao = this.scanner.next();
                scp.setDescricao(descricao);
                if(this.srv.Editar(scp) != null){
                    System.out.println("Alteração realizada com sucesso!");
                }else{
                    System.out.println("PROBLEMA - Não foi possível realizar a alteração solicitada!");
                }
            }else{
                System.out.println("PROBLEMA - SubClasse de Produto não encontrada!");
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
        System.out.println("Removendo...");
        System.out.print("Informe o código da SubClasse de Produto: ");
        int cod = this.scanner.nextInt();
        try {
            SubClasseProduto scp = this.srv.Ler(cod);
            if(scp != null){
                if(this.srv.Deletar(cod) != null){
                    System.out.println("SubClasse de Produto excluída com sucesso!");
                }else{
                    System.out.println("PROBLEMA - SubClasse de Produto não foi excluída!");
                }
            }else{
                System.out.println("PROBLEMA - SubClasse de Produto não encontrada!");
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

        private void ImprimirPorLinha(SubClasseProduto alvo){
        String mensagem = "";
        mensagem += "SubSubClasse de Produto: ";
        mensagem += "Código: " +alvo.getCodigo() +" | ";
        mensagem += "Descrição: " +alvo.getDescricao()+" | ";
        mensagem += "Data de inclusão: " +alvo.getDataDeInclusao()+" | ";
        mensagem += "Codigo da Classe" +alvo.getCodigoClasse() +"|";
        System.out.println(mensagem);
    }
}
