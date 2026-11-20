package modelo;

import java.util.LinkedList;

// Estudiante hereda los atributos y metodos de Persona.
public class Estudiante extends Persona {

    // Semestre actual del estudiante.
    private int semestre;

    // Matriz de notas:
    // 10 filas para semestres y 20 columnas para materias.
    private Double[][] notas;

    // Lista enlazada para el historial de materias cursadas.
    private LinkedList<String> historialMaterias;

    // Constructor.
    public Estudiante(
            String nombre,
            String id,
            String email,
            int semestre) {

        // Llama al constructor de Persona.
        super(nombre, id, email);

        this.semestre = semestre;
        this.notas = new Double[10][20];
        this.historialMaterias = new LinkedList<String>();
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Double[][] getNotas() {
        return notas;
    }

    public LinkedList<String> getHistorialMaterias() {
        return historialMaterias;
    }

    // Agrega una materia al historial.
    public void agregarAlHistorial(String codigoMateria) {
        historialMaterias.add(codigoMateria);
    }

    // Registra una nota.
    public boolean registrarNota(
            int numeroSemestre,
            int numeroMateria,
            double nota) {

        // Comprueba que el semestre este entre 1 y 10.
        if (numeroSemestre < 1 || numeroSemestre > 10) {
            System.out.println(
                    "El semestre debe estar entre 1 y 10"
            );
            return false;
        }

        // Comprueba que la materia este entre 1 y 20.
        if (numeroMateria < 1 || numeroMateria > 20) {
            System.out.println(
                    "La materia debe estar entre 1 y 20"
            );
            return false;
        }

        // Comprueba que la nota este entre 0.0 y 5.0.
        if (nota < 0.0 || nota > 5.0) {
            System.out.println(
                    "La nota debe estar entre 0.0 y 5.0"
            );
            return false;
        }

        // Convierte los numeros ingresados en posiciones de la matriz.
        int posicionSemestre = numeroSemestre - 1;
        int posicionMateria = numeroMateria - 1;

        // Guarda la nota.
        notas[posicionSemestre][posicionMateria] = nota;

        System.out.println("Nota registrada correctamente");
        return true;
    }

    // Consulta una nota.
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

        // Devuelve la nota o null si no existe una nota registrada.
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

        int posicionSemestre = numeroSemestre - 1;

        // Indica si se encontro al menos una nota.
        boolean tieneNotas = false;

        System.out.println(
                "===== NOTAS DEL SEMESTRE "
                + numeroSemestre + " ====="
        );

        // Recorre las 20 materias del semestre seleccionado.
        for (int i = 0;
                i < notas[posicionSemestre].length;
                i++) {

            // Solo muestra las posiciones con una nota registrada.
            if (notas[posicionSemestre][i] != null) {

                System.out.println(
                        "Materia " + (i + 1)
                        + ": " + notas[posicionSemestre][i]
                );

                tieneNotas = true;
            }
        }

        // Se ejecuta si no se encontro ninguna nota.
        if (!tieneNotas) {
            System.out.println(
                    "No hay notas registradas en este semestre"
            );
        }
    }

    // Calcula el promedio de un semestre.
    public double calcularPromedioSemestre(int numeroSemestre) {

        // Comprueba que el semestre este entre 1 y 10.
        if (numeroSemestre < 1 || numeroSemestre > 10) {
            System.out.println(
                    "El semestre debe estar entre 1 y 10"
            );
            return 0.0;
        }

        int posicionSemestre = numeroSemestre - 1;
        double sumaNotas = 0.0;
        int cantidadNotas = 0;

        // Recorre las 20 materias del semestre.
        for (int i = 0;
                i < notas[posicionSemestre].length;
                i++) {

            // Ignora las posiciones que todavia contienen null.
            if (notas[posicionSemestre][i] != null) {

                sumaNotas = sumaNotas
                        + notas[posicionSemestre][i];

                cantidadNotas++;
            }
        }

        // Evita una division entre cero.
        if (cantidadNotas == 0) {
            return 0.0;
        }

        return sumaNotas / cantidadNotas;
    }

    // Polimorfismo mediante sobrescritura.
    @Override
    public String mostrarInformacion() {

        return "Estudiante: " + getNombre()
                + " | ID: " + getId()
                + " | Email: " + getEmail()
                + " | Semestre: " + semestre
                + " | Materias cursadas: "
                + historialMaterias.size();
    }
}