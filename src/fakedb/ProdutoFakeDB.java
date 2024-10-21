package fakedb;

import java.time.LocalDate;
import java.util.ArrayList;

import dominio.Produto;

public class ProdutoFakeDB extends BaseFakeDB<Produto>{

    @Override
    public void preencherDados() {

        if(this.tabela == null){
            this.tabela = new ArrayList<Produto>();

            this.tabela.add(new Produto(1, "File Mignion", LocalDate.now(), 1, 62.00));
            
        }
    }
    
}
