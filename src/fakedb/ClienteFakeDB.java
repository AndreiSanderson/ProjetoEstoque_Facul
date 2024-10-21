package fakedb;

import java.util.ArrayList;

import dominio.Cliente;

public class ClienteFakeDB extends BaseFakeDB<Cliente> {

    @Override
    public void preencherDados() {
        if(this.tabela == null){
            this.tabela = new ArrayList<Cliente>();

            this.tabela.add(new Cliente(1, "Arthur", "arthur@email.com", "(11) 98765-4321", "123.456.789-01"));
            this.tabela.add(new Cliente(2, "Maria", "maria@email.com", "(21) 97654-3210", "987.654.321-09"));
            this.tabela.add(new Cliente(3, "Lucas", "lucas@email.com", "(31) 98547-1234", "321.654.987-22"));
            this.tabela.add(new Cliente(4, "Fernanda", "fernanda@email.com", "(41) 98456-7890", "456.789.123-33"));
            this.tabela.add(new Cliente(5, "João", "joao@email.com", "(51) 99876-5432", "789.123.456-44"));

        }
    }
}
