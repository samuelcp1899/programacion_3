import java.util.Scanner;

public class Ejercicio9 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

    System.out.println("Ingrese el tamallo del arreglo: ");
    int n = teclado.nextInt(); //Lee la cantidad de datos que tendra el arreglo

    int []arreglo = new int[n]; //Crea un arreglo de numeros enteros con tamaño n
        
    System.out.println("Ingrese los elementos del arreglo: ");
    for(int i = 0; i <n; i++) { //ciclo para llenar el arreglo con los datos ingresados 
        arreglo[i] = teclado.nextInt(); //Guarda cada numero en una posicion
    }

    System.out.println("Ingrese el numero a buscar: ");
    int numero = teclado.nextInt(); //Lee el numero que desea buscar

    int contador =0; //Almacena cuantas veces aparece el numero a buscar

    for(int i =0; i <n; i++ ) { //Recorre nuevamente el arreglo 
        if(arreglo [i] == numero) { //Verifica si el elemento actual es el que se busca
            contador ++; //Incrementa el contador a 1
        }
    }

    System.out.println(" El numero " + numero + " aparece " + contador + " veces en el arreglo. ");
    teclado.close();

    }
}

