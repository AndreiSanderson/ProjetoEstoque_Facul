package fakedb;

import java.util.ArrayList;

import dominio.Fornecedor;

public class FornecedorFakeDB extends BaseFakeDB<Fornecedor>{

    @Override
    public void preencherDados() {
        if(this.tabela == null){
            this.tabela = new ArrayList<Fornecedor>();

            this.tabela.add(new Fornecedor(1, "Super Sabor", "contato@supersabor.com", "(11) 98765-4321", "SSabor", "12.345.678/0001-91"));
            this.tabela.add(new Fornecedor(2, "Tech Solutions", "vendas@techsol.com", "(21) 97654-3210", "TechSol", "98.765.432/0001-12"));
            this.tabela.add(new Fornecedor(3, "Construtora Brasil", "contato@construbras.com", "(31) 98547-1234", "Construbras", "55.123.456/0001-55"));
            this.tabela.add(new Fornecedor(4, "Moda Urbana", "atendimento@trendwear.com", "(41) 98456-7890", "Murbana", "77.654.321/0001-44"));
            this.tabela.add(new Fornecedor(5, "Farmácia Natural", "suporte@bemnatural.com", "(51) 99876-5432", "FarNatural", "33.456.789/0001-22"));
        }
    }
}

    

