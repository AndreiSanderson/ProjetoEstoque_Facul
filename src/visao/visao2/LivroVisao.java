package visao.visao2;

import java.util.ArrayList;

import dominio.Livro;
import servico.LivroServico;


public class LivroVisao {

    private LivroServico srv;

    public LivroVisao(){
        this.srv = new LivroServico();
    }
    
    public void Exibir(){
        ArrayList<Livro> lista = this.srv.Navegar();
        System.out.println("=====================================================");
        for (Livro alvo : lista) {
            this.Imprimir(alvo);
        }
    }

    public void Imprimir(Livro alvo){
        System.out.println("Livro: ");
        System.out.println("Código: " +alvo.getCodigo());
        System.out.println("Titulo: " +alvo.getTitulo());
        System.out.println("Autor: " +alvo.getAutor());
        System.out.println("ISBN: " +alvo.getIsbn());
        System.out.println("Ano de Publicação: " +alvo.getAnoPublicacao());
        System.out.println("====================================================");
    }

    public void ImprimirPorLinha(Livro alvo){
        String mensagem = "";
        mensagem += "Livro: ";
        mensagem += "Código: " +alvo.getCodigo() +" | ";
        mensagem += "Titulo: " +alvo.getTitulo()+" | ";
        mensagem += "Autor: " +alvo.getAutor()+" | ";
        mensagem += "ISBN: " +alvo.getIsbn()+"|";
        mensagem += "Ano de Publicação: " +alvo.getAnoPublicacao()+ "|";
        System.out.println(mensagem);
    }

    
    public void ImprimirPorLinha(int chave){
        Livro alvo = this.srv.Ler(chave);
        this.ImprimirPorLinha(alvo);
    }


    public void Criar(Livro novo){
        this.srv.Adicionar(novo);
    }

    public void Editar(int chave, Livro alt){
        Livro alvo = this.srv.Ler(chave);
        if (alvo != null){
            alvo.setTitulo(alt.getTitulo());
        }else{
            System.out.println("Item não localizado.");
        }
    }

    public void Remover(int chave){
        Livro alvo = this.srv.Ler(chave);
        if (alvo != null){
            this.srv.Deletar(chave);
        }else{
            System.out.println("Item não localizado.");
        }
    }
}
