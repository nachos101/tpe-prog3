import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Greedy {

    public List<Paquete> listaPaquetesOrdenados (Map<String, Paquete> paquetes){
        List<Paquete> lista = new ArrayList<>(paquetes.values());
        lista.sort(Comparator.comparingDouble(Paquete::getPesoPaquete).reversed());
        return lista;
    }

    /* Estrategia Greedy
    -Candidatos:
        Los posibles candidatos seran los paquetes disponibles para asignacion.
    
    -Estrategia de seleccion de candidatos:
        Se tiene una lista de paquetes la cual se ordena segun el peso de manera descendente.
        De igual manera se tienen los camiones que esperan la asignacion de estos paquetes.
        El proceso comienza con la seleccion del paquete de mayor peso. Teniendo en cuenta las restricciones,
        si este paquete al sumarlo al peso actual del camion a asignar supera la carga maxima del mismo, 
        deja de ser un candidato valido para ese camion y se intenta seguir con el siguiente paquete en la lista.
        Se tiene en cuenta tambien la refrigeracion de aquelos paquetes que lo necesiten
    
    -Consideracion:
        Greedy toma las decisiones que considera optimas para cada paso, no de manera general.
        Por esto la solucion factible puede no ser la optima y que queden paquetes sin asignar por mas
        que distribuyendolos de otra manera si pudieran asignarse.

    La complejidad temporal de esta estrategia es de O(n * m), siendo n la cantidad de paquetes y
    m la cantidad de camiones. La asignacion se ejecuta n veces y en el peor de los casos recorre
    todos los camiones m veces.
    */

    public Solucion Greedy(Map<String, Paquete> paquetes, List<Camion> camiones) {
        List<Paquete> candidatos = listaPaquetesOrdenados(paquetes);
        camiones.sort(Comparator.comparingDouble(Camion::getCapacidadMaxima).reversed());
        Solucion s = new Solucion();

        for (Paquete p : candidatos) {
            s.incrementarEstados();
            boolean asignado = false;
            int i = 0;
            while (i < camiones.size() && !asignado){
                if ((camiones.get(i).pesoActual() + p.getPesoPaquete() <= camiones.get(i).getCapacidadMaxima())&&
                    (!p.isContieneAlimentos() || camiones.get(i).isRefrigerado())){
                    s.agregarPaqueteSolucion(camiones.get(i).getId(), p);
                    //agrego el paquete al camion para que se actualice el peso 
                    camiones.get(i).agregarPaquetes(p);
                    asignado = true;
                }
                i++;
            }

            if (!asignado){
                s.agregarNoAsignado(p);
            }
        }

        return s;
    }

}
