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

      // toma cada caracter de la cadena uno por uno y lo guarda en c

      for (char c : cadena.toCharArray()) {

         // si estamos Leyendo X

         if (leyendoX) {

            if (c == '&') {

               leyendoX = false; // X termino ahora viene Y

               HaySeparador = true; // anota si hubo separador

            } else { // si NO es el separador

               pila.push(c); // guardamos el caracter en la pila
            }

         } else { // si estamos leyendo Y

            if (pila.empty()) {

               EsValida = false; // Y es mas larga que X, NO cumple

               break; // salimos de for, ya no hace falta seguir
            }

            // sacamos el ultimo caracter que entro en la pila

            char tope = pila.pop();

            // si es distinto al caracter actual Y

            if (tope != c) {

               EsValida = false; // Y no es la inversa X, NO cumple

               break;
            }

         }
      }

      //debe haber aparecido el & y la pila debe estar vacia

      //si sobran caracteres en la pila, X era mas larga que Y

      if(!HaySeparador || !pila.empty()) {
         
         EsValida = false; //NO cumple
      }

      //Mostramos el  resultado

      if(EsValida) {
         System.out.println("SI tiene  la forma X&Y");
      
      } else{
         System.out.println("NO tiene la forma X&Y");
      }

      teclado.close();

   }

}
