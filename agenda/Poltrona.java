package agenda;

public class Poltrona {
  private String cliente;
  public Poltrona(String nome) {
    setCliente(nome);
  }

  public void setCliente(String nome) {
    this.cliente = nome;
  }

  public String getCliente() {
    return cliente;
  }
}
