package modelo;

// Clase ABSTRACTA: es la base de la jerarquia de herencia que pide el proyecto.
// No se puede crear un objeto Persona directamente.
public abstract class Persona {

    // Atributos privados (encapsulamiento)
    private String nombre;
    private String id;
    private String email;

    // Constructor
    public Persona(String nombre, String id, String email) {
        this.nombre = nombre;
        this.id = id;
        this.email = email;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Metodo abstracto que sera sobrescrito
    public abstract String mostrarInformacion();
}