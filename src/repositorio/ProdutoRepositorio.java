package repositorio;

import dominio.Produto;
import fakedb.ProdutoFakeDB;

public class ProdutoRepositorio extends BaseRepositorio<Produto>{

    private ProdutoFakeDB db;

    public ProdutoRepositorio(){
        this.db = new ProdutoFakeDB();
        this.dados = this.db.getTabela();
    }

    @Override
    public Produto Read(int chave) {
        for (Produto produto : dados) {
            if(chave == produto.getCodigo()){
                return produto;
            }
        }
            return null;
    }

    @Override
    public Produto Edit(Produto instancia) {
        Produto produto = this.Read(instancia.getCodigo());
        if(produto != null){
            produto.setDescricao(instancia.getDescricao());
            produto.setValor(instancia.getValor());
            return produto;
        }else{
            return null;
        }
    }

    @Override
    public Produto Add(Produto instancia) {
        Produto produto = this.dados.getLast();
        int proxChave = produto.getCodigo() + 1;
        instancia.setCodigo(proxChave);
        this.dados.add(instancia);
        return instancia;
    }

    @Override
    public Produto Delete(int chave) {
        Produto produto = this.Read(chave);
        if(produto != null){
            this.dados.remove(produto);
            return produto;
        }else{
            return null;
        }
    }
    
}
