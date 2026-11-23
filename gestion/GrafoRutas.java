package gestion;

// Esta clase administra las rutas de aprendizaje.
// Cada materia funciona como un punto y las conexiones indican
// que es posible avanzar de una materia hacia otra.
public class GrafoRutas {

    // Cantidad maxima de materias que se pueden guardar.
    private int capacidadMaxima;

    // Cantidad de materias registradas actualmente.
    private int cantidadMaterias;

    // Arreglo que almacena los codigos de las materias.
    private String[] codigosMaterias;

    // Matriz que almacena las conexiones entre las materias.
    //
    // Las filas representan las materias de origen.
    // Las columnas representan las materias de destino.
    //
    // 0 significa que no existe una conexion.
    // Un numero mayor que 0 representa el costo de la conexion.
    private int[][] matrizConexiones;

    // Constructor.
    public GrafoRutas(int capacidadMaxima) {

        // Comprueba que la capacidad ingresada sea valida.
        if (capacidadMaxima <= 0) {
            capacidadMaxima = 20;
        }

        this.capacidadMaxima = capacidadMaxima;
        this.cantidadMaterias = 0;

        // Crea el arreglo para guardar los codigos de las materias.
        this.codigosMaterias = new String[capacidadMaxima];

        // Crea una matriz cuadrada para guardar las conexiones.
        this.matrizConexiones =
                new int[capacidadMaxima][capacidadMaxima];
    }

    // Agrega una materia al grafo de rutas.
    public boolean agregarMateria(String codigoMateria) {

        // Comprueba que el codigo no sea null ni este vacio.
        if (codigoMateria == null
                || codigoMateria.isEmpty()) {

            System.out.println(
                    "El codigo de la materia no es valido"
            );

            return false;
        }

        // Comprueba si el arreglo ya se encuentra lleno.
        if (cantidadMaterias >= capacidadMaxima) {

            System.out.println(
                    "No hay espacio para agregar mas materias"
            );

            return false;
        }

        // Comprueba si la materia ya esta registrada.
        if (buscarPosicionMateria(codigoMateria) != -1) {

            System.out.println(
                    "La materia ya existe en las rutas"
            );

            return false;
        }

        // Guarda el codigo en la siguiente posicion disponible.
        codigosMaterias[cantidadMaterias] = codigoMateria;

        // Aumenta la cantidad de materias registradas.
        cantidadMaterias++;

        System.out.println(
                "Materia agregada a las rutas correctamente"
        );

        return true;
    }

    // Busca la posicion de una materia utilizando su codigo.
    private int buscarPosicionMateria(String codigoMateria) {

        // Recorre solamente las posiciones utilizadas.
        for (int i = 0; i < cantidadMaterias; i++) {

            // Compara los codigos sin importar mayusculas o minusculas.
            if (codigosMaterias[i].equalsIgnoreCase(
                    codigoMateria)) {

                // Retorna la posicion donde fue encontrada.
                return i;
            }
        }

        // Retorna -1 cuando la materia no existe.
        return -1;
    }

    // Agrega una conexion desde una materia hacia otra.
    public boolean agregarConexion(
            String codigoOrigen,
            String codigoDestino,
            int costo) {

        // Busca la posicion de la materia de origen.
        int posicionOrigen =
                buscarPosicionMateria(codigoOrigen);

        // Busca la posicion de la materia de destino.
        int posicionDestino =
                buscarPosicionMateria(codigoDestino);

        // Comprueba que la materia de origen exista.
        if (posicionOrigen == -1) {

            System.out.println(
                    "La materia de origen no existe"
            );

            return false;
        }

        // Comprueba que la materia de destino exista.
        if (posicionDestino == -1) {

            System.out.println(
                    "La materia de destino no existe"
            );

            return false;
        }

        // El costo de la conexion debe ser mayor que cero.
        if (costo <= 0) {

            System.out.println(
                    "El costo debe ser mayor que cero"
            );

            return false;
        }

        // Evita conectar una materia consigo misma.
        if (posicionOrigen == posicionDestino) {

            System.out.println(
                    "Una materia no puede conectarse consigo misma"
            );

            return false;
        }

        // Guarda el costo de la conexion en la matriz.
        matrizConexiones[posicionOrigen][posicionDestino] =
                costo;

        System.out.println(
                "Conexion agregada correctamente"
        );

        return true;
    }

    // Elimina una conexion entre dos materias.
    public boolean eliminarConexion(
            String codigoOrigen,
            String codigoDestino) {

        // Busca las posiciones de las materias.
        int posicionOrigen =
                buscarPosicionMateria(codigoOrigen);

        int posicionDestino =
                buscarPosicionMateria(codigoDestino);

        // Comprueba que las dos materias existan.
        if (posicionOrigen == -1
                || posicionDestino == -1) {

            System.out.println(
                    "Una de las materias no existe"
            );

            return false;
        }

        // Comprueba que exista una conexion.
        if (matrizConexiones[posicionOrigen][posicionDestino]
                == 0) {

            System.out.println(
                    "La conexion no existe"
            );

            return false;
        }

        // Guarda cero para indicar que ya no existe la conexion.
        matrizConexiones[posicionOrigen][posicionDestino] = 0;

        System.out.println(
                "Conexion eliminada correctamente"
        );

        return true;
    }

    // Muestra las conexiones guardadas en la matriz.
    public void mostrarMatrizConexiones() {

        // Comprueba que existan materias registradas.
        if (cantidadMaterias == 0) {

            System.out.println(
                    "No existen materias en las rutas"
            );

            return;
        }

        System.out.println(
                "===== MATRIZ DE CONEXIONES ====="
        );

        // Muestra los codigos de las materias en la parte superior.
        System.out.print("        ");

        for (int i = 0; i < cantidadMaterias; i++) {

            System.out.print(
                    codigosMaterias[i] + "\t"
            );
        }

        System.out.println();

        // Recorre las filas de la matriz.
        for (int i = 0; i < cantidadMaterias; i++) {

            // Muestra el codigo correspondiente a la fila.
            System.out.print(
                    codigosMaterias[i] + "\t"
            );

            // Recorre las columnas de la fila.
            for (int j = 0; j < cantidadMaterias; j++) {

                System.out.print(
                        matrizConexiones[i][j] + "\t"
                );
            }

            System.out.println();
        }
    }

    // Calcula la ruta de menor costo entre dos materias.
    public void calcularRutaMasCorta(
            String codigoOrigen,
            String codigoDestino) {

        // Busca las posiciones de las materias.
        int origen =
                buscarPosicionMateria(codigoOrigen);

        int destino =
                buscarPosicionMateria(codigoDestino);

        // Comprueba que las materias existan.
        if (origen == -1 || destino == -1) {

            System.out.println(
                    "Una de las materias no existe"
            );

            return;
        }

        // Guarda la distancia o costo mas corto
        // desde el origen hasta cada materia.
        int[] costos = new int[cantidadMaterias];

        // Indica si una materia ya fue revisada.
        boolean[] revisadas =
                new boolean[cantidadMaterias];

        // Guarda la materia anterior de cada posicion.
        // Permite reconstruir la ruta encontrada.
        int[] anteriores =
                new int[cantidadMaterias];

        // Inicializa los arreglos.
        for (int i = 0; i < cantidadMaterias; i++) {

            // Al principio se utiliza un valor muy grande
            // porque aun no se conoce el costo de la ruta.
            costos[i] = Integer.MAX_VALUE;

            // Ninguna materia ha sido revisada.
            revisadas[i] = false;

            // Inicialmente no existe una materia anterior.
            anteriores[i] = -1;
        }

        // El costo de llegar del origen al mismo origen es cero.
        costos[origen] = 0;

        // Recorre las materias para buscar las rutas.
        for (int i = 0;
                i < cantidadMaterias - 1;
                i++) {

            // Busca la materia no revisada con el menor costo.
            int materiaActual =
                    buscarMateriaMenorCosto(
                            costos,
                            revisadas
                    );

            // Si no quedan materias alcanzables, termina el ciclo.
            if (materiaActual == -1) {
                break;
            }

            // Marca la materia como revisada.
            revisadas[materiaActual] = true;

            // Recorre todas las posibles materias de destino.
            for (int materiaVecina = 0;
                    materiaVecina < cantidadMaterias;
                    materiaVecina++) {

                // Obtiene el costo de la conexion.
                int costoConexion =
                        matrizConexiones[materiaActual]
                                [materiaVecina];

                // Comprueba que exista una conexion,
                // que la materia vecina no este revisada
                // y que la materia actual sea alcanzable.
                if (costoConexion > 0
                        && !revisadas[materiaVecina]
                        && costos[materiaActual]
                        != Integer.MAX_VALUE) {

                    // Calcula el nuevo costo posible.
                    int nuevoCosto =
                            costos[materiaActual]
                            + costoConexion;

                    // Comprueba si la nueva ruta tiene menor costo.
                    if (nuevoCosto
                            < costos[materiaVecina]) {

                        // Actualiza el costo de la materia vecina.
                        costos[materiaVecina] =
                                nuevoCosto;

                        // Guarda desde que materia se llego.
                        anteriores[materiaVecina] =
                                materiaActual;
                    }
                }
            }
        }

        // Comprueba si no fue posible llegar al destino.
        if (costos[destino] == Integer.MAX_VALUE) {

            System.out.println(
                    "No existe una ruta entre las materias"
            );

            return;
        }

        // Muestra el costo total de la mejor ruta.
        System.out.println(
                "Costo total de la ruta: "
                + costos[destino]
        );

        // Reconstruye y muestra la ruta encontrada.
        mostrarRuta(
                anteriores,
                origen,
                destino
        );
    }

    // Busca la materia no revisada con el menor costo.
    private int buscarMateriaMenorCosto(
            int[] costos,
            boolean[] revisadas) {

        // Inicialmente se utiliza el valor entero mas grande.
        int menorCosto = Integer.MAX_VALUE;

        // -1 significa que todavia no se encontro una posicion.
        int posicionMenor = -1;

        // Recorre todas las materias registradas.
        for (int i = 0; i < cantidadMaterias; i++) {

            // Comprueba que la materia no este revisada
            // y que su costo sea menor.
            if (!revisadas[i]
                    && costos[i] < menorCosto) {

                menorCosto = costos[i];
                posicionMenor = i;
            }
        }

        return posicionMenor;
    }

    // Reconstruye y muestra la ruta encontrada.
    private void mostrarRuta(
            int[] anteriores,
            int origen,
            int destino) {

        // Arreglo temporal para guardar las posiciones
        // de las materias de la ruta.
        int[] ruta = new int[cantidadMaterias];

        // Guarda la cantidad de materias de la ruta.
        int cantidadMateriasRuta = 0;

        // Comienza desde la materia de destino.
        int actual = destino;

        // Retrocede desde el destino utilizando
        // las posiciones anteriores.
        while (actual != -1) {

            ruta[cantidadMateriasRuta] = actual;

            cantidadMateriasRuta++;

            actual = anteriores[actual];
        }

        // Comprueba que la ruta encontrada llegue al origen.
        if (ruta[cantidadMateriasRuta - 1] != origen) {

            System.out.println(
                    "No fue posible construir la ruta"
            );

            return;
        }

        System.out.print("Ruta de aprendizaje: ");

        // Recorre la ruta en sentido contrario:
        // desde el origen hasta el destino.
        for (int i = cantidadMateriasRuta - 1;
                i >= 0;
                i--) {

            System.out.print(
                    codigosMaterias[ruta[i]]
            );

            // Agrega una flecha entre las materias.
            if (i > 0) {
                System.out.print(" -> ");
            }
        }

        System.out.println();
    }

    // Retorna la cantidad de materias registradas.
    public int getCantidadMaterias() {
        return cantidadMaterias;
    }

    public static void main(String[] args) {
        
    }
}