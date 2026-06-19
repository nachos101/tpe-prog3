import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) {		
		try {
			Map<String,Paquete> paquetes = Lector.getPaquetes("Paquete.txt");
			List<Camion> camiones = Lector.getCamiones("Camion.txt");
 			System.out.println("\n--- Paquetes leídos ---");
            paquetes.values().forEach(System.out::println);
            camiones.forEach(System.out::println);
			Servicios s1 = new Servicios("Camion.txt", "Paquete.txt");
			System.out.println("PAQUETE BUSCADO: " + s1.servicio1("P001"));
			System.out.println("ALIMENTOS?:\n" + s1.servicio2(false));
			System.out.println("RANGO URGENCIA:\n " + s1.servicio3(2, 20));
			//Se llama a la solucion backtracking
			Backtracking bt = new Backtracking();
			Solucion s = bt.backtracking(paquetes, camiones);
			System.out.println(s.toString());
			Greedy gr = new Greedy();
			Solucion g = gr.Greedy(paquetes,camiones);
			System.out.println(g.toStringGreedy()); 
		}
		catch(IOException e) {
			System.err.println("Error");
			e.printStackTrace();
		}
	}

}
