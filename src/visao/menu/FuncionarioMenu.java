package visao.menu;

import java.util.ArrayList;

import dominio.Funcionario;
import servico.FuncionarioServico;
import visao.Menuzao;
import visao.Util;

public class FuncionarioMenu extends BaseMenu{
    Menuzao menuzao = new Menuzao();
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
            ArrayList<Funcionario> lista = this.srv.Navegar();
            System.out.println("=====================================================");
            for (Funcionario alvo : lista) {
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

        System.out.print("Informe o código do Funcionario: ");
        int cod = this.scanner.nextInt();
        try {
            Funcionario novFuncionario = this.srv.Ler(cod);
            if(novFuncionario != null){
                this.ImprimirPorLinha(novFuncionario);
            }else{
                System.out.println("PROBLEMA - Funcionario não encontrado!");
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
        System.out.print("Adicionando");
        System.out.print("Informe o nome do novo Funcionario: ");
        String nome = this.scanner.next();
        System.out.print("Informe o email do novo Funcionario: ");
        String email = this.scanner.next();
        System.out.print("Informe o telefone do novo Funcionario: ");
        String telefone = this.scanner.next();
        System.out.print("Informe o Cargo do funcionario: ");
        String cargo = this.scanner.next();
        System.out.print("Informe o Salario deste Funcionario: ");
        Double salario = this.scanner.nextDouble();
        Funcionario novFuncionario = new Funcionario();
        novFuncionario.setNome(nome);
        novFuncionario.setEmail(email);
        novFuncionario.setTelefone(telefone);
        novFuncionario.setSalario(salario);
        novFuncionario.setCargo(cargo);
        try {
            if(this.srv.Adicionar(novFuncionario) != null){
                System.out.println("Funcionario adicionado com sucesso!");
            }else{
                System.out.println("PROBLEMA - Erro ao adicionar um novo Funcionario!");
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
        System.out.print("Informe o código do Funcionario: ");
        int cod = this.scanner.nextInt();
        try {
            Funcionario novFuncionario = this.srv.Ler(cod);
            if(novFuncionario != null){
                System.out.print("Informe o novo e-mail: ");
                String email = this.scanner.next();
                novFuncionario.setEmail(email);
                System.out.print("Informe o novo telefone: ");
                String telefone = this.scanner.next();
                novFuncionario.setTelefone(telefone);
                System.out.print("Informe o novo Cargo: ");
                String cargo = this.scanner.next();
                novFuncionario.setCargo(cargo);
                System.out.print("Informe o novo salario: ");
                Double salario = this.scanner.nextDouble();
                novFuncionario.setSalario(salario);
                if(this.srv.Editar(novFuncionario) != null){
                    System.out.println("Alteração realizada com sucesso!");
                }else{
                    System.out.println("PROBLEMA - Não foi possível realizar a alteração solicitada!");
                }
            }else{
                System.out.println("PROBLEMA - Funcionario não encontrado!");
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
        System.out.print("Informe o código do Funcionario: ");
        int cod = this.scanner.nextInt();
        try {
            Funcionario novFuncionario = this.srv.Ler(cod);
            if(novFuncionario != null){
                if(this.srv.Deletar(cod) != null){
                    System.out.println("Funcionario excluído com sucesso!");
                }else{
                    System.out.println("PROBLEMA - Funcionario não foi excluído!");
                }
            }else{
                System.out.println("PROBLEMA - Funcionario não encontrado!");
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
