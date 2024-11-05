package visao.visao2;

import java.util.ArrayList;

import dominio.Funcionario;
import servico.FuncionarioServico;


public class FuncionarioVisao {

    private FuncionarioServico srv;

    public FuncionarioVisao(){
        this.srv = new FuncionarioServico();
    }
    
    public void Exibir(){
        ArrayList<Funcionario> lista = this.srv.Navegar();
        System.out.println("=====================================================");
        for (Funcionario alvo : lista) {
            this.Imprimir(alvo);
        }
    }

    public void Imprimir(Funcionario alvo){
        System.out.println("Classe de produto: ");
        System.out.println("Código: " +alvo.getCodigo());
        System.out.println("Nome: " +alvo.getNome());
        System.out.println("Email: " +alvo.getEmail());
        System.out.println("Telefone: " +alvo.getTelefone());
        System.out.println("Cargo: " +alvo.getCargo());
        System.out.println("Salário: " +alvo.getSalario());
        System.out.println("====================================================");
    }

    public void ImprimirPorLinha(Funcionario alvo){
        String mensagem = "";
        mensagem += "Classe de produto: ";
        mensagem += "Código: " +alvo.getCodigo() +" | ";
        mensagem += "Nome: " +alvo.getNome()+" | ";
        mensagem += "Email: " +alvo.getEmail()+" | ";
        mensagem += "Telefone: " +alvo.getTelefone()+ "|";
        mensagem += "Cargo: " +alvo.getCargo() + "|";
        mensagem += "Salario: " +alvo.getSalario() + "|";
        System.out.println(mensagem);
    }

    
    public void ImprimirPorLinha(int chave){
        Funcionario alvo = this.srv.Ler(chave);
        this.ImprimirPorLinha(alvo);
    }


    public void Criar(Funcionario novo){
        this.srv.Adicionar(novo);
    }

    public void Editar(int chave, Funcionario alt){
        Funcionario alvo = this.srv.Ler(chave);
        if (alvo != null){
            alvo.setNome(alt.getNome());
            alvo.setEmail(alt.getEmail());
            alvo.setTelefone(alt.getTelefone());
            alvo.setCargo(alt.getCargo());
            alvo.setSalario(alt.getSalario());
        }else{
            System.out.println("Item não localizado.");
        }
    }

    public void Remover(int chave){
        Funcionario alvo = this.srv.Ler(chave);
        if (alvo != null){
            this.srv.Deletar(chave);
        }else{
            System.out.println("Item não localizado.");
        }
    }
    
}
