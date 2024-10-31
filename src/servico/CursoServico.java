package servico;

import java.util.ArrayList;

import dominio.Curso;
import repositorio.CursoRepositorio;

public class CursoServico extends BaseServico<Curso>{

    private CursoRepositorio repositorio;

    public CursoServico(){
        this.repositorio = new CursoRepositorio();
    }

    @Override
    public ArrayList<Curso> Navegar() {
        return this.repositorio.Browse();
    }

    @Override
    public Curso Ler(int chave) {
        return this.repositorio.Read(chave);
    }

    @Override
    public Curso Editar(Curso obj) {
        return this.repositorio.Edit(obj);
    }

    @Override
    public Curso Adicionar(Curso obj) {
        return this.repositorio.Add(obj);
    }

    @Override
    public Curso Deletar(int chave) {
        return this.repositorio.Delete(chave);
    }
    
}
