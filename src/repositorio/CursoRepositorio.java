package repositorio;

import dominio.Curso;
import fakedb.CursoFakeDB;

public class CursoRepositorio extends BaseRepositorio<Curso>{

    CursoFakeDB db;

    public CursoRepositorio(){
        this.db = new CursoFakeDB();
        this.dados = this.db.getTabela();
    }

    @Override
    public Curso Read(int chave) {
        for (Curso crs : dados) {
            if(chave == crs.getCodigo()){
                return crs;
            }
        }
        return null;
    }

    @Override
    public Curso Edit(Curso instancia) {
        Curso crs = this.Read(instancia.getCodigo());
        if(crs != null){
            crs.setCargaHoraria(instancia.getCargaHoraria());
            crs.setDescricao(instancia.getDescricao());
            crs.setNome(instancia.getNome());
            return crs;
        }else{
            return null;
        }
    }

    @Override
    public Curso Add(Curso instancia) {
        Curso crs = this.dados.getLast();
        int proxChave = crs.getCodigo() + 1;
        instancia.setCodigo(proxChave);
        this.dados.add(instancia);
        return instancia;
    }

    @Override
    public Curso Delete(int chave) {
        Curso crs = this.Read(chave);
        if(crs != null){
            this.dados.remove(crs);
            return crs;
        }else{
            return null;
        }
    }
    
}
