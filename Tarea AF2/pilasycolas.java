import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class pilasycolas {
    public static void main(String[] args) {

        System.out.println("----- PILA -----"); //LIFO
        Stack<String> platos = new Stack<>();

        System.out.println(platos.empty()); //True = vacia False = Llena

        platos.push("Plato 1");
        platos.push("Plato 2");
        platos.push("Plato 3");
        platos.push("Plato 4");
        System.out.println(platos);

        System.out.println(platos.peek()); //Peek para ver el tope sin quitarlos

        System.out.println(platos.search("Plato 1")); //sirve para buscar un objeto específico dentro 
        // de la pila y saber a qué distancia se encuentra del tope

        System.out.println(platos.size()); //Para contar y devolver el numero total de elementos 
        // que hay guardados en la  pila en un momento dado

        System.out.println(platos.pop()); //Elimina el elemento que esta en el tope de la pila y lo devuelve

        System.out.println(platos);

        System.out.println(platos.empty()); //false

        //-----------------------------------------//
        System.out.println("----- COLA ----");//FIFO

        Queue<String> fila = new LinkedList<>(); //permite agregar y eliminar elementos en los extremos de forma muy eficiente  

        System.out.println(fila.isEmpty()); //True = esta vacia

        fila.add("Cliente 1"); //.add sirve para insertar un nuevo elemento al final de la estructura
        fila.add("Cliente 2");
        fila.offer("Cliente 3"); //sirve para insertar un nuevo elemento al final de una cola
        //  respetando el orden de la estructura  FIFO

        fila.offer("Cliente 4");
        System.out.println(fila); //vemos la cola

        System.out.println(fila.peek()); //Para ver el primero sin quitarlo

        System.out.println(fila.element());// Igual que peek pero lanza excepcion si esta vacia

        System.out.println(fila.size()); //tamaño de la cola

        System.out.println(fila.contains("Cliente 3")); // sirve para verificar si un elemento específico ya se encuentra dentro de la cola,
        //  devolviendo true si existe o false en caso contrario

        System.out.println(fila.poll()); //sirve para recuperar y eliminar el primer elemento que está al frente de la cola 
        // Si la cola está vacía, devuelve null en lugar de lanzar un error

        System.out.println(fila.remove()); //Igual que el poll pero lanza excepcion si esta vacia

        System.out.println(fila); //muestra la cola restante

        System.out.println(fila.isEmpty()); //comprueba si la cola esta vacia
        
    }
}
