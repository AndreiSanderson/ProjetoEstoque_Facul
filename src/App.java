import visao.ClasseProdutoVisao;
import visao.Produtovisao;
import visao.SubclasseProdutoVisao;

public class App {
    public static void main(String[] args) {
        ClasseProdutoVisao visao = new ClasseProdutoVisao();
        SubclasseProdutoVisao subvisao = new SubclasseProdutoVisao();
        Produtovisao prodvisao = new Produtovisao();
        visao.Exibir();
        subvisao.ExibirSub();
        prodvisao.ExibirProduto();
    }
}




