package com.mycompany.sistemaescolar.dao;

import com.mycompany.sistemaescolar.conexao.Conexao;
import com.mycompany.sistemaescolar.model.AlunoModel;
import com.mycompany.sistemaescolar.model.ProfessorModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    public void CadastrarProfessor(ProfessorModel pm) {
        String sql = "INSERT INTO professores (nome,disciplina,telefone,email) VALUES (?,?,?,?)";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexao.createConnectionMySQL();
            ps = con.prepareStatement(sql);

            ps.setString(1, pm.getNome());
            ps.setString(2, pm.getDisciplina());
            ps.setString(3, pm.getTelefone());
            ps.setString(4, pm.getEmail());

            ps.execute();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar professor (DAO) " + e);
        }
    }

    public List<ProfessorModel> mostrarProfessores() {
        String sql = "SELECT * FROM professores";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<ProfessorModel> professores = new ArrayList<ProfessorModel>();

        try {
            con = Conexao.createConnectionMySQL();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ProfessorModel pm = new ProfessorModel();

                pm.setId_professor(rs.getInt("id_professor"));
                pm.setNome(rs.getString("nome"));
                pm.setDisciplina(rs.getString("disciplina"));
                pm.setTelefone(rs.getString("telefone"));
                pm.setEmail(rs.getString("email"));

                professores.add(pm);
            }
        } catch (Exception e) {
            System.out.println("Erro ao mostrar pro (DAO) " + e);
        }

        return professores;
    }

    public void atualizarProfessor(ProfessorModel pm) {
        String sql = "UPDATE professores SET nome=?, disciplina=?, telefone=?, email=? WHERE id_professor=?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexao.createConnectionMySQL();
            ps = con.prepareStatement(sql);

            ps.setString(1, pm.getNome());
            ps.setString(2, pm.getDisciplina());
            ps.setString(3, pm.getTelefone());
            ps.setString(4, pm.getEmail());

            ps.setInt(5, pm.getId_professor());

            ps.execute();

        } catch (Exception e) {
            System.out.println("Erro ao atualizar professores (DAO) " + e);
        }
    }

    public void excluirProfessor(int id) {
        String sql = "DELETE FROM professores WHERE id_professor=?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexao.createConnectionMySQL();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.execute();
        } catch (Exception e) {
            System.out.println("Erro ao deletar professor (DAO) " + e);
        }
    }
}
