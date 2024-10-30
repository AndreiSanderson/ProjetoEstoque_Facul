package repositorio;

import dominio.Cliente;
import fakedb.ClienteFakeDB;

public class ClienteRepositorio extends BaseRepositorio <Cliente> {

    private ClienteFakeDB db;

    public ClienteRepositorio(){
        this.db = new ClienteFakeDB();
        this.dados = this.db.getTabela();
    }

    @Override
    public Cliente Read(int chave) {
        for (Cliente cliente : dados) {
            if(chave == cliente.getCodigo()){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Cliente Edit(Cliente instancia) {
        Cliente cliente = this.Read(instancia.getCodigo());
        if(cliente != null){
            cliente.setEmail(instancia.getEmail());
            cliente.setNome(instancia.getNome());
            cliente.setTelefone(instancia.getTelefone());
            return cliente;
        }else{
            return null;
        }
    }

    @Override
    public Cliente Add(Cliente instancia) {
        Cliente cliente = this.dados.getLast();
        int proxChave = cliente.getCodigo() + 1;
        instancia.setCodigo(proxChave);
        this.dados.add(instancia);
        return instancia;
    }

    @Override
    public Cliente Delete(int chave) {
        Cliente cliente = this.Read(chave);
        if(cliente != null){
            this.dados.remove(cliente);
            return cliente;
        }else{
            return null;
        }
    }
    
}
