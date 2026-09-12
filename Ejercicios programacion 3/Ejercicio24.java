import java.util.Scanner;
public class Ejercicio24 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Meses del año en un arreglo
        String [] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto",
                         "Septiembre", "Octubre", "Noviembre", "Diciembre"};
         
         //Matriz de produccion: 12 meses y 4 cereales      
         int[][] produccion = new int [12][4];
         
         //Ingreso de datos de produccion
         System.out.println("Ingrese la produccion (en toneladas) de arroz, avena, cebada y trigo para cada mes: ");
         for(int i = 0; i< 12; i++){   //Recorre los  12 meses
            System.out.println("\nMes: " + meses[i]);

            for(int j = 0; j < 4; j++) { //Recorre los  4 cereales
                produccion[i][j] = teclado.nextInt(); //Guarda el valor ingresado
            }
         }

         //Produccion total por mes
         int[] totalMes =  new int[12]; //Vector para guardarla suma de cada mes
         int sumaAnual = 0;   //Variable para acumular la produccion total del año
         
         for(int i = 0; i < 12; i++){ 
            int sumaMes = 0; //inicia la suma del mes en 0

            for(int j = 0; j < 4; j++) {
                sumaMes += produccion[i][j]; //Suma la produccion de los 4 cereales en el mes
            }
            totalMes[i] = sumaMes; //Guarda la suma mensual
            sumaAnual += sumaMes; //Acumula el total por año
           }

           //Promedio Anual
           double promedioAnual = (double) sumaAnual /12;  //calcula el promedio dividiendo la produccion total entre 12 meses

           //Contadores de meses superiores e inferiores superiores al promedio
           int mesesSuperirores = 0, mesesInferiores =0;

           for(int i = 0; i < 12; i++){
            if(totalMes[i] > promedioAnual){
                mesesSuperirores++; //cuenta meses con produccion superior al promedio

            }else if (totalMes[i]< promedioAnual){
                mesesInferiores++; //cuenta meses con produccion inferior al promedio
            }
           }

           //Encontrar el mes con mayor produccion
           int mayorProduccion = totalMes[0]; //Inicia con el primer mes
           int mesMayor = 0; //Guarda el indice del mes con mayor produccion 

           for(int i = 1; i < 12; i++){
            if(totalMes[i] > mayorProduccion){
                mayorProduccion = totalMes[i]; //Actualiza  el valor maximo
                mesMayor = i; //Guarda el valor del mes con la mayor produccion
            }
           }

           //Mostramos resultados
           System.out.println("\nResultados: ");
           System.out.println("Promedio anual de toneladas cosechadas: " + promedioAnual);
           System.out.println("Meses con cosecha superior al promedio: " +  mesesSuperirores);
           System.out.println("Meses con cosecha inferior al promedio: " + mesesInferiores);
           System.out.println("Mes con mayor produccion: " + meses[mesMayor] + " (" + mayorProduccion + " toneladas)");

           teclado.close();


    }
}