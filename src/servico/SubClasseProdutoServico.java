package servico;

import java.util.ArrayList;

import dominio.SubClasseProduto;
import repositorio.SubClasseProdutoRepositorio;

public class SubClasseProdutoServico extends BaseServico<SubClasseProduto>{

    private SubClasseProdutoRepositorio repositorio;

    public SubClasseProdutoServico(){
        this.repositorio = new SubClasseProdutoRepositorio();
    }

    @Override
    public ArrayList<SubClasseProduto> Navegar() {
        return this.repositorio.Browse();
    }

    @Override
    public SubClasseProduto Ler(int chave) {
        return this.repositorio.Read(chave);
    }

    @Override
    public SubClasseProduto Editar(SubClasseProduto obj) {
        return this.repositorio.Edit(obj);
    }

    @Override
    public SubClasseProduto Adicionar(SubClasseProduto obj) {
        return this.repositorio.Add(obj);
    }

    @Override
    public SubClasseProduto Deletar(int chave) {
        return this.repositorio.Delete(chave);
    }
    
}
