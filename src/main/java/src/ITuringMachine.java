package src;

import java.util.ArrayList;

public interface ITuringMachine {
    public ArrayList<String> getStates();
    public void setStates(Object param);

    public ArrayList<String> getInput_symbols();
    public void setInput_symbols(Object param);

    public ArrayList<String> getTape_symbols();
    public void setTape_symbols(Object param);

    public String getInitial_state();
    public void setInitial_state(Object param);

    public String getBlank_symbol();
    public void setBlank_symbol(Object param);

    public ArrayList<String> getEnd_states();
    public void setEnd_states(Object param);

    //public Map<String, Map<String, List<String>>> getTransiction();
    //public void setTransiction(Map<String, Map<String, List<String>>> param);
}