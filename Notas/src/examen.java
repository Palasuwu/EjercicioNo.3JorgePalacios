import java.util.ArrayList;
import java.util.List;

class Examen {
    private String nombreExamen;
    private List<Integer> resultados;

    public Examen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
        this.resultados = new ArrayList<>();
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public List<Integer> getResultados() {
        return resultados;
    }

    public void agregarResultado(int resultado) {
        resultados.add(resultado);
    }
}
