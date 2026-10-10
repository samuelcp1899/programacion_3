import java.util.Scanner;
import java.util.Stack;

//cada símbolo que ABRE se guarda en la pila.
//cada símbolo que CIERRA debe coincidir con el último que se abrió (el tope de la pila).
// Ejemplo equilibrado:    ((a+b)*5) - 7
// Ejemplo NO equilibrado: 2*[(a+b)/2.5 + x - 7*y   (le falta el corchete que cierra)

public class Problema93 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Escribe una expresion: ");
        String Expresion = teclado.nextLine();

        // pila vacia donde se va a guardar los simbolos que abren
        Stack<Character> pila = new Stack<>();

        // si no esta equilibrado pasa a false
        boolean equilibrada = true;

        // i posicion del caracter que se esta revisando este empieza en 0

        for (int i = 0; i < Expresion.length(); i++) {

            // char.At(i) nos da el caracter que esta en la posicion iF
            char c = Expresion.charAt(i);

            // Si el caracter es un simbolo que abre
            if (c == '(' || c == '[' || c == '{') {

                // se guarda en la pila
                pila.push(c);

                // Si el caracter es un simbolo que cierra
            } else if (c == ')' || c == ']' || c == '}') {

                // si la pila esta vacia no hay nada que cerrar
                if (pila.empty()) {

                    // No esta equilibrada cierra algo que nunca abrio
                    equilibrada = false;

                    // salimos del for
                    break;
                }

                // sacamos el ultimo simbolo que se abrio
                char abierto = pila.pop();

                // verifica que el que cierra sea pareja del que abrio
                if (c == ')' && abierto != '(') {

                    // no coincide No esta equilibrada
                    equilibrada = false;
                    break;

                }

                if (c == ']' && abierto != '[') {
                    equilibrada = false;
                    break;

                }

                if (c == '}' && abierto != '{') {
                    equilibrada = false;
                    break;

                }

            }

        }

        // Si la pila no quedo vacia quedaron simbolos abiertos sin cerrar

        // si sobraron simbolos en la pila
        if (!pila.empty()) {

            // No esta equilibrada falta cerrar
            equilibrada = false;
        }

        // Resultado
        if (equilibrada) {
            System.out.println("La Expresion SI esta equilibrada");

        } else {
            System.out.println("La Expresion NO esta equilibrada");
        }

        teclado.close();
    }

}
