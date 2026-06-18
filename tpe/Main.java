package tpe_prog3;
import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Camion camioneta = new Camion(1,"FFD",true,80);
		Paquete p = new Paquete(1,"SAD",60,true,5);
		System.out.println(camioneta);
		System.out.println(p);
		
		
		try {
			List<Paquete> listPaquete = Lector.getPaquetes("Paquete.txt");
			List<Camion> listCamion = Lector.getCamiones("Camiones.txt");
			System.out.println("\n--- Paquetes leídos ---");
            listPaquete.forEach(System.out::println);
            listCamion.forEach(System.out::println);
		}
		catch(IOException e) {
			System.err.println("Error");
			e.printStackTrace();
		}
	}

}
