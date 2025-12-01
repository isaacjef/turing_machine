package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public final class TuringMachine extends ATM {

    List<String> step = new ArrayList<>();

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

            List<String> movements = new ArrayList<>();

            for (Object mov : tuples) {
                // Verifica se mov é não nulo: []

                if (mov != null && !"null".equals(mov.toString())) {
                    movements.add(mov.toString());
                }
            }

            transiction.computeIfAbsent(initial, k -> new HashMap<>())
                .put(simbolo, movements);
        }

        return transiction;
    }

    public List<String> finite_control(TuringMachine mt, String input) {

        int i = 2;
        int ipt = input.length();
        List<String> saida = new LinkedList<>();

        String output = "" ;
        input = "##" + input + "##";
        String actual_state = this.getInitial_state();
        // A verificação sempre iniciará na posição 2 das strings: ##_...##
        char actual_symbol = input.charAt(i); // símbolo atual lido na fita de entrada

        Map<String, Map<String, List<String>>> transiction = mt.getTransiction();

        while (ipt != 0) {
            List<String> tuple = transiction.get(actual_state).get("" + actual_symbol);
            
            step.add(actual_symbol + "");
            step.add(actual_state);
            step.add(tuple.get(2)); // direção do movimento
            step.add(tuple.get(3)); // saída escrita na fita 2
            
            for (int j = 0; j <= 4; j++) {
                if (tuple.get(2).equals("L")) {
                    i -= 1;
                    actual_state = tuple.get(0);
                    actual_symbol = input.charAt(i);
                    tuple = transiction.get(actual_state).get("" + actual_symbol);
                } else {
                    i += 1;
                    actual_state = tuple.get(0);
                    actual_symbol = input.charAt(i);
                    tuple = transiction.get(actual_state).get("" + actual_symbol);
                }

                step.add(actual_symbol + "");
                step.add(actual_state);
                step.add(tuple.get(2)); // direção do movimento
                step.add(tuple.get(3));

                if ( !tuple.get(3).equals("#") ) {
                    output += tuple.get(3);
                } 
                
            }
            System.out.println("Ref " + output);
            
            output = saidaFormatada(input.length()-4, output.replace(" ", ""));

            saida.add(String.format("##%s##", output));
            ipt--;
        }

        return saida;
    }

    private String saidaFormatada(int tamanho, String output) {

        StringBuilder sb = new StringBuilder();

        if (tamanho <= output.length()) {
            return output;
        }

        int total = tamanho - output.length();
        int espacamento = total / 2;
        int espacamentoDireita = total - espacamento;

        for (int j=0; j<espacamento; j++) {
            sb.append(" ");
        }

        sb.append(output);

        for (int j=0; j<espacamentoDireita; j++) {
            sb.append(" ");
        }

        //sb = new StringBuilder();
        return sb.toString();
    }

    public List<String> steps_saida() {
        List<String> stepsFormatado = new ArrayList<>();
        System.out.println(this.step.size());
        //StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.step.size(); i+=4) {
            StringBuilder sb = new StringBuilder();

            // Caractere de entrada | Estado atual | Direção do movimento (Fita 1) | Símbolo escrito na fita de saída (Fita 2)
            sb.append("Passo " + (i/4 +1) + ":\n");
            sb.append(String.format("Símbolo Atual (F.1): %s \n", this.step.get(i)));
            sb.append(String.format("Estado: %s \n", this.step.get(i+1)));
            sb.append(String.format("Movimento (F.1): %s \n", this.step.get(i+2)));
            sb.append(String.format("Símbolo de Saída (F.2): %s \n", this.step.get(i+3)));

            stepsFormatado.add(sb.toString());
        }

        return stepsFormatado;
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

    public void setStep(List<String> steps) {
        this.step = steps;
    }

}
