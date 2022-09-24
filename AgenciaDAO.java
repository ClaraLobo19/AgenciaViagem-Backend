package agenciaViagem;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AgenciaDAO {
	
	
/*****************************MÉTODO SAVE****************************** */	
	public void save(ClienteLogin cliente) {

		String sql= "INSERT INTO cliente( NOME_CLIENTE,  CPF_Cliente, RG_Cliente, email_Cliente, telefone_Cliente, Data_Nascimento, Senha)"+ " VALUES(?,?,?,?,?,?,?)";
		Connection conn= null;
		PreparedStatement pstm= null;
		
		try{
			// Cria uma conexão com o banco 
			 conn= Conexao.createConnectionToMySQL();
			 // Cria um PreparedStatment, classe usada para executar a query 
			 pstm= conn.prepareStatement(sql);
			// Adicionar os valores dos parâmetros da sql
			 pstm.setString(1, cliente.getNome_Cliente());
			 pstm.setString(2, cliente.getCPF_cliente());
			 pstm.setString(3, cliente.getRG_cliente());
			 pstm.setString(4, cliente.getEmail_cliente());
			 pstm.setString(5, cliente.getTelefone_Cliente());
			 pstm.setDate(6, new Date(cliente.getData_Nascimento().getTime()));
			 pstm.setString(7, cliente.getSenha());
			 
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
		String sql= "DELETE FROM contato WHERE id = ?";
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
	
	
		public void update(ClienteLogin cliente ) {//RECEBE TODO O OBJETO
			String sql="UPDATE contato SET  nome_cliente = ?, cpf_cliente = ? ,rg_cliente = ?, email_Cliente=?, Telefone_cliente = ?, Data_Nascimento=?, Senha=?" + "WHERE id = ?";// SÃO COLUNAS DA TABELA NO MYSQL
			Connection conn= null;
			PreparedStatement pstm= null;
			
			try{
				// Cria uma conexão com o banco 
				 conn= Conexao.createConnectionToMySQL();
				 // Cria um PreparedStatment, classe usada para executar a query 
				 pstm= conn.prepareStatement(sql);
				// Adicionar os valores dos parâmetros da sql
				 pstm.setString(1, cliente.getNome_Cliente());
				 pstm.setString(2, cliente.getCPF_cliente());
				 pstm.setString(3, cliente.getRG_cliente());
				 pstm.setString(4, cliente.getEmail_cliente());
				 pstm.setString(5, cliente.getTelefone_Cliente());
				 pstm.setDate(6, new Date(cliente.getData_Nascimento().getTime()));
				 pstm.setString(7, cliente.getSenha());
				 
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
		
		
		public ClienteLogin getContatoById(int id) {
			String sql="SELECT * FROM contato where id=?"; //id=? irá receber o parâmetro
			
			Connection conn= null;
			PreparedStatement pstm= null;
			
			ClienteLogin cliente = new ClienteLogin();
			ResultSet rset=null; //RECEBER A COLEÇÃO DA VARIÁVEL CONTATOS
			
			try {
				conn= Conexao.createConnectionToMySQL(); 
				pstm= conn.prepareStatement(sql);
				pstm.setInt(1,id);
				rset=pstm.executeQuery();
				
				rset.next();//IRÁ LER OQ TÁ BANCO DE DADOS
				cliente.setNome_Cliente(rset.getString("nome"));
				cliente.setCPF_cliente(rset.getString("CPF"));
				cliente.setRG_cliente(rset.getString("RG"));
				cliente.setEmail_cliente(rset.getString("Email"));
				cliente.setTelefone_Cliente(rset.getString("Telefone"));
				cliente.setData_Nascimento(rset.getDate("Data de Nascimento"));
			} catch(Exception e) { e.printStackTrace(); }
			
			finally{
				// FECHA AS CONEXÕES QUE ESTÃO ABERTAS
				try{
					if(pstm!= null) { pstm.close(); }
					if(conn!= null) { conn.close(); }
				} catch(Exception e) { e.printStackTrace(); }// TRAZER O ERRO CASO O TRY NÃO DER CERTO
			}
			return cliente;
		}
	
}
	 


