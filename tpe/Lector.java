

import java.io.*;
import java.util.*;

public class Lector {

	public static List<Camion> getCamiones(String ruta) throws IOException{
		List<Camion> camiones = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            boolean primera = true;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                if (primera) {
                    primera = false;      // omitir cabecera
                    continue;
                }
                List<String> campos = parsearLineaCSV(linea);
                // Esperamos al menos 4 campos: id, patente, capacidad, modelo
                if (campos.size() < 4) continue;
                int idCamion = Integer.parseInt(campos.get(0).trim());
                String patente = campos.get(1).trim();
                boolean refrigerado = false;
                if (Integer.parseInt(campos.get(2).trim()) == 1){
                    refrigerado = true;
                }
                float capacidad = Float.parseFloat(campos.get(3).trim());
                camiones.add(new Camion(idCamion, patente, refrigerado ,capacidad));
            }
        
        return camiones;
        }	
	}
	
	public static Map<String,Paquete> getPaquetes(String ruta) throws IOException{
		Map<String,Paquete> paquetes = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            boolean primera = true;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                if (primera) {
                    primera = false;
                    continue;
                }
                List<String> campos = parsearLineaCSV(linea);
                if (campos.size() < 5) continue;
                int idPaq = Integer.parseInt(campos.get(0).trim());
                String codigo = campos.get(1).trim();
                float pesoPaquete = Float.parseFloat(campos.get(2).trim());
                boolean contieneAlimentos = false;
                if (Integer.parseInt(campos.get(3).trim()) == 1){
                    contieneAlimentos = true;
                }
                int nivelUrgencia = Integer.parseInt(campos.get(4).trim());
                paquetes.put(codigo, new Paquete(idPaq, codigo, pesoPaquete, contieneAlimentos, nivelUrgencia));
            }
        }
        return paquetes;
	}
	
	private static List<String> parsearLineaCSV(String linea) {
        List<String> campos = new ArrayList<>();
        boolean dentroDeComillas = false;
        StringBuilder campoActual = new StringBuilder();
        for (int i = 0; i < linea.length(); i++) {
            char c = linea.charAt(i);
            if (dentroDeComillas) {
                if (c == '"') {
                    // ¿Siguiente comilla? (escapado)
                    if (i + 1 < linea.length() && linea.charAt(i + 1) == '"') {
                        campoActual.append('"');
                        i++; // saltar la segunda comilla
                    } else {
                        dentroDeComillas = false;
                    }
                } else {
                    campoActual.append(c);
                }
            } else {
                if (c == '"') {
                    dentroDeComillas = true;
                } else if (c == ',') {
                    campos.add(campoActual.toString());
                    campoActual.setLength(0);
                } else {
                    campoActual.append(c);
                }
            }
        }
        campos.add(campoActual.toString());
        return campos;
	}
	
}

