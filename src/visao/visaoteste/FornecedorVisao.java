package visao.visaoteste;

import java.util.ArrayList;

import dominio.Fornecedor;
import servico.FornecedorServico;


public class FornecedorVisao {
    private FornecedorServico srv;

    public FornecedorVisao(){
        this.srv = new FornecedorServico();
    }
    
    public void Exibir(){
        ArrayList<Fornecedor> lista = this.srv.Navegar();
        System.out.println("=====================================================");
        for (Fornecedor alvo : lista) {
            this.Imprimir(alvo);
        }
    }



    public void Imprimir(Fornecedor alvo){
        System.out.println("Classe de produto: ");
        System.out.println("Código: " +alvo.getCodigo());
        System.out.println("Razão Social: " +alvo.getNome());
        System.out.println("CNPJ: " +alvo.getCnpj());
        System.out.println("Nome Fantasia: " +alvo.getNomeFantasia());
        System.out.println("Email: " +alvo.getEmail());
        System.out.println("Telefone: " +alvo.getEmail());
        System.out.println("====================================================");
    }

    public void ImprimirPorLinha(Fornecedor alvo){
        String mensagem = "";
        mensagem += "Classe de produto: ";
        mensagem += "Código: " +alvo.getCodigo() +" | ";
        mensagem += "Razão Social: " +alvo.getNome()+" | ";
        mensagem += "CNPJ: " +alvo.getCnpj()+" | ";
        mensagem += "Nome Fantasia: " +alvo.getNomeFantasia() +"|";
        mensagem += "Email: " + alvo.getEmail() +"|";
        mensagem += "Telefone: " + alvo.getTelefone()+ "|";
        System.out.println(mensagem);
    }

    
    public void ImprimirPorLinha(int chave){
        Fornecedor alvo = this.srv.Ler(chave);
        this.ImprimirPorLinha(alvo);
    }


    public void Criar(Fornecedor novo){
        this.srv.Adicionar(novo);
    }

    public void Editar(int chave, Fornecedor alt){
        Fornecedor alvo = this.srv.Ler(chave);
        if (alvo != null){
            alvo.setNome(alt.getNome());
            alvo.setNomeFantasia(alt.getNomeFantasia());
            alvo.setEmail(alt.getEmail());
            alvo.setTelefone(alt.getTelefone());
        }else{
            System.out.println("Item não localizado.");
        }
    }

    public void Remover(int chave){
        Fornecedor alvo = this.srv.Ler(chave);
        if (alvo != null){
            this.srv.Deletar(chave);
        }else{
            System.out.println("Item não localizado.");
        }
    }
}
