public class Sala {

    public static void main(String[] args) {
        
    }
    // Atributos
    private int numero; // guardar el numero de salas ( puede ser sala 1 2 o 3)

    // Creacion de la matriz para guardar las sillas generales
    // use boolean por que en este caso la silla solo puede tener 2 estados
    // Disponible y ocupado por lo que se puede representar como verdadero y falso
    private boolean[][] sillasGenerales;

    // Determina una silla (False: silla disponible)
    // --------------------(True: Silla ocupada)

    // Matriz para guardar el estado de las sillas preferenciales
    // sala 1 y 2
    private boolean[][] sillasPreferenciales;

    // Arreglo que guarda las 3 funciones disponibles
    private Funcion[] funciones;

    // Constructor que recibe el numero de la sala al momento de crearla publica
    public Sala(int numero) {
        this.numero = numero; // Guarda el numero recibido del atributo numero

        // Matriz de sillas generales (6 filas y 12 columnas)
        this.sillasGenerales = new boolean[6][12];

        // comprueba si la sala creada es la sala 1 o la sala 2
        if (numero == 1 || numero == 2) {

            // en caso de que sea la sala 1 o 2, es la seccion preferencial
            // con 2 filas y 9 columnas
            this.sillasPreferenciales = new boolean[2][9];
        } else {

            // como la sala 3 no tiene sillasPreferenciales se deja null
            this.sillasPreferenciales = null;
        }

        // Arreglo con espacio para las 3 funciones de la sala
        this.funciones = new Funcion[3];

        // Funciones con horarios
        this.funciones[0] = new Funcion("14:00 - 16:30");

        this.funciones[1] = new Funcion("16:30 - 19:00");

        this.funciones[2] = new Funcion("19:00 - 21:00");
    }

    // Metodos
    // Para consultar el numero de la sala
    public int getNumero() {
        return numero;
    }

    // Para consultar la matriz de sillas generales
    public boolean[][] getSillasGenerales() {
        return sillasGenerales;
    }

    public boolean[][] getSillasPreferenciales() {
        return sillasPreferenciales;
    }

    // Consultar el arreglo de las funciones de la sala
    public Funcion[] getFunciones() {
        return funciones;
    }

    // Visualizar las funciones

    // Recorre las 3 funciones de la sala y muestra su informacion
    public void mostrarFunciones() {

        // Numero de la sala
        System.out.println("Funciones de la sala: " + numero);

        // Recorre todo el arreglo de funciones
        for (int i = 0; i < funciones.length; i++) {

            // Muestra el numero de la funcion
            System.out.println("Funcion: " + (i + 1));

            // Llama al metodo mostrar info de la funcion
            funciones[i].mostrarInfo();

            System.out.println("--------------------");
        }

    }

    // Metodo para mostrar las sillas generales de la sala
    public void mostrarSillasGenerales() {

        // Recorre las 6 filas de la matriz de sillas generales
        for (int i = 0; i < sillasGenerales.length; i++) {

            // Convierte el numero de la fila en una letra
            // Cuando i vale 0, la letra sera A
            // Cuando i vale 1, la letra sera B y asi sucesivamente
            char letraFila = (char) ('A' + i);

            // Muestra la letra de la fila
            System.out.println(letraFila + " ");

            // Recorre las 12 sillas que tiene cada fila
            for (int j = 0; j < sillasGenerales[i].length; j++) {

                // Comprueba si la silla esta ocupada
                if (sillasGenerales[i][j]) {

                    // La X representa la silla ocupada
                    System.out.print("[X]");
                } else {

                    // La O representa una silla disponible
                    System.out.println("[0]");
                }
            }

            // Realiza un salto de linea al terminar cada fila
            System.out.println();
        }
    }

    // Metodo para mostrar las sillas preferenciales
    public void mostrarSillasPreferenciales() {
        // Comprueba si la sala tiene seccion preferencial
        if (sillasPreferenciales == null) {

            // la sala 3 no tiene sillas preferenciales
            System.out.println("Esta sala no tiene sillas preferenciales: ");

            // Termina el metodo para no intentar recorrer una matriz inexistente
            return;
        }

        // Recorre las 2 filas de la seccion preferencial
        for (int i = 0; i < sillasPreferenciales.length; i++) {

            // Convierte el numero de la fila en una letra
            // cuando i vale 0, la letra sera G
            // cuando i vale 1, la letra sera H
            // para no usar un int ya que las filas se identifican con letras
            // tambien para aprovechar el ciclo
            char letraFila = (char) ('G' + i);

            // Letra de cada fila
            System.out.print(letraFila + "");

            // Recorre las 9 sillas que tiene cada fila preferencial
            for (int j = 0; j < sillasPreferenciales[i].length; j++) {

                // Comprueba si la silla preferencial esta ocupada
                if (sillasPreferenciales[i][j]) {

                    // La X marca una silla ocupada
                    System.out.print("[X]");
                } else {
                    // la O marca una silla disponible
                    System.out.print("[O]");
                }
            }

            // Realiza un salto de linea al terminar cada fila
            System.out.println();

        }
    }

    // Metodo para comprar una silla general
    public boolean comprarSillaGeneral(int fila, int numeroSilla) {

        // Se resta 1 por que las posicones de las matrices comienzan desde 0
        // La fila 1 sera la posicion 0 y la silla 1 sera la posicion 0
        int posicionFila = fila - 1;
        int posicionSilla = numeroSilla - 1;

        // comprueba que la fila se encuentre entre 1 y 6
        if (fila < 1 || fila > 6) {

            // muestra un mensaje si la fila no existe
            System.out.println("La fila ingresada no existe: ");

            // Retorna falso porque no se pudo realizar la compra
            return false;
        }

        // Comprueba que el numero de la silla se encuentre entre 1 y 12
        if (numeroSilla < 1 || numeroSilla > 12) {

            // Muestra un mensaje si la silla no existe
            System.out.println("La silla ingresada no existe: ");

            // Retorna falso por que no se pudo realizar la compra
            return false;
        }

        // Comprueba si la silla seleccionada ya esta ocupada
        if (sillasGenerales[posicionFila][posicionSilla]) {

            // Muestra un mensaje si la silla ya fue comprada
            System.out.println("La silla ya esta ocupada: ");

            return false;
        }

        // Cambia el estado de la silla de disponible a ocupada (false a true)
        sillasGenerales[posicionFila][posicionSilla] = true;

        // Convierte la posicion de la fila en una letra para mostrarla
        char letraFila = (char) ('A' + posicionFila);

        // Muestra un mensaje de que la compra fue realizada
        System.out.println("La silla " + letraFila + numeroSilla + "Fue comprada con exito: ");

        return true;
    }

    // Metodo para comprar una silla preferencial
    public boolean comprarSillaPreferencial(int fila, int numeroSilla) {

        // Comprueba si la sala tiene sillas preferenciales
        if (sillasPreferenciales == null) {

            // Muestra un mensaje si se intenta comprar una silla preferencial en la sala 3
            System.out.println("Esta sala no tiene sillas preferenciales");

            return false;

        }

        // Se resta 1 por que las posicones de las matrices comienzan desde 0
        int posicionFila = fila - 1;
        int posicionSilla = numeroSilla - 1;

        // comprueba que la fila se encuentre entre 1 y 2
        if (fila < 1 || fila > 2) {

            // Mensaje por si la fila no existe
            System.out.println("La fila preferencial ingresada no existe: ");

            return false;
        }

        // Comprueba que el numero de la silla se encuentre entre 1 y 9
        if (numeroSilla < 1 || numeroSilla > 9) {

            // Mensaje si la silla no existe
            System.out.println("La silla preferencial ingresada no existe: ");

            return false;
        }

        // Comprueba si la silla seleccionada esta ocupada
        if (sillasPreferenciales[posicionFila][posicionSilla]) {

            // Muestra un mensaje si la silla ya fue comprada
            System.out.println("La silla preferencial ya esta ocupada: ");

            return false;
        }

        // Cambia el estado de la silla de disponible a ocupada
        // false a true
        sillasPreferenciales[posicionFila][posicionSilla] = true;

        // Convierte la poscion de la fila en una letra
        // Fila 1 se convierte en G y la fila 2 en H
        char letraFila = (char) ('G' + posicionFila);

        // Mensaje de que la compra fue realizda correctamente
        System.out.println("La silla " + letraFila + numeroSilla + "fue comprada con exito: ");

        return true;
    }

}