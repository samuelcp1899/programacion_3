import java.util.Scanner;
public class Ejercicio12 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese el tamaño del arreglo A: ");
        int n = teclado.nextInt(); //Lee la cantidad de datos que tendrá el arreglo 
        int[] arregloA = new int[n]; //Crea el arreglo A con tamaño n 

        System.out.println("Ingrese los valores del arreglo A: ");
        for(int i = 0; i < n; i++ ) {  //Ciclo for para llenar el arreglo
            arregloA[i] = teclado.nextInt(); //Lee un número y lo guarda en la posición correspondiente
        }

        System.out.println("Ingrese el valor X a buscar: ");
        int x = teclado.nextInt(); //Valor que se va a buscar en el arreglo 

        //Contar cuántas veces aparece X en el arreglo A
        int contador = 0; 
        for(int i = 0; i < n; i++) { //Recorre el arreglo A
            if(arregloA[i] == x) { //Verifica si el elemento actual es igual a X
                contador++; //Incrementa el contador si encuentra coincidencia
            }
        }

        //Arreglo B con tamaño exacto según las veces que aparece X
        int[] arregloB = new int[contador]; 

        //Llenar arreglo B con las posiciones donde aparece X
        int j = 0; //Índice para recorrer arreglo B
        for(int i = 0; i < n; i++ ) { //Recorre el arreglo A
            if(arregloA[i] == x) { 
                arregloB[j++] = i + 1; //Guarda la posición (i+1 porque se cuenta desde 1)
            }
        } 
         
        //Mostrar arreglo resultante B
        System.out.print("Arreglo resultante B = (");
        for(int i = 0; i < arregloB.length; i++) { //Recorre el arreglo B
            System.out.print(arregloB[i]); //Imprime cada posición encontrada
            if(i < arregloB.length - 1 ){ //Si no es el último elemento
                System.out.print(", "); //Imprime una coma para separar
            }
        }
        System.out.println(")"); 
        teclado.close(); 
    }
}