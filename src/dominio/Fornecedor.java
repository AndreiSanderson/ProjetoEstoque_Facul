package dominio;

public class Fornecedor extends BasePessoa {
    //para economizar linhas utilizaremos a "BasePessoa", dessa forma o atributo razao social será utilizado como "nome"
    private String nomeFantasia;
    private String cnpj;
    public String getNomeFantasia() {
        return nomeFantasia;
    }
    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public Fornecedor() {
    }
    public Fornecedor(int codigo, String nome, String email, String telefone, String nomeFantasia, String cnpj) {
        super(codigo, nome, email, telefone);
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }

    
}