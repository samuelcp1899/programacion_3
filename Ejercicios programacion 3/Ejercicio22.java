import java.util.Scanner;
public class Ejercicio22 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Ingreso para la matriz
        System.out.print("Ingrese el numero de filas: "); 
        int filas = teclado.nextInt();//Guarda el numero de filas

        System.out.print("Ingrese el numero de columnas: ");
        int columnas = teclado.nextInt();//Guarda el numero de columnas

        //Declaramos la matriz
        int[][] matriz = new int [filas][columnas];

        //Ingreso de los elementos de la matriz
        System.out.println("Ingresa los elementos de la matriz: ");
        for(int i = 0; i < filas; i++) { //Recorre cada fila
            for(int j = 0; j < columnas; j++) { //Recorre cada columna
            matriz[i][j] = teclado.nextInt(); //Guarda el valor ingresado en la posicion [i][j]
            } }

            
            System.out.println("\nMatriz ingresada: ");
            for(int i =0; i < filas; i++ ){ //Recorre filas
            for (int j = 0; j < columnas; j++) { //Recorre columnas
                
                System.out.print(matriz[i][j] + "\t"); 
            }
            System.out.println();

            }

            //Mayor y menor con el primer elemento
            int Mayor = matriz[0][0];
            int Menor = matriz[0][0];
            int filaMayor = 0, columnaMayor =0; //posicion del mayor
            int filaMenor =0, columnaMenor =0; //posicion del Menor

            //Se recorre la matriz para encontrar mayor  y menor
            for(int i = 0; i < filas;  i++) { //Recorre filas
                for(int j = 0; j < columnas; j++){ //Recorre columnas
                    if(matriz[i][j] > Mayor ){ // si el elemento actual es mayor que el registrado
                        Mayor = matriz[i][j]; //Actualiza el mayor
                        filaMayor = i; //Guarda la fila del mayor 
                        columnaMayor = j; //Guarda columna del mayor
                    }
                    if(matriz[i][j] < Menor) { // si el elemento actual es menor que el registrado
                        Menor = matriz [i][j]; //Actualiza el menor
                        filaMenor = i; //Guarda la fila del menor
                        columnaMenor = j; //Guarda columna del menor
                    }
                }
            }

            
            System.out.println("\nMayor elemento: " + Mayor + " en posicion [" + filaMayor + "][" + columnaMayor + "]");
            //imprime el valor encontrado junto con su posicion fila y columna
            System.out.println("Menor elemento: " + Menor + " en posicion [" + filaMenor + "][" + columnaMenor + "]");

       teclado.close();

    }
}
