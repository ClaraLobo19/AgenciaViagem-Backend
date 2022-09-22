package agenciaViagem;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AgenciaDAO clienteDao = new AgenciaDAO();
		ClienteLogin cliente1 = new ClienteLogin();
		
		//Adicionar dados em CLiente
		cliente1.setID_cliente(1);
		cliente1.setNome_Cliente("Joao");
		cliente1.setCPF_cliente("398745-84");
		cliente1.setRG_cliente("6878284-3");
		cliente1.setTelefone("34561234");
		cliente1.setData_Nascimento(new Date());
		cliente1.setID_usuario(0);
		cliente1.setSenha("sena123");
		clienteDao.save(cliente1);
		
	
		//remover
		clienteDao.removeById(1);
		
		
		
	}

}
