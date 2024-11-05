package visao.visaoteste;

import java.util.ArrayList;

import dominio.Curso;
import servico.CursoServico;

public class CursoVisao {
    
    private CursoServico srv;

    public CursoVisao(){
        this.srv = new CursoServico();
    }
    
    public void Exibir(){
        ArrayList<Curso> lista = this.srv.Navegar();
        System.out.println("=====================================================");
        for (Curso alvo : lista) {
            this.Imprimir(alvo);
        }
    }



    public void Imprimir(Curso alvo){
        System.out.println("Classe de produto: ");
        System.out.println("Código: " +alvo.getCodigo());
        System.out.println("Nome : " +alvo.getNome());
        System.out.println("Descrição: " +alvo.getDescricao());
        System.out.println("Carga Horária: " +alvo.getCargaHoraria());
        System.out.println("====================================================");
    }

    public void ImprimirPorLinha(Curso alvo){
        String mensagem = "";
        mensagem += "Classe de produto: ";
        mensagem += "Código: " +alvo.getCodigo() +" | ";
        mensagem += "Nome: " +alvo.getNome() + "|";
        mensagem += "Descrição: " +alvo.getDescricao()+" | ";
        mensagem += "Carga horaria: " +alvo.getCargaHoraria() +" | ";
        System.out.println(mensagem);
    }

    
    public void ImprimirPorLinha(int chave){
        Curso alvo = this.srv.Ler(chave);
        this.ImprimirPorLinha(alvo);
    }


    public void Criar(Curso novo){
        this.srv.Adicionar(novo);
    }

    public void Editar(int chave, Curso alt){
        Curso alvo = this.srv.Ler(chave);
        if (alvo != null){
            alvo.setNome(alt.getNome());
            alvo.setDescricao(alt.getDescricao());
            alvo.setCargaHoraria(alt.getCargaHoraria());
        }else{
            System.out.println("Item não localizado.");
        }
    }

    public void Remover(int chave){
        Curso alvo = this.srv.Ler(chave);
        if (alvo != null){
            this.srv.Deletar(chave);
        }else{
            System.out.println("Item não localizado.");
        }
    }
}
