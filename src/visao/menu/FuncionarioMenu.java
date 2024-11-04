package visao.menu;

import java.util.ArrayList;

import dominio.Funcionario;
import servico.FuncionarioServico;
import visao.Util;

public class FuncionarioMenu extends BaseMenu{
        private FuncionarioServico srv;

    public FuncionarioMenu(){
        super();
        this.srv = new FuncionarioServico();
    }

    @Override
    public void ExibirMenu() {
        int opcao = 0;         
        while (opcao != 9){
            Util.LimparConsole();
            System.out.println("Cadastro de Funcionarios");
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

        ArrayList<Funcionario> lista = this.srv.Navegar();
        System.out.println("=====================================================");
        for (Funcionario alvo : lista) {
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

        System.out.print("Informe o código da Funcionario: ");
        int cod = this.scanner.nextInt();

        Funcionario cp = this.srv.Ler(cod);
        if(cp != null){
            this.ImprimirPorLinha(cp);
        }else{
            System.out.println("PROBLEMA - Funcionario não encontrado!");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
        Util.LimparConsole();      
        System.out.println("Adicionando");

        System.out.print("Informe a descrição do novo Funcionario: ");
        String descricao = this.scanner.next();

        Funcionario cp = new Funcionario();
        cp.setDescricao(descricao);
        cp.setDataDeInclusao(LocalDate.now());

        //ClasseProduto cpnovo = this.srv.Adicionar(cp); //<-método didatico
        if(this.srv.Adicionar(cp) != null){
            System.out.println("Funcionario adicionado com sucesso!");
        }else{
            System.out.println("PROBLEMA - Erro ao adicionar um novo Funcionario!");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.LimparConsole();      
        System.out.println("Atualizando");

        System.out.print("Informe o código do Funcionario: ");
        int cod = this.scanner.nextInt();

        Funcionario cp = this.srv.Ler(cod);
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
            System.out.println("PROBLEMA - Funcionario não encontrado!");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Remover() {
        Util.LimparConsole();      
        System.out.println("Removendo");

        System.out.print("Informe o código do Funcionario: ");
        int cod = this.scanner.nextInt();

        Funcionario cp = this.srv.Ler(cod);
        if(cp != null){
            if(this.srv.Deletar(cod) != null){
                System.out.println("Funcionario excluído com sucesso!");
            }else{
                System.out.println("PROBLEMA - Funcionario não foi excluída!");
            }
        }else{
            System.out.println("PROBLEMA - Funcionario não encontrado!");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

        private void ImprimirPorLinha(Funcionario alvo){
        String mensagem = "";
        mensagem += "Funcionario: ";
        mensagem += "Código: " +alvo.getCodigo() +" | ";
        mensagem += "Nome: " +alvo.getNome()+" | ";
        mensagem += "Email: " +alvo.getEmail()+" | ";
        mensagem += "Telefone: " +alvo.getTelefone()+ "|";
        mensagem += "Cargo: " +alvo.getCargo() + "|";
        mensagem += "Salario: " +alvo.getSalario() + "|";
        System.out.println(mensagem);
    }
    
}
