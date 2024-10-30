package repositorio;

import dominio.Livro;
import fakedb.LivroFakeDB;

public class LivroRepositorio extends BaseRepositorio<Livro>{

    private LivroFakeDB db;

    public LivroRepositorio(){
        this.db = new LivroFakeDB();
        this.dados = db.getTabela();
    }

    @Override
    public Livro Read(int chave) {
        for (Livro livro : dados) {
            if(chave == livro.getCodigo()){
                return livro;
            }
        }
        return null;
    }

    @Override
    public Livro Edit(Livro instancia) {
        return null;       
    }


    @Override
    public Livro Add(Livro instancia) {
        Livro livro = this.dados.getLast();
        int proxChave = livro.getCodigo() + 1;
        instancia.setCodigo(proxChave);
        this.dados.add(instancia);
        return instancia;
    }

    @Override
    public Livro Delete(int chave) {
        Livro livro = this.Read(chave);
        if(livro != null){
            this.dados.remove(livro);
            return livro;
        }
        else{
            return null;
        }
    }
    
}
