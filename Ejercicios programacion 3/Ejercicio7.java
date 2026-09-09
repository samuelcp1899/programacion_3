import java.util.Scanner;
public class Ejercicio7{
    public static void main(String[]argsStrings){
        Scanner sc = new Scanner (System.in); //Ingresar datos por teclado

        int[] A = new int [10]; //Arreglo principal donde se almacenaran los 10 numeros registrados
        int[] pares = new int [10]; //Arreglo donde se almacenaran los numeros pares
        int[]impares = new int [10]; //Arreglo donde se almacenaran los numeros impares

        int contpares = 0; //contador de numeros pares
        int contimpares = 0; //contador de numeros impares

     System.out.println("Introduce 10 numeros: ");
    for(int i =0; i< A.length; i++) { //Recorre las posiciones del arreglo A
        A[i] = sc.nextInt(); //Guarda cada numero ingresado por el usuario en el arreglo A
    }
      
    for(int i =0; i < A.length; i++){ //Recorre el arreglo para analizar cada numero
        if(A[i] %2 == 0 ) { //verifica si el numero es par ya que su residio es 0
            pares [contpares++] = A[i]; //Guarda el numero par en el arreglo de pares y aumenta el contador en 1
        }else{
            impares [contimpares++] = A[i]; //si el numero no es par entonces es impar, se guarda en el arreglo de impares y aumenta el contador en 1
        }
        }
        
        System.out.println("\npares:"); //Muestra la lista de numeros pares
        for(int i=0; i< contpares; i++){ //Recorre solo las posiciones ocupadas del arreglo pares
            System.out.print(pares[i] + " "); //Imprime los numeros pares almacenados en el arreglo
           }
            
           System.out.println("\nimpares: "); //Muestra la lista de numeros impares
           for(int i=0; i< contimpares; i++){ //Recorre solo las posiciones ocupadas del arreglo impares
               System.out.print(impares[i]+ " "); //Imprime los numeros impares almacenados en el arreglo
               
           }
    sc.close(); //cierra el scanner para evitar fugas de memoria

    }

    }
