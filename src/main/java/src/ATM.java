package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract  class ATM {

    private ArrayList<String> states = new ArrayList<>();
    private ArrayList<String> input_symbols = new ArrayList<>();
    private ArrayList<String> tape_symbols = new ArrayList<>();
    private String initial_state;
    private String blank_symbol;
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

    public ArrayList<String> getInput_symbols() {
        return new ArrayList<>(this.input_symbols);
    }

    public void setInput_symbols(Object input_symbols) {
        if (input_symbols instanceof List) {
            ArrayList<?> i_symbols = (ArrayList<?>) input_symbols;
            int cont = 0;
            for (Object percorrer : i_symbols) {
                if (percorrer instanceof String) {
                    cont++;
                } else {
                    throw new IllegalArgumentException("Símbolo(s) de entrada inválido(s)! Não são do tipo String. ");
                }
            }

            if (cont == i_symbols.size()) {
                this.input_symbols = (ArrayList<String>) i_symbols;
            }
        } else {
            throw new IllegalArgumentException("Alfabeto inválido!  ");
        }
    }

    public ArrayList<String> getTape_symbols() {
        return new ArrayList<>(this.tape_symbols);
    }

    public void setTape_symbols(Object tape_symbols) {
        if (tape_symbols instanceof List) {
            ArrayList<?> t_symbols = (ArrayList<?>) tape_symbols;
            int cont = 0;
            for (Object percorrer : t_symbols) {
                if (percorrer instanceof String) {
                    cont++;
                } else {
                    throw new IllegalArgumentException("Símbolo(s) de entrada inválido(s)! Não são do tipo String. ");
                }
            }

            if (cont == t_symbols.size()) {
                this.tape_symbols = (ArrayList<String>) t_symbols;
            }
        } else {
            throw new IllegalArgumentException("Alfabeto inválido!  ");
        }
    }

    public String getInitial_state() {
        return "" + this.initial_state;
    }

    public void setInitial_state(Object initial_state) {
        if (initial_state instanceof String i_state) {
            if (this.getStates().contains(i_state)) {
                this.initial_state = i_state;
            } else {
                throw new IllegalArgumentException("Estado inicial não existente na MT! ");
            }
        } else {
            throw new IllegalArgumentException("Estado inicial inválido! Não é do tipo String. ");
        }
    }

    public String getBlank_symbol() {
        return "" + this.blank_symbol;
    }

    public void setBlank_symbol(Object blank_symbol) {
        if (blank_symbol instanceof String symbol) {
            if (this.getTape_symbols().contains(symbol)) {
                this.blank_symbol = symbol;
            } else {
                throw new IllegalArgumentException("Símbolo branco não existente na MT! ");
            }
        } else {
            throw new IllegalArgumentException("Símbolo branco inválido! Não é do tipo String. ");
        }
    }

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