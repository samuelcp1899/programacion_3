import java.util.Scanner;
import java.util.Stack;

//   - Si i es positivo, se inserta el elemento j en la pila Pi.
//   - Si i es negativo, se elimina el elemento j de la pila P|i|.
//   - Si i es cero, termina la entrada de datos.
//   - k solo puede valer -1 o 0:
//       - Si k es -1, se borran todos los elementos de la pila Pi.
//       - Si k es 0, el proceso es el indicado arriba con i y j.
// Al terminar se muestra el contenido de las 5 pilas.

public class Problema95 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
 
        // 5 pilas
        Stack<Integer> p1 = new Stack<>();
        Stack<Integer> p2 = new Stack<>();
        Stack<Integer> p3 = new Stack<>();
        Stack<Integer> p4 = new Stack<>();
        Stack<Integer> p5 = new Stack<>();
 
        System.out.println("Escribe triples ");
 
        // i = numero de pila (valor inicial distinto de 0)
        int i = 1;
 
        // Mientras i no sea 0 sigue leyendo datos
        while (i != 0) {
 
            // Pedimos el numero de pila
            System.out.print("i = ");
 
            // lee i
            i = teclado.nextInt();
 
            // Si es 0
            if (i == 0) {
                break; // se termina la entrada de datos
            }
 
            // si esta fuera del rango -5 .... 5
            if (i < -5 || i > 5) {
                System.out.println("Pila no valida, debe estar entre 1 y 5");
                continue; // se vuelve a pedir otro dato
            }
 
            // pedimos el elemento
            System.out.print("j = ");
 
            // leemos j
            int j = teclado.nextInt();
 
            // pedimos k (solo puede ser -1 o 0)
            System.out.print("k = ");
 
            // leemos k
            int k = teclado.nextInt();
 
            // si k no es -1 ni 0
            if (k != -1 && k != 0) {
                System.out.println("k no valido, debe ser -1 o 0");
                continue; // se vuelve a pedir otro dato
            }
 
            // numero = el numero el numero de pila sin signo (si i = -3 numero = 3)
 
            // aqui se guarda el numero de pila positivo
            int numero;
 
            // Si i es positivo
            if (i > 0) {
                numero = i; // queda igual
 
            } else { // si i es negativo
                numero = -i; // le quitamos el signo
            }
 
            // Se elige la pila con la que se va a trabajar y se guarda en Pila
            Stack<Integer> pila; // pila apunta a la pila elegida
 
            if (numero == 1) {
                pila = p1;
 
            } else if (numero == 2) {
                pila = p2;
 
            } else if (numero == 3) {
                pila = p3;
 
            } else if (numero == 4) {
                pila = p4;
 
            } else {
                pila = p5;
            }
 
            // Caso k = -1 BORRAR TODOS los elementos de la pila elegida (j no se usa)
            if (k == -1) {
 
                while (!pila.empty()) { // Mientras la pila tenga elementos
 
                    pila.pop(); // Se saca uno, asi se van borrando todos
 
                }
 
            // Caso k = 0 e i positivo INSERTAR
            } else if (i > 0) {
                pila.push(j); // se inserta j en la pila elegida
 
            } else { // Caso k = 0 e i negativo ELIMINAR
 
                Stack<Integer> aux = new Stack<>(); // pila que ayuda para guardar lo que saquemos mientras buscamos j
 
                boolean encontrado = false; // Guarda si encontramos j
 
                while (!pila.empty() && !encontrado) { // Mientras haya elementos y no hayamos encontrado j
 
                    int tope = pila.pop(); // Sacamos el elemento de arriba
 
                    if (tope == j) { // si es el elemento que buscamos
 
                        encontrado = true; // lo marcamos como encontrado no lo volvemos a guardar
 
                    } else { // si NO es
 
                        aux.push(tope); // lo guardamos en la pila auxiliar para devolverlo despues
                    }
 
                }
 
                // Se devuelve a la pila original los elementos que habiamos sacado
 
                while (!aux.empty()) { // Mientras el auxiliar tenga elementos
 
                    pila.push(aux.pop()); // Se regresan a la pila original osea queda en su orden original
 
                }
 
                if (!encontrado) {
                    System.out.println("El elemento " + j + " no esta en la pila P" + numero);
                }
 
            }
 
        }
 
        //Cuando termina la entrada se muestran las 5 pilas con su contenido
        System.out.println("Contenido de las pilas");
        System.out.println("P1: " + p1); //el ultimo de cada lista es el tope
 
        System.out.println("P2: " + p2);
        System.out.println("P3: " + p3);
        System.out.println("P4: " + p4);
        System.out.println("P5: " + p5);
 
        teclado.close();
    }
}
