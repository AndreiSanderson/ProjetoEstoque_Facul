package fakedb;

import java.util.ArrayList;

import dominio.Funcionario;

public class FuncionarioFakeDB extends BaseFakeDB<Funcionario> {

    @Override
    public void preencherDados() {
        if(this.tabela == null){
            this.tabela = new ArrayList<Funcionario>();

            tabela.add(new Funcionario(1, "Carlos Silva", "carlos@supersabor.com", "(11) 92345-6789", "Gerente de Vendas", 4500.00));
            tabela.add(new Funcionario(2, "Ana Santos", "ana@techsol.com", "(21) 93210-5432", "Analista de TI", 5000.00));
            tabela.add(new Funcionario(3, "Pedro Oliveira", "pedro@construbras.com", "(31) 94123-4567", "Engenheiro Civil", 7000.00));
            tabela.add(new Funcionario(4, "Mariana Costa", "mariana@trendwear.com", "(41) 95098-1234", "Designer de Moda", 3800.00));
            tabela.add(new Funcionario(5, "João Pereira", "joao@bemnatural.com", "(51) 96087-9876", "Farmacêutico", 4300.00));
        }
    }
    
}
