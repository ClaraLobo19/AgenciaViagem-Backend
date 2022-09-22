package agenciaViagem;
import java.util.Date;

public class ClienteLogin {
	int ID_cliente;
	private String Nome_Cliente;
	private String CPF_cliente;
	private String RG_cliente;
	private String telefone;
	private Date data_Nascimento;
	private int ID_usuario;
	private String senha;
	
	
	public ClienteLogin ( ) {
		
	}
	
   String Cadastrar() {	  
	   return "ClienteLogin [Nome_Cliente=" + Nome_Cliente + ", ID_usuario=" + ID_usuario + ", senha=" + senha + "]";
   }

	
	


	public int getID_cliente() {
		return ID_cliente;
	}


	public void setID_cliente(int iD_cliente) {
		this.ID_cliente = iD_cliente;
	}


	public String getNome_Cliente() {
		return Nome_Cliente;
	}


	public void setNome_Cliente(String nome_Cliente) {
		this.Nome_Cliente = nome_Cliente;
	}


	public String getCPF_cliente() {
		return CPF_cliente;
	}


	public void setCPF_cliente(String CPF_cliente) {
		this.CPF_cliente = CPF_cliente;
	}
	
	public String getRG_cliente() {
		return RG_cliente;
	}

	public void setRG_cliente(String rG_cliente) {
		RG_cliente = rG_cliente;
	}



	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public Date getData_Nascimento() {
		return data_Nascimento;
	}


	public void setData_Nascimento(Date data_Nascimento) {
		this.data_Nascimento = data_Nascimento;
	}


	public int getID_usuario() {
		return ID_usuario;
	}


	public void setID_usuario(int iD_usuario) {
		this.ID_usuario = iD_usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	

}
