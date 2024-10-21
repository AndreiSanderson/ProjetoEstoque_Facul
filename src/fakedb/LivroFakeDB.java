package fakedb;

import java.util.ArrayList;

import dominio.Livro;

public class LivroFakeDB extends BaseFakeDB<Livro>{

    @Override
    public void preencherDados() {
        if(this.tabela == null){
            this.tabela = new ArrayList<Livro>();

            tabela.add(new Livro(1, "1984", "George Orwell", "978-0451524935", 1949));
            tabela.add(new Livro(2, "Dom Casmurro", "Machado de Assis", "978-8520932128", 1899));
            tabela.add(new Livro(3, "O Senhor dos Anéis", "J.R.R. Tolkien", "978-0544003415", 1954));
            tabela.add(new Livro(4, "A Revolução dos Bichos", "George Orwell", "978-0451526342", 1945));
            tabela.add(new Livro(5, "O Alquimista", "Paulo Coelho", "978-0062315007", 1988));    
        }
    }
    
}
