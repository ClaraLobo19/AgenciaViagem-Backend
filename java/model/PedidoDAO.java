package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidoDAO {
	
	/*****************************MÉTODO SAVE****************************** */	
	public void save(Pedido pedido) {

		String sql= "INSERT INTO Pedido( ID_Passagem,  ID_Cliente, Data_Pedido)"+ " VALUES(?,?,?)";
		Connection conn= null;
		PreparedStatement pstm= null;
		
		try{
			// Cria uma conexão com o banco 
			 conn= Conexao.createConnectionToMySQL();
			 // Cria um PreparedStatment, classe usada para executar a query 
			 pstm= conn.prepareStatement(sql);
			// Adicionar os valores dos parâmetros da sql
			 pstm.setInt(1, pedido.getID_Passagem());
			 pstm.setInt(2, pedido.getID_cliente());
			 pstm.setDate(3,pedido.getDataPedido());
			 
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
		String sql= "DELETE FROM Pedido WHERE ID_Pedido = ?";
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
	
	
		public void update(Pedido pedido ) {//RECEBE TODO O OBJETO
			String sql="UPDATE Pedido SET Data_Pedido=?" + "WHERE ID_Pedido = ?";// SÃO COLUNAS DA TABELA NO MYSQL
			Connection conn= null;
			PreparedStatement pstm= null;
			
			try{
				// Cria uma conexão com o banco 
				 conn= Conexao.createConnectionToMySQL();
				 // Cria um PreparedStatment, classe usada para executar a query 
				 pstm= conn.prepareStatement(sql);
				// Adicionar os valores dos parâmetros da sql
				 pstm.setDate(1, pedido.getDataPedido());
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
		
		
		public Pedido getContatoById(int id) {
			String sql="SELECT * FROM Pedido where ID_Pedido=?"; //id=? irá receber o parâmetro
			
			Connection conn= null;
			PreparedStatement pstm= null;
			
			Pedido pedido=new Pedido();
			ResultSet rset=null; //RECEBER A COLEÇÃO DA VARIÁVEL CONTATOS
			
			try {
				conn= Conexao.createConnectionToMySQL(); 
				pstm= conn.prepareStatement(sql);
				pstm.setInt(1,id);
				rset=pstm.executeQuery();
				
				rset.next();//IRÁ LER OQ TÁ BANCO DE DADOS
				pedido.setID_Pedido(rset.getInt("ID Pedido"));
				pedido.setID_Passagem(rset.getInt("ID Passagem"));
				pedido.setID_cliente(rset.getInt("ID Cliente"));
				pedido.setDataPedido(rset.getDate("Data de Pedido"));
			} catch(Exception e) { e.printStackTrace(); }
			
			finally{
				// FECHA AS CONEXÕES QUE ESTÃO ABERTAS
				try{
					if(pstm!= null) { pstm.close(); }
					if(conn!= null) { conn.close(); }
				} catch(Exception e) { e.printStackTrace(); }// TRAZER O ERRO CASO O TRY NÃO DER CERTO
			}
		return pedido;
	}
	
	

}
