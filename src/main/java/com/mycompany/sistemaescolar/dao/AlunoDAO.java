package com.mycompany.sistemaescolar.dao;

import com.mycompany.sistemaescolar.conexao.Conexao;
import com.mycompany.sistemaescolar.model.AlunoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public void CadastrarAluno(AlunoModel am) {
        String sql = "INSERT INTO alunos (nome,matricula,telefone,endereco) VALUES (?,?,?,?)";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexao.createConnectionMySQL();
            ps = con.prepareStatement(sql);

            ps.setString(1, am.getNome());
            ps.setString(2, am.getMatricula());
            ps.setString(3, am.getTelefone());
            ps.setString(4, am.getEndereco());

            ps.execute();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar (DAO) " + e);
        }
    }

    public List<AlunoModel> mostrarAlunos() {
        String sql = "SELECT * FROM alunos";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<AlunoModel> alunos = new ArrayList<AlunoModel>();

        try {
            con = Conexao.createConnectionMySQL();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                AlunoModel am = new AlunoModel();

                am.setId_aluno(rs.getInt("id_aluno"));
                am.setNome(rs.getString("nome"));
                am.setMatricula(rs.getString("matricula"));
                am.setTelefone(rs.getString("telefone"));
                am.setEndereco(rs.getString("endereco"));

                alunos.add(am);
            }
        } catch (Exception e) {
            System.out.println("Erro ao mostrar (DAO) " + e);
        }

        return alunos;
    }

    public void atulizarAluno(AlunoModel alunoModel) {
        String sql = "UPDATE alunos SET nome=?, matricula=?, telefone=?, endereco=? WHERE id_aluno=?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexao.createConnectionMySQL();
            ps = con.prepareStatement(sql);

            ps.setString(1, alunoModel.getNome());
            ps.setString(2, alunoModel.getMatricula());
            ps.setString(3, alunoModel.getTelefone());
            ps.setString(4, alunoModel.getEndereco());

            ps.setInt(5, alunoModel.getId_aluno());

            ps.execute();

        } catch (Exception e) {
            System.out.println("Erro ao atualizar alunos (DAO) " + e);
        }
    }

    public void excluirAluno(int id) {
        String sql = "DELETE FROM alunos WHERE id_aluno=?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexao.createConnectionMySQL();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.execute();
        } catch (Exception e) {
            System.out.println("Erro ao deletar aluno (DAO) " + e);
        }
    }
}
