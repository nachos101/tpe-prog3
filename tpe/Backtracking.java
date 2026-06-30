
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class Backtracking {

	/*Explicacion estrategia backtracking.
    -Arbol de exploracion:
        El arbol de exploracion se genera a partir de todas las posibles combinaciones
        de asignar paquetes a camiones.
        Se tiene en cuenta que hay paquetes que contienen alimentos que necesitan de camiones 
        refrigerados, si se quiere asignar un paquete de alimentos a un camion que no es refrigerado, 
        se descarta ese paquete en esa solucion y se pasa al siguiente paquete.
        Los camiones refrigerados pueden, ademas, transportar paquetes que no requieran
        esa refrigeracion, mas no viceversa.

    -Estrategia de poda:
		Sabiendo que las restricciones son que cada camion puede llevar una cantidad maxima
		tomamos la decision de que si al sumar el peso del paquete a asignar al peso actual de camion, esta suma supera
		el peso maximo de carga del camion, ya no se considera en esa solucion y se pasa a otro paquete.
        Ademas, si a aquellos paquetes que contengan alimentos se los intenta asignar a un camion sin refrigeracion, 
		se descarta ese paquete en esa solucion y se pasa al siguiente.
        Se necesita llegar a los estados solucion para poder comparar el peso total de paquetes sin 
        asignar, de este modo se descartan las soluciones menos favorables y se encuentra la mejor solucion que es
		aquella con el menor peso total de los paquetes que no pudieron ser asignados a ningun camión.

	-Estados solucion:
		Se llega a un estado solucion cuando todos los camiones hayan alcanzado su capacidad maxima, o se hayan agotado
		los paquetes, lo que suceda primero.

	La complejidad temporal de esta estrategia es de O((m+1)^n), siendo n la cantidad de paquetes y m la cantidad de camiones.
	Si hay m camiones, cada paquete puede generar hasta m+1 ramas, y se eleva a la n porque para cada uno
	de los paquetes se elige entre m+1 opciones.
    */

	/* Se pasan los datos de un Map a una List para poder trabajar con indices de forma temporal.
	Esto tiene un costo unico de O(n) siendo n los paquetes almacenados en el mapa. */
	public Solucion backtracking(List<Paquete> listaPaquetes, List<Camion> camiones) {
		//arranca el peso no asignado en un numero muy alto.
		Solucion mejorSolucion = new Solucion(Float.MAX_VALUE);
		//arranca el peso no asignado en cero.
	    Solucion solucionActual = new Solucion();
	
	    btRecursivo(listaPaquetes, camiones, 0, solucionActual, mejorSolucion);
	 
	    return mejorSolucion;
	}
	
	public void btRecursivo(List<Paquete> paquetes, List<Camion> camiones, 
			int indice, Solucion actual, Solucion mejor) {
			//Caso base. El peso de los paquetes no asignados de la solucion actual es mejor que la ultima mejor solucion.
			actual.incrementarEstados();
			if (actual.getPesoNoAsignado() >= mejor.getPesoNoAsignado()){
				return;
			}
			if (indice == paquetes.size()) {
				if (actual.getPesoNoAsignado() < mejor.getPesoNoAsignado()) {
					mejor.copiarDe(actual, camiones);
				}
				return;
			}

			Paquete p = paquetes.get(indice);

			//Se intenta asignar el paquete a un camion.
			for (Camion c : camiones) {
				if (c.pesoActual() + p.getPesoPaquete() <= c.getCapacidadMaxima() &&
					(!p.isContieneAlimentos() || c.isRefrigerado())) {
					c.agregarPaquetes(p);
					btRecursivo(paquetes, camiones, indice + 1, actual, mejor);
					c.eliminarPaquete(p);
				}
			}

			//En caso de no ser posible, se deja sin asignar.
			actual.agregarNoAsignado(p);
			btRecursivo(paquetes, camiones, indice + 1, actual, mejor);
			actual.quitarNoAsignado(p);
	}
}