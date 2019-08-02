package usuario;

import agenda.Voo;
import agenda.Poltrona;

public class Compra {
	private Voo voo;
	private Poltrona poltrona;
	public Compra(Voo voo, Poltrona poltrona) {
		setVoo(voo);
		setPoltrona(poltrona);
	}
	
	public void setVoo(Voo voo) {
		this.voo = voo;
	}
	
	public Voo getVoo() {
		return voo;
	}
	
	public void setPoltrona(Poltrona poltrona) {
		this.poltrona = poltrona;
	}
	
	public Poltrona getPoltrona() {
		return poltrona;
	}
}
