package model;

public class PessoaBean {

    private String nome;
    private int idade;
    private String email;
    private String status = "Acordado";

    public PessoaBean() {

    }

    public PessoaBean(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public PessoaBean(String nome, int idade, String email, String status) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        if (status != null) {
            this.status = status;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
