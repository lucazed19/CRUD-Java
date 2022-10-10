package Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.ConexaoJdbc;

public class CursoDAO {
	
	public List<Curso> list(){
		List<Curso> cursos = new ArrayList<>();
		
		try (Connection conexao = ConexaoJdbc.connection()){
			String sql = "SELECT * FROM curso";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				int id = result.getInt("id");
				String nome = result.getString("nome");
				int duracaoHoras = result.getInt("duracao_horas");
				
				cursos.add(new Curso(
						id,
						nome,
						duracaoHoras
				));
			}
			
		} catch (SQLException e) {
			System.out.println("Listagem de cursos FALHOU!");
            e.printStackTrace();
		}
		
		return cursos;
	}
	
	public Curso getById(int id) {
		Curso curso = new Curso();
		
		try(Connection conexao = ConexaoJdbc.connection()) {
			String sql = "SELECT * FROM curso WHERE id = ?";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            
            ResultSet result = stmt.executeQuery();

            if (result.next()){
            	curso.setId(result.getInt("id"));
            	curso.setNome(result.getString("nome"));
            	curso.setDuracaoHoras(result.getInt("duracao_horas"));
            }
                
			
		} catch (SQLException e) {
			System.out.println("Listagem de cursos FALHOU!");
            e.printStackTrace();
		}
		
		return curso;
	}
	
	public void create(Curso curso) {
		try (Connection conexao = ConexaoJdbc.connection()){
			String sql = "INSERT into curso(nome, duracao_horas) values(?,?)";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, curso.getNome());
			stmt.setInt(2, curso.getDuracaoHoras());
			
			int rowsAffected = stmt.executeUpdate();
            System.out.println("Inserção BEM SUCEDIDA!. Foi adicionada " + rowsAffected + " linha");
			
		} catch (SQLException e) {
			System.out.println("Criação de curso FALHOU!");
            e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		try (Connection conexao = ConexaoJdbc.connection()){
			String sql = "DELETE from curso WHERE id = ?";
			
			PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1 , id);
            
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Delete BEM SUCEDIDA! Foi deletada " + rowsAffected + " linha");
		
		} catch (SQLException e) {
			System.out.println("Exclusão de curso FALHOU!");
            e.printStackTrace();
		}
	}
	
	public void update(Curso curso) {
		try (Connection conexao = ConexaoJdbc.connection()){
			String sql = "UPDATE curso SET nome = ?, duracao_horas = ? WHERE id = ?";

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, curso.getNome());
            stmt.setInt(2, curso.getDuracaoHoras());
            stmt.setInt(3, curso.getId());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Atualização BEM SUCEDIDA! Foi atualizada: " + rowsAffected + " linha");
			
		} catch (SQLException e) {
			System.out.println("Update de curso FALHOU!");
            e.printStackTrace();
		}
		
	}
	
}	

