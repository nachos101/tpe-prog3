
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Servicios {
	private List<Camion> listaCamiones;
	private Map<String, Paquete> paquetesPorCodigo;
	private List<Paquete> conAlimentos;
	private List<Paquete> sinAlimentos;
	private List<Paquete>[] paquetesPorUrgencia;

	public Servicios(String pathCamiones, String pathPaquetes) throws IOException
	{
		this.listaCamiones = Lector.getCamiones(pathCamiones);
		List<Paquete>listaPaquetes = Lector.getPaquetes(pathPaquetes);
		this.paquetesPorCodigo = new HashMap<>();
		this.conAlimentos = new ArrayList<>();
		this.sinAlimentos = new ArrayList<>();
		this.paquetesPorUrgencia = new ArrayList[101];	
		inicializar(listaPaquetes);
	}

	private void inicializar(List<Paquete> listaPaquetes) {

		//se inicializa el arreglo de urgencias con listas para poder almacenar paquetes.
		for (int i = 0; i <= 100; i++) {
			paquetesPorUrgencia[i] = new ArrayList<>();
		}

		/*se completan las listas con y sin alimentos segun corresponda el paquete leido; se 
		ordena en la lista de paquetes por urgencia segun el mismo y se agrega en el mapa
		siendo el codigo la clave y el paquete el valor.*/
		for (Paquete p : listaPaquetes) {
			if (p.isContieneAlimentos()) {
				conAlimentos.add(p);
			} else {
				sinAlimentos.add(p);
			}
			paquetesPorUrgencia[p.getNivelUrgencia()].add(p);
			paquetesPorCodigo.put(p.getCodigo(), p);
		}
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
/* 	public List<Paquete> servicio2(boolean contieneAlimentos) {
		List<Paquete> alimentos = new ArrayList<Paquete>();
		for (Paquete p : paquetesPorCodigo.values()){
			if (p.isContieneAlimentos() == contieneAlimentos){
				alimentos.add(p);
			}
		}
		return alimentos;
	}
 */

	/*Dado un booleano que indica si se buscan paquetes que contienen alimentos, o no,
	retornar el listado de paquetes correspondiente.
	Es una complejidad de O(1) ya que solo se devuelve una lista previamente construida.
	*/

	public List<Paquete> servicio2(boolean contieneAlimentos) {
		if (contieneAlimentos){
			return this.conAlimentos;
		}else{
			return this.sinAlimentos;
		}
	}

	/* Dados dos valores enteros, que representan un nivel de urgencia min y max, 
	retornar todos los paquetes cuyo nivel de urgencia se encuentre en ese rango.
	Se decide recorrer el mapa una vez y no ordenar los elementos, asi se mantiene una
	complejidad de O(n) con el hashmap, la cantidad de paquetes almacenados en paquetesPorCodigo.*/
/* 	public List<Paquete> servicio3(int urgenciaMinima, int urgenciaMaxima) {
		List<Paquete> urgentes = new ArrayList<Paquete>();
		for (Paquete p : paquetesPorCodigo.values()){
			if (p.getNivelUrgencia() >= urgenciaMinima &&
				p.getNivelUrgencia() <= urgenciaMaxima){
				urgentes.add(p);
			}
		}
		return urgentes;
	} */

	/* Dados dos valores enteros, que representan un nivel de urgencia min y max, 
	retornar todos los paquetes cuyo nivel de urgencia se encuentre en ese rango.
	Se decide tener los paquetes ordenados previamente por urgencia, al llamar la funcion
	solo se recorren los valores entre la urgencia minima y la maxima. 
	De esta manera se mantiene una complejidad temporal de O(p) siendo p los paquetes
	que se encuentran dentro de ese rango. P puede ser igual a la cantidad total de paquetes
	si el rango fuera de 0-100.
	*/

	public List<Paquete> servicio3(int urgenciaMinima, int urgenciaMaxima) {
		List<Paquete> solucion = new ArrayList<>();

		for (int i = urgenciaMinima; i <= urgenciaMaxima; i++) {
			solucion.addAll(this.paquetesPorUrgencia[i]);
		}

		return solucion;
	}
}