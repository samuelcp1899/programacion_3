package modelo;

// Profesor tambien hereda de Persona.
// Junto con Estudiante forma la jerarquia de herencia.
public class Profesor extends Persona {

    // Departamento al que pertenece el profesor.
    private String departamento;

    // Salario del profesor.
    private double salario;

    // Constructor de Profesor.
    public Profesor(
            String nombre,
            String id,
            String email,
            String departamento,
            double salario) {

        // Llama al constructor de Persona.
        super(nombre, id, email);

        this.departamento = departamento;
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }

    // Sobrescribe el metodo abstracto de Persona.
    // Esta es la version propia de Profesor.
    @Override
    public String mostrarInformacion() {

        return "Profesor: " + getNombre()
                + " | ID: " + getId()
                + " | Email: " + getEmail()
                + " | Departamento: "
                + departamento;
    }
}