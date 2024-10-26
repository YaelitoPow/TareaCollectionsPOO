import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class ContarPalabras {
    private Map<String, Integer> frecuencias;

    public ContarPalabras(String texto) {
        this.frecuencias = contarFrecuencias(extraerPalabras(texto));
    }

    //Método para extraer palabras usando una expresión regular
    private List<String> extraerPalabras(String texto) {
        Pattern patron = Pattern.compile("\\b[a-záéíóúüñ]+\\b");
        Matcher matcher = patron.matcher(texto);
        List<String> palabras = new ArrayList<>();

        while (matcher.find()) {
            palabras.add(matcher.group());
        }
        return palabras;
    }

    //Método para contar las frecuencias de las palabras
    private Map<String, Integer> contarFrecuencias(List<String> palabras) {
        return palabras.stream()
                .collect(Collectors.groupingBy(p -> p, Collectors.summingInt(p -> 1)));
    }

    //Método para contar la frecuencia de una palabra específica
    public int contarOcurrencias(String palabra) {
        return frecuencias.getOrDefault(palabra, 0);
    }

    //Método para obtener el mapa de frecuencias
    public Map<String, Integer> getFrecuencias() {
        return frecuencias;
    }
}
