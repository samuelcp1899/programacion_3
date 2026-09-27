import java.util.Scanner;


public class Principal {

    // Metodo que inicia la ejecucion del programa
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Arreglo que almacena las 3 salas
        Sala[] salas = new Sala[3];

        // se crean las 3 salas y se guardan en el arreglo
        salas[0] = new Sala(1);
        salas[1] = new Sala(2);
        salas[2] = new Sala(3);

        // Arreglo que permite guardar hasta 20 peliculas
        Pelicula[] peliculas = new Pelicula[20];

        // Guarda la cantidad de peliculas registradas
        int cantidadPeliculas = 0;

        // Guarda la opcion seleccionada por el usuario
        int opcion = 0;

        // El ciclo mantiene el programa funcionando mientras la opcion no sea 4
        while (opcion != 4) {

            // Opciones principales del sistema
            System.out.println("====== CINEMASTAR ======");
            System.out.println("1. Creacion de peliculas");
            System.out.println(" 2. Asignacion de funciones");
            System.out.println("3. Venta de entradas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            // Guarda la opcion creada por el usuario
            opcion = teclado.nextInt();

            // Limpia el salto de linea que queda despues de leer un numero
            teclado.nextLine();

            // Comprueba cual opcion seleccionado el usuario
            switch (opcion) {

                case 1:
                    // Esta opcion permitira registrar y mostrar peliculas
                    System.out.println("Menu de creacion de peliculas");
                    break;

                case 2:
                    // Esta opcion permitira asignar peliculas a las funciones
                    System.out.println("Menu de asignacion de funciones");
                    break;

                case 3:
                    // Esta opcion permitira vender las entradas
                    System.out.println("Menu de venta de entradas");
                    break;

                case 4:
                    // Esta opcion termina la aplicacion
                    System.out.println("Aplicacion finalizada");
                    break;

                    default:

                    // Se ejecuta cuando se ingresa una opcion diferente
                    System.out.println("La opcion ingresada no existe");
                    break;

            }

            //Imprime una linea para separar las opciones
            System.out.println("-----------------------------");

        }

       
        teclado.close();
    }
}
