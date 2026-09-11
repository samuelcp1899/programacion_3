

public class Ejercicio18 {
    public static void main(String[] args) {
        //Declaramos una matriz 10x10 para almacenar las tablas de multiplicar

        int[][] tabla = new int [10][10];

        //Llenamos la matriz con los productos 
        for(int i = 0; i < 10; i++){ //Recorre las filas (1 a 10)
            for(int j = 0; j < 10; j++) { //Recorre las columnas  (1 a 10)
                tabla [i][j] = (i + 1) * (j + 1); //Calcula el resultado y lo guarda
                System.out.println((i+1) + " x " + (j + 1 ) +  " = "  + tabla[i][j]);
                //Imprime cada operacion de la tabla de multiplicar numero x numero
            }
        }

        //Imprimimos las tablas de multiplicar 
        
        System.out.println("Tabla de multiplicar del 1 al 10: \n");
        for(int i =0; i < 10; i++) { //Recorre cada fila 
            for(int j = 0; j < 10; j++) { //Recorre cada columna
                
                System.out.print(tabla[i][j] + "\t"); //Imprime el valor 
            }
            System.out.println(); //salto de linea al terminar cada fila

        }

    }
}
