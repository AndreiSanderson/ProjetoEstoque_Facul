package visao.menu;

import java.time.LocalDate;
import java.util.ArrayList;

import dominio.Produto;
import servico.ProdutoServico;
import visao.Menuzao;
import visao.Util;

public class ProdutoMenu extends BaseMenu{
    Menuzao menuzao = new Menuzao();
    private ProdutoServico srv;

    public ProdutoMenu(){
        super();
        this.srv = new ProdutoServico();
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
            ArrayList<Produto> lista = this.srv.Navegar();
            System.out.println("=====================================================");
            for (Produto alvo : lista) {
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

        System.out.print("Informe o código do Produto: ");
        int cod = this.scanner.nextInt();
        try {
            Produto novoProduto = this.srv.Ler(cod);
            if(novoProduto != null){
                this.ImprimirPorLinha(novoProduto);
            }else{
                System.out.println("PROBLEMA - Produto não encontrado!");
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
        System.out.print("Informe o Código da SubClasse: ");
        int subClasse = this.scanner.nextInt();
        System.out.print("Informe o valor deste produto: ");
        double valor = this.scanner.nextDouble();

        Produto novoProduto = new Produto();
        novoProduto.setDescricao(descricao);
        novoProduto.setDataDeInclusao(LocalDate.now());
        novoProduto.setValor(valor);
        novoProduto.setCodigoSubClasse(subClasse);
        try {
            if(this.srv.Adicionar(novoProduto) != null){
                System.out.println("Produto adicionado com sucesso!");
            }else{
                System.out.println("PROBLEMA - Erro ao adicionar um novo produto!");
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

        System.out.print("Informe o código do Produto: ");
        int cod = this.scanner.nextInt();
        try {
            Produto novoProduto = this.srv.Ler(cod);
            if(novoProduto != null){
                System.out.print("Informe a nova Descrição: ");
                String descricao = this.scanner.next();
                novoProduto.setDescricao(descricao);
                System.out.println("Informe o novo Valor: ");
                double valor = this.scanner.nextDouble();
                novoProduto.setValor(valor);            
                if(this.srv.Editar(novoProduto) != null){
                    System.out.println("Alteração realizada com sucesso!");
                }else{
                    System.out.println("PROBLEMA - Não foi possível realizar a alteração solicitada!");
                }
            }else{
                System.out.println("PROBLEMA - Produto não encontrado!");
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

        System.out.print("Informe o código do Produto: ");
        int cod = this.scanner.nextInt();
        try {
            Produto novoProduto = this.srv.Ler(cod);
            if(novoProduto != null){
                if(this.srv.Deletar(cod) != null){
                    System.out.println("Produto excluído com sucesso!");
                }else{
                    System.out.println("PROBLEMA - Produto não foi excluído!");
                }
            }else{
                System.out.println("PROBLEMA - Produto não encontrado!");
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

        private void ImprimirPorLinha(Produto alvo){
        String mensagem = "";
        mensagem += "Produto: ";
        mensagem += "Código: " +alvo.getCodigo() +" | ";
        mensagem += "Descrição: " +alvo.getDescricao()+" | ";
        mensagem += "Data de inclusão: " +alvo.getDataDeInclusao()+" | ";
        mensagem += "Código de SubClasse: " +alvo.getCodigoSubClasse() + "|";
        mensagem += "Valor: " +alvo.getValor() +"|";
        System.out.println(mensagem);
    }
}
