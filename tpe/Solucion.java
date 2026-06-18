package tpe_prog3;

import java.util.ArrayList;
import java.util.List;

public class Solucion {
    private float pesoNoAsignado;
    private List<Paquete> noAsignados;
    private int estadosGenerados;

    public Solucion() {
        this.pesoNoAsignado = Float.MAX_VALUE; 
        this.noAsignados = new ArrayList<>();
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

    public void copiarDe(Solucion otra) {
        this.pesoNoAsignado = otra.pesoNoAsignado;
        this.noAsignados = new ArrayList<>(otra.noAsignados);
        this.estadosGenerados = otra.estadosGenerados;
    }

    public float getPesoNoAsignado() {
        return pesoNoAsignado;
    }

    @Override
    public String toString() {
        return "Peso no asignado: " + pesoNoAsignado + "Paquetes sin asignar: " + noAsignados +  "Estados generados: " + estadosGenerados;
    }
}