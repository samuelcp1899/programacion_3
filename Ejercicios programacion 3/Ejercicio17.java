import java.util.Scanner; 


public class Ejercicio17 { 


    public static void main(String[] args) { 
   

        Scanner teclado = new Scanner(System.in); 
        // Crea un objeto Scanner llamado "teclado" para leer datos ingresados por el usuario.

        System.out.print("Ingrese el numero de filas: "); 
        // Solicita al usuario el número de filas de la matriz.
        int filas = teclado.nextInt(); 
        // Guarda el número ingresado en la variable filas.

        System.out.print("Arregle el numero de columnas: "); 
        // Solicita al usuario el número de columnas de la matriz.
        int columnas = teclado.nextInt(); 
        // Guarda el número ingresado en la variable columnas.

        int[][] matriz = new int[filas][columnas]; 
        // Declara una matriz bidimensional con las dimensiones dadas.

        //Ingresar los elementos de la matriz 
        System.out.println("Ingrese los elementos de la matriz: "); 
        // Pide al usuario que ingrese los valores de la matriz.
        for(int i = 0; i < filas; i++) { 
            // Recorre cada fila.
            for(int j = 0; j < columnas; j++){ 
                // Recorre cada columna dentro de la fila.
                matriz[i][j] = teclado.nextInt(); 
                // Asigna el valor ingresado a la posición correspondiente de la matriz.
            }
        }

        //Sumar cada fila 
        System.out.println("\nsuma de cada fila: "); 
        // Muestra un título para la suma de filas.
        for(int i =0; i < filas; i++){ 
            // Recorre cada fila.
            int sumafila =0; 
            // Inicializa la suma de la fila en 0.
            for(int j = 0; j < columnas; j++ ){ 
                // Recorre cada columna de la fila.
                sumafila += matriz [i][j]; 
                // Acumula el valor de cada elemento en la suma de la fila.
            }
            System.out.println("Columna " + (i + 1 ) + ": " + sumafila); 
            // Imprime la suma de la fila (nota: aquí dice "Columna", pero en realidad es la fila).
        }

        //Sumar cada columna
        System.out.println("\nsuma de cada columna: "); 
        // Muestra un título para la suma de columnas.
        for(int j =0; j < columnas; j++) { 
            // Recorre cada columna.
            int sumacolumna =0; 
            // Inicializa la suma de la columna en 0.
            for(int i = 0; i < filas; i ++) { 
                // Recorre cada fila de la columna.
                sumacolumna += matriz[i][j]; 
                // Acumula el valor de cada elemento en la suma de la columna.
            }
            System.out.println("Columna " + (j + 1 ) + ": " + sumacolumna); 
            // Imprime la suma de la columna.
        }

        teclado.close(); 
       
    }
}