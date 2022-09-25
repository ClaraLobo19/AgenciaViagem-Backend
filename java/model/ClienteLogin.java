package model;
import java.util.Date;

public class ClienteLogin {
	int ID_cliente;
	private String nome_Cliente;
	private String CPF_cliente;
	private String RG_cliente;
	private String email_cliente;
	private String telefone_Cliente;
	private Date data_Nascimento;
	private String senha;
	
	
	@Override
	public String toString() {
		return "ClienteLogin [ID_cliente=" + ID_cliente + ", Nome_Cliente=" + nome_Cliente + ", email_cliente="
				+ email_cliente + "]";
	}
	public int getID_cliente() {
		return ID_cliente;
	}
	public void setID_cliente(int iD_cliente) {
		ID_cliente = iD_cliente;
	}
	public String getNome_Cliente() {
		return nome_Cliente;
	}
	public void setNome_Cliente(String nome_Cliente) {
		nome_Cliente = nome_Cliente;
	}
	public String getCPF_cliente() {
		return CPF_cliente;
	}
	public void setCPF_cliente(String cPF_cliente) {
		CPF_cliente = cPF_cliente;
	}
	public String getRG_cliente() {
		return RG_cliente;
	}
	public void setRG_cliente(String rG_cliente) {
		RG_cliente = rG_cliente;
	}
	public String getEmail_cliente() {
		return email_cliente;
	}
	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}
	public String getTelefone_Cliente() {
		return telefone_Cliente;
	}
	public void setTelefone_Cliente(String telefone_Cliente) {
		this.telefone_Cliente = telefone_Cliente;
	}
	public Date getData_Nascimento() {
		return data_Nascimento;
	}
	public void setData_Nascimento(Date data_Nascimento) {
		this.data_Nascimento = data_Nascimento;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}