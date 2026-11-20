package modelo;

import java.util.LinkedList;
import java.util.Queue;

// Representa una materia del sistema academico.
public class Materia {

    // Codigo unico de la materia.
    private String codigo;

    // Nombre de la materia.
    private String nombre;

    // Cantidad maxima de estudiantes.
    private int cupoMaximo;

    // Cantidad actual de estudiantes inscritos.
    private int cantidadInscritos;

    // Lista enlazada con los codigos de los prerrequisitos.
    private LinkedList<String> prerrequisitos;

    // Cola FIFO para estudiantes que esperan un cupo.
    private Queue<Estudiante> colaEspera;

    // Constructor.
    public Materia(
            String codigo,
            String nombre,
            int cupoMaximo) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.cupoMaximo = cupoMaximo;
        this.cantidadInscritos = 0;

        // Inicializa la lista de prerrequisitos.
        this.prerrequisitos = new LinkedList<String>();

        // Inicializa la cola de espera.
        this.colaEspera = new LinkedList<Estudiante>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public int getCantidadInscritos() {
        return cantidadInscritos;
    }

    public LinkedList<String> getPrerrequisitos() {
        return prerrequisitos;
    }

    // Agrega un prerrequisito.
    public boolean agregarPrerrequisito(String codigoMateria) {

        if (codigoMateria == null || codigoMateria.isEmpty()) {
            System.out.println(
                    "El codigo del prerrequisito no es valido"
            );
            return false;
        }

        if (prerrequisitos.contains(codigoMateria)) {
            System.out.println(
                    "El prerrequisito ya fue agregado"
            );
            return false;
        }

        if (codigo.equalsIgnoreCase(codigoMateria)) {
            System.out.println(
                    "Una materia no puede ser prerrequisito de si misma"
            );
            return false;
        }

        prerrequisitos.add(codigoMateria);

        System.out.println(
                "Prerrequisito agregado correctamente"
        );

        return true;
    }

    // Elimina un prerrequisito.
    public boolean eliminarPrerrequisito(String codigoMateria) {

        boolean eliminado =
                prerrequisitos.remove(codigoMateria);

        if (eliminado) {
            System.out.println(
                    "Prerrequisito eliminado correctamente"
            );
            return true;
        }

        System.out.println(
                "El prerrequisito no estaba registrado"
        );

        return false;
    }

    // Comprueba si existe un cupo.
    public boolean tieneCupoDisponible() {
        return cantidadInscritos < cupoMaximo;
    }

    // Agrega un estudiante al final de la cola.
    public boolean agregarAColaEspera(
            Estudiante estudiante) {

        if (estudiante == null) {
            System.out.println("El estudiante no existe");
            return false;
        }

        if (colaEspera.contains(estudiante)) {
            System.out.println(
                    "El estudiante ya se encuentra en la cola"
            );
            return false;
        }

        colaEspera.offer(estudiante);

        System.out.println(
                "Estudiante agregado a la cola de espera"
        );

        return true;
    }

    // Consulta al primero sin retirarlo.
    public Estudiante consultarPrimeroCola() {
        return colaEspera.peek();
    }

    // Retira al primero de la cola.
    public Estudiante retirarPrimeroCola() {
        return colaEspera.poll();
    }

    // Muestra la cola de espera.
    public void mostrarColaEspera() {

        if (colaEspera.isEmpty()) {
            System.out.println(
                    "La cola de espera esta vacia"
            );
            return;
        }

        System.out.println("===== COLA DE ESPERA =====");

        int posicion = 1;

        for (Estudiante estudiante : colaEspera) {

            System.out.println(
                    posicion + ". "
                    + estudiante.getNombre()
                    + " - ID: " + estudiante.getId()
            );

            posicion++;
        }
    }

    // Retorna la cantidad de estudiantes esperando.
    public int cantidadEnEspera() {
        return colaEspera.size();
    }

    // Inscribe o agrega a la cola si no hay cupo.
    public boolean solicitarInscripcion(
            Estudiante estudiante) {

        if (estudiante == null) {
            System.out.println("El estudiante no existe");
            return false;
        }

        if (tieneCupoDisponible()) {

            cantidadInscritos++;

            System.out.println(
                    "El estudiante fue inscrito correctamente"
            );

            return true;
        }

        agregarAColaEspera(estudiante);

        System.out.println(
                "No habia cupo. El estudiante quedo en espera"
        );

        return false;
    }

    // Cancela una inscripcion y usa la cola.
    public boolean cancelarInscripcion() {

        if (cantidadInscritos == 0) {
            System.out.println(
                    "La materia no tiene estudiantes inscritos"
            );
            return false;
        }

        cantidadInscritos--;

        System.out.println(
                "Inscripcion cancelada correctamente"
        );

        if (!colaEspera.isEmpty()) {

            Estudiante siguienteEstudiante =
                    colaEspera.poll();

            cantidadInscritos++;

            System.out.println(
                    "El cupo fue asignado a: "
                    + siguienteEstudiante.getNombre()
            );
        }

        return true;
    }

    // Muestra la informacion de la materia.
    public void mostrarInformacion() {

        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println(
                "Cupo maximo: " + cupoMaximo
        );
        System.out.println(
                "Cantidad de inscritos: "
                + cantidadInscritos
        );
        System.out.println(
                "Estudiantes en espera: "
                + colaEspera.size()
        );

        if (prerrequisitos.isEmpty()) {
            System.out.println(
                    "Prerrequisitos: Ninguno"
            );
        } else {
            System.out.println(
                    "Prerrequisitos: " + prerrequisitos
            );
        }
    }
}