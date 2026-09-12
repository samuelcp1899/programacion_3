public class Ejercicio20 {
    public static void main(String[] args) {
        //Matriz 10x10
        int[][] matriz = new int[10][10];

        //Asignamos los valores
        for(int i = 0; i < 10; i++) { //Recorre filas
            for(int j =0; j < 10; j++){ //Recorre columnas 
                if(j > i ){
                    matriz[i][j] = 0; //arriba de la diagonal= 0
                }else{
                    matriz[i][j] = 1; //Diagonal y debajo = 1
                }
            }
        }

        //Imprimimos la matriz
        System.out.println("Matriz 10x10: ");
        for(int i = 0; i < 10; i++){ //Recorre cada fila de la matriz de 0 a 9 con un total de 10 filas
            for(int j = 0; j < 10; j++){ //Recorre cada columna dentro de la fila de 0 a 9
        
            System.out.print(matriz[i][j] + "\t"); //imprime el valor almacenado en [i][j] de la matriz
             //el \t añade una tabulacion para que los numeros queden alineados en columnas
        }
        
        System.out.println(); //Salto de linea despues de imprimir una fila completa para la siguiente
        }
       


    }
}
