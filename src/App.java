import java.util.ArrayList;
import java.util.HashSet;

public class App {
    public static void main(String[] args) {

        String input = "xyzf";

        // Imprimimos los valores
        generarPermutaciones(input).forEach((permutacion) -> {
            System.out.print(permutacion + ", ");
        });

    }

    public static ArrayList<String> generarPermutaciones(String input) {

        // Esta estructura de datos no acepta repeticiones de nuestro input
        HashSet<Character> set = new HashSet<>();

        //LLena el set con cada caracter de input
        for (char c : input.toCharArray()) {
            set.add(c);
        }

        ArrayList<String> result = new ArrayList<>();

        generarPermutacionesRecursivo(set, new ArrayList<>(), result);

        return result;
    }

    public static void generarPermutacionesRecursivo(HashSet<Character> set, ArrayList<Character> permutacionActual, ArrayList<String> result) {
    
        if (permutacionActual.size() == set.size()) {

            StringBuilder permutationBuilder = new StringBuilder();

            for (Character c : permutacionActual) {
                permutationBuilder.append(c);
            }

            result.add(permutationBuilder.toString());

        } else {
            for (Character c : set) {
                
                if (!permutacionActual.contains(c)) {

                    permutacionActual.add(c);
                    generarPermutacionesRecursivo(set, permutacionActual, result);
                    permutacionActual.remove(permutacionActual.size() - 1);

                }
            }
        }
    }
}

