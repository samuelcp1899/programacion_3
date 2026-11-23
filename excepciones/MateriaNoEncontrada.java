package excepciones;

// Excepcion personalizada que se utiliza cuando
// no se encuentra una materia con el codigo solicitado.
public class MateriaNoEncontrada extends Exception {

    // Constructor que recibe el mensaje del error.
    public MateriaNoEncontrada(String mensaje) {

        // Envia el mensaje al constructor de la clase padre Exception.
        super(mensaje);
    }
}