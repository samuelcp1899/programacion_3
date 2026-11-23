package excepciones;

// Excepcion personalizada que se utiliza cuando
// un dato no cumple las reglas establecidas en el sistema.
public class DatoInvalido extends Exception {

    // Constructor que recibe el mensaje del error.
    public DatoInvalido(String mensaje) {

        // Envia el mensaje al constructor de la clase padre Exception.
        super(mensaje);
    }
}
