package servico;

import java.util.ArrayList;

import dominio.Veiculo;
import repositorio.VeiculoRepositorio;

public class VeiculoServico extends BaseServico<Veiculo>{

    private VeiculoRepositorio repositorio;

    public VeiculoServico(){
        this.repositorio = new VeiculoRepositorio();
    }

    @Override
    public ArrayList<Veiculo> Navegar() {
        return this.repositorio.Browse();
    }

    @Override
    public Veiculo Ler(int chave) {
        return this.repositorio.Read(chave);
    }

    @Override
    public Veiculo Editar(Veiculo obj) {
        return this.repositorio.Edit(obj);
    }

    @Override
    public Veiculo Adicionar(Veiculo obj) {
        return this.repositorio.Add(obj);
    }

    @Override
    public Veiculo Deletar(int chave) {
        return this.repositorio.Delete(chave);
    }
    
}
