import java.util.Stack;
import java.util.Scanner;

//X una cadena de caracteres
//Y la cadena inversa de X
//& el separador

public class Problema92 {

   public static void main(String[] args) {

      Scanner teclado = new Scanner(System.in);
      System.out.println("Escribe la cadena para con la forma X&Y (ejemplo hola&aloh)");

      // Leemos lo que escribio el usuario y lo guardamos
      String cadena = teclado.nextLine();

      Stack<Character> pila = new Stack<>(); // Pila donde se gurdara los caracteres de X

      // true = leyendo X, false = ya estamos leyendo Y
      boolean leyendoX = true;

      boolean HaySeparador = false; // Guardara si aparecio el &

      // asumimos que es valida si algo falla pasamos a false
      boolean EsValida = true;

      // Para recorrer la cadena desde posicion 0 hasta la ultima
      for (int i = 0; i < cadena.length(); i++);{
         
      //char c = cadena.charAt(i);

      }

   }

}
