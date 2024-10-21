package fakedb;

import java.util.ArrayList;

import dominio.Curso;

public class CursoFakeDB extends BaseFakeDB <Curso>{

    @Override
    public void preencherDados() {

        if(this.tabela == null){
            this.tabela = new ArrayList<Curso>();

            tabela.add(new Curso(1, "Java Básico", "Introdução à linguagem Java", 40));
            tabela.add(new Curso(2, "Python para Data Science", "Análise de dados com Python", 60));
            tabela.add(new Curso(3, "Desenvolvimento Web", "Criação de sites com HTML, CSS e JavaScript", 80));
            tabela.add(new Curso(4, "Machine Learning", "Conceitos e algoritmos de aprendizado de máquina", 100));
            tabela.add(new Curso(5, "Banco de Dados", "Modelagem e manipulação de bancos de dados SQL", 50));    
        }
    }
    
}
