package gestion;

import java.util.TreeMap;
import modelo.Materia;

// Esta clase administra las materias del sistema.
public class GestorMaterias {

    // TreeMap que guarda las materias ordenadas por codigo.
    // La llave es el codigo y el valor es el objeto Materia.
    private TreeMap<String, Materia> materias;

    // Constructor.
    public GestorMaterias() {

        // Crea el TreeMap inicialmente vacio.
        this.materias = new TreeMap<String, Materia>();
    }

    public static void main(String[] args) {
        
    }
    // Registra una materia en el sistema.
    public boolean registrarMateria(Materia materia) {

        // Comprueba que el objeto recibido exista.
        if (materia == null) {
            System.out.println("La materia no existe");
            return false;
        }

        // Obtiene el codigo de la materia.
        String codigo = materia.getCodigo();

        // Comprueba que el codigo no sea null ni este vacio.
        if (codigo == null || codigo.isEmpty()) {
            System.out.println("El codigo de la materia no es valido");
            return false;
        }

        // Comprueba si ya existe una materia con ese codigo.
        if (materias.containsKey(codigo)) {
            System.out.println(
                    "Ya existe una materia con ese codigo"
            );
            return false;
        }

        // Guarda la materia usando su codigo como llave.
        materias.put(codigo, materia);

        System.out.println("Materia registrada correctamente");
        return true;
    }

    // Busca una materia mediante su codigo.
    public Materia buscarMateria(String codigo) {

        // get retorna la materia asociada con el codigo.
        // Si el codigo no existe, retorna null.
        return materias.get(codigo);
    }

    // Elimina una materia mediante su codigo.
    public boolean eliminarMateria(String codigo) {

        // Comprueba si el codigo se encuentra registrado.
        if (!materias.containsKey(codigo)) {
            System.out.println(
                    "No existe una materia con ese codigo"
            );
            return false;
        }

        // Elimina la materia asociada con el codigo.
        materias.remove(codigo);

        System.out.println("Materia eliminada correctamente");
        return true;
    }

    // Muestra las materias ordenadas por codigo.
    public void mostrarMaterias() {

        // Comprueba si el TreeMap esta vacio.
        if (materias.isEmpty()) {
            System.out.println("No hay materias registradas");
            return;
        }

        System.out.println("===== MATERIAS REGISTRADAS =====");

        // Recorre los codigos en el orden establecido por TreeMap.
        for (String codigo : materias.keySet()) {

            // Obtiene la materia correspondiente al codigo.
            Materia materia = materias.get(codigo);

            // Muestra la informacion de la materia.
            materia.mostrarInformacion();

            System.out.println("-------------------------------");
        }
    }

    // Agrega un prerrequisito a una materia registrada.
    public boolean agregarPrerrequisito(
            String codigoMateria,
            String codigoPrerrequisito) {

        // Busca la materia principal.
        Materia materia = materias.get(codigoMateria);

        // Comprueba que la materia principal exista.
        if (materia == null) {
            System.out.println(
                    "La materia principal no esta registrada"
            );
            return false;
        }

        // Comprueba que la materia usada como prerrequisito exista.
        Materia prerrequisito =
                materias.get(codigoPrerrequisito);

        if (prerrequisito == null) {
            System.out.println(
                    "La materia prerrequisito no esta registrada"
            );
            return false;
        }

        // Llama al metodo de la clase Materia.
        return materia.agregarPrerrequisito(
                codigoPrerrequisito
        );
    }

    // Retorna la cantidad de materias registradas.
    public int cantidadMaterias() {
        return materias.size();
    }

    // Permite consultar el TreeMap completo.
    public TreeMap<String, Materia> getMaterias() {
        return materias;
    }
}