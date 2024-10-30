package repositorio;

import dominio.Fornecedor;
import fakedb.FornecedorFakeDB;

public class FornecedorRepositorio extends BaseRepositorio<Fornecedor>{

    private FornecedorFakeDB db;

    public FornecedorRepositorio(){
        this.db = new FornecedorFakeDB();
        this.dados = this.db.getTabela();
    }

    @Override
    public Fornecedor Read(int chave) {
        for (Fornecedor fornecedor : dados) {
            if(chave == fornecedor.getCodigo()){
                return fornecedor;
            }
        }
        return null;
    }

    @Override
    public Fornecedor Edit(Fornecedor instancia) {
        Fornecedor fornecedor = this.Read(instancia.getCodigo());
        if(fornecedor != null){
            fornecedor.setNome(instancia.getNome());
            fornecedor.setEmail(instancia.getEmail());
            fornecedor.setNomeFantasia(instancia.getNomeFantasia());
            fornecedor.setTelefone(instancia.getTelefone());
            return fornecedor;
        }else{
            return null;
        }
    }

    @Override
    public Fornecedor Add(Fornecedor instancia) {
        Fornecedor fornecedor = this.dados.getLast();
        int proxChave = fornecedor.getCodigo() + 1;
        instancia.setCodigo(proxChave);
        this.dados.add(instancia);
        return instancia;
    }

    @Override
    public Fornecedor Delete(int chave) {
        Fornecedor fornecedor = this.Read(chave);
        if(fornecedor != null){
            this.dados.remove(fornecedor);
            return fornecedor;
        }else{
            return null;
        }
    }
}
