import java.io.*;
import java.nio.file.*;
import java.util.Map;

public class ManejoArchivos {
    
    //Método para leer el contenido de un archivo
    public static String leerArchivo(String ruta) throws IOException {
        return new String(Files.readAllBytes(Paths.get(ruta)));
    }

    //Método para guardar las frecuencias en un archivo
public static void guardarFrecuenciasEnArchivo(Map<String, Integer> frecuencias, String rutaSalida) {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaSalida))) {
        for (Map.Entry<String, Integer> entrada : frecuencias.entrySet()) {
            
            //Obtener la palabra y su frecuencia
            String palabra = entrada.getKey();  //La palabra que se está contando
            Integer frecuencia = entrada.getValue();  //La cantidad de veces que aparece

            writer.write(palabra + "," + frecuencia);

            writer.newLine();
        }
    } catch (IOException e) {
        System.err.println("Error al guardar las frecuencias en el archivo: " + e.getMessage());
    }
  }
}
