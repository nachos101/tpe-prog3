package tpe_prog3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solucion {
    private float pesoNoAsignado;
    private List<Paquete> noAsignados;
    private HashMap<Integer, ArrayList<Paquete>> asignaciones;
    private int estadosGenerados;
    public Solucion() {
        this.pesoNoAsignado = 0; 
        this.noAsignados = new ArrayList<>();
        this.asignaciones = new HashMap<>();
        this.estadosGenerados = 0;
    }
    
    public Solucion(float pesoInicial) {
        this.pesoNoAsignado = pesoInicial; 
        this.noAsignados = new ArrayList<>();
        this.asignaciones = new HashMap<>();
        this.estadosGenerados = 0;
    }

    public void agregarNoAsignado(Paquete p) {
        noAsignados.add(p);
        pesoNoAsignado += p.getPesoPaquete();
    }

    public void quitarNoAsignado(Paquete p) {
        noAsignados.remove(p);
        pesoNoAsignado -= p.getPesoPaquete();
    }

    public void incrementarEstados() {
        estadosGenerados++;
    }

    public void copiarDe(Solucion otra, List<Camion> camiones) {
        this.pesoNoAsignado = otra.pesoNoAsignado;
        this.noAsignados = new ArrayList<>(otra.noAsignados);
        this.estadosGenerados = otra.estadosGenerados;
        for (Camion c : camiones) {
            asignaciones.put(c.getId(), new ArrayList<>(c.getListaPaquete()));
        }
    }

    public float getPesoNoAsignado() {
        return pesoNoAsignado;
    }

	@Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append("\n=== SOLUCION BACKTRACKING ===\n");
	    for (var entry : asignaciones.entrySet()) {
	        sb.append("Camion ")
            .append(entry.getKey())
            .append(" = ");
            if (entry.getValue().isEmpty()){
                sb.append("|camion vacio.|");
            }
            sb.append(entry.getValue())
            .append("\n");
	    }
	    sb.append("Peso no asignado: " + pesoNoAsignado + " kg\n");
	    sb.append("Paquetes sin asignar: ");
        if (noAsignados.isEmpty()){
            sb.append("Ninguno, se asignaron todos los paquetes." + "\n");
        }
        sb.append(noAsignados + "\n");
	    sb.append("Estados generados: " + estadosGenerados + "\n");
	    return sb.toString();
    }
}