public class MatricesA2 {
    public static void main (String [] args) {
     
            //Declaracion de una matriz 3x3 (FORMA 1)
            int[][] m = {{5, 8, 6},
                         {1, 3, 2},
                         {4, 9, 7}};
    
        //Recorrer la matriz
       for(int i = 0; i < m.length;i++){ //m.length -> Siempre para recorrer filas
        for(int j = 0; j < m [0].length; j++){ //m[0].length -> Siempre sera para recorrer las columnas

            System.out.println("m["+i+"]["+j+"]= "+m[i][j]);
         
        } 
       }
             
      //Visualizar de mejor manera la matriz
      String cad =""; 
     
      for(int i = 0; i < m.length;i++){ //m.length -> Siempre para recorrer filas
        for(int j = 0; j < m [0].length; j++){ //m[0].length -> Siempre sera para recorrer las columnas
            cad += "|"+m[i][j];        
        } 
          cad+="| \n";
       }
       System.out.println(cad);

    }
}