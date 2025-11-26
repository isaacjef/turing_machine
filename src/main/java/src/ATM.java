package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract  class ATM {

    private ArrayList<String> states = new ArrayList<>();
    private ArrayList<String> end_states = new ArrayList<>();
    private Map<String, Map<String, List<String>>> transiction = new HashMap<>();

    public ArrayList<String> getStates() {
        return new ArrayList<>(this.states);
    }

    public void setStates(Object states) {
        // Verifica se todos os elementos são do tipo String
        if (states instanceof List){
            ArrayList<?> states0 = (ArrayList<?>) states;
            int cont=0;
            for (Object percorrer : states0)
                if(percorrer instanceof String)
                    cont++;
            if(cont == states0.size())
                this.states = (ArrayList<String>) states0;
            else
                throw new IllegalArgumentException("Estado não é do tipo String!");
        } else {
            throw new IllegalArgumentException("Estado(s) inválido(s)! ");
        }
    }

    //public void setStates(Object param);

    //public ArrayList<String> getInput_symbols();
   // public void setInput_symbols(Object param);

    //public ArrayList<String> getTape_symbols();
    //public void setTape_symbols(Object param);

    //public String getInitial_state();
    //public void setInitial_state(Object param);

    //public String getBlank_symbol();
    //public void setBlank_symbol(Object param);

    public ArrayList<String> getEnd_states() {
        return new ArrayList<>(this.end_states);
    }

    public void setEnd_states(Object end_states) {
        if (end_states instanceof List){
            ArrayList<?> end_state0 = (ArrayList<?>) end_states;
            int cont=0;
            for (Object percorrer : end_state0)
                if(percorrer instanceof String string)
                    if(this.getStates().contains(string))
                        cont++;
            if(cont==end_state0.size()){
                this.end_states = (ArrayList<String>) end_state0;
            } else
                throw new IllegalArgumentException("Estados finais não contidos no conjunto de Estados!");
        } else {
            throw new IllegalArgumentException("Estado(s) final(is) inválido(s)! ");
        }
    }

    public Map<String, Map<String, List<String>>> getTransiction() {
        return this.transiction;
    }

    public void setTransiction(Map<String, Map<String, List<String>>> transiction) {
        this.transiction = transiction;
    }
}