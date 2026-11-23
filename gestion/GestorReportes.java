package gestion;

import java.util.Stack;
import modelo.Estudiante;

// Esta clase administra los reportes academicos
// utilizando una pila.
public class GestorReportes {

    // Pila que almacena los reportes academicos.
    // Funciona con el principio LIFO:
    // el ultimo reporte guardado es el primero en salir.
    private Stack<String> pilaReportes;

    // Constructor de la clase.
    public GestorReportes() {

        // Crea la pila inicialmente vacia.
        this.pilaReportes = new Stack<String>();
    }

    // Genera un reporte academico de un estudiante.
    public boolean generarReporteEstudiante(
            Estudiante estudiante,
            int numeroSemestre) {

        // Comprueba que el estudiante recibido exista.
        if (estudiante == null) {
            System.out.println("El estudiante no existe");
            return false;
        }

        // Comprueba que el semestre se encuentre entre 1 y 10.
        if (numeroSemestre < 1 || numeroSemestre > 10) {
            System.out.println(
                    "El semestre debe estar entre 1 y 10"
            );
            return false;
        }

        // Construye el reporte como un texto.
        String reporte =
                "===== REPORTE ACADEMICO =====\n"
                + "Nombre: " + estudiante.getNombre() + "\n"
                + "ID: " + estudiante.getId() + "\n"
                + "Email: " + estudiante.getEmail() + "\n"
                + "Semestre consultado: "
                + numeroSemestre + "\n"
                + "Promedio: "
                + estudiante.calcularPromedioSemestre(
                        numeroSemestre
                )
                + "\n"
                + "Materias en historial: "
                + estudiante.getHistorialMaterias().size();

        // push guarda el reporte en la parte superior de la pila.
        pilaReportes.push(reporte);

        System.out.println("Reporte generado correctamente");
        System.out.println(reporte);

        return true;
    }

    // Consulta el ultimo reporte sin eliminarlo.
    public String consultarUltimoReporte() {

        // Comprueba si la pila esta vacia.
        if (pilaReportes.isEmpty()) {
            return "No existen reportes guardados";
        }

        // peek consulta el ultimo elemento sin eliminarlo.
        return pilaReportes.peek();
    }

    // Retira y devuelve el ultimo reporte generado.
    public String retirarUltimoReporte() {

        // Comprueba si la pila esta vacia.
        if (pilaReportes.isEmpty()) {
            return "No existen reportes guardados";
        }

        // pop devuelve y elimina el ultimo elemento.
        return pilaReportes.pop();
    }

    // Muestra todos los reportes guardados,
    // desde el mas reciente hasta el mas antiguo.
    public void mostrarReportes() {

        // Comprueba si la pila esta vacia.
        if (pilaReportes.isEmpty()) {
            System.out.println(
                    "No existen reportes guardados"
            );
            return;
        }

        System.out.println(
                "===== HISTORIAL DE REPORTES ====="
        );

        // Recorre la pila desde la ultima posicion
        // hasta la primera.
        for (int i = pilaReportes.size() - 1;
                i >= 0;
                i--) {

            System.out.println(pilaReportes.get(i));
            System.out.println("-------------------------------");
        }
    }

    // Retorna la cantidad de reportes guardados.
    public int cantidadReportes() {
        return pilaReportes.size();
    }

    // Elimina todos los reportes guardados.
    public void limpiarReportes() {

        // clear elimina todos los elementos de la pila.
        pilaReportes.clear();

        System.out.println(
                "El historial de reportes fue eliminado"
        );
    }
}