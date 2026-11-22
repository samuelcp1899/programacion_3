package gestion;

import java.util.HashMap;
import modelo.Estudiante;

// Esta clase se encarga de administrar los estudiantes del sistema.
public class GestorEstudiantes {

    // HashMap que almacena los estudiantes.
    // La llave es el ID y el valor es el objeto Estudiante.
    private HashMap<String, Estudiante> estudiantes;

    // Constructor.
    public GestorEstudiantes() {

        // Crea el HashMap inicialmente vacio.
        estudiantes = new HashMap<String, Estudiante>();
    }

    // Metodo para registrar un estudiante.
    public boolean registrarEstudiante(Estudiante estudiante) {

        // Comprueba que el estudiante recibido no sea null.
        if (estudiante == null) {
            System.out.println("El estudiante no existe");
            return false;
        }

        // Comprueba si ya existe un estudiante con el mismo ID.
        if (estudiantes.containsKey(estudiante.getId())) {
            System.out.println("Ya existe un estudiante con ese ID");
            return false;
        }

        // Guarda el estudiante usando su ID como llave.
        estudiantes.put(estudiante.getId(), estudiante);

        System.out.println("Estudiante registrado correctamente");
        return true;
    }

    // Metodo para buscar un estudiante por su ID.
    public Estudiante buscarEstudiante(String id) {

        // Busca el ID y retorna el estudiante asociado.
        // Si el ID no existe, HashMap retorna null.
        return estudiantes.get(id);
    }

    // Metodo para eliminar un estudiante por su ID.
    public boolean eliminarEstudiante(String id) {

        // Comprueba si el estudiante existe.
        if (!estudiantes.containsKey(id)) {
            System.out.println("No existe un estudiante con ese ID");
            return false;
        }

        // Elimina el estudiante asociado con el ID.
        estudiantes.remove(id);

        System.out.println("Estudiante eliminado correctamente");
        return true;
    }

    // Metodo para mostrar todos los estudiantes registrados.
    public void mostrarEstudiantes() {

        // Comprueba si no existen estudiantes registrados.
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados");
            return;
        }

        System.out.println("===== ESTUDIANTES REGISTRADOS =====");

        // Recorre todos los estudiantes almacenados en el HashMap.
        for (Estudiante estudiante : estudiantes.values()) {

            // mostrarInformacion retorna un String.
            System.out.println(estudiante.mostrarInformacion());

            System.out.println("-----------------------------------");
        }
    }

    // Metodo para consultar la cantidad de estudiantes registrados.
    public int cantidadEstudiantes() {
        return estudiantes.size();
    }
}