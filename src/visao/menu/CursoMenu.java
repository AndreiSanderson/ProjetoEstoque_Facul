package visao.menu;

import java.util.ArrayList;

import dominio.Curso;
import servico.CursoServico;
import visao.Util;

public class CursoMenu extends BaseMenu{
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

        ArrayList<Curso> lista = this.srv.Navegar();
        System.out.println("=====================================================");
        for (Curso alvo : lista) {
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

        System.out.print("Informe o código da Curso: ");
        int cod = this.scanner.nextInt();

        Curso cp = this.srv.Ler(cod);
        if(cp != null){
            this.ImprimirPorLinha(cp);
        }else{
            System.out.println("PROBLEMA - Curso não encontrada!");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
        Util.LimparConsole();      
        System.out.println("Adicionando");

        System.out.print("Informe a descrição do novo Curso: ");
        String descricao = this.scanner.next();

        Curso cp = new Curso();
        cp.setDescricao(descricao);
        cp.setDataDeInclusao(LocalDate.now());

        //ClasseProduto cpnovo = this.srv.Adicionar(cp); //<-método didatico
        if(this.srv.Adicionar(cp) != null){
            System.out.println("Curso adicionado com sucesso!");
        }else{
            System.out.println("PROBLEMA - Erro ao adicionar um novo Curso!");
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

        Curso cp = this.srv.Ler(cod);
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
            System.out.println("PROBLEMA - Curso não encontrada!");
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

        Curso cp = this.srv.Ler(cod);
        if(cp != null){
            if(this.srv.Deletar(cod) != null){
                System.out.println("Curso excluído com sucesso!");
            }else{
                System.out.println("PROBLEMA - Curso não foi excluída!");
            }
        }else{
            System.out.println("PROBLEMA - Curso não encontrada!");
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
    

