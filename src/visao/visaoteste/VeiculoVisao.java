package visao.visao2;

import java.util.ArrayList;

import dominio.Veiculo;
import servico.VeiculoServico;

public class VeiculoVisao {
    
    private VeiculoServico srv;

    public VeiculoVisao(){
        this.srv = new VeiculoServico();
    }
    
    public void Exibir(){
        ArrayList<Veiculo> lista = this.srv.Navegar();
        System.out.println("=====================================================");
        for (Veiculo alvo : lista) {
            this.Imprimir(alvo);
        }
    }

    public void Imprimir(Veiculo alvo){
        System.out.println("Veiculo: ");
        System.out.println("Código: " +alvo.getCodigo());
        System.out.println("Marca: " +alvo.getMarca());
        System.out.println("Modelo: " +alvo.getModelo());
        System.out.println("Ano de Fabricação: " +alvo.getAnoFabricacao());
        System.out.println("Preço: " +alvo.getPreco());
        System.out.println("====================================================");
    }

    public void ImprimirPorLinha(Veiculo alvo){
        String mensagem = "";
        mensagem += "Veiculo: ";
        mensagem += "Código: " +alvo.getCodigo() +" | ";
        mensagem += "Marca: " +alvo.getMarca()+" | ";
        mensagem += "Modelo: " +alvo.getModelo()+" | ";
        mensagem += "Ano de Fabricação: " +alvo.getAnoFabricacao()+ "|";
        mensagem += "Preço: " +alvo.getPreco() +"|";
        System.out.println(mensagem);
    }

    
    public void ImprimirPorLinha(int chave){
        Veiculo alvo = this.srv.Ler(chave);
        this.ImprimirPorLinha(alvo);
    }

    public void Criar(Veiculo novo){
        this.srv.Adicionar(novo);
    }

    public void Editar(int chave, Veiculo alt){
        Veiculo alvo = this.srv.Ler(chave);
        if (alvo != null){
            alvo.setPreco(alt.getPreco());
        }else{
            System.out.println("Item não localizado.");
        }
    }

    public void Remover(int chave){
        Veiculo alvo = this.srv.Ler(chave);
        if (alvo != null){
            this.srv.Deletar(chave);
        }else{
            System.out.println("Item não localizado.");
        }
    }
}
