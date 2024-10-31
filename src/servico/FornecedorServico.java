package servico;

import java.util.ArrayList;

import dominio.Fornecedor;
import repositorio.FornecedorRepositorio;

public class FornecedorServico extends BaseServico<Fornecedor>{

    private FornecedorRepositorio repositorio;

    public FornecedorServico(){
        this.repositorio = new FornecedorRepositorio();
    }

    @Override
    public ArrayList<Fornecedor> Navegar() {
        return this.repositorio.Browse();
    }

    @Override
    public Fornecedor Ler(int chave) {
        return this.repositorio.Read(chave);
    }

    @Override
    public Fornecedor Editar(Fornecedor obj) {
        return this.repositorio.Edit(obj);
    }

    @Override
    public Fornecedor Adicionar(Fornecedor obj) {
        return this.repositorio.Add(obj);
    }

    @Override
    public Fornecedor Deletar(int chave) {
        return this.repositorio.Delete(chave);
    }
    
}
