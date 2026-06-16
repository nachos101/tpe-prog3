package tp_prog3;

import java.util.ArrayList;

public class Camion {
	private int id;
	private String patente;
	private boolean refrigerado;
	private float capacidadMaxima;
	private ArrayList<Paquete> listaPaquetes;
	
	public Camion(int id, String patente, boolean refrigerado, float capacidadMaxima) {
		super();
		this.id = id;
		this.patente = patente;
		this.refrigerado = refrigerado;
		this.capacidadMaxima = capacidadMaxima;
		this.listaPaquetes = new ArrayList<>();
	}
	
	public void agregarPaquetes(Paquete p){
		if (this.pesoActual() + p.getPesoPaquete() < this.capacidadMaxima){ //hay que chequear que no nos pasemos de la capacidad maxima del camion
			this.listaPaquetes.add(p);
		}
		else {
			System.out.println("No hay espacio para este paquete");
		}
	}
	
	public float pesoActual() {
		float suma = 0;
		for(Paquete aux : listaPaquetes) {
			suma = suma + aux.getPesoPaquete();
		}
		return suma;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public boolean isRefrigerado() {
		return refrigerado;
	}
	public void setRefrigerado(boolean refrigerado) {
		this.refrigerado = refrigerado;
	}
	public float getCapacidadMaxima() {
		return capacidadMaxima;
	}
	public void setCapacidadMaxima(float capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	@Override
	public String toString() {
		return "Camion [id=" + id + ", patente=" + patente + ", refrigerado=" + refrigerado + ", capacidadMaxima="
				+ capacidadMaxima + "]";
	}
	
	
}
