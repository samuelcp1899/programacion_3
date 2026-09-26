
public class pelicula {

    public static void main(String[] args) {
    }
    
        // Atributos de las peliculas
        private String nombre;
        private String idioma;
        private String tipo; // 35mm o 3D
        private int duracion;

        // Constructor para inicializar la pelicula (sin constructor hay un vacio)
        //un constructor es un metodo que se llama de forma automatica al crear un objeto de una clase
        //Sirviendo para inicializar (asignar un valor inicial a un objeto o una variable) los atributos de ese objeto
        public pelicula (String nombre, String idioma, String tipo, int duracion ) {
            this.nombre = nombre; //el this sirve para saber a que objeto se le esta ejecutando el metodo o el constructor
            this.idioma = idioma;
            this.tipo = tipo;
            this.duracion = duracion;

        }

        //Metodos gets para acceder a los atributos
        //funcionan como una llave para consultar los atributos privados
        public String getnombre(){
            return nombre;
        }

        public String getidioma(){
            return idioma;
        }
        public String gettipo (){
            return tipo;
        }
        public int getduracion(){
            return duracion;
        }

        //Metodo para mostrar informacion de la pelicula
        public void mostrarInfo(){
            System.out.println("Nombre: " + nombre);
            System.out.println("Idioma: " + idioma);
            System.out.println("Tipo: " + tipo);
            System.out.println("Duracion: " + duracion + "minutos");
        }

    }

