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

            //la sala 3 no tiene sillas preferenciales
            System.out.println("Esta sala no tiene sillas preferenciales: ");

            //Termina el metodo para no intentar recorrer una matriz inexistente
            return;
        }

        //Recorre las 2 filas de la seccion preferencial
        for (int i = 0; i < sillasPreferenciales.length; i++) {

        }

    }
}