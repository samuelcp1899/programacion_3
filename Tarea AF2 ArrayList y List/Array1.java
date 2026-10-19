import java.util.ArrayList;

//Ejemplo 1 arraylist de los 5 mejores jugadores de la historia 
//un array guarda los elementos en orden 

public class Array1 {

    public static void main(String[] args) {
        
ArrayList<String> top5 = new ArrayList<>(); //guarda los array que guarda los nombres de los jugadores

//add sirve para agregar un elemento
top5.add("Messi"); //posicion 0
top5.add("Cristiano"); //posicion 1
top5.add("Maradona"); //posicion 2
top5.add("Pele"); //posicion 3
top5.add("Cruyff"); //posicion 4

//muestra la lista de todos los elementos en este caso los jugadores
System.out.println(top5);

System.out.println(top5.get(0)); //el get devuelve el elemento que esta en la posicion  colocada

System.out.println(top5.size()); // muestra los elementos que tiene  la lista

System.out.println(top5.indexOf("Pele")) ; //devuelve la posicion donde esta el elemento o -1 en caso de que no este

System.out.println(top5.indexOf("Di estefano")); //muestra -1 por que no esta en la lista

System.out.println(top5.contains("Maradona")); // el contains devuelve true si el elemento esta en la lista

top5.set(4, "Puskas"); //reemplaza el elemento de esa posicion por otro
//cambia a pele por puskas en este caso

System.out.println(top5);

top5.add("Cruyff"); // el add otra vez para agregar un elemento al final de lista y crece a 6 elementos
System.out.println(top5); //Messi, Cristiano ,Maradona, Pele, Zidane, Cruyff

top5.remove(4); //remove elimina un elemento en la lista con la posicion elegida los demas se corren
//elimina a zidane

System.out.println(top5); //la lista actualizada Messi, Cristiano, Maradona, Pele, Cruyff

//Recorre la lista, con el get(i) para ver cada elemento

for(int i = 0; i < top5.size(); i++) { // i va de 0 hasta el tamaño -1

System.out.println((i + 1) + ". " + top5.get(i)); // i + 1 para mostrar el puesto del 1 al 5
}

System.out.println(top5.isEmpty()); //con el empty devuelve true si  la lista no tiene elementos
//en este caso false

top5.clear(); //el clear borra (limpia) todos los elementos de la lista
System.out.println(top5);
System.out.println(top5.isEmpty()); //true

    }
}