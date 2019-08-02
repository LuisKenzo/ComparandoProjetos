package agenda;

public class Poltrona {
	  private int clienteID;
	  private String status;
	  private int linha;
	  private int coluna;
	  
	  
	  public Poltrona(int clienteID, int linha, int coluna) {
	    setClienteID(clienteID);
	    setStatus("vazia");
	    setLinha(linha);
	    setColuna(coluna);
	  }
	  
	  public Poltrona(String cliente) {
		  setStatus("ocupada");
	  }
	  
	  public void ocupaPoltrona(int clienteID) {
		  setClienteID(clienteID);
		  setStatus("ocupada");
	  }
	  
	  public void desocupaPoltrona() {
		  setClienteID(-1);
		  setStatus("vazia");
	  }
	
	  public void setClienteID(int clienteID) {
	    this.clienteID = clienteID;
	  }
	
	  public int getClienteID() {
	    return clienteID;
	  }
	  
	  public void setStatus(String status) {
		  this.status = status;
	  }
	  
	  public String getStatus() {
		  return status;
	  }
	  
	  public void setLinha(int linha) {
		  this.linha = linha;
	  }
	  
	  public int getLinha() {
		  return linha;
	  }
	  
	  public void setColuna(int coluna) {
		  this.coluna = coluna;
	  }
	  
	  public int getColuna() {
		  return coluna;
	  }
}
