package modelo;

import java.util.LinkedList;

// Estudiante HEREDA de Persona
public class Estudiante extends Persona {

    private int semestre;

    // Matriz obligatoria del proyecto
    private Double[][] notas;

    // Lista enlazada para historial
    private LinkedList<String> historialMaterias;

    public Estudiante(
            String nombre,
            String id,
            String email,
            int semestre) {

        // Constructor de la clase padre
        super(nombre, id, email);

        this.semestre = semestre;

        // 10 semestres y 20 materias
        this.notas = new Double[10][20];

        // Lista enlazada vacia
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

    // Agrega una materia al historial
    public void agregarAlHistorial(String codigoMateria) {
        historialMaterias.add(codigoMateria);
    }

    // Sobrescritura del metodo abstracto
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