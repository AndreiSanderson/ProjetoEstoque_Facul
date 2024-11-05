package visao.menu;

import java.util.ArrayList;

import dominio.Livro;
import servico.LivroServico;
import visao.Menuzao;
import visao.Util;

public class LivroMenu extends BaseMenu{
    Menuzao menuzao = new Menuzao();
    private LivroServico srv;

    public LivroMenu(){
        super();
        this.srv = new LivroServico();
    }

    @Override
    public void ExibirMenu() {
        int opcao = 0;         
        while (opcao != 9){
            Util.LimparConsole();
            System.out.println("Cadastro de Livros");
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
                System.out.println();
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
            ArrayList<Livro> lista = this.srv.Navegar();
            System.out.println("=====================================================");
            for (Livro alvo : lista) {
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
        System.out.print("Informe o código do Livro: ");
        int cod = this.scanner.nextInt();
        try {
            Livro novoLivro = this.srv.Ler(cod);
            if(novoLivro != null){
                this.ImprimirPorLinha(novoLivro);
            }else{
                System.out.println("PROBLEMA - Livro não encontrado!");
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
        System.out.print("Informe o titulo do novo Livro: ");
        String titulo = this.scanner.next();
        System.out.print("Informe o Autor: ");
        String autor = this.scanner.next();
        System.out.print("Informe o ISBN do livro: ");
        String isbn = this.scanner.next();
        System.out.print("Informe o Ano de publicação: ");
        int anoPublicacao = this.scanner.nextInt();
        Livro novoLivro = new Livro();
        novoLivro.setTitulo(titulo);
        novoLivro.setAutor(autor);
        novoLivro.setIsbn(isbn);
        novoLivro.setAnoPublicacao(anoPublicacao);
        try {
            if(this.srv.Adicionar(novoLivro) != null){
                System.out.println("Livro adicionado com sucesso!");
            }else{
                System.out.println("PROBLEMA - Erro ao adicionar um novo livro!");
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
        System.out.print("Informe o código do Livro: ");
        int cod = this.scanner.nextInt();
        try {
            Livro novoLivro = this.srv.Ler(cod);
            if(novoLivro != null){
                System.out.print("Informe o novo Titulo: ");
                String titulo = this.scanner.next();
                novoLivro.setTitulo(titulo);
            
                if(this.srv.Editar(novoLivro) != null){
                    System.out.println("Alteração realizada com sucesso!");
                }else{
                    System.out.println("PROBLEMA - Não foi possível realizar a alteração solicitada!");
                }
            }else{
                System.out.println("PROBLEMA - Livro não encontrado!");
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
        System.out.print("Informe o código do Livro: ");
        int cod = this.scanner.nextInt();
        try {
            Livro novoLivro = this.srv.Ler(cod);
            if(novoLivro != null){
                if(this.srv.Deletar(cod) != null){
                    System.out.println("Livro excluído com sucesso!");
                }else{
                    System.out.println("PROBLEMA - Livro não foi excluído!");
                }
            }else{
                System.out.println("PROBLEMA - Livro não encontrado!");
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
    
    private void ImprimirPorLinha(Livro alvo){
    String mensagem = "";
    mensagem += "Livro: ";
    mensagem += "Código: " +alvo.getCodigo() +" | ";
    mensagem += "Titulo: " +alvo.getTitulo()+" | ";
    mensagem += "Autor: " +alvo.getAutor()+" | ";
    mensagem += "ISBN: " +alvo.getIsbn()+"|";
    mensagem += "Ano de Publicação: " +alvo.getAnoPublicacao()+ "|";
    System.out.println(mensagem);
    }
}
