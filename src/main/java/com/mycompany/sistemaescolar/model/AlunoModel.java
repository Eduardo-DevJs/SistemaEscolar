
package com.mycompany.sistemaescolar.model;


public class AlunoModel {
    private int id_aluno;
    private String nome;

    private String matricula;
    private String telefone;
    private String endereco;

    public AlunoModel() {
    }

    public AlunoModel(int id_aluno, String nome, String matricula, String telefone, String endereco) {
        this.id_aluno = id_aluno;
        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
}
