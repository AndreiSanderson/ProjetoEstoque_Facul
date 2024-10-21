package fakedb;

import java.time.LocalDate;
import java.util.ArrayList;

import dominio.SubClasseProduto;

public class SubClasseProdutoFakeDB extends BaseFakeDB<SubClasseProduto>{

    @Override
    public void preencherDados() {

        if(this.tabela == null){
            this.tabela = new ArrayList<SubClasseProduto>();
            
            this.tabela.add(new SubClasseProduto(1, "Bovinos", LocalDate.now(), 1));
        }
    }
    
}
