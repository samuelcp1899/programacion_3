package modelo;

import java.util.LinkedList;
import excepciones.DatoInvalido;

// Estudiante hereda los atributos y metodos de Persona.
public class Estudiante extends Persona {

    // Semestre actual del estudiante.
    private int semestre;

    // Matriz de notas:
    // 10 filas para los semestres y 20 columnas para las materias.
    // Se utiliza Double para que las notas no registradas sean null.
    private Double[][] notas;

    // Lista enlazada para guardar el historial de materias cursadas.
    private LinkedList<String> historialMaterias;

    // Constructor de la clase Estudiante.
    public Estudiante(
            String nombre,
            String id,
            String email,
            int semestre) {

        // Llama al constructor de la clase padre Persona.
        super(nombre, id, email);

        this.semestre = semestre;

        // Crea la matriz con 10 semestres y 20 materias.
        // Todas las posiciones comienzan en null.
        this.notas = new Double[10][20];

        // Crea la lista enlazada inicialmente vacia.
        this.historialMaterias = new LinkedList<String>();
    }

    // Permite consultar el semestre actual.
    public int getSemestre() {
        return semestre;
    }

    // Permite cambiar el semestre actual.
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    // Permite consultar la matriz completa de notas.
    public Double[][] getNotas() {
        return notas;
    }

    // Permite consultar el historial de materias cursadas.
    public LinkedList<String> getHistorialMaterias() {
        return historialMaterias;
    }

    // Agrega el codigo de una materia al historial.
    public void agregarAlHistorial(String codigoMateria) {
        historialMaterias.add(codigoMateria);
    }

    // Registra una nota en un semestre y una materia determinados.
    // Puede lanzar la excepcion DatoInvalido si alguno de los datos
    // no cumple con los rangos establecidos.
    public boolean registrarNota(
            int numeroSemestre,
            int numeroMateria,
            double nota) throws DatoInvalido {

        // Comprueba que el semestre este entre 1 y 10.
        if (numeroSemestre < 1 || numeroSemestre > 10) {

            throw new DatoInvalido(
                    "El semestre debe estar entre 1 y 10"
            );
        }

        // Comprueba que la materia este entre 1 y 20.
        if (numeroMateria < 1 || numeroMateria > 20) {

            throw new DatoInvalido(
                    "La materia debe estar entre 1 y 20"
            );
        }

        // Comprueba que la nota este entre 0.0 y 5.0.
        if (nota < 0.0 || nota > 5.0) {

            throw new DatoInvalido(
                    "La nota debe estar entre 0.0 y 5.0"
            );
        }

        // Se resta 1 porque las posiciones de las matrices
        // comienzan en 0, pero el usuario comienza a contar desde 1.
        int posicionSemestre = numeroSemestre - 1;
        int posicionMateria = numeroMateria - 1;

        // Guarda la nota en la posicion correspondiente.
        notas[posicionSemestre][posicionMateria] = nota;

        System.out.println("Nota registrada correctamente");

        // Retorna true porque el registro fue exitoso.
        return true;
    }

    // Consulta una nota utilizando el semestre y la materia.
    public Double consultarNota(
            int numeroSemestre,
            int numeroMateria) {

        // Comprueba que el semestre este entre 1 y 10.
        if (numeroSemestre < 1 || numeroSemestre > 10) {

            System.out.println(
                    "El semestre debe estar entre 1 y 10"
            );

            return null;
        }

        // Comprueba que la materia este entre 1 y 20.
        if (numeroMateria < 1 || numeroMateria > 20) {

            System.out.println(
                    "La materia debe estar entre 1 y 20"
            );

            return null;
        }

        // Convierte los numeros en posiciones de la matriz.
        int posicionSemestre = numeroSemestre - 1;
        int posicionMateria = numeroMateria - 1;

        // Devuelve la nota almacenada.
        // Si no hay una nota registrada, devuelve null.
        return notas[posicionSemestre][posicionMateria];
    }

    // Muestra las notas registradas en un semestre.
    public void mostrarNotasSemestre(int numeroSemestre) {

        // Comprueba que el semestre este entre 1 y 10.
        if (numeroSemestre < 1 || numeroSemestre > 10) {

            System.out.println(
                    "El semestre debe estar entre 1 y 10"
            );

            return;
        }

        // Convierte el numero del semestre en una posicion.
        int posicionSemestre = numeroSemestre - 1;

        // Indica si se encontro por lo menos una nota.
        boolean tieneNotas = false;

        System.out.println(
                "===== NOTAS DEL SEMESTRE "
                + numeroSemestre + " ====="
        );

        // Recorre las 20 materias del semestre seleccionado.
        for (int i = 0;
                i < notas[posicionSemestre].length;
                i++) {

            // Solo muestra las posiciones que tienen una nota.
            if (notas[posicionSemestre][i] != null) {

                System.out.println(
                        "Materia " + (i + 1)
                        + ": " + notas[posicionSemestre][i]
                );

                tieneNotas = true;
            }
        }

        // Se ejecuta si todas las posiciones estaban en null.
        if (!tieneNotas) {

            System.out.println(
                    "No hay notas registradas en este semestre"
            );
        }
    }

    // Calcula el promedio de las notas registradas
    // en un semestre determinado.
    public double calcularPromedioSemestre(
            int numeroSemestre) {

        // Comprueba que el semestre este entre 1 y 10.
        if (numeroSemestre < 1 || numeroSemestre > 10) {

            System.out.println(
                    "El semestre debe estar entre 1 y 10"
            );

            return 0.0;
        }

        // Convierte el semestre en una posicion de la matriz.
        int posicionSemestre = numeroSemestre - 1;

        // Acumula la suma de las notas.
        double sumaNotas = 0.0;

        // Cuenta cuantas notas fueron registradas.
        int cantidadNotas = 0;

        // Recorre las materias del semestre.
        for (int i = 0;
                i < notas[posicionSemestre].length;
                i++) {

            // Solo utiliza las posiciones que tienen una nota.
            if (notas[posicionSemestre][i] != null) {

                sumaNotas = sumaNotas
                        + notas[posicionSemestre][i];

                cantidadNotas++;
            }
        }

        // Evita dividir entre cero cuando no existen notas.
        if (cantidadNotas == 0) {
            return 0.0;
        }

        // Calcula y devuelve el promedio.
        return sumaNotas / cantidadNotas;
    }

    // Polimorfismo mediante sobrescritura del metodo
    // abstracto declarado en Persona.
    @Override
    public String mostrarInformacion() {

        return "Estudiante: " + getNombre()
                + " | ID: " + getId()
                + " | Email: " + getEmail()
                + " | Semestre: " + semestre
                + " | Materias cursadas: "
                + historialMaterias.size();
    }
    public static void main(String[] args) {
        
    }
}