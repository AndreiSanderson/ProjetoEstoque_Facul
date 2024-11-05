package visao.menu;

import java.util.ArrayList;

import dominio.Fornecedor;
import servico.FornecedorServico;
import visao.Menuzao;
import visao.Util;

public class FornecedorMenu extends BaseMenu{
    Menuzao menuzao = new Menuzao();
    private FornecedorServico srv;

    public FornecedorMenu(){
        super();
        this.srv = new FornecedorServico();
    }

    @Override
    public void ExibirMenu() {
        int opcao = 0;         
        while (opcao != 9){
            Util.LimparConsole();
            System.out.println("Cadastro de Fornecedores");
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
            ArrayList<Fornecedor> lista = this.srv.Navegar();
            System.out.println("=====================================================");
            for (Fornecedor alvo : lista) {
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
        System.out.print("Informe o código do Fornecedor: ");
        int cod = this.scanner.nextInt();
        try {
            Fornecedor novoFornecedor = this.srv.Ler(cod);
            if(novoFornecedor != null){
                this.ImprimirPorLinha(novoFornecedor);
            }else{
                System.out.println("PROBLEMA - Fornecedor não encontrado!");
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
        System.out.print("Informe a Razão Social do Fornecedor: ");
        String razaoSocial = this.scanner.next();
        System.out.print("Informe o CNPJ do Fornecedor: ");
        String cnpj = this.scanner.next();
        System.out.print("Informe o Nome Fantasia do Fornecedor: ");
        String nomeFantasia = this.scanner.next();
        System.out.print("Informe o email do novo Cliente: ");
        String email = this.scanner.next();
        System.out.print("Informe o telefone do novo Cliente: ");
        String telefone = this.scanner.next();
        Fornecedor novoFornecedor = new Fornecedor();
        novoFornecedor.setNome(razaoSocial);
        novoFornecedor.setCnpj(cnpj);
        novoFornecedor.setNomeFantasia(nomeFantasia);
        novoFornecedor.setEmail(email);
        novoFornecedor.setTelefone(telefone);
        try {
            if(this.srv.Adicionar(novoFornecedor) != null){
                System.out.println("Fornecedor adicionado com sucesso!");
            }else{
                System.out.println("PROBLEMA - Erro ao adicionar um novo fornecedor!");
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
        System.out.print("Informe o código do Fornecedor: ");
        int cod = this.scanner.nextInt();
        try {
            Fornecedor novoFornecedor = this.srv.Ler(cod);
            if(novoFornecedor != null){
                System.out.print("Informe a nova Razão Social: ");
                String razaoSocial = this.scanner.next();
                novoFornecedor.setNome(razaoSocial);
                System.out.print("Informe o Nome Fantasia: ");
                String nomeFantasia = this.scanner.next();
                novoFornecedor.setNomeFantasia(nomeFantasia);
                System.out.print("Informe o email: ");
                String email = this.scanner.next();
                novoFornecedor.setEmail(email);
                System.out.print("Informe o telefone: ");
                String telefone = this.scanner.next();
                novoFornecedor.setTelefone(telefone);
                if(this.srv.Editar(novoFornecedor) != null){
                    System.out.println("Alteração realizada com sucesso!");
                }else{
                    System.out.println("PROBLEMA - Não foi possível realizar a alteração solicitada!");
                }

            }else{
                System.out.println("PROBLEMA - Fornecedor não encontrado!");
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
        System.out.print("Informe o código do Fornecedor: ");
        int cod = this.scanner.nextInt();
        try {
            Fornecedor novoFornecedor = this.srv.Ler(cod);
            if(novoFornecedor != null){
                if(this.srv.Deletar(cod) != null){
                    System.out.println("Fornecedor excluído com sucesso!");
                }else{
                    System.out.println("PROBLEMA - Fornecedor não foi excluído!");
                }
            }else{
                System.out.println("PROBLEMA - Fornecedor não encontrado!");
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

    private void ImprimirPorLinha(Fornecedor alvo){
    String mensagem = "";
    mensagem += "Fornecedor: ";
    mensagem += "Código: " +alvo.getCodigo() +" | ";
    mensagem += "Razão Social: " +alvo.getNome()+" | ";
    mensagem += "CNPJ: " +alvo.getCnpj()+" | ";
    mensagem += "Nome Fantasia: " +alvo.getNomeFantasia() +"|";
    mensagem += "Email: " + alvo.getEmail() +"|";
    mensagem += "Telefone: " + alvo.getTelefone()+ "|";
    System.out.println(mensagem);
    }
}

