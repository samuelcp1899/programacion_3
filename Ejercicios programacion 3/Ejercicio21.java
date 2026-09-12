import java.util.Scanner;
public class Ejercicio21 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Tamaño de la matriz
        System.out.print("Ingrese el tamaño de la matriz: ");
        int M = teclado.nextInt(); 

        //Declaramos la matriz MxM
        int[][] matriz = new int [M][M];

        //Ingresamos los elementos de la matriz
        System.out.print("Ingrese los numeros de la matriz: ");
        for(int i =0; i < M; i++){ //Recorre cada fila
         for(int j =0; j < M; j++){ //Recorre columnas
            matriz[i][j] = teclado.nextInt(); //Guarda cada valor ingresado
         }
        }

        //Vector B con M posiciones
        int[] B = new int[M];

        //Calculamos la suma de los numeros pares en cada fila
        for(int i = 0; i < M; i++) { //Recorre cada fila
            int sumaPares = 0; //Inicia la suma en 0
            for(int j = 0; j < M; j++) { //Recorre cada columna de la fila
            if(matriz[i][j] % 2 == 0){ //Verifica si el numero es par
               sumaPares += matriz[i][j]; //Acumula el valor par
            }
            }
            B[i] = sumaPares; //Asigna la suma de pares a la fila del vector B 
            }

            //Imprimimos el vector B
            System.out.println("\nVector B (suma de pares por fila) : ");
            for(int i = 0; i < M; i++) { //Recorre cada posicon del vector B 
                System.out.println("Fila " + (i + 1 ) + ": " +B[i]); //Imprime la suma de pares correspondiente a la fila i
            }

          teclado.close();
    }
}
