package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PassagemDAO {
	
	/*****************************MÉTODO SAVE****************************** */	
	public void save(Passagem passagem) {

		String sql= "INSERT INTO Passagem( ID_Voo, Classe, num_assento)"+ " VALUES(?,?)";
		Connection conn= null;
		PreparedStatement pstm= null;
		
		try{
			// Cria uma conexão com o banco 
			 conn= Conexao.createConnectionToMySQL();
			 // Cria um PreparedStatment, classe usada para executar a query 
			 pstm= conn.prepareStatement(sql);
			// Adicionar os valores dos parâmetros da sql
			 pstm.setInt(1, passagem.getID_voo());
			 pstm.setString(2, passagem.getClasse());
			 pstm.setInt(3,passagem.getNum_Assento());
			 
			 // Executaa sql para inserção dos dados 
			 pstm.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		} finally{
			// Fecha as conexões
			try{
				if(pstm!= null) {
					pstm.close();
				}
				if(conn!= null) {
					conn.close();
				}
		    }
			catch(Exception e) {
				e.printStackTrace();
				}
			}
		}
	
	
/**********************METODO REMOVE*********************************************/

	
	public void removeById(int id) {
		String sql= "DELETE FROM Passagem WHERE ID_Passagem = ?";
		Connection conn= null;
		PreparedStatement pstm= null;
		try{
			conn= Conexao.createConnectionToMySQL();
			pstm= conn.prepareStatement(sql);
			pstm.setInt(1, id);pstm.execute();
			}
		catch(Exception e) {// TODOAuto-generatedcatch block
			e.printStackTrace();
		}
	    finally{
			try{
					if(pstm!= null) {
						pstm.close();
					}
					if(conn!= null) {
						conn.close();
					}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	    }
	}
	
	
	/*****************************MÉTODO UPDATE**************************************/
	
	
	public void update(Passagem passagem ) {//RECEBE TODO O OBJETO
		String sql="UPDATE Passagem SET  Classe = ?, num_assento = ? " + "WHERE ID_Passagem = ?";// SÃO COLUNAS DA TABELA NO MYSQL
		Connection conn= null;
		PreparedStatement pstm= null;
		
		try{
			// Cria uma conexão com o banco 
			 conn= Conexao.createConnectionToMySQL();
			 // Cria um PreparedStatment, classe usada para executar a query 
			 pstm= conn.prepareStatement(sql);
			// Adicionar os valores dos parâmetros da sql
			 pstm.setString(1, passagem.getClasse());
			 pstm.setInt(2, passagem.getNum_Assento());
			 
			// EXECUTAR SQL PARA INSERÇÃO DE DADOS 
			pstm.execute();
		} catch(Exception e) { e.printStackTrace(); }
		
		finally{
			// FECHA AS CONEXÕES QUE ESTÃO ABERTAS
			try{
				if(pstm!= null) { pstm.close(); }
				if(conn!= null) { conn.close(); }
			} catch(Exception e) { e.printStackTrace(); }// TRAZER O ERRO CASO O TRY NÃO DER CERTO
		}
	}
	
	/***************************PROCURAR CLIENTE POR CONTATO*********************************************/	
	
	
	public Passagem getContatoById(int id) {
		String sql="SELECT * FROM Passagem where ID_passagem=?"; //id=? irá receber o parâmetro
		
		Connection conn= null;
		PreparedStatement pstm= null;
		
		Passagem passagem= new Passagem();
		
		ResultSet rset=null; //RECEBER A COLEÇÃO DA VARIÁVEL CONTATOS
		
		try {
			conn= Conexao.createConnectionToMySQL(); 
			pstm= conn.prepareStatement(sql);
			pstm.setInt(1,id);
			rset=pstm.executeQuery();
			rset.next();//IRÁ LER OQ TÁ BANCO DE DADOS
			
			passagem.setClasse(rset.getString("Classe"));
			passagem.setNum_Assento(rset.getInt("Numero do Assento"));
			
		} catch(Exception e) { e.printStackTrace(); }
		
		finally{
			// FECHA AS CONEXÕES QUE ESTÃO ABERTAS
			try{
				if(pstm!= null) { pstm.close(); }
				if(conn!= null) { conn.close(); }
			} catch(Exception e) { e.printStackTrace(); }// TRAZER O ERRO CASO O TRY NÃO DER CERTO
		}
		
	  return passagem;
	}

	
}
