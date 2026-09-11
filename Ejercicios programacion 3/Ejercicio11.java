import java.util.Scanner;

public class Ejercicio11 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese el tamaño del arreglo A: ");
        int n = teclado.nextInt(); //Lee la cantidad de datos que tendrá el arreglo

        int[] arregloA = new int [n]; //Crea el arreglo A con tamaño n
        
        System.out.println("Ingrese los elementos del arreglo A : ");
        for(int i = 0; i < n; i++ ) { //Ciclo for que recorre desde 0 hasta n-1
            arregloA[i] = teclado.nextInt(); //Lee un número y lo guarda en la posición correspondiente
        }

        //Contadores para saber cuántos negativos, ceros y positivos hay
        int contNeg = 0, contCero = 0, contPos =0;
        for(int i =0; i <n; i++ ) { //Recorre el arreglo A
            if (arregloA[i] <0  ) contNeg++; //Incrementa contador de negativos
                else if (arregloA[i] == 0 ) contCero++; //Incrementa contador de ceros
                else contPos++; //Incrementa contador de positivos
             }

             //Crear los tres arreglos con el tamaño exacto
             int[] negativos = new int[contNeg]; //Arreglo para negativos
             int[] ceros = new int[contCero]; //Arreglo para ceros
             int[] positivos = new int[contPos]; //Arreglo para positivos

             //Llenar los arreglos
             int iNeg = 0, iCero = 0, iPos = 0; //Índices para cada arreglo
             for(int i = 0; i < n; i++ ) { //Recorre el arreglo A
                if(arregloA[i] < 0 ) { 
                negativos[iNeg++] = arregloA[i]; //Guarda el número negativo
                } else if (arregloA[i] == 0) {
                    ceros[iCero++] = arregloA[i]; //Guarda el cero
                }else {
                    positivos[iPos++] = arregloA[i]; //Guarda el número positivo
                }
             }

           //Mostrar resultados
        System.out.print("Arreglo de negativos = ");
        for (int i = 0; i < negativos.length; i++) { //Recorre el arreglo de negativos
        System.out.print(negativos[i] + " "); //Muestra cada número en la misma línea
     } 
        System.out.println();

        System.out.print("Arreglo de ceros = ");
        for (int i = 0; i < ceros.length; i++) { //Recorre el arreglo de ceros
        System.out.print(ceros[i] + " "); //Muestra cada cero en la misma línea
     }
        System.out.println();

        System.out.print("Arreglo de positivos = ");
        for (int i = 0; i < positivos.length; i++) { //Recorre el arreglo de positivos
        System.out.print(positivos[i] + " "); //Muestra cada número positivo en la misma línea
    }
        System.out.println();
        teclado.close(); 

    }
}