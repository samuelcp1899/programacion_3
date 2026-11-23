package principal;

import java.util.Scanner;

import gestion.GestorEstudiantes;
import gestion.GestorMaterias;
import gestion.GestorReportes;
import gestion.GrafoRutas;

import modelo.Estudiante;
import modelo.Horario;

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
        // Comienza en 0 para poder entrar al ciclo.
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

                    // Comprueba que el semestre ingresado sea numerico.
                    if (!teclado.hasNextInt()) {

                        System.out.println(
                                "El semestre debe ser un numero"
                        );

                        // Elimina el dato incorrecto.
                        teclado.nextLine();

                        // Termina este caso y regresa al menu.
                        break;
                    }

                    // Guarda el semestre ingresado.
                    int semestre = teclado.nextInt();

                    // Limpia el salto de linea.
                    teclado.nextLine();

                    // Comprueba que el semestre se encuentre
                    // dentro del rango permitido.
                    if (semestre < 1 || semestre > 10) {

                        System.out.println(
                                "El semestre debe estar entre 1 y 10"
                        );

                        break;
                    }

                    // Crea un objeto de la clase Estudiante.
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

                    // Esta opcion se completara en el siguiente bloque.
                    System.out.println(
                            "Busqueda de estudiante pendiente"
                    );

                    break;

                case 4:

                    // Esta opcion se completara en el siguiente bloque.
                    System.out.println(
                            "Eliminacion de estudiante pendiente"
                    );

                    break;

                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:

                    // Estas opciones se implementaran poco a poco.
                    System.out.println(
                            "Esta opcion se implementara "
                            + "en el siguiente bloque"
                    );

                    break;

                case 18:

                    // Finaliza el programa.
                    System.out.println(
                            "Programa finalizado correctamente"
                    );

                    break;

                default:

                    // Se ejecuta si la opcion no existe.
                    System.out.println(
                            "La opcion seleccionada no existe"
                    );

                    break;
            }
        }

        // Cierra el Scanner cuando finaliza el programa.
        teclado.close();
    }
}