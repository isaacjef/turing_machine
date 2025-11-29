package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public final class TuringMachine extends ATM {

    //private ArrayList<String> states = new ArrayList<>();
    //private ArrayList<String> input_symbols = new ArrayList<>();
    //private ArrayList<String> tape_symbols = new ArrayList<>();
    //private String initial_state = "";
    //private String blank_symbol = "";
    //private ArrayList<String> end_states = new ArrayList<>();
    //private Map<String, Map<String, List<String>>> transiction = new HashMap<>();

    public TuringMachine(ArrayList<String> states,
            ArrayList<String> input_symbols,
            ArrayList<String> tape_symbols,
            String initial_state,
            String blank_symbol,
            ArrayList<String> end_states,
            Map<String, Map<String, List<String>>> transiction) {
        setStates(states);
        setInput_symbols(input_symbols);
        setTape_symbols(tape_symbols);
        setInitial_state(initial_state);
        setBlank_symbol(blank_symbol);
        setEnd_states(end_states);
        setTransiction(transiction);
    }

    // Inicializar a MT vazia.
    public TuringMachine() {
    }

    /*
     * Função de conversão JSONObject para classe MT
     * @param JSONObject
     */
    public void MTfromJSON(JSONObject json) {

        // Caso de haver garantia na tipagem do json não se faz necessário corrigir
        List<String> chavestestar = Arrays.asList("states", "input_symbols", "tape_symbols", "initial_state", "blank_symbol", "end_states", "transiction");

        if (json.keySet().containsAll(chavestestar) && chavestestar.containsAll(json.keySet())) {
            try {
                setStates(new ArrayList<>((JSONArray) json.get("states")));
                setInput_symbols(new ArrayList<>((JSONArray) json.get("input_symbols")));
                setTape_symbols(new ArrayList<>((JSONArray) json.get("tape_symbols")));
                setInitial_state((String) json.get("initial_state"));
                setBlank_symbol((String) json.get("blank_symbol"));
                setEnd_states(new ArrayList<>((JSONArray) json.get("end_states")));
                setTransiction(define_transiction((JSONArray) json.get("transiction")));
            } catch (IllegalArgumentException e) {
                System.out.println("Erro na conversão do NFA -> " + e);

                // Inicializando NFA com valores vazios:
                setStates(new ArrayList<>());
                setInput_symbols(new ArrayList<>());
                setTape_symbols(new ArrayList<>());
                setInitial_state("");
                setBlank_symbol("");
                setEnd_states(new ArrayList<>());
                setTransiction(new LinkedHashMap<>());
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Map<String, Map<String, List<String>>> define_transiction(JSONArray jsonArray) {

        Map<String, Map<String, List<String>>> transiction = new LinkedHashMap<>();

        for (Object objRegra : jsonArray) {

            JSONObject regra = (JSONObject) objRegra;
            String initial = (String) regra.get("initial");
            String simbolo = (String) regra.get("symbol");
            String end = regra.get("end").toString();
            ArrayList<String> input_tape = (ArrayList<String>) regra.get("in_tape");
            ArrayList<String> output_tape = (ArrayList<String>) regra.get("out_tape");

            // tuple = [end, in_tape, out_tape] = ["q0", "0", "R", "#", "R"]
            ArrayList<String> tuples = new ArrayList<>();
            tuples.add(end);
            tuples.addAll(input_tape);
            tuples.addAll(output_tape);
            //System.out.println(tuples);

            List<String> movements = new ArrayList<>();

            for (Object mov : tuples) {
                // Verifica se mov é não nulo: []

                if (mov != null && !"null".equals(mov.toString())) {
                    movements.add(mov.toString());
                    //System.out.print("initial: " + initial + " | symbol: " + simbolo + " ");
                    //System.out.println("Movement ->" + movements);

                    //if(!this.getStates().contains((String) mov))
                    //throw new IllegalArgumentException("Estado(s) final(is) não está contido nos Estados do NFA. ");
                }
            }

            transiction.computeIfAbsent(initial, k -> new HashMap<>())
                .put(simbolo, movements);
        }

        return transiction;
    }

    // Finite control -> read_write_tape
    public void finite_control(JSONArray jsonArray, String input) {

        int i = 2;
        int ipt = input.length();

        String output = "" ;
        input = "##" + input + "##";
        String actual_state = this.getInitial_state();
        // A verificação sempre iniciará na posição 2 das strings: ##_...##
        char actual_symbol = input.charAt(i); // símbolo atual lido na fita de entrada

        Map<String, Map<String, List<String>>> transiction = define_transiction(jsonArray);

        while (ipt != 0) {
            String registro = "";
            // (q0, 1) -> ["q1", "1", "L", "#", "R"]
            List<String> tuple = transiction.get(actual_state).get("" + actual_symbol);
            //System.out.printf("(%s,%s) -> ", actual_state, actual_symbol);

            for (int j = 0; j <= 4; j++) {
                // L -> -1 ; R -> +1 ; Ex: ##0##
                if (tuple.get(2).equals("L")) {
                    i -= 1;
                    actual_state = tuple.get(0);
                    // #_0## ... ##_## ... ##0_#
                    actual_symbol = input.charAt(i);
                    tuple = transiction.get(actual_state).get("" + actual_symbol);
                } else {
                    i += 1;

                    actual_state = tuple.get(0);
                    actual_symbol = input.charAt(i);
                    tuple = transiction.get(actual_state).get("" + actual_symbol);
                }

                if (actual_state.equals("q6") || actual_state.equals("q13")) {
                    output += tuple.get(3);
                } else if (actual_state.equals("q7") || actual_state.equals("q14")) {
                    output += tuple.get(3);
                }
            }
            System.out.printf("(%s,%s) -> ", actual_state, actual_symbol);
            System.out.printf("Out: ##%s##", output);
            System.out.print("\n");
            ipt--;
        }

        //output = String.format("##%s##", output);
        //System.out.println("Out: " + output);
    }

        @Override
    public String toString() {

        StringBuilder text = new StringBuilder();

        text.append("========= Máquina de Turing =========\n");
        text.append("Estados: ").append(this.getStates()).append("\n");
        text.append("Símbolos de Entrada: ").append(this.getInput_symbols()).append("\n");
        text.append("Símbolos de fita: ").append(this.getTape_symbols()).append("\n");
        text.append("Transições:\n");
        text.append("-------------------------------------\n");
        /*
         * Aninha todos os pares ESTADO, SIMBOLO → ESTADOS de forma ter uma melhor visualização
         */ //.sorted(Map.Entry.comparingByKey())
        this.getTransiction().entrySet().stream()
        .forEach(entry -> {
            entry.getValue().entrySet().stream().sorted(Map.Entry.comparingByKey())
            .forEach(trans -> {
                String saida = trans.getValue().isEmpty() ? "null" : trans.getValue().toString();
                text.append(String.format("| (%s, %s) = %s\n", entry.getKey(), trans.getKey(), saida));});
        });
        text.append("\r-------------------------------------\n");
        text.append("Estado Inicial: ").append(this.getInitial_state()).append("\n");
        text.append("Símbolo branco: ").append(this.getBlank_symbol()).append("\n");
        text.append("Estados Finais: ").append(this.getEnd_states()).append("\n");        
        text.append("=====================================\n");

        return text.toString();
    }
}
