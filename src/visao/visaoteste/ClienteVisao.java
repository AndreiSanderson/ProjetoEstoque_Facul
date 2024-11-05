package visao.visao2;

import java.util.ArrayList;

import dominio.Cliente;
import servico.ClienteServico;

public class ClienteVisao{

    private ClienteServico srv;

    public ClienteVisao(){
        this.srv = new ClienteServico();
    }
    
    public void Exibir(){
        ArrayList<Cliente> lista = this.srv.Navegar();
        System.out.println("=====================================================");
        for (Cliente alvo : lista) {
            this.Imprimir(alvo);
        }
    }



    public void Imprimir(Cliente alvo){
        System.out.println("Cliente: ");
        System.out.println("Código: " +alvo.getCodigo());
        System.out.println("Nome: " +alvo.getNome());
        System.out.println("CPF: " +alvo.getCpf());
        System.out.println("Email: " +alvo.getEmail());
        System.out.println("Telefone: " +alvo.getTelefone());
        System.out.println("====================================================");
    }

    public void ImprimirPorLinha(Cliente alvo){
        String mensagem = "";
        mensagem += "Cliente: ";
        mensagem += "Código: " +alvo.getCodigo() +" | ";
        mensagem += "Nome: " +alvo.getNome()+" | ";
        mensagem += "CPF: " +alvo.getCpf()+" | ";
        mensagem += "Email: " +alvo.getEmail()+ "|";
        mensagem += "Telefone: " +alvo.getTelefone() +"|";
        System.out.println(mensagem);
    }

    
    public void ImprimirPorLinha(int chave){
        Cliente alvo = this.srv.Ler(chave);
        this.ImprimirPorLinha(alvo);
    }


    public void Criar(Cliente novo){
        this.srv.Adicionar(novo);
    }

    public void Editar(int chave, Cliente alt){
        Cliente alvo = this.srv.Ler(chave);
        if (alvo != null){
            alvo.setEmail(alt.getEmail());
            alvo.setTelefone(alt.getTelefone());
        }else{
            System.out.println("Item não localizado.");
        }
    }

    public void Remover(int chave){
        Cliente alvo = this.srv.Ler(chave);
        if (alvo != null){
            this.srv.Deletar(chave);
        }else{
            System.out.println("Item não localizado.");
        }
    }
}

