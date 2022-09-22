package agenciaViagem;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AgenciaDAO {
	public void save(ClienteLogin cliente) {

		String sql= "INSERT INTO cliente( NOME_CLIENTE,  CPF_Client, RG_Cliente, Telefone, Data_Nascimento,ID_Usuario, Senha)"+ " VALUES(?,?,?,?,?,?,?)";
		Connection conn= null;
		PreparedStatement pstm= null;
		
		try{
			// Cria uma conexão com o banco 
			 conn= Conexao.createConnectionToMySQL();
			 // Cria um PreparedStatment, classe usada para executar a query 
			 pstm= conn.prepareStatement(sql);
			 // Adiciona o valor do primeiro parâmetro da sql
			 pstm.setInt(1,cliente.getID_cliente());
			// Adicionar o valor do segundo parâmetro da sql
			 pstm.setString(2, cliente.getNome_Cliente());
			//assim por diante
			 pstm.setString(3, cliente.getCPF_cliente());
			 pstm.setString(4, cliente.getRG_cliente());
			 pstm.setString(5, cliente.getTelefone());
			 // Adiciona valor do terceiro parâmetro da sql
			 pstm.setDate(6, new Date(cliente.getData_Nascimento().getTime()));
			 pstm.setInt(7,cliente.getID_usuario());
			 pstm.setString(8, cliente.getSenha());
			 
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
	
	/*************************************************/
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
}
	 


