package servico;

import java.util.ArrayList;

import dominio.Livro;
import repositorio.LivroRepositorio;

public class LivroServico extends BaseServico<Livro>{

    private LivroRepositorio repositorio;

    public LivroServico(){
        this.repositorio = new LivroRepositorio();
    }

    @Override
    public ArrayList<Livro> Navegar() {
        return this.repositorio.Browse();
    }

    @Override
    public Livro Ler(int chave) {
        return this.repositorio.Read(chave);
    }

    @Override
    public Livro Editar(Livro obj) {
        return this.repositorio.Edit(obj);
    }

    @Override
    public Livro Adicionar(Livro obj) {
        return this.repositorio.Add(obj);
    }

    @Override
    public Livro Deletar(int chave) {
        return this.repositorio.Delete(chave);
    }
    
}
