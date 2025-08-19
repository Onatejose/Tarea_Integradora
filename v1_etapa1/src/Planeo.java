
import java.util.Scanner;
public class Planeo {
    // Variables para guardar la información del curso
    static String codigoCurso;
    static String nombreCurso;
    static int creditosCurso;
    static String profesorCurso;
    static String salonCurso;
    static boolean cursoRegistrado = false;
    static final Scanner lector = new Scanner(System.in);

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

    // Metodo principal que muestra el menu
    public static void main(String[] args) {
        // Menú principal
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
            if (opcion == 1 && !cursoRegistrado) {
                // Registrar curso si aún no ha sido registrado
                cursoRegistrado = registrarCurso();
            }else if (opcion == 1 && cursoRegistrado) {
                // Mensaje si el curso ya fue registrado
                System.out.println("El curso ya ha sido registrado."); 
            }else if (opcion == 2) {
            } else if (opcion == 3) {
            } else if (opcion == 4) {
            } else if (opcion == 5) {
            } else if (opcion == 6) {
                // Salida del menu
                System.out.println("Saliendo del sistema...");
                System.out.println("Gracias por usar PLANEO, hasta luego!");
            } else {
                // Opción inválida
                System.out.println("Opción inválida.");
            }
        }
        lector.close();

    }   
}
