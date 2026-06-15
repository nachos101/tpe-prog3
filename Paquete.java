package tp_prog3;

public class Paquete {
	private int id;
	private String codigo;
	private boolean contieneAlimentos;
	private float pesoPaquete;
	private int nivelUrgencia;
	public Paquete(int id, String codigo, boolean contieneAlimentos, float pesoPaquete, int nivelUrgencia) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.contieneAlimentos = contieneAlimentos;
		this.pesoPaquete = pesoPaquete;
		if (nivelUrgencia >=1 && nivelUrgencia <= 100) {
			this.nivelUrgencia = nivelUrgencia;
		}
		else {
			this.nivelUrgencia = 1;
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public boolean isContieneAlimentos() {
		return contieneAlimentos;
	}
	public void setContieneAlimentos(boolean contieneAlimentos) {
		this.contieneAlimentos = contieneAlimentos;
	}
	public float getPesoPaquete() {
		return pesoPaquete;
	}
	public void setPesoPaquete(float pesoPaquete) {
		this.pesoPaquete = pesoPaquete;
	}
	public int getNivelUrgencia() {
		return nivelUrgencia;
	}
	public void setNivelUrgencia(int nivelUrgencia) {
		this.nivelUrgencia = nivelUrgencia;
	}
	
}
