import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SedeUniversitaria {
    private String nombreSede;
    private List<Estudiante> estudiantes;
    private List<Examen> resultadosExamenes;

    public SedeUniversitaria(String nombreSede) {
        this.nombreSede = nombreSede;
        this.estudiantes = new ArrayList<>();
        this.resultadosExamenes = new ArrayList<>();
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public List<Examen> getResultadosExamenes() {
        return resultadosExamenes;
    }

    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void registrarResultadoExamen(Examen examen) {
        resultadosExamenes.add(examen);
    }

    public void calcularEstadisticas() {
        if (resultadosExamenes.isEmpty()) {
            System.out.println("No hay resultados de exámenes para calcular estadísticas.");
            return;
        }

        // Calcular promedio, mediana, moda y desviación estándar
        List<Integer> resultadosTotales = new ArrayList<>();
        for (Examen examen : resultadosExamenes) {
            resultadosTotales.addAll(examen.getResultados());
        }

        int totalAlumnos = resultadosTotales.size();
        double promedio = resultadosTotales.stream().mapToDouble(Integer::doubleValue).average().orElse(0);
        double mediana = calcularMediana(resultadosTotales);
        int moda = calcularModa(resultadosTotales);
        double desviacionEstandar = calcularDesviacionEstandar(resultadosTotales, promedio);

        System.out.println("Estadísticas para " + nombreSede);
        System.out.println("Total de estudiantes: " + totalAlumnos);
        System.out.println("Promedio de resultados: " + promedio);
        System.out.println("Mediana de resultados: " + mediana);
        System.out.println("Moda de resultados: " + moda);
        System.out.println("Desviación estándar de resultados: " + desviacionEstandar);
    }

    private double calcularMediana(List<Integer> resultados) {
        Collections.sort(resultados);
        int n = resultados.size();
        if (n % 2 == 0) {
            return (resultados.get(n / 2 - 1) + resultados.get(n / 2)) / 2.0;
        } else {
            return resultados.get(n / 2);
        }
    }

    private int calcularModa(List<Integer> resultados) {
        int moda = 0;
        int maxFrecuencia = 0;
        for (int num : resultados) {
            int frecuencia = Collections.frequency(resultados, num);
            if (frecuencia > maxFrecuencia) {
                moda = num;
                maxFrecuencia = frecuencia;
            }
        }
        return moda;
    }

    private double calcularDesviacionEstandar(List<Integer> resultados, double promedio) {
        double sumaCuadrados = 0;
        for (int num : resultados) {
            sumaCuadrados += Math.pow(num - promedio, 2);
        }
        double varianza = sumaCuadrados / resultados.size();
        return Math.sqrt(varianza);
    }
}
