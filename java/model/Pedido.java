package model;
import java.sql.Date;

public class Pedido {
	private int ID_Pedido;
	private int ID_Passagem;
	private int ID_Cliente;
	private Date DataPedido;
	
	
	public int getID_Pedido() {
		return ID_Pedido;
	}
	public void setID_Pedido(int iD_Pedido) {
		ID_Pedido = iD_Pedido;
	}
	public int getID_Passagem() {
		return ID_Passagem;
	}
	public void setID_Passagem(int iD_Passagem) {
		ID_Passagem = iD_Passagem;
	}
	public int getID_cliente() {
		return ID_Cliente;
	}
	public void setID_cliente(int iD_cliente) {
		ID_Cliente = iD_cliente;
	}
	public Date getDataPedido() {
		return DataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		DataPedido = dataPedido;
	}
	
	
	
	
	
	

}



