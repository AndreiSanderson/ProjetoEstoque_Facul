package fakedb;

import java.time.LocalDate;
import java.util.ArrayList;

import dominio.ClasseProduto;

public class ClasseProdutoFakeDB extends BaseFakeDB <ClasseProduto>{

    @Override
    public void preencherDados() {
        if (this.tabela == null) {
            this.tabela = new ArrayList<>();
        }
        this.tabela.add(new ClasseProduto(1, "Carnes", LocalDate.now()));
        this.tabela.add(new ClasseProduto(2, "Bebidas", LocalDate.now()));
        this.tabela.add(new ClasseProduto(3, "Laticínio", LocalDate.now()));
        this.tabela.add(new ClasseProduto(4, "Frutas", LocalDate.now()));
        this.tabela.add(new ClasseProduto(5, "Verduras", LocalDate.now()));

    }
    
    
}
