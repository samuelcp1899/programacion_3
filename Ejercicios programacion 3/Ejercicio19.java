import java.util.Scanner;

public class Ejercicio19 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Ingresar el tamaño de la matriz
        System.out.print("Ingrese el numero de filas: ");
        int n = teclado.nextInt();

        System.out.println("Ingrese el numero de columnas: ");
        int m = teclado.nextInt();

        //Hacemos la matriz
        int[][] matriz = new int[n][m];

        //Damos valores 1 en diagonal y 0 en el resto
        for(int i = 0; i < n; i++) { //Recorre filas
            for(int j = 0; j < m; j++) { //Recorre columnas
                if(i == j) {
                matriz[i][j] = 1; //Diagonal 1
                }else {
                    matriz[i][j] = 0; //Resto de posiciones 0
                }
                 
            }

        }

        //Imprimimos la matriz 
        
        System.out.println("\nMatriz generada: ");
        for(int i = 0; i <n; i++) { //Recorre cada fila
            for(int j = 0; j  < m; j++){ //Recorre cada columna
             System.out.print(matriz[i][j] + "\t"); 
        }
        System.out.println();
    }
        teclado.close();
    }
}

