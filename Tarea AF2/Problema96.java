import java.util.Scanner;
import java.util.Stack;

// Estrategia del problema, para cada linea (frase):
//   1) Cada caracter se añade a una PILA.
//   2) A la vez, cada caracter se añade al FINAL de una LISTA ENLAZADA CIRCULAR.
//   3) Se extrae caracter por caracter, al mismo tiempo, de la pila (el ultimo que entro)
//      y de la lista circular (el primero). Si siempre son iguales, es palindromo.
// Ejemplo: "anita lava la tina" es palindromo, "hola mundo" no lo es.
// Nota: se ignoran los espacios, los signos y las mayusculas.

public class Problema96 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Escribe una frase por linea. Para terminar escribe FIN. ");

        String linea = teclado.nextLine(); // Para leer la primera linea

        while (!linea.equals("FIN")) { // mientras la linea no sea FIN sigue

            Stack<Character> pila = new Stack<>(); // pila vacia para la frase

            Elemento ultimo = null; // Ultimo elemento de la lista circular null = lista vacia
            // ultimo.siguiente siempre es el primero de la lista

            // Se recorre la frase y se llena la pila y la lista circular
            // el for toma cada caracter de la frase, uno por uno y lo guarda en c

            for (char c : linea.toCharArray()) {

                if (c != ' ') { // Si el caracter NO es un espacio se ignora

                    pila.push(c); // se añade a la pila

                    Elemento nuevo = new Elemento(c); // Se crea un elemento con el caracter

                    if (ultimo == null) { // Si la lista esta vacia

                        nuevo.siguiente = nuevo; // el elemento se apunta a si mismo( es el unico forma el circulo)

                        ultimo = nuevo; // y es el ultimo

                    } else {

                        nuevo.siguiente = ultimo.siguiente; // El nuevo apunta al primero para cerrar el circulo

                        ultimo.siguiente = nuevo; // El que era ultimo ahora apunta al nuevo

                        ultimo = nuevo; // El nuevo pasa a ser el ultimo (se añadio al final)
                    }

                }
            }

            // Extraer de la pila y de la lista al mismo tiempo y comparar

            boolean esPalindromo = true; // se asume que es palindromo si algo falla pasa a false

            while (!pila.empty() && esPalindromo) { // Mientras haya caracteres y todo coincida hasta ahora

                char dePila = pila.pop(); // se saca el tope de la pila (el ultimo caracter de la frase)

                Elemento primero = ultimo.siguiente; // El primero de la lista es el que sigue al ultimo

                char deLista = primero.dato; // Se guarda el caracter del primero

                if (primero == ultimo) { // Si el primero y el ultimo son el mismo elemento (o era el unico)

                    ultimo = null; // La lista queda vacia

                } else {

                    ultimo.siguiente = primero.siguiente; // El ultimo ahora apunta al segundo (se elimina el primero)
                }

                if (dePila != deLista) { // si los dos caracteres son distintos

                    esPalindromo = false; // No es palindromo

                }

            }

            // Se muestra el resultado de la frase

            if (esPalindromo) {
                System.out.println("SI es palindromo");

            } else {
                System.out.println("NO es palindromo");
            }

            linea = teclado.nextLine(); // Leemos la siguiente linea
        }

        teclado.close();

    }
}

// Elemento cada cajita de la lista enlazada circular

class Elemento {

    char dato; // El caracter que guarda cada elemento

    Elemento siguiente; // Referencia al elemento que viene despues

    Elemento(char d) { // El constructor crea un elemento con el carcter d

        dato = d;

    }
}
