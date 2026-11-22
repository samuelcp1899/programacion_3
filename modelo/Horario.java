package modelo;

// Esta clase administra la disponibilidad de un horario semanal.
public class Horario {

    // Matriz que representa 7 dias y 24 horas por cada dia.
    // Primera posicion: dia de la semana.
    // Segunda posicion: hora del dia.
    // false = horario disponible.
    // true = horario ocupado.
    private boolean[][] horasOcupadas;

    // Arreglo con los nombres de los dias.
    // Permite mostrar el nombre del dia en lugar de mostrar solo un numero.
    private String[] nombresDias;

    // Constructor.
    public Horario() {

        // Se crea una matriz de 7 dias y 24 horas.
        // Todas las posiciones comienzan automaticamente en false.
        this.horasOcupadas = new boolean[7][24];

        // Arreglo estatico con los nombres de los 7 dias.
        this.nombresDias = new String[7];

        nombresDias[0] = "Lunes";
        nombresDias[1] = "Martes";
        nombresDias[2] = "Miercoles";
        nombresDias[3] = "Jueves";
        nombresDias[4] = "Viernes";
        nombresDias[5] = "Sabado";
        nombresDias[6] = "Domingo";
    }

    // Reserva una hora específica de un dia.
    public boolean reservarHorario(int dia, int hora) {

        // Comprueba que el dia ingresado se encuentre entre 1 y 7.
        if (dia < 1 || dia > 7) {
            System.out.println("El dia debe estar entre 1 y 7");
            return false;
        }

        // Comprueba que la hora se encuentre entre 0 y 23.
        if (hora < 0 || hora > 23) {
            System.out.println("La hora debe estar entre 0 y 23");
            return false;
        }

        // Se resta 1 al dia porque los arreglos empiezan en la posicion 0.
        int posicionDia = dia - 1;

        // Comprueba si el horario ya se encuentra ocupado.
        if (horasOcupadas[posicionDia][hora]) {
            System.out.println("El horario ya se encuentra ocupado");
            return false;
        }

        // Cambia el estado del horario de false a true.
        horasOcupadas[posicionDia][hora] = true;

        System.out.println(
                "Horario reservado: "
                + nombresDias[posicionDia]
                + " a las " + hora + ":00"
        );

        return true;
    }

    // Libera una hora que estaba reservada.
    public boolean liberarHorario(int dia, int hora) {

        // Comprueba que el dia se encuentre entre 1 y 7.
        if (dia < 1 || dia > 7) {
            System.out.println("El dia debe estar entre 1 y 7");
            return false;
        }

        // Comprueba que la hora se encuentre entre 0 y 23.
        if (hora < 0 || hora > 23) {
            System.out.println("La hora debe estar entre 0 y 23");
            return false;
        }

        int posicionDia = dia - 1;

        // Si la posicion contiene false, el horario ya estaba disponible.
        if (!horasOcupadas[posicionDia][hora]) {
            System.out.println("El horario ya se encuentra disponible");
            return false;
        }

        // Cambia el horario de ocupado a disponible.
        horasOcupadas[posicionDia][hora] = false;

        System.out.println(
                "Horario liberado: "
                + nombresDias[posicionDia]
                + " a las " + hora + ":00"
        );

        return true;
    }

    // Consulta si una hora esta disponible.
    public boolean estaDisponible(int dia, int hora) {

        // Si los datos son incorrectos, retorna false.
        if (dia < 1 || dia > 7 || hora < 0 || hora > 23) {
            return false;
        }

        int posicionDia = dia - 1;

        // El signo ! invierte el valor booleano.
        // Si la posicion contiene false:
        // !false produce true, por lo tanto esta disponible.
        // Si la posicion contiene true:
        // !true produce false, por lo tanto esta ocupada.
        return !horasOcupadas[posicionDia][hora];
    }

    // Muestra el estado de todas las horas de un dia.
    public void mostrarHorarioDia(int dia) {

        // Comprueba que el dia exista.
        if (dia < 1 || dia > 7) {
            System.out.println("El dia debe estar entre 1 y 7");
            return;
        }

        int posicionDia = dia - 1;

        System.out.println(
                "===== HORARIO DEL "
                + nombresDias[posicionDia].toUpperCase()
                + " ====="
        );

        // Recorre las 24 horas del dia seleccionado.
        for (int hora = 0; hora < 24; hora++) {

            // Comprueba el estado de cada hora.
            if (horasOcupadas[posicionDia][hora]) {

                System.out.println(
                        hora + ":00 - Ocupado"
                );

            } else {

                System.out.println(
                        hora + ":00 - Disponible"
                );
            }
        }
    }

    // Muestra solamente las horas ocupadas de toda la semana.
    public void mostrarHorariosOcupados() {

        // Permite saber si se encontro al menos una reserva.
        boolean encontroReserva = false;

        System.out.println("===== HORARIOS OCUPADOS =====");

        // Recorre los 7 dias.
        for (int dia = 0; dia < horasOcupadas.length; dia++) {

            // Recorre las 24 horas de cada dia.
            for (int hora = 0;
                    hora < horasOcupadas[dia].length;
                    hora++) {

                // Solo muestra las posiciones ocupadas.
                if (horasOcupadas[dia][hora]) {

                    System.out.println(
                            nombresDias[dia]
                            + " - " + hora + ":00"
                    );

                    encontroReserva = true;
                }
            }
        }

        // Se ejecuta si todas las posiciones estaban en false.
        if (!encontroReserva) {
            System.out.println("No existen horarios ocupados");
        }
    }

    // Retorna la matriz completa de horarios.
    public boolean[][] getHorasOcupadas() {
        return horasOcupadas;
    }
}