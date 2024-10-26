import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String rutaEntrada = "D:/Programación/EjerciciosCollections/customers-1000.csv";  //Archivo de entrada
        String rutaSalida = "salida.txt";    //Archivo donde se guardará la salida

        try {

            //Leer contenido del archivo
            String contenido = ManejoArchivos.leerArchivo(rutaEntrada).toLowerCase();
            ContarPalabras contador = new ContarPalabras(contenido);

            //Búsqueda de la palabra
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Ingrese la palabra que desea buscar: ");
                String palabraBuscada = scanner.nextLine().toLowerCase();
                int frecuencia = contador.contarOcurrencias(palabraBuscada);

                // Mostrar resultados
                if (frecuencia == 0) {
                    System.out.println("La palabra \"" + palabraBuscada + "\" no se encontró en el texto.");
                } else {
                    System.out.println("La palabra \"" + palabraBuscada + "\" aparece " + frecuencia + " veces.");
                }
            }

            //Guardar frecuencias en el archivo
            ManejoArchivos.guardarFrecuenciasEnArchivo(contador.getFrecuencias(), rutaSalida);
            System.out.println("\nFrecuencia de palabras guardada en: " + rutaSalida);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
