package tpe_prog3;

import java.util.List;

public class Backtracking {

	public Solucion backtracking(List<Paquete> paquetes, List<Camion> camiones) {
	    Solucion mejorSolucion = new Solucion();
	    Solucion solucionActual = new Solucion();
	    
	    btRecursivo(paquetes, camiones, 0, solucionActual, mejorSolucion);
	 
	    return mejorSolucion;
	}
	
	public void btRecursivo(List<Paquete> paquetes, List<Camion> camiones, 
			int indice, Solucion actual, Solucion mejor) {
			//caso base
			if (indice == paquetes.size()) {
				if (actual.getPesoNoAsignado() < mejor.getPesoNoAsignado()) {
					mejor.copiarDe(actual);
				}
				return;
			}

			Paquete paquete = paquetes.get(indice);

			//primero intento asignar a cada camion
			for (Camion camion : camiones) {
				if (camion.pesoActual()+paquete.getPesoPaquete()< camion.getCapacidadMaxima() && (!paquete.isContieneAlimentos() || camion.isRefrigerado())) {
					camion.agregarPaquetes(paquete);
					btRecursivo(paquetes, camiones, indice + 1, actual, mejor);
					camion.eliminarPaquete(paquete);
				}
			}

			//sino los dejo sin asignar
			actual.agregarNoAsignado(paquete);
			btRecursivo(paquetes, camiones, indice + 1, actual, mejor);
			actual.quitarNoAsignado(paquete);
	}
}
