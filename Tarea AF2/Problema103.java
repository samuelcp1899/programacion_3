import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Problema103 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Creacion de las colas

        Queue<Integer> carritos = new LinkedList<>(); // Cola de los carritos disponibles

        Queue<Integer> esperando = new LinkedList<>(); // Cola de cliente esperando un carrito

        Queue<Integer> comprando = new LinkedList<>(); // Cola de carritos de clientes comprando

        Queue<Integer> caja1 = new LinkedList<>(); // Cola caja 1 ...

        Queue<Integer> caja2 = new LinkedList<>();

        Queue<Integer> caja3 = new LinkedList<>();

        // Al inicio los 25 carritos estan disponibles

        for (int k = 1; k <= 25; k++) {

            carritos.add(k); // Se agrega el carrito k a la cola de disponibles

        }

        int numeroCliente = 0; // un contador que le da un numero a cada cliente

        int opcion = -1; // Opcion del menu su valor inicial es distinto de 0

        // El menu se muestra una sola vez

        System.out.println("1. Llega un cliente");
        System.out.println("2. Un cliente termina de comprar");
        System.out.println("3. Un cliente paga una caja");
        System.out.println("4. Mostrar el estado");
        System.out.println("0. Salir");

        while (opcion != 0) { // Mientras no elija 0 (salir) sigue

            System.out.println();
            System.out.print("Opcion: ");

            opcion = teclado.nextInt(); // Lee la opcion elegida

            if (opcion == 1) {

                numeroCliente++; // Le da un numero al cliente

                if (!carritos.isEmpty()) { // Si hay carritos disponibles

                    int carrito = carritos.poll(); // Sacamos el primer carrito de la cola de disponibles

                    comprando.add(carrito); // El cliente empieza a comprar con ese carrito

                    System.out.println("El cliente " + numeroCliente + " toma el carrito " + carrito);

                } else { // si NO hay carritos disponible

                    esperando.add(numeroCliente); // el cliente se pone en la cola de espera

                    System.out.println("El cliente " + numeroCliente + " espera, no hay carritos disponibles");

                }

            } else if (opcion == 2) {

                if (!comprando.isEmpty()) { // si hay alguien comprando

                    int carrito = comprando.poll(); // termina el que lleva mas tiempo (el primero de la cola)

                    // Se elige la caja con menso gente comparando el tamaño de las colas

                    if (caja1.size() <= caja2.size() && caja1.size() <= caja3.size()) {

                        caja1.add(carrito); // la caja 1 es la que tiene menos gente o hay empate

                        System.out.println("El cliente del carrito " + carrito + " se pone en la caja 1");

                    } else if (caja2.size() <= caja3.size()) {

                        caja2.add(carrito); // caja 2 tiene menos gente

                        System.out.println("El cliente del carrito " + carrito + " se pone en la caja 2");

                    } else {

                        caja3.add(carrito); // la caja 3 es la que tiene menos gente

                        System.out.println("El cliente del carrito " + carrito + " se pone en la caja 3");
                    }

                }

            } else if (opcion == 3) {

                System.out.println("Numero de caja (1, 2, o 3)");

                int numeroCaja = teclado.nextInt(); // Lee en que caja paga el cliente

                Queue<Integer> caja; // Caja apuntara a la cola de la caja elegida

                if (numeroCaja == 1) {

                    caja = caja1;

                } else if (numeroCaja == 2) {

                    caja = caja2;

                } else if (numeroCaja == 3) {

                    caja = caja3;

                } else {

                    System.out.println("Caja no valida");

                    continue; // vuelve al menu
                }

                if (caja.isEmpty()) { // si la caja NO tiene clientes

                    System.out.println("La caja " + numeroCaja + " no tiene clientes");

                } else { // Si la caja tiene clientes

                    int carrito = caja.poll(); // el primero de la cola paga y sale

                    carritos.add(carrito); // el carrito esta disponible

                    System.out.println("El cliente de carrito " + carrito + " paga en la caja " + numeroCaja
                            + " y deja el carrito disponible");

                    if (!esperando.isEmpty()) { // si hay cleinte esperando un carrito

                        int cliente = esperando.poll(); // Sale el primero de la cola de espera

                        int carritoNuevo = carritos.poll(); // toma el primer carrito disponible

                        comprando.add(carritoNuevo); // Empieza a comprar

                        System.out.println("El cliente " + cliente + " que esperaba toma el carrito " + carritoNuevo);

                    }

                }

            } else if (opcion == 4) {

                System.out.println("Carritos disponibles (" + carritos.size() + "): " + carritos);

                System.out.println("Clientes esperando carrito: " + esperando);

                System.out.println("Carritos de clientes comprando: " + comprando);

                System.out.println("Caja 1: " + caja1);
                System.out.println("Caja 2: " + caja2);
                System.out.println("Caja 3: " + caja3);

            } else if (opcion != 0) { // si no es ninguna opcion valida

                System.out.println("Opcion no valida");

            }

        }

        teclado.close();
    }

}