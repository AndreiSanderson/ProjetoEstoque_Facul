package repositorio;

import dominio.Veiculo;
import fakedb.VeiculoFakeDB;

public class VeiculoRepositorio extends BaseRepositorio<Veiculo>{

    private VeiculoFakeDB db;

    public VeiculoRepositorio(){
        this.db = new VeiculoFakeDB();
        this.dados = this.db.getTabela();
    }

    @Override
    public Veiculo Read(int chave) {
        for (Veiculo veiculo : dados) {
            if (chave == veiculo.getCodigo()) {
                return veiculo;
            }
        }
        return null;
    }

    @Override
    public Veiculo Edit(Veiculo instancia) {
        Veiculo veiculo = this.Read(instancia.getCodigo());
        if(veiculo != null){
            veiculo.setPreco(instancia.getPreco());
            return veiculo;
        }else{
            return null;
        }
    }

    @Override
    public Veiculo Add(Veiculo instancia) {
        Veiculo veiculo = this.dados.getLast();
        int proxChave = veiculo.getCodigo() + 1;
        instancia.setCodigo(proxChave);
        this.dados.add(instancia);
        return instancia;
    }

    @Override
    public Veiculo Delete(int chave) {
        Veiculo veiculo = this.Read(chave);
        if(veiculo != null){
            this.dados.remove(veiculo);
            return veiculo;
        }else{
            return null;
        }
    }
    
}
