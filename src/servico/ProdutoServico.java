package servico;

import java.util.ArrayList;

import dominio.Produto;
import repositorio.ProdutoRepositorio;

public class ProdutoServico extends BaseServico<Produto>{

    private ProdutoRepositorio repositorio;

    public ProdutoServico(){
        this.repositorio = new ProdutoRepositorio();
    }

    @Override
    public ArrayList<Produto> Navegar() {
        return this.repositorio.Browse();
    }

    @Override
    public Produto Ler(int chave) {
        return this.repositorio.Read(chave);
    }

    @Override
    public Produto Editar(Produto obj) {
        return this.repositorio.Edit(obj);
    }

    @Override
    public Produto Adicionar(Produto obj) {
        return this.repositorio.Add(obj);
    }

    @Override
    public Produto Deletar(int chave) {
        return this.repositorio.Delete(chave);
    }
    
}
