package gestion;

import java.util.TreeMap;
import excepciones.MateriaNoEncontrada;
import modelo.Materia;

// Esta clase administra las materias del sistema.
public class GestorMaterias {

    // TreeMap que almacena las materias ordenadas por codigo.
    // La llave es el codigo y el valor es el objeto Materia.
    private TreeMap<String, Materia> materias;

    // Constructor de la clase.
    public GestorMaterias() {

        // Crea el TreeMap inicialmente vacio.
        this.materias = new TreeMap<String, Materia>();
    }

    // Metodo para registrar una materia.
    public boolean registrarMateria(Materia materia) {

        // Comprueba que la materia recibida no sea null.
        if (materia == null) {
            System.out.println("La materia no existe");
            return false;
        }

        // Obtiene el codigo de la materia.
        String codigo = materia.getCodigo();

        // Comprueba que el codigo no sea null ni este vacio.
        if (codigo == null || codigo.isEmpty()) {
            System.out.println(
                    "El codigo de la materia no es valido"
            );
            return false;
        }

        // Comprueba si ya existe una materia con el mismo codigo.
        if (materias.containsKey(codigo)) {
            System.out.println(
                    "Ya existe una materia con ese codigo"
            );
            return false;
        }

        // Guarda la materia usando el codigo como llave.
        materias.put(codigo, materia);

        System.out.println("Materia registrada correctamente");

        return true;
    }

    // Metodo para buscar una materia mediante su codigo.
    // Si no existe, lanza la excepcion personalizada.
    public Materia buscarMateria(String codigo)
            throws MateriaNoEncontrada {

        // Busca la materia dentro del TreeMap.
        Materia materia = materias.get(codigo);

        // Si get retorna null, la materia no esta registrada.
        if (materia == null) {

            // Lanza la excepcion personalizada.
            throw new MateriaNoEncontrada(
                    "No existe una materia con el codigo: "
                    + codigo
            );
        }

        // Devuelve la materia encontrada.
        return materia;
    }

    // Metodo para eliminar una materia mediante su codigo.
    public boolean eliminarMateria(String codigo)
            throws MateriaNoEncontrada {

        // Comprueba si el codigo no esta registrado.
        if (!materias.containsKey(codigo)) {

            // Lanza la excepcion personalizada.
            throw new MateriaNoEncontrada(
                    "No existe una materia con el codigo: "
                    + codigo
            );
        }

        // Elimina la materia asociada con el codigo.
        materias.remove(codigo);

        System.out.println("Materia eliminada correctamente");

        return true;
    }

    // Metodo para agregar un prerrequisito a una materia.
    public boolean agregarPrerrequisito(
            String codigoMateria,
            String codigoPrerrequisito)
            throws MateriaNoEncontrada {

        // Busca la materia principal.
        Materia materia = materias.get(codigoMateria);

        // Comprueba que la materia principal exista.
        if (materia == null) {

            throw new MateriaNoEncontrada(
                    "No existe la materia principal con el codigo: "
                    + codigoMateria
            );
        }

        // Busca la materia que sera utilizada como prerrequisito.
        Materia prerrequisito =
                materias.get(codigoPrerrequisito);

        // Comprueba que el prerrequisito exista.
        if (prerrequisito == null) {

            throw new MateriaNoEncontrada(
                    "No existe la materia prerrequisito con el codigo: "
                    + codigoPrerrequisito
            );
        }

        // Llama al metodo de la clase Materia.
        return materia.agregarPrerrequisito(
                codigoPrerrequisito
        );
    }

    // Metodo para mostrar todas las materias.
    public void mostrarMaterias() {

        // Comprueba si el TreeMap esta vacio.
        if (materias.isEmpty()) {
            System.out.println("No hay materias registradas");
            return;
        }

        System.out.println("===== MATERIAS REGISTRADAS =====");

        // Recorre las materias en el orden de sus codigos.
        for (Materia materia : materias.values()) {

            // Muestra los datos de la materia.
            materia.mostrarInformacion();

            System.out.println("-------------------------------");
        }
    }

    // Comprueba si existe una materia con un codigo determinado.
    public boolean existeMateria(String codigo) {

        // containsKey verifica si el codigo existe como llave.
        return materias.containsKey(codigo);
    }

    // Retorna la cantidad de materias registradas.
    public int cantidadMaterias() {

        // size retorna la cantidad de elementos.
        return materias.size();
    }

    // Permite consultar el TreeMap completo.
    public TreeMap<String, Materia> getMaterias() {
        return materias;
    }
}