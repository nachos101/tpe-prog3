package tp_prog3;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		List<Paquete> listExample = new ArrayList<>();
		Lector l = new Lector();
		Camion camioneta = new Camion(1,"FFD",true,80);
		Paquete p = new Paquete(1,"SAD",60,true,5);
		
		listExample.addAll(l.getPaquetes("Paquete.txt"));
		
		System.out.println(camioneta);
		System.out.println(p);
	}

}
