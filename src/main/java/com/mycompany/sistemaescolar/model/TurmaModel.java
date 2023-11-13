
package com.mycompany.sistemaescolar.model;

public class TurmaModel {
    private int id_turma;
    private String nome;
    private String sala;
    private ProfessorModel professorModel;
    private AlunoModel alunoModel;

    public TurmaModel() {
    }

    public TurmaModel(int id_turma, String nome, String sala, ProfessorModel professorModel, AlunoModel alunoModel) {
        this.id_turma = id_turma;
        this.nome = nome;
        this.sala = sala;
        this.professorModel = professorModel;
        this.alunoModel = alunoModel;
    }

    public int getId_turma() {
        return id_turma;
    }

    public void setId_turma(int id_turma) {
        this.id_turma = id_turma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public ProfessorModel getProfessorModel() {
        return professorModel;
    }

    public void setProfessorModel(ProfessorModel professorModel) {
        this.professorModel = professorModel;
    }

    public AlunoModel getAlunoModel() {
        return alunoModel;
    }

    public void setAlunoModel(AlunoModel alunoModel) {
        this.alunoModel = alunoModel;
    }
    
}
