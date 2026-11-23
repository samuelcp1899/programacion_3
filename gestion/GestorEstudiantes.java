package gestion;

import java.util.HashMap;
import excepciones.EstudianteNoEncontrado;
import modelo.Estudiante;

// Esta clase se encarga de administrar los estudiantes del sistema.
public class GestorEstudiantes {

    // HashMap que almacena los estudiantes.
    // La llave es el ID y el valor es el objeto Estudiante.
    private HashMap<String, Estudiante> estudiantes;

    // Constructor de la clase.
    public GestorEstudiantes() {

        // Crea el HashMap inicialmente vacio.
        this.estudiantes = new HashMap<String, Estudiante>();
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

        // Guarda el estudiante utilizando su ID como llave.
        estudiantes.put(estudiante.getId(), estudiante);

        System.out.println("Estudiante registrado correctamente");

        return true;
    }

    // Metodo para buscar un estudiante mediante su ID.
    // Si el estudiante no existe, lanza una excepcion personalizada.
    public Estudiante buscarEstudiante(String id)
            throws EstudianteNoEncontrado {

        // Busca el estudiante dentro del HashMap.
        Estudiante estudiante = estudiantes.get(id);

        // Si get retorna null, el estudiante no esta registrado.
        if (estudiante == null) {

            // Lanza la excepcion personalizada.
            throw new EstudianteNoEncontrado(
                    "No existe un estudiante con el ID: " + id
            );
        }

        // Devuelve el estudiante encontrado.
        return estudiante;
    }

    // Metodo para eliminar un estudiante mediante su ID.
    public boolean eliminarEstudiante(String id)
            throws EstudianteNoEncontrado {

        // Comprueba si el ID no se encuentra registrado.
        if (!estudiantes.containsKey(id)) {

            // Lanza la excepcion personalizada.
            throw new EstudianteNoEncontrado(
                    "No existe un estudiante con el ID: " + id
            );
        }

        // Elimina el estudiante asociado con el ID.
        estudiantes.remove(id);

        System.out.println("Estudiante eliminado correctamente");

        return true;
    }

    // Metodo para mostrar todos los estudiantes registrados.
    public void mostrarEstudiantes() {

        // Comprueba si el HashMap no tiene estudiantes.
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados");
            return;
        }

        System.out.println("===== ESTUDIANTES REGISTRADOS =====");

        // Recorre todos los estudiantes almacenados en el HashMap.
        for (Estudiante estudiante : estudiantes.values()) {

            // mostrarInformacion devuelve un String,
            // por eso se imprime utilizando System.out.println.
            System.out.println(estudiante.mostrarInformacion());

            System.out.println("-----------------------------------");
        }
    }

    // Metodo para consultar la cantidad de estudiantes registrados.
    public int cantidadEstudiantes() {

        // size retorna la cantidad de elementos del HashMap.
        return estudiantes.size();
    }

    // Comprueba si existe un estudiante con un ID determinado.
    public boolean existeEstudiante(String id) {

        // containsKey comprueba si el ID existe como llave.
        return estudiantes.containsKey(id);
    }

    // Permite consultar el HashMap completo.
    public HashMap<String, Estudiante> getEstudiantes() {
        return estudiantes;
    }
}