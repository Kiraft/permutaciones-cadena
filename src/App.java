import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // System.out.println("Ingresa la cadena: ");
        // String input = sc.nextLine();
        String input = "xyz";
        
        ArrayList<String> w1 = generarPermutaciones(input);
        ArrayList<String> w2 = new ArrayList<>();

        // Imprimimos los valores
        System.out.println("--- VALORES DE W1 --- ");
        w1.forEach((permutacion) -> {
            System.out.print(permutacion + " ");
        });
        System.out.println("\n");
        
        // Llena w2 con valores de w1
        for (String permutacion : w1) {
            for (String permutacionAux : w1) {
                w2.add(permutacion.concat(permutacionAux));
            }
        }

        // Imprime valores de w2
        System.out.println("--- VALORES DE W2 ---");
        w2.forEach((permutacion) -> {
            System.out.print(permutacion + " ");
        });

    }

    public static ArrayList<String> generarPermutaciones(String input) {

        // Esta estructura de datos no acepta repeticiones de nuestro input
        HashSet<Character> setCaracters = new HashSet<>();

        //LLena el set con cada caracter de input
        for (char c : input.toCharArray()) {
            setCaracters.add(c);
        }

        // Guarda los resultados
        ArrayList<String> resultados = new ArrayList<>();
        
        //Genera y guarda las permutaciones
        generarPermutacionesRecursivo(setCaracters, new ArrayList<>(), resultados);

        return resultados;
    }

    public static void generarPermutacionesRecursivo(HashSet<Character> setCaracters, ArrayList<Character> permutacionActual, ArrayList<String> resultados) {
        
        //Construye las permutaciones de permutacionActual
        StringBuilder permutacionBuilder = new StringBuilder();

        if (permutacionActual.size() == setCaracters.size()) {

            for (Character c : permutacionActual) {
                permutacionBuilder.append(c);
            }

            //Añade la permutacion al arraylist de resultados
            resultados.add(permutacionBuilder.toString());

        } else {
            for (Character c : setCaracters) {
                
                
                if (!permutacionActual.contains(c)) { //evita que se añáda un caracter ya existente

                    permutacionActual.add(c);
                    generarPermutacionesRecursivo(setCaracters, permutacionActual, resultados);

                    //Elimina la permutacion actual del arraylist para crear otra permutacion
                    permutacionActual.remove(permutacionActual.size() - 1);

                }
            }
        }
    }
}

