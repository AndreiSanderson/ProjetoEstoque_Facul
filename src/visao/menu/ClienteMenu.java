package visao.menu;

import java.util.ArrayList;

import dominio.Cliente;
import servico.ClienteServico;
import visao.Menuzao;
import visao.Util;

public class ClienteMenu extends BaseMenu {
    
    Menuzao menuzao = new Menuzao();

    private ClienteServico srv;

    public ClienteMenu(){
        super();
        this.srv = new ClienteServico();
    }

    @Override
    public void ExibirMenu() {
        int opcao = 0;         
        while (opcao != 9){
            Util.LimparConsole();
            System.out.println("Cadastro de Cliente");
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
            ArrayList<Cliente> lista = this.srv.Navegar();
            System.out.println("=====================================================");
            for (Cliente alvo : lista) {
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
        System.out.print("Informe o código do Cliente: ");
        int cod = this.scanner.nextInt();
        try {
            Cliente novoCliente = this.srv.Ler(cod);
            if(novoCliente != null){
                this.ImprimirPorLinha(novoCliente);
            }else{
                System.out.println("PROBLEMA - Cliente não encontrado!");
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
        System.out.print("Informe o nome do novo Cliente: ");
        String nome = this.scanner.next();
        System.out.print("Informe o CPF do novo Cliente: ");
        String cpf = this.scanner.next();
        System.out.print("Informe o email do novo Cliente: ");
        String email = this.scanner.next();
        System.out.print("Informe o telefone do novo Cliente: ");
        String telefone = this.scanner.next();
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(nome);
        novoCliente.setCpf(cpf);
        novoCliente.setEmail(email);
        novoCliente.setTelefone(telefone);
        try {
            if(this.srv.Adicionar(novoCliente) != null){
                System.out.println("Cliemte adicionado com sucesso!");
            }else{
                System.out.println("PROBLEMA - Erro ao adicionar um novo cliente!");
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
        System.out.print("Informe o código do cliente: ");
        int cod = this.scanner.nextInt();
        try {
            Cliente novoCliente = this.srv.Ler(cod);
            if(novoCliente != null){
                System.out.println("Você deseja alterar o email do usuário?");
                System.out.print("Informe o novo email do Cliente: ");
                String email = this.scanner.next();
                novoCliente.setEmail(email);

                System.out.print("Informe o novo telefone do Cliente: ");
                String telefone = this.scanner.next();
                novoCliente.setTelefone(telefone);
                if(this.srv.Editar(novoCliente) != null){
                    System.out.println("Alteração realizada com sucesso!");
                }else{
                    System.out.println("PROBLEMA - Não foi possível realizar a alteração solicitada!");
                }
            }else{
                System.out.println("PROBLEMA - Cliente não encontrado!");
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
        System.out.print("Informe o código do cliente: ");
        int cod = this.scanner.nextInt();
        try {
            Cliente novoCliente = this.srv.Ler(cod);
            if(novoCliente != null){
                if(this.srv.Deletar(cod) != null){
                    System.out.println("Cliente excluído com sucesso!");
                }else{
                    System.out.println("PROBLEMA - Cliente não foi excluída!");
                }
            }else{
                System.out.println("PROBLEMA - Cliente não encontrado!");
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

    private void ImprimirPorLinha(Cliente alvo){
    String mensagem = "";
    mensagem += "Cliente: ";
    mensagem += "Código: " +alvo.getCodigo() +" | ";
    mensagem += "Nome: " +alvo.getNome()+" | ";
    mensagem += "CPF: " +alvo.getCpf()+" | ";
    mensagem += "Email: " +alvo.getEmail()+ "|";
    mensagem += "Telefone: " +alvo.getTelefone() +"|";
    System.out.println(mensagem);
    }
}
