package src;

import java.util.ArrayList;
import java.util.List;

public class Resultados {

    private String resumoTuringmachine;
    private TuringMachine turingMachine;
    private String resultadoResumo;
    private List<String> resultadoOutCompleted;
    private List<String> resultadoStep;

    public List<String> getResultadoStep() {
        return resultadoStep;
    }

    public void setResultadoStep(List<String> resultadoStep) {
        this.resultadoStep = resultadoStep;
    }

    public Resultados() {

    }

    public String getResumoTuringmachine() {
        return this.resumoTuringmachine;
    }

    public void setResumoTuringmachine(String resumoTuringmachine) {
        this.resumoTuringmachine = resumoTuringmachine;
    }

    public TuringMachine getTuringMachine() {
        return this.turingMachine;
    }

    public void setTuringMachine(TuringMachine turingMachine) {
        this.turingMachine = turingMachine;
    }

    public List<String> getResultadoOutCompleted() {
        return this.resultadoOutCompleted;
    }

    public void setResultadoOutCompleted(List<String> resultadoOutCompleted) {
        this.resultadoOutCompleted = resultadoOutCompleted;
    }

    public String getResultadoResumo() {
        return this.resultadoResumo;
    }

    public void setResultadoResumo(String resultadoResumo) {
        this.resultadoResumo = resultadoResumo;
    }

    public void setResultadoResumo(List<String> lista) {

        List<String> aux = new ArrayList<>();

        lista.forEach(entry -> {
            aux.add(" Out: " + entry);
        });

        this.resultadoResumo = String.join("\n", aux);

    }

    public void setResultadoStep() {
        this.resultadoStep = new ArrayList<>();
        this.resultadoStep = this.getTuringMachine().steps_saida();
    }
}
