package tp_prog3;
import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Camion camioneta = new Camion(1,"FFD",true,80);
		Paquete p = new Paquete(1,"SAD",60,true,5);
		System.out.println(camioneta);
		System.out.println(p);
		
		
		try {
			List<Paquete> listExample = Lector.getPaquetes("Paquete.txt");
			System.out.println("\n--- Paquetes leídos ---");
            listExample.forEach(System.out::println);
		}
		catch(IOException e) {
			System.err.println("Error");
			e.printStackTrace();
		}
	}

}
