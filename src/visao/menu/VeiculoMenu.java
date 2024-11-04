package visao.menu;

import java.util.ArrayList;

import dominio.Veiculo;
import servico.VeiculoServico;
import visao.Util;

public class VeiculoMenu extends BaseMenu{
        private VeiculoServico srv;

    public VeiculoMenu(){
        super();
        this.srv = new VeiculoServico();
    }

    @Override
    public void ExibirMenu() {
        int opcao = 0;         
        while (opcao != 9){
            Util.LimparConsole();
            System.out.println("Cadastro de Veiculos");
            System.out.println("1 - Listar");
            System.out.println("2 - Localizar");
            System.out.println("3 - Adicionar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("9 - Sair");
            System.out.print("Selecione uma opção: ");

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
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        }
    }

    @Override
    public void Listar() {
        Util.LimparConsole();
        System.out.println("listando");

        ArrayList<Veiculo> lista = this.srv.Navegar();
        System.out.println("=====================================================");
        for (Veiculo alvo : lista) {
            this.ImprimirPorLinha(alvo);
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.LimparConsole();      
        System.out.println("Localizando");

        System.out.print("Informe o código do Veiculo: ");
        int cod = this.scanner.nextInt();

        Veiculo cp = this.srv.Ler(cod);
        if(cp != null){
            this.ImprimirPorLinha(cp);
        }else{
            System.out.println("PROBLEMA - Veiculo não encontrado!");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
        Util.LimparConsole();      
        System.out.println("Adicionando");

        System.out.print("Informe a descrição do novo Veiculo: ");
        String descricao = this.scanner.next();

        Veiculo cp = new Veiculo();
        cp.setDescricao(descricao);
        cp.setDataDeInclusao(LocalDate.now());

        //Veiculo cpnovo = this.srv.Adicionar(cp); //<-método didatico
        if(this.srv.Adicionar(cp) != null){
            System.out.println("Veiculo adicionado com sucesso!");
        }else{
            System.out.println("PROBLEMA - Erro ao adicionar um novo Veiculo!");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.LimparConsole();      
        System.out.println("Atualizando");

        System.out.print("Informe o código do Veiculo: ");
        int cod = this.scanner.nextInt();

        Veiculo cp = this.srv.Ler(cod);
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
            System.out.println("PROBLEMA - Veiculo não encontrado!");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Remover() {
        Util.LimparConsole();      
        System.out.println("Removendo");

        System.out.print("Informe o código do Veiculo: ");
        int cod = this.scanner.nextInt();

        Veiculo cp = this.srv.Ler(cod);
        if(cp != null){
            if(this.srv.Deletar(cod) != null){
                System.out.println("Veiculo excluída com sucesso!");
            }else{
                System.out.println("PROBLEMA - Veiculo não foi excluído!");
            }
        }else{
            System.out.println("PROBLEMA - Veiculo não encontrado!");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

        private void ImprimirPorLinha(Veiculo alvo){
        String mensagem = "";
        mensagem += "Veiculo: ";
        mensagem += "Código: " +alvo.getCodigo() +" | ";
        mensagem += "Marca: " +alvo.getMarca()+" | ";
        mensagem += "Modelo: " +alvo.getModelo()+" | ";
        mensagem += "Ano de Fabricação: " +alvo.getAnoFabricacao()+ "|";
        mensagem += "Preço: " +alvo.getPreco() +"|";
        System.out.println(mensagem);
    }
}
