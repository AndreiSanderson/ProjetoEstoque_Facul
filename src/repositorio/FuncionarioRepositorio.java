package repositorio;

import dominio.Funcionario;
import fakedb.FuncionarioFakeDB;

public class FuncionarioRepositorio extends BaseRepositorio <Funcionario> {

    private FuncionarioFakeDB db;

    public FuncionarioRepositorio(){
        this.db = new FuncionarioFakeDB();
        this.dados = db.getTabela();
    }

    @Override
    public Funcionario Read(int chave) {
        for (Funcionario funcionario : dados) {
            if (chave == funcionario.getCodigo()) {
                return funcionario;            
            }
        }
        return null;
    }

    @Override
    public Funcionario Edit(Funcionario instancia) {
        Funcionario funcionario = this.Read(instancia.getCodigo());
        if(funcionario != null){
            funcionario.setNome(instancia.getNome());
            funcionario.setCargo(instancia.getCargo());
            funcionario.setSalario(instancia.getSalario());
            funcionario.setEmail(instancia.getEmail());
            funcionario.setTelefone(instancia.getTelefone());
            return funcionario;
        }else{
            return null;
        }
    }

    @Override
    public Funcionario Add(Funcionario instancia) {
        Funcionario funcionario = this.dados.getLast();
        int proxChave = funcionario.getCodigo() + 1;
        instancia.setCodigo(proxChave);
        this.dados.add(instancia);
        return instancia;
    }

    @Override
    public Funcionario Delete(int chave) {
        Funcionario funcionario = this.Read(chave);
        if(funcionario != null){
            this.dados.remove(funcionario);
            return funcionario;
        }
        else{
            return null;
        }
    }
}
