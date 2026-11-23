package excepciones;

// Excepcion personalizada que se utiliza cuando
// no se encuentra un estudiante con el ID solicitado.
public class EstudianteNoEncontrado extends Exception {

    // Constructor que recibe el mensaje del error.
    public EstudianteNoEncontrado(String mensaje) {

        // Envia el mensaje al constructor de la clase Exception.
        super(mensaje);
    }
}