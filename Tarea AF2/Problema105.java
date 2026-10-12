import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;;

//   1) Crear una COLA que guarde el numero de seguridad social de cada repartidor y la
//      entidad anunciada en la propaganda, para UN unico dia de trabajo.
//   2) Actualizar la lista a partir de los datos de la cola:
//        - Si el repartidor ya esta en la lista, se le suma un dia trabajado.
//        - Si el repartidor NO esta en la lista, se agrega con 1 dia trabajado.

public class Problema105 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        LinkedList<Repartidor> lista = new LinkedList<>(); //lista enlazada de repartidores

        lista.add(new Repartidor("1001" , "Banco Sol" , 3));  //Repartidor 1001 3 dias ultima entidad banco sol

        lista.add(new Repartidor("1002", "Cine Rex", 1)); //Repartidor 1002 1 dia

        lista.add(new Repartidor("1003", "Pizzeria Luigi", 2)); //Repartidor 1003 2 dia

        System.out.println("Lista Inicial:");

        for (Repartidor r : lista){  //Recorre la lista r es cada repartidor

            System.out.println("SS: " + r.numeroSS + " | dias: " + r.dias + " | ultima entidad:" + r.entidad);

        }

        //COLA con los datos del dia de trabajo

        Queue<Repartidor> cola = new LinkedList<>(); //COLA vacia cada elemento es un repartidor de ese dia

        System.out.println();

        System.out.println("Datos del dia de trabajo (escribe fin en el numero para terminar)");

        System.out.println("Numero de seguridad social: ");
        String numero = teclado.nextLine(); //lee el numero de seguridad social

        while(!numero.equals("fin")){ //Mientras no escriba fin seguimos leyendo datos

            System.out.println("Entidad anunciada: ");
            
            String entidad = teclado.nextLine(); //lee la entidad enunciada

            cola.add(new Repartidor(numero, entidad, 1)); //agregamos 1 a cola un repartidor con 1 dia de trabajo

            System.out.println("Numero de seguridad social: ");
            numero = teclado.nextLine(); //leemos el siguiente numero
    
        }

        //Actualizar la lista con los datos en la cola

        while(!cola.isEmpty()) { //mientras la cola tenga elementos

            Repartidor deLaCola = cola.poll(); //Saca el primero de la cola

            boolean encontrado = false; //Guardara si el repartidor ya esta en la lista

                for (Repartidor r : lista) {                //recorremos la lista buscando su numero de seguridad social

                if (r.numeroSS.equals(deLaCola.numeroSS)) { // si es el mismo numero:

                    r.dias = r.dias + 1;                //le sumamos un dia trabajado

                    r.entidad = deLaCola.entidad;       // guardamos la entidad de su ultimo dia

                    encontrado = true;                  //  anotamos que si estaba en la lista
                }
            }

            if(!encontrado){ //si NO estaba en la lista

                lista.add(deLaCola); //se agrega al final de la lista con un 1 dia
            }
        }

        //Lista ya actualizada
        System.out.println();
        System.out.println("Lista Actualizada: ");

        for(Repartidor r : lista){

            System.out.println("  SS: " + r.numeroSS + " | dias: " + r.dias + " | ultima entidad: " + r.entidad);
        }

        teclado.close();
    }
}

//guarda los datos de un repartidor
class Repartidor {

    String numeroSS; //numero de seguridad social
    
    String entidad; //entidad anunciada en la propaganda (la del ultimo dia trabajando)

    int dias;

    Repartidor(String n, String e, int d){  //Constructor crea un repartidor con esos datos

        numeroSS = n;

        entidad = e;

        dias = d;

    }
}
