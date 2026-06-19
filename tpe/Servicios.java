package tpe_prog3;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Servicios {
	private List<Camion> listaCamiones;
	private Map<String, Paquete> paquetesPorCodigo;
	
	public Servicios(String pathCamiones, String pathPaquetes) throws IOException
	{
		this.listaCamiones = Lector.getCamiones(pathCamiones);
		this.paquetesPorCodigo = Lector.getPaquetes(pathPaquetes);
	}
	
	/*dado un codigo de paquete, retornar la informacion del paquete asociado,
	En caso de no existir, retornar null.
	El get del mapa devuelve el paquete asociado a la key, pero si no lo encuentra, 
	retorna null
	Complejidad O(1).*/
	public Paquete servicio1(String codigoPaquete) {
		return paquetesPorCodigo.get(codigoPaquete);
	}

	/* Dado un booleano que indica si se buscan paquetes que contienen alimentos, o no,
	retornar el listado de paquetes correspondiente.
	Es una complejidad de O(n) siendo n la cantidad de paquetes almacenados en paquetesPorCodigo.*/
	public List<Paquete> servicio2(boolean contieneAlimentos) {
		List<Paquete> alimentos = new ArrayList<Paquete>();
		for (Paquete p : paquetesPorCodigo.values()){
			if (p.isContieneAlimentos() == contieneAlimentos){
				alimentos.add(p);
			}
		}
		return alimentos;
	}


	/* Dados dos valores enteros, que representan un nivel de urgencia min y max, 
	retornar todos los paquetes cuyo nuvel de urgencia se encuentre en ese rango.
	Se decide recorrer el mapa una vez y no ordenar los elementos, asi se mantiene una
	complejidad de O(n) con el hashmap, la cantidad de paquetes almacenados en paquetesPorCodigo.*/
	public List<Paquete> servicio3(int urgenciaMinima, int urgenciaMaxima) {
		List<Paquete> urgentes = new ArrayList<Paquete>();
		for (Paquete p : paquetesPorCodigo.values()){
			if (p.getNivelUrgencia() >= urgenciaMinima &&
				p.getNivelUrgencia() <= urgenciaMaxima){
				urgentes.add(p);
			}
		}
		return urgentes;
	}
}