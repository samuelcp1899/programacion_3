import java.util.Scanner;
public class Ejercicio10 {
        
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese el tamaño del arreglo A : ");
        int n = teclado.nextInt();  //Lee la cantidad de datos que tendra el arreglo

        int [] arregloA = new int [n];  //Crea el arreglo tamaño A con tamaño n
        
        System.out.println("Ingrese los elementos del arreglo A: ");
        for(int i =0; i < n; i++ ){  //ciclo for que recorre desde 0 hasta n-1
            arregloA[i] = teclado.nextInt(); //Lee el numero un numero y lo guarda en la posicion correspondiente
        }

        //Arreglo B 
        int[] arregloB = new int [(n + 1 ) /2 ]; //Declara el arreglo B y si n es impar incluye el elemento central

        //Sumar los opuestos
        for(int i = 0; i < (n + 1 ) /2; i++ ) {  //recorre hasta la mitad del arreglo A
            if (i != n - 1 - i ) {  //Si no estamos en el elemento central 
         arregloB[i] = arregloA[i] + arregloA[n - 1 - i]; //entonces suma el elemento en la posicion i con su supuesto 
        
        }else {
            arregloB[i] = arregloA[i]; //Elemento actual si n es impar
        }
     }

     //Arreglo resultante B
     System.out.print("Arreglo resultante B = (");
     for (int i =0; i < arregloB.length; i++ ) {  //Recorre el arreglo B
        System.out.print(arregloB[i] + " "); //Muestra cada elemento de B
        
     if (i < arregloB.length - 1 ) { // en caso de que no sea el ultimo elemento
        System.out.print(",");

     }}

     System.out.print(")" );
     teclado.close();

    }
}
