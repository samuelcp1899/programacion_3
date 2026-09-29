import java.util.Scanner;

public class Main {

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
            System.out.println("2. Asignacion de funciones");
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

                    // Comprueba si todavia hay espacio en el arreglo
                    if (cantidadPeliculas < peliculas.length) {

                        // Solicita el nombre de la pelicula
                        System.out.print("Ingrese el nombre de la pelicula: ");
                        String nombre = teclado.nextLine();

                        // Solicita el idioma de la pelicula
                        System.out.print("Ingrese el idioma de la pelicula: ");
                        String idioma = teclado.nextLine();

                        System.out.print("Ingrese el tipo de pelicula 3D o 35mm: ");
                        String tipo = teclado.nextLine();

                        // Comprueba que el tipo de pelicula ingresado sea 3D o 35mm
                        if (tipo.equalsIgnoreCase("35mm") || tipo.equalsIgnoreCase("3D")) {

                            System.out.print("Ingrese la duracion en minutos de la pelicula: ");
                            int duracion = teclado.nextInt();

                            // Limpia el salto de linea
                            teclado.nextLine();

                            Pelicula nuevaPelicula = new Pelicula(nombre, idioma, tipo, duracion);

                            // Guarda las peliculas en la siguiente posicion
                            peliculas[cantidadPeliculas] = nuevaPelicula;

                            // Aumenta la cantidad de peliculas registradas
                            cantidadPeliculas++;

                            System.out.println("Pelicula registrada correctamente ");

                            // Muestra informacion de la pelicula
                            nuevaPelicula.mostrarInfo();
                        } else {
                            System.out.println("El tipo de pelicula debe ser 3D o 35mm");
                        }

                    } else {
                        // Cuando las 20 posiciones estan ocupadas
                        System.out.println("No hay espacio para registrar mas peliculas");
                    }

                    break;

                case 2:
                    // Esta opcion permitira asignar peliculas a las funciones
                    System.out.println("Menu de asignacion de funciones");

                    // Comprueba si existen peliculas registradas
                    if (cantidadPeliculas == 0) {

                        System.out.println("No hay peliculas registradas");
                        break;
                    }

                    // Muestra las peliculas disponibles
                    System.out.println("====== PELICULAS DISPONIBLES ======");

                    for (int i = 0; i < cantidadPeliculas; i++) {
                        System.out.println((i + 1) + ".");

                        peliculas[i].mostrarInfo();
                        System.out.println("--------------------");
                    }

                    // Seleccion de pelicula
                    System.out.println("Seleccione la pelicula que desea ver: ");
                    int peliculaSeleccionada = teclado.nextInt();

                    // Seleccion de la sala
                    System.out.println("Seleccione la sala: ");
                    int salaSeleccionada = teclado.nextInt();

                    // Seleccion de la funcion
                    System.out.println("Seleccione la funcion: ");
                    int funcionSeleccionada = teclado.nextInt();

                    teclado.nextLine();

                    // Comprueba si existe la pelicula
                    if (peliculaSeleccionada < 1
                            || peliculaSeleccionada > cantidadPeliculas) {

                        System.out.println("La pelicula seleccionada no existe");
                        break;
                    }

                    // Comprueba que la sala exista
                    if (salaSeleccionada < 1 || salaSeleccionada > 3) {

                        System.out.println("La sala seleccionada no existe");
                        break;
                    }

                    // Obtiene la pelicula seleccionada
                    Pelicula pelicula = peliculas[peliculaSeleccionada - 1];

                    // Obtiene la sala seleccionada
                    Sala sala = salas[salaSeleccionada - 1];

                    // Asigna la pelicula a la funcion
                    sala.asignarPeliculaFuncion(funcionSeleccionada, pelicula);
                    break;

                case 3:
                    // Esta opcion permitira vender las entradas
                    System.out.println("Menu de venta de entradas");

                    // Solicita la sala
                    System.out.print("Seleccione la sala: ");
                    int salaVenta = teclado.nextInt();

                    // Solicita la funcion
                    System.out.print("Seleccione la funcion: ");
                    int funcionVenta = teclado.nextInt();

                    // Comprueba que la sala exista
                    if (salaVenta < 1 || salaVenta > 3) {
                        System.out.println("La sala ingresada no existe");
                        break;
                    }

                    // Comprueba que la funcion exista
                    if (funcionVenta < 1 || funcionVenta > 3) {
                        System.out.println("La funcion ingresada no existe");
                        break;
                    }

                    // Comprueba si la funcion tiene una pelicula asignada
                    if (salas[salaVenta - 1].getFunciones()[funcionVenta - 1].getpelicula() == null) {
                        System.out.println("Esta funcion no tiene una pelicula asignada");
                        break;
                    }

                    // Obtiene la sala seleccionada
                    Sala salaSeleccionada2 = salas[salaVenta - 1];

                    // Muestra la cantidad de sillas disponibles
                    salaSeleccionada2.mostrarCantidadSillasDisponibles(funcionVenta);

                    // Muestra las sillas generales disponibles
                    salaSeleccionada2.mostrarSillasGenerales(funcionVenta);

                    // Muestra las sillas preferenciales solamente en las salas 1 y 2
                    if (salaVenta == 1 || salaVenta == 2) {
                        salaSeleccionada2.mostrarSillasPreferenciales(funcionVenta);
                    }

                    // Tipo de entrada
                    System.out.println("1. General");
                    System.out.println("2. Preferencial");
                    System.out.print("Seleccione el tipo de entrada: ");

                    int tipoEntrada = teclado.nextInt();

                    // Comprueba que el tipo de entrada sea valido
                    if (tipoEntrada < 1 || tipoEntrada > 2) {
                        System.out.println("Tipo de entrada invalido");
                        break;
                    }

                    // Comprueba que no se seleccione preferencial en la sala 3
                    if (salaVenta == 3 && tipoEntrada == 2) {
                        System.out.println("La sala 3 no tiene sillas preferenciales");
                        break;
                    }

                    // Solicita la cantidad de sillas que desea comprar
                    System.out.print("Ingrese la cantidad de sillas que desea comprar: ");
                    int cantidadSillas = teclado.nextInt();

                    // Comprueba que la cantidad de sillas sea valida
                    if (cantidadSillas <= 0) {
                        System.out.println("La cantidad de sillas debe ser mayor que 0");
                        break;
                    }

                    // Variable que almacena el valor total de la compra
                    int valorTotal = 0;

                    // Recorre la cantidad de sillas que el usuario desea comprar
                    for (int i = 0; i < cantidadSillas; i++) {

                        System.out.println("Silla " + (i + 1));

                        // Solicita la fila
                        System.out.print("Ingrese la fila: ");
                        int fila = teclado.nextInt();

                        // Solicita la silla
                        System.out.print("Ingrese la silla: ");
                        int silla = teclado.nextInt();

                        // Entrada general
                        if (tipoEntrada == 1) {
                            boolean compra = salaSeleccionada2.comprarSillaGeneral(
                                    funcionVenta,
                                    fila,
                                    silla);

                            // Si la compra fue realizada suma el valor de la entrada
                            if (compra) {
                                valorTotal = valorTotal
                                        + salaSeleccionada2.calcularValorCompra(false);
                            }

                        }
                        // Entrada preferencial
                        else if (tipoEntrada == 2) {
                            boolean compra = salaSeleccionada2.comprarSillaPreferencial(
                                    funcionVenta,
                                    fila,
                                    silla);

                            // Si la compra fue realizada suma el valor de la entrada
                            if (compra) {
                                valorTotal = valorTotal
                                        + salaSeleccionada2.calcularValorCompra(true);
                            }
                        }
                    }

                    // Muestra las sillas generales despues de realizar la compra
                    System.out.println("====== SILLAS GENERALES DESPUES DE LA COMPRA ======");
                    salaSeleccionada2.mostrarSillasGenerales(funcionVenta);

                    // Muestra las sillas preferenciales despues de realizar la compra
                    // Solamente se muestran en las salas 1 y 2
                    if (salaVenta == 1 || salaVenta == 2) {
                        System.out.println("====== SILLAS PREFERENCIALES DESPUES DE LA COMPRA ======");
                        salaSeleccionada2.mostrarSillasPreferenciales(funcionVenta);
                    }

                    // Muestra el valor total de todas las sillas compradas
                    System.out.println("Valor total a pagar: $" + valorTotal);

                    // Muestra la cantidad de sillas disponibles despues de la compra
                    salaSeleccionada2.mostrarCantidadSillasDisponibles(funcionVenta);

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

            // Imprime una linea para separar las opciones
            System.out.println("-----------------------------");

        }

        teclado.close();
    }
}