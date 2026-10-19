import java.util.LinkedList;
import java.util.List;

//Ejemplo con list  para compras de supermercado
//como list es una interfaz se necesita de otra clase como array o en este caso un linkedlist

public  class ListCompras {

//Metodo que recibe el list de textos y la muestra numerada
    public static void mostrar(List<String> lista) {
        
        for(int i = 0; i <lista.size();i ++){ // i va de 0 hasta el tamaño -1

            System.out.println((i + 1) + ". " + lista.get(i)); //para el numero y el producto

        }
    }

    public static void main(String[] args) {

        List<String> compras = new LinkedList<>();
        
        compras.add("Pan"); //agrega al final posicion 0
        
        compras.add("Leche"); //posicion 1

        compras.add("Aceite"); //posicion 2

    mostrar(compras); //metodo para ver la lista

    compras.add(1, "Arroz"); //Arroz queda en la posicion 1

    System.out.println(compras); //Pan, Arroz, Leche, Aceite

    System.out.println(compras.contains("Leche")); //true leche esta en la lista

    System.out.println(compras.indexOf("Aceite")); //Aceite esta en la posicion 3
    
    compras.remove("Pan"); //Elimina el pan

    System.out.println(compras); //muestra despues de eliminar el pan

    System.out.println(compras.size()); // La lista tiene 3 productos

    System.out.println(compras.isEmpty());// False la lista no esta vacia
        
    }
}