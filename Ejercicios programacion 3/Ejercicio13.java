import java.util.Scanner;
public class Ejercicio13 {
    public static void main(String[] args) {
            Scanner teclado = new Scanner(System.in);

            System.out.println("Ingrese el tamaño del arreglo A: ");
            int n = teclado.nextInt(); //Lee la cantidad de datos que tendrá el arreglo

            int [] arregloA = new int[n]; //Crea el arreglo A con tamaño n

            System.out.println("Ingrese los elementos del arreglo A: ");
            for(int i = 0; i< n; i++) { //Ciclo for que recorre desde 0 hasta n-1
                    arregloA[i] = teclado.nextInt(); //Lee un número y lo guarda en la posición correspondiente
            }

            //Calcular la suma de los elementos
            int suma = 0;
            for(int i = 0; i <n; i++){ //Recorre el arreglo A
                suma += arregloA[i]; //Acumula la suma de todos los elementos
            }

            //Calcular la media 
            double media = (double) suma /n; //Divide la suma entre el número de elementos

            //Contadores para saber cuántos son mayores y menores que la media
            int contMay = 0, contMen = 0;
            for(int i = 0; i< n; i++) { //Recorre el arreglo A
                if(arregloA[i] > media) contMay++; //Incrementa contador de mayores
                else if (arregloA[i] < media) contMen++; //Incrementa contador de menores
            }

            //Crear los arreglos con tamaño exacto 
            int[] mayores = new int [contMay]; //Arreglo para los elementos mayores que la media
            int[] menores = new int[contMen]; //Arreglo para los elementos menores que la media

            //Llenar los arreglos 
            int iMay =0, iMen =0; //Índices para recorrer los arreglos mayores y menores
            for(int i = 0; i < n; i++){ //Recorre el arreglo A
                if(arregloA[i] > media ){
                    mayores[iMay++] = arregloA[i]; //Guarda el número mayor en el arreglo de mayores
                }else if (arregloA[i] < media){
                    menores[iMen++] = arregloA[i]; //Guarda el número menor en el arreglo de menores
                }
            }

         //Mostrar resultados 
         System.out.println("Media = " +media); //Imprime el valor de la media

         System.out.print("Arreglo de mayores = ");
         for(int i = 0; i< mayores.length; i++) { //Recorre el arreglo de mayores
            System.out.print(mayores[i] + " "); //Imprime cada número mayor en la misma línea
         }
         System.out.println();

         System.out.print("Arreglo de menores = ");
         for(int i = 0; i < menores.length; i++) { //Recorre el arreglo de menores
            System.out.print(menores[i] + " "); //Imprime cada número menor en la misma línea
         }
        System.out.println();
        teclado.close(); //Cierra el objeto Scanner

    }
}