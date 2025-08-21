import java.util.Scanner;
public class Planeo {
    // Variables globales para almacenar información del curso.
    static String codigoCurso;
    static String nombreCurso;
    static int creditosCurso;
    static String profesorCurso;
    static String salonCurso;
    static boolean cursoRegistrado = false; // La utilizare para validar si el curso ya fue registrado.
    static final Scanner lector = new Scanner(System.in);

    // Arreglos para almacenar datos de hasta 5 actividades, entre corchetes se indica el maximo de actividades.
    static String[] nombresActividades = new String[5];
    static String[] fechasActividades = new String[5];
    static int[] porcentajesActividades = new int[5];
    static double[] notasActividades = new double[5];
    static int actividadesRegistradas = 0; //Numero de actividades registradas, inicia en 0 para validar las siguientes opciones del menu.

    // Metodo para registrar curso
    public static boolean registrarCurso() {
            System.out.println("Ingrese el código del curso: ");
            codigoCurso = lector.nextLine();
            System.out.println("Ingrese el nombre del curso: ");
            nombreCurso = lector.nextLine();
            System.out.println("Ingrese el número de créditos: ");
            creditosCurso = lector.nextInt();
            lector.nextLine();
            System.out.println("Ingrese el nombre del profesor: ");
            profesorCurso = lector.nextLine();
            System.out.println("Ingrese el salón: ");
            salonCurso = lector.nextLine();
            System.out.println("Curso registrado exitosamente: " + nombreCurso);
            return true;
    }

// Metodo para asociar actividades al curso
public static void asociarActividades() {
    System.out.print("¿Cuántas actividades? (1-5): ");
    int numeroActividades = lector.nextInt();
    lector.nextLine();

    if (numeroActividades < 1 || numeroActividades > 5) {  //Validacion de entradas en el rango
        System.out.println("Dejbe ser entre 1 y 5.");
        return;
    }

    int total = 0; //Validacion de entradas de porcentajes sea 100%
    actividadesRegistradas = numeroActividades;
    for (int i = 0; i < numeroActividades; i++) {
        System.out.print("Nombre actvidad " + (i + 1) + ": ");
        nombresActividades[i] = lector.nextLine();
        System.out.print("Fecha (DD-MM-YYYY): ");
        fechasActividades[i] = lector.nextLine();
        System.out.print("Porcentaje (1-100): ");
        porcentajesActividades[i] = lector.nextInt();
        lector.nextLine();
        total += porcentajesActividades[i];
        System.out.println("Registrada '" + nombresActividades[i] + "' (" + fechasActividades[i] + ") " + porcentajesActividades[i] + "%.");
    }
    if (total != 100) {
        System.out.println("Error total: " + total + "%. Debe ser 100%.");
        actividadesRegistradas = 0; //Reinicia las actividades en caso de error
    } else {
        System.out.println("Actividades registradas.");
    }
}

// Metodo para cargar notas de actividades
public static void cargarNotas() {
    for (int i = 0; i < actividadesRegistradas; i++) {
        notasActividades[i] = -1; //Se inicia la nota en -1, mientras no se ingrese una nota
        System.out.print("Ingrese la nota para '" + nombresActividades[i] + "' (" + fechasActividades[i] + "): ");
        double nota = lector.nextDouble();
        lector.nextLine();
        if (nota < 0 || nota > 5) { //Validacion de entradas de notas
            System.out.println("Nota inválida. Debe estar entre 0 y 5.");
            i--; // Se resta para repetir la entrada de nota
        } else {
            notasActividades[i] = nota;
        }
    }
    System.out.println("Notas cargadas.");
}

// Metodo para visualizar actividades del curso
public static void visualizarActividades() {

    System.out.println("Actividades del curso '" + nombreCurso + "':");
    for (int i = 0; i < actividadesRegistradas; i++) {
        System.out.println((i + 1) + ". " + nombresActividades[i] +
            "Fecha: " + fechasActividades[i] +
            "Porcentaje: " + porcentajesActividades[i] + "%");
    }
    }

    // Menu principal
    public static void main(String[] args) {
        int opcion = 0;
        while (opcion != 6) {
            System.out.println("Bienvenido a PLANEO");
            System.out.println("1. Registrar curso");
            System.out.println("2. Asociar actividades al curso");
            System.out.println("3. Cargar notas de actividades");
            System.out.println("4. Visualizar actividades del curso");
            System.out.println("5. Consultar promedio del curso");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = lector.nextInt();
            lector.nextLine(); 
            if (opcion == 1 && !cursoRegistrado) {// Registrara UN curso si aún no hay alguno registrado
                cursoRegistrado = registrarCurso();
            }else if (opcion == 1 && cursoRegistrado) { // Mensaje si el curso ya fue registrado
                System.out.println("El curso ya ha sido registrado."); 
            }else if (opcion == 2 && cursoRegistrado) { //Permite asociar actividades al curso si ya fue registrado
                asociarActividades();
            } else if (opcion == 2 && !cursoRegistrado) {// Mensaje si no hay curso registrado
                System.out.println("No hay ningun curso registrado.");
            } else if (opcion == 3) {
                if (actividadesRegistradas > 0) { // Permite cargar notas si hay actividades registradas
                    cargarNotas();
                } else { 
                    System.out.println("No hay actividades registradas.");} // Mensaje si no hay actividades registradas
            } else if (opcion == 4) {
                if (actividadesRegistradas > 0){ // Permite visualizar actividades si hay actividades registradas
                    visualizarActividades();
                } else {
                    System.out.println("No hay actividades registradas."); // Mensaje si no hay actividades registradas
                }
            } else if (opcion == 5) {
            } else if (opcion == 6) {
                // Salida del menu
                System.out.println("Saliendo del sistema...");
                System.out.println("Gracias por usar PLANEO, hasta luego!");
            } else {
                // Mensaje en caso de que se ingrese una opción inválida
                System.out.println("Opción inválida.");
            }
        }
        lector.close();

    }
}   

