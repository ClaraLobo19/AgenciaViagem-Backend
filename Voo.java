package agenciaViagem;

import java.util.Date;

public class Voo {
	int ID_Passagem;
	 String  Hora_Chegada ;
	 Date Hora_Saida ;
	 String Destino_Local;
	 String Saida_Local ;
	  public int getID_Passagem() {
		return ID_Passagem;
	}
	public void setID_Passagem(int iD_Passagem) {
		ID_Passagem = iD_Passagem;
	}
	public String getHora_Chegada() {
		return Hora_Chegada;
	}
	public void setHora_Chegada(String hora_Chegada) {
		Hora_Chegada = hora_Chegada;
	}
	public Date getHora_Saida() {
		return Hora_Saida;
	}
	public void setHora_Saida(Date hora_Saida) {
		Hora_Saida = hora_Saida;
	}
	public String getDestino_Local() {
		return Destino_Local;
	}
	public void setDestino_Local(String destino_Local) {
		Destino_Local = destino_Local;
	}
	public String getSaida_Local() {
		return Saida_Local;
	}
	public void setSaida_Local(String saida_Local) {
		Saida_Local = saida_Local;
	}
	

}
