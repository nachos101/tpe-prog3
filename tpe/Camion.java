
import java.util.ArrayList;
import java.util.List;

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
		this.listaPaquetes.add(p);
	}
	
	public void eliminarPaquete(Paquete p) {
		this.listaPaquetes.remove(p);
	}

	public List<Paquete> getListaPaquete(){
		return new ArrayList<>(listaPaquetes);
	}
	
	public float pesoActual() {
		float suma = 0;
		for(Paquete p : listaPaquetes) {
			suma = suma + p.getPesoPaquete();
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
		return "Camion [id: " + id + ", patente: " + patente + ", refrigerado: " + refrigerado + ", capacidadMaxima: "
			+ capacidadMaxima + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (!(obj instanceof Paquete)) return false;
	    Paquete otro = (Paquete) obj;
	    return this.id == otro.getId();
	}

}
