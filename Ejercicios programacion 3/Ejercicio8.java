import java.util.Random;

public class Ejercicio8 {

    public static void main(String[] args) {
        
   Random random = new Random(); //Creamos el objeto para generar numeros random
   int [] numeros = new int[30]; //Crea un arreglo de 30 posiciones

 //Para generar 30 numeros aleatorios 
 for(int i = 0; i < numeros.length; i++) { //Recorre  todas las posiciones del arreglo
   numeros[i] = random.nextInt(30) + 1; //genera numeros aleatorios entre 1 y 30
   }

   //se muestra el arreglo
   System.out.println("Arreglo generado: ");

   for(int i =0; i < numeros.length; i++){ //Recorre el arreglo y muestra los numeros generados
   System.out.print(numeros[i] + " "); //imprime el numero de cada arreglo 
   }

  int mayor = numeros [0]; //Toma el primer numero del arreglo como valor inicial mayor
  int menor = numeros [0]; //Toma el primer numero del arreglo como valor inicial menor

  //Buscar mayor y menor
  for(int i = 1; i < numeros.length; i++){ //Recorre el arreglo desde la 2 posicion para buscar el numero mayor y menor
     
    if(numeros[i] > mayor ){ //Verifica si el numero actual es mayor que el mayor encontrado hasta el momento
      mayor = numeros[i]; //Actualiza el valor del numero mayor
    }

    if(numeros[i] < menor){ //Verifica si el numero actual es menor que el menor encontrado hasta el momento 
      menor = numeros[i]; //Actualiza el valor del  numero menor
    }
 }

   //contar repeticiones
   int repmayor = 0; //Contador que registra la cantidad de veces que aparece el numero mayor
   int repmenor = 0; //Contador del numero menor

   for(int i = 0; i < numeros.length; i++){ //Recorre nuevamente el arreglo para contar repeticiones
    if(numeros[i] == mayor) { //Compara si el elemento actual es igual que el mayor 
      repmayor++; //incrementa el contador de repeticiones
    }
  
    if(numeros [i] == menor){ //comprueba el numero actial 
      repmenor++; //incrementa el contador de repeticiones 
    }
  }

  
  System.out.println(" \n Numero mayor:" + mayor);
  System.out.println("Se repite: " + repmayor + "veces");

  
  System.out.println("\n Numero menor: " + menor);
  System.out.println("Se repite: " + repmenor + "veces");

    }
}
