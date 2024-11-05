package visao.menu;

import java.util.ArrayList;

import dominio.Curso;
import servico.CursoServico;
import visao.Menuzao;
import visao.Util;

public class CursoMenu extends BaseMenu{
    
    Menuzao menuzao = new Menuzao();
    private CursoServico srv;

    public CursoMenu(){
        super();
        this.srv = new CursoServico();
    }

    @Override
    public void ExibirMenu() {
        int opcao = 0;         
        while (opcao != 9){
            Util.LimparConsole();
            System.out.println("Cadastro de Curso");
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
            ArrayList<Curso> lista = this.srv.Navegar();
            System.out.println("=====================================================");
            for (Curso alvo : lista) {
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

        System.out.print("Informe o código do Curso: ");
        int cod = this.scanner.nextInt();
        try {
            Curso novoCurso = this.srv.Ler(cod);
            if(novoCurso != null){
                this.ImprimirPorLinha(novoCurso);
            }else{
                System.out.println("PROBLEMA - Curso não encontrado!");
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

        System.out.print("Informe o nome do novo Curso: ");
        String nome = this.scanner.next();
        System.out.print("Informe a descrição do curso: ");
        String descricao = this.scanner.next();
        System.out.print("Informe a Carga Horaria do curso: ");
        int cargahoraria = this.scanner.nextInt();
        Curso novoCurso = new Curso();
        novoCurso.setNome(nome);
        novoCurso.setDescricao(descricao);
        novoCurso.setCargaHoraria(cargahoraria);

        try {
            if(this.srv.Adicionar(novoCurso) != null){
                System.out.println("Curso adicionado com sucesso!");
            }else{
                System.out.println("PROBLEMA - Erro ao adicionar um novo Curso!");
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

        System.out.print("Informe o código do Curso: ");
        int cod = this.scanner.nextInt();
        try {
            Curso novoCurso = this.srv.Ler(cod);
            if(novoCurso != null){
                System.out.print("Informe a nova Descrição: ");
                String descricao = this.scanner.next();
                novoCurso.setDescricao(descricao);
                System.out.print("Informe a nova Carga Horaria do curso: ");
                int cargahoraria = this.scanner.nextInt();
                novoCurso.setCargaHoraria(cargahoraria);
                if(this.srv.Editar(novoCurso) != null){
                    System.out.println("Alteração realizada com sucesso!");
                }else{
                    System.out.println("PROBLEMA - Não foi possível realizar a alteração solicitada!");
                }
            }else{
                System.out.println("PROBLEMA - Curso não encontrado!");
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

        System.out.print("Informe o código do  Curso: ");
        int cod = this.scanner.nextInt();
        try {
            Curso novoCurso = this.srv.Ler(cod);
            if(novoCurso != null){
                if(this.srv.Deletar(cod) != null){
                    System.out.println("Curso excluído com sucesso!");
                }else{
                    System.out.printf("PROBLEMA - Curso não foi excluído!\n Tente novamente!\n");
                }
            }else{
                System.out.println("PROBLEMA - Curso não encontrado!");
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

    private void ImprimirPorLinha(Curso alvo){
    String mensagem = "";
    mensagem += "Curso: ";
    mensagem += "Código: " +alvo.getCodigo() +" | ";
    mensagem += "Nome: " +alvo.getNome() + "|";
    mensagem += "Descrição: " +alvo.getDescricao()+" | ";
    mensagem += "Carga horaria: " +alvo.getCargaHoraria() +" | ";
    System.out.println(mensagem);
    }
    
}
    

