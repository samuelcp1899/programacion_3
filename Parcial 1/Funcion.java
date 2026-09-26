public class Funcion {

    // Atributos
    private String horario;
    private Pelicula pelicula;

    // Constructor
    // se define el horario

    public Funcion(String horario) {
        this.horario = horario;
        this.pelicula = null;
    }

    // metodos gets
    public String getHorario() {
        return horario;
    }

    public Pelicula getpelicula() {
        return pelicula;
    }

    // Asignar una pelicula a la funcion
    public void asignarPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    // Mostrar informacion
    public void mostrarInfo() {
        System.out.println("Horario: " + horario);

        // comprueba si ya hay una pelicula asignada y muestra su nombre
        if (pelicula != null) {
            System.out.println("Pelicula: " + pelicula.getNombre());
        } else { // en caso que no, saldra que no hay una pelicula asignada todavia
            System.out.println("No asignada");
        }
    }
}