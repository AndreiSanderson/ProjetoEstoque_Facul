package fakedb;

import java.util.ArrayList;

import dominio.Veiculo;

public class VeiculoFakeDB extends BaseFakeDB<Veiculo> {

    @Override
    public void preencherDados() {
        if(this.tabela == null){
            this.tabela = new ArrayList<Veiculo>();

            tabela.add(new Veiculo(1, "Toyota", "Corolla", 2020, 95000.00));
            tabela.add(new Veiculo(2, "Honda", "Civic", 2019, 87000.00));
            tabela.add(new Veiculo(3, "Ford", "Ranger", 2021, 210000.00));
            tabela.add(new Veiculo(4, "Chevrolet", "Onix", 2022, 75000.00));
            tabela.add(new Veiculo(5, "Audi", "R8", 2023, 130000.00));
        }
    }
    
}
