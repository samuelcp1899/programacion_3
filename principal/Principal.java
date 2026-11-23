package principal;

import java.util.Scanner;

import excepciones.DatoInvalido;
import excepciones.EstudianteNoEncontrado;
import excepciones.MateriaNoEncontrada;

import gestion.GestorEstudiantes;
import gestion.GestorMaterias;
import gestion.GestorReportes;
import gestion.GrafoRutas;

import modelo.Estudiante;
import modelo.Horario;
import modelo.Materia;

// Clase principal que inicia y controla el sistema academico.
public class Principal {

    // Metodo principal donde comienza la ejecucion del programa.
    public static void main(String[] args) {

        // Scanner permite recibir los datos ingresados por el usuario.
        Scanner teclado = new Scanner(System.in);

        // Gestor encargado de administrar los estudiantes
        // utilizando un HashMap.
        GestorEstudiantes gestorEstudiantes =
                new GestorEstudiantes();

        // Gestor encargado de administrar las materias
        // utilizando un TreeMap.
        GestorMaterias gestorMaterias =
                new GestorMaterias();

        // Gestor encargado de almacenar los reportes
        // utilizando una pila.
        GestorReportes gestorReportes =
                new GestorReportes();

        // Grafo con capacidad maxima para 20 materias.
        GrafoRutas grafoRutas =
                new GrafoRutas(20);

        // Horario semanal de 7 dias y 24 horas.
        Horario horario = new Horario();

        // Guarda la opcion elegida por el usuario.
        int opcion = 0;

        // Mantiene el programa funcionando
        // mientras el usuario no seleccione la opcion 18.
        while (opcion != 18) {

            // Muestra las opciones principales del sistema.
            System.out.println("\n===== SISTEMA ACADEMICO =====");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Buscar estudiante");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Registrar materia");
            System.out.println("6. Mostrar materias");
            System.out.println("7. Agregar prerrequisito");
            System.out.println("8. Solicitar inscripcion");
            System.out.println("9. Mostrar cola de espera");
            System.out.println("10. Registrar nota");
            System.out.println("11. Mostrar notas");
            System.out.println("12. Generar reporte");
            System.out.println("13. Consultar ultimo reporte");
            System.out.println("14. Reservar horario");
            System.out.println("15. Mostrar horarios ocupados");
            System.out.println("16. Administrar rutas");
            System.out.println("17. Mostrar matriz de conexiones");
            System.out.println("18. Salir");
            System.out.print("Seleccione una opcion: ");

            // Verifica que el usuario haya ingresado un numero entero.
            if (teclado.hasNextInt()) {

                // Guarda la opcion ingresada.
                opcion = teclado.nextInt();

                // Limpia el salto de linea que queda despues de nextInt().
                teclado.nextLine();

            } else {

                // Se ejecuta si el usuario escribe texto
                // cuando el programa espera un numero.
                System.out.println(
                        "Debe ingresar una opcion numerica"
                );

                // Elimina el dato incorrecto del Scanner.
                teclado.nextLine();

                // Regresa al inicio del ciclo.
                continue;
            }

            // Comprueba cual opcion selecciono el usuario.
            switch (opcion) {

                case 1:

                    // Solicita los datos para crear un estudiante.
                    System.out.println(
                            "\n===== REGISTRAR ESTUDIANTE ====="
                    );

                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.print("ID: ");
                    String id = teclado.nextLine();

                    System.out.print("Email: ");
                    String email = teclado.nextLine();

                    System.out.print("Semestre actual: ");

                    // Comprueba que el semestre sea numerico.
                    if (!teclado.hasNextInt()) {

                        System.out.println(
                                "El semestre debe ser un numero"
                        );

                        teclado.nextLine();
                        break;
                    }

                    int semestre = teclado.nextInt();
                    teclado.nextLine();

                    // Comprueba que el semestre sea valido.
                    if (semestre < 1 || semestre > 10) {

                        System.out.println(
                                "El semestre debe estar entre 1 y 10"
                        );

                        break;
                    }

                    // Crea un objeto Estudiante.
                    Estudiante nuevoEstudiante =
                            new Estudiante(
                                    nombre,
                                    id,
                                    email,
                                    semestre
                            );

                    // Registra el estudiante en el HashMap.
                    gestorEstudiantes.registrarEstudiante(
                            nuevoEstudiante
                    );

                    break;

                case 2:

                    // Muestra todos los estudiantes registrados.
                    gestorEstudiantes.mostrarEstudiantes();

                    break;

                case 3:

                    // Busca un estudiante mediante su ID.
                    System.out.println(
                            "\n===== BUSCAR ESTUDIANTE ====="
                    );

                    System.out.print(
                            "Ingrese el ID del estudiante: "
                    );

                    String idBuscar = teclado.nextLine();

                    try {

                        // Busca el estudiante en el HashMap.
                        Estudiante estudianteEncontrado =
                                gestorEstudiantes
                                        .buscarEstudiante(
                                                idBuscar
                                        );

                        // Muestra la informacion del estudiante.
                        System.out.println(
                                estudianteEncontrado
                                        .mostrarInformacion()
                        );

                    } catch (EstudianteNoEncontrado error) {

                        // Captura el error si el ID no existe.
                        System.out.println(
                                "Error: " + error.getMessage()
                        );
                    }

                    break;

                case 4:

                    // Elimina un estudiante mediante su ID.
                    System.out.println(
                            "\n===== ELIMINAR ESTUDIANTE ====="
                    );

                    System.out.print(
                            "Ingrese el ID del estudiante: "
                    );

                    String idEliminar = teclado.nextLine();

                    try {

                        // Intenta eliminar al estudiante.
                        gestorEstudiantes.eliminarEstudiante(
                                idEliminar
                        );

                    } catch (EstudianteNoEncontrado error) {

                        // Captura el error si el ID no existe.
                        System.out.println(
                                "Error: " + error.getMessage()
                        );
                    }

                    break;

                case 5:

                    // Solicita los datos necesarios
                    // para registrar una materia.
                    System.out.println(
                            "\n===== REGISTRAR MATERIA ====="
                    );

                    System.out.print(
                            "Codigo de la materia: "
                    );

                    String codigoMateria =
                            teclado.nextLine();

                    System.out.print(
                            "Nombre de la materia: "
                    );

                    String nombreMateria =
                            teclado.nextLine();

                    System.out.print("Cupo maximo: ");

                    // Comprueba que el cupo sea numerico.
                    if (!teclado.hasNextInt()) {

                        System.out.println(
                                "El cupo maximo debe ser un numero"
                        );

                        teclado.nextLine();
                        break;
                    }

                    int cupoMaximo =
                            teclado.nextInt();

                    teclado.nextLine();

                    // Comprueba que el cupo sea valido.
                    if (cupoMaximo <= 0) {

                        System.out.println(
                                "El cupo maximo debe ser mayor que cero"
                        );

                        break;
                    }

                    // Crea el objeto Materia.
                    Materia nuevaMateria =
                            new Materia(
                                    codigoMateria,
                                    nombreMateria,
                                    cupoMaximo
                            );

                    // Registra la materia en el TreeMap.
                    boolean materiaRegistrada =
                            gestorMaterias.registrarMateria(
                                    nuevaMateria
                            );

                    // Agrega la materia al grafo solamente
                    // si fue registrada correctamente.
                    if (materiaRegistrada) {

                        grafoRutas.agregarMateria(
                                codigoMateria
                        );
                    }

                    break;

                case 6:

                    // Muestra las materias ordenadas por codigo.
                    gestorMaterias.mostrarMaterias();

                    break;

                case 7:

                    // Agrega una materia como prerrequisito de otra.
                    System.out.println(
                            "\n===== AGREGAR PRERREQUISITO ====="
                    );

                    System.out.print(
                            "Codigo de la materia principal: "
                    );

                    String codigoPrincipal =
                            teclado.nextLine();

                    System.out.print(
                            "Codigo de la materia prerrequisito: "
                    );

                    String codigoPrerrequisito =
                            teclado.nextLine();

                    try {

                        // Comprueba que ambas materias existan
                        // y registra el prerrequisito.
                        gestorMaterias.agregarPrerrequisito(
                                codigoPrincipal,
                                codigoPrerrequisito
                        );

                    } catch (MateriaNoEncontrada error) {

                        System.out.println(
                                "Error: " + error.getMessage()
                        );
                    }

                    break;

                case 8:

                    // Solicita la inscripcion de un estudiante.
                    System.out.println(
                            "\n===== SOLICITAR INSCRIPCION ====="
                    );

                    System.out.print(
                            "ID del estudiante: "
                    );

                    String idInscripcion =
                            teclado.nextLine();

                    System.out.print(
                            "Codigo de la materia: "
                    );

                    String codigoInscripcion =
                            teclado.nextLine();

                    try {

                        // Busca al estudiante en el HashMap.
                        Estudiante estudianteInscripcion =
                                gestorEstudiantes
                                        .buscarEstudiante(
                                                idInscripcion
                                        );

                        // Busca la materia en el TreeMap.
                        Materia materiaInscripcion =
                                gestorMaterias
                                        .buscarMateria(
                                                codigoInscripcion
                                        );

                        // Indica si el estudiante cumple
                        // todos los prerrequisitos.
                        boolean cumplePrerrequisitos = true;

                        // Recorre los prerrequisitos de la materia.
                        for (String codigoRequisito :
                                materiaInscripcion
                                        .getPrerrequisitos()) {

                            // Comprueba si el historial contiene
                            // el codigo del prerrequisito.
                            if (!estudianteInscripcion
                                    .getHistorialMaterias()
                                    .contains(codigoRequisito)) {

                                System.out.println(
                                        "Falta aprobar el prerrequisito: "
                                        + codigoRequisito
                                );

                                cumplePrerrequisitos = false;
                            }
                        }

                        // Impide la inscripcion si falta
                        // algun prerrequisito.
                        if (!cumplePrerrequisitos) {

                            System.out.println(
                                    "El estudiante no cumple "
                                    + "todos los prerrequisitos"
                            );

                            break;
                        }

                        // Si hay cupo, inscribe al estudiante.
                        // Si no hay cupo, lo agrega a la cola.
                        materiaInscripcion.solicitarInscripcion(
                                estudianteInscripcion
                        );

                    } catch (EstudianteNoEncontrado error) {

                        System.out.println(
                                "Error: " + error.getMessage()
                        );

                    } catch (MateriaNoEncontrada error) {

                        System.out.println(
                                "Error: " + error.getMessage()
                        );
                    }

                    break;

                case 9:

                    // Muestra la cola de espera de una materia.
                    System.out.println(
                            "\n===== COLA DE ESPERA ====="
                    );

                    System.out.print(
                            "Codigo de la materia: "
                    );

                    String codigoCola =
                            teclado.nextLine();

                    try {

                        // Busca la materia.
                        Materia materiaCola =
                                gestorMaterias
                                        .buscarMateria(
                                                codigoCola
                                        );

                        // Muestra la cola en orden FIFO.
                        materiaCola.mostrarColaEspera();

                    } catch (MateriaNoEncontrada error) {

                        System.out.println(
                                "Error: " + error.getMessage()
                        );
                    }

                    break;

                case 10:

                    // Registra una nota en la matriz
                    // de un estudiante.
                    System.out.println(
                            "\n===== REGISTRAR NOTA ====="
                    );

                    System.out.print(
                            "ID del estudiante: "
                    );

                    String idNota = teclado.nextLine();

                    try {

                        // Busca al estudiante.
                        Estudiante estudianteNota =
                                gestorEstudiantes
                                        .buscarEstudiante(
                                                idNota
                                        );

                        System.out.print(
                                "Numero del semestre: "
                        );

                        if (!teclado.hasNextInt()) {

                            System.out.println(
                                    "El semestre debe ser un numero"
                            );

                            teclado.nextLine();
                            break;
                        }

                        int semestreNota =
                                teclado.nextInt();

                        System.out.print(
                                "Numero de la materia (1 a 20): "
                        );

                        if (!teclado.hasNextInt()) {

                            System.out.println(
                                    "La materia debe ser un numero"
                            );

                            teclado.nextLine();
                            break;
                        }

                        int numeroMateria =
                                teclado.nextInt();

                        System.out.print(
                                "Nota (0.0 a 5.0): "
                        );

                        if (!teclado.hasNextDouble()) {

                            System.out.println(
                                    "La nota debe ser numerica"
                            );

                            teclado.nextLine();
                            break;
                        }

                        double nota =
                                teclado.nextDouble();

                        teclado.nextLine();

                        // Registra la nota en la matriz.
                        estudianteNota.registrarNota(
                                semestreNota,
                                numeroMateria,
                                nota
                        );

                    } catch (EstudianteNoEncontrado error) {

                        System.out.println(
                                "Error: " + error.getMessage()
                        );

                    } catch (DatoInvalido error) {

                        System.out.println(
                                "Error: " + error.getMessage()
                        );
                    }

                    break;

                case 11:

                    // Muestra las notas y el promedio
                    // de un estudiante.
                    System.out.println(
                            "\n===== MOSTRAR NOTAS ====="
                    );

                    System.out.print(
                            "ID del estudiante: "
                    );

                    String idMostrarNotas =
                            teclado.nextLine();

                    try {

                        // Busca al estudiante.
                        Estudiante estudianteMostrarNotas =
                                gestorEstudiantes
                                        .buscarEstudiante(
                                                idMostrarNotas
                                        );

                        System.out.print(
                                "Semestre que desea consultar: "
                        );

                        if (!teclado.hasNextInt()) {

                            System.out.println(
                                    "El semestre debe ser un numero"
                            );

                            teclado.nextLine();
                            break;
                        }

                        int semestreMostrar =
                                teclado.nextInt();

                        teclado.nextLine();

                        // Muestra las notas registradas.
                        estudianteMostrarNotas
                                .mostrarNotasSemestre(
                                        semestreMostrar
                                );

                        // Calcula el promedio.
                        double promedio =
                                estudianteMostrarNotas
                                        .calcularPromedioSemestre(
                                                semestreMostrar
                                        );

                        System.out.println(
                                "Promedio del semestre: "
                                + promedio
                        );

                    } catch (EstudianteNoEncontrado error) {

                        System.out.println(
                                "Error: " + error.getMessage()
                        );
                    }

                    break;

                case 12:

                    // Genera un reporte academico
                    // y lo guarda en la pila.
                    System.out.println(
                            "\n===== GENERAR REPORTE ====="
                    );

                    System.out.print(
                            "ID del estudiante: "
                    );

                    String idReporte =
                            teclado.nextLine();

                    try {

                        // Busca al estudiante.
                        Estudiante estudianteReporte =
                                gestorEstudiantes
                                        .buscarEstudiante(
                                                idReporte
                                        );

                        System.out.print(
                                "Semestre del reporte: "
                        );

                        if (!teclado.hasNextInt()) {

                            System.out.println(
                                    "El semestre debe ser un numero"
                            );

                            teclado.nextLine();
                            break;
                        }

                        int semestreReporte =
                                teclado.nextInt();

                        teclado.nextLine();

                        // Genera el reporte y lo guarda
                        // en la pila mediante push.
                        gestorReportes
                                .generarReporteEstudiante(
                                        estudianteReporte,
                                        semestreReporte
                                );

                    } catch (EstudianteNoEncontrado error) {

                        System.out.println(
                                "Error: " + error.getMessage()
                        );
                    }

                    break;

                case 13:

                    // Consulta el reporte que se encuentra
                    // en la parte superior de la pila.
                    System.out.println(
                            "\n===== ULTIMO REPORTE ====="
                    );

                    // Este metodo utiliza peek,
                    // por eso no elimina el reporte.
                    System.out.println(
                            gestorReportes
                                    .consultarUltimoReporte()
                    );

                    break;

                case 14:

                    // Permite reservar una hora
                    // dentro del horario semanal.
                    System.out.println(
                            "\n===== RESERVAR HORARIO ====="
                    );

                    System.out.println("1. Lunes");
                    System.out.println("2. Martes");
                    System.out.println("3. Miercoles");
                    System.out.println("4. Jueves");
                    System.out.println("5. Viernes");
                    System.out.println("6. Sabado");
                    System.out.println("7. Domingo");

                    System.out.print(
                            "Seleccione el dia: "
                    );

                    if (!teclado.hasNextInt()) {

                        System.out.println(
                                "El dia debe ser un numero"
                        );

                        teclado.nextLine();
                        break;
                    }

                    int diaHorario =
                            teclado.nextInt();

                    System.out.print(
                            "Ingrese la hora entre 0 y 23: "
                    );

                    if (!teclado.hasNextInt()) {

                        System.out.println(
                                "La hora debe ser un numero"
                        );

                        teclado.nextLine();
                        break;
                    }

                    int horaHorario =
                            teclado.nextInt();

                    teclado.nextLine();

                    // Reserva la posicion de la matriz.
                    horario.reservarHorario(
                            diaHorario,
                            horaHorario
                    );

                    break;

                case 15:

                    // Muestra todas las horas ocupadas
                    // en la matriz semanal.
                    System.out.println(
                            "\n===== HORARIOS RESERVADOS ====="
                    );

                    horario.mostrarHorariosOcupados();

                    break;

                case 16:

                    // Permite agregar conexiones
                    // o calcular una ruta.
                    System.out.println(
                            "\n===== ADMINISTRAR RUTAS ====="
                    );

                    System.out.println(
                            "1. Agregar conexion"
                    );

                    System.out.println(
                            "2. Calcular ruta mas corta"
                    );

                    System.out.print(
                            "Seleccione una opcion: "
                    );

                    if (!teclado.hasNextInt()) {

                        System.out.println(
                                "Debe seleccionar "
                                + "una opcion numerica"
                        );

                        teclado.nextLine();
                        break;
                    }

                    int opcionRuta =
                            teclado.nextInt();

                    teclado.nextLine();

                    // Agrega una conexion.
                    if (opcionRuta == 1) {

                        System.out.print(
                                "Codigo de la materia de origen: "
                        );

                        String origenConexion =
                                teclado.nextLine();

                        System.out.print(
                                "Codigo de la materia de destino: "
                        );

                        String destinoConexion =
                                teclado.nextLine();

                        System.out.print(
                                "Costo de la conexion: "
                        );

                        if (!teclado.hasNextInt()) {

                            System.out.println(
                                    "El costo debe ser un numero"
                            );

                            teclado.nextLine();
                            break;
                        }

                        int costoConexion =
                                teclado.nextInt();

                        teclado.nextLine();

                        // Guarda el costo en la matriz.
                        grafoRutas.agregarConexion(
                                origenConexion,
                                destinoConexion,
                                costoConexion
                        );

                    } else if (opcionRuta == 2) {

                        // Solicita la materia de origen.
                        System.out.print(
                                "Codigo de la materia de origen: "
                        );

                        String origenRuta =
                                teclado.nextLine();

                        // Solicita la materia de destino.
                        System.out.print(
                                "Codigo de la materia de destino: "
                        );

                        String destinoRuta =
                                teclado.nextLine();

                        // Calcula la ruta de menor costo
                        // utilizando Dijkstra.
                        grafoRutas.calcularRutaMasCorta(
                                origenRuta,
                                destinoRuta
                        );

                    } else {

                        System.out.println(
                                "La opcion de rutas no existe"
                        );
                    }

                    break;

                case 17:

                    // Muestra la matriz con las conexiones
                    // registradas entre las materias.
                    grafoRutas.mostrarMatrizConexiones();

                    break;

                case 18:

                    // Finaliza el programa.
                    System.out.println(
                            "Programa finalizado correctamente"
                    );

                    break;

                default:

                    // Se ejecuta si la opcion
                    // no se encuentra entre 1 y 18.
                    System.out.println(
                            "La opcion seleccionada no existe"
                    );

                    break;
            }
        }

        // Cierra el Scanner cuando termina el programa.
        teclado.close();
    }
}