package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VooDAO {
	
	
	/*****************************MÉTODO SAVE****************************** */	
	public void save(Voo voo) {

		String sql= "INSERT INTO Voo( Hora_Saida, Hora_Chegada, Local_Saida, Local_Chegada)"+ " VALUES(?,?)";
		Connection conn= null;
		PreparedStatement pstm= null;
		
		try{
			// Cria uma conexão com o banco 
			 conn= Conexao.createConnectionToMySQL();
			 // Cria um PreparedStatment, classe usada para executar a query 
			 pstm= conn.prepareStatement(sql);
			// Adicionar os valores dos parâmetros da sql
			 pstm.setString(1, voo.getHora_Saida() );
			 pstm.setString(2, voo.getHora_Chegada());
			 pstm.setString(2, voo.getLocal_Saida());
			 pstm.setString(2, voo.getLocal_Chegada());
			 
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
		String sql= "DELETE FROM Voo WHERE ID_VOO = ?";
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
	
	
	public void update(Voo voo) {//RECEBE TODO O OBJETO
		String sql="UPDATE Passagem SET Hora_Saida=?, Hora_Chegada=?, Local_Saida=?, Local_Chegada=?" + "WHERE ID_Voo = ?";// SÃO COLUNAS DA TABELA NO MYSQL
		Connection conn= null;
		PreparedStatement pstm= null;
		
		try{
			// Cria uma conexão com o banco 
			 conn= Conexao.createConnectionToMySQL();
			 // Cria um PreparedStatment, classe usada para executar a query 
			 pstm= conn.prepareStatement(sql);
			// Adicionar os valores dos parâmetros da sql
			 pstm.setString(1, voo.getHora_Saida());
			 pstm.setString(2, voo.getHora_Chegada());
			 pstm.setString(1, voo.getLocal_Saida());
			 pstm.setString(1, voo.getLocal_Chegada());
			 
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
	
	
	public Voo getContatoById(int id) {
		String sql="SELECT * FROM Passagem where ID_Voo=?"; //id=? irá receber o parâmetro
		
		Connection conn= null;
		PreparedStatement pstm= null;
		
		Voo voo=new Voo();		
		
		ResultSet rset=null; //RECEBER A COLEÇÃO DA VARIÁVEL CONTATOS
		
		try {
			conn= Conexao.createConnectionToMySQL(); 
			pstm= conn.prepareStatement(sql);
			pstm.setInt(1,id);
			rset=pstm.executeQuery();
			rset.next();//IRÁ LER OQ TÁ BANCO DE DADOS
			
			
			voo.setHora_Saida(rset.getString("Hora de Saida"));
			voo.setHora_Chegada(rset.getString("Hora de Chegada"));
			voo.setLocal_Saida(rset.getString("Local de Saida"));
			voo.setLocal_Chegada(rset.getString("Local de Chegada"));
			
		} catch(Exception e) { e.printStackTrace(); }
		
		finally{
			// FECHA AS CONEXÕES QUE ESTÃO ABERTAS
			try{
				if(pstm!= null) { pstm.close(); }
				if(conn!= null) { conn.close(); }
			} catch(Exception e) { e.printStackTrace(); }// TRAZER O ERRO CASO O TRY NÃO DER CERTO
		}
		
	  return voo;
	}

}
