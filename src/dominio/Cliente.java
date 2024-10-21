package dominio;

public class Cliente extends BasePessoa {
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cliente() {
    super();
    }
    public Cliente(int codigo, String nome, String email, String telefone, String cpf) {
        super(codigo, nome, email, telefone);
        this.cpf = cpf;
    }
        
}
