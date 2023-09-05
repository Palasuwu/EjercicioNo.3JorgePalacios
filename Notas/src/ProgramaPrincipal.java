// Jorge Palacios Ejercicio No.3
//Problema con clase sede y Main  
import java.util.Scanner;

public class ProgramaPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SedeUniversitaria sede = new SedeUniversitaria("Sede Principal");

        while (true) {
            System.out.println("\nMenú Principal:");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Ingresar Notas");
            System.out.println("3. Revisar Notas de Estudiantes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombreEstudiante = scanner.nextLine();
                    System.out.print("Ingrese la edad del estudiante: ");
                    int edadEstudiante = scanner.nextInt();

                    Estudiante nuevoEstudiante = new Estudiante(nombreEstudiante, edadEstudiante);
                    sede.registrarEstudiante(nuevoEstudiante);
                    System.out.println("Estudiante agregado exitosamente.");
                    break;

                case 2:
                    scanner.nextLine(); 
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombreEstudianteNotas = scanner.nextLine();
                    Estudiante estudianteNotas = sede.buscarEstudiante(nombreEstudianteNotas);

                    if (estudianteNotas != null) {
                        System.out.print("Ingrese la nota del estudiante " + estudianteNotas.getNombre() + ": ");
                        double nota = scanner.nextDouble();

                        Examen nuevoExamen = new Examen("Examen", nota);
                        sede.registrarResultadoExamen(estudianteNotas, nuevoExamen);
                        System.out.println("Nota ingresada exitosamente.");
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 3:
                    scanner.nextLine(); 
                    System.out.print("Ingrese el nombre del estudiante para revisar sus notas: ");
                    String nombreEstudianteNotasConsulta = scanner.nextLine();
                    Estudiante estudianteConsulta = sede.buscarEstudiante(nombreEstudianteNotasConsulta);

                    if (estudianteConsulta != null) {
                        System.out.println("Notas de " + estudianteConsulta.getNombre() + ":");
                        for (Examen examen : estudianteConsulta.getExamenes()) {
                            System.out.println(examen.getNombre() + ": " + examen.getCalificacion());
                        }
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no valida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
}
