package tpe_prog3;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Servicios {
	private ArrayList<Camion> listaCamiones;
	private Map<String, Paquete> paquetesPorCodigo;
	
	public Servicios(String pathCamiones, String pathPaquetes)
	{
		this.listaCamiones = new ArrayList<>();
		this.paquetesPorCodigo
	}
	
	public Paquete servicio1(String codigoPaquete) { }
	
	public List<Paquete> servicio2(boolean contieneAlimentos) {
	}
	
	public List<Paquete> servicio3(int urgenciaMinima, int
	urgenciaMaxima) { }
}
