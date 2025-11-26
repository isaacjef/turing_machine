package src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
    /*
     *  Função principal de execução
     *
     */

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String diretorioJson = "tm_rule30.json";
        JSONObject jsonObject = new JSONObject();
        JSONParser parser = new JSONParser();
        ArrayList<NFA> listaNFA = new ArrayList<>();

        /*
         * Pensei de fazer assim pois dessa forma dá para tratar um possivel erro no diretório
         * fora da classe NFA.
         * Mas também é possivel criar a função dentro da classe NFA passando como parametro o
         * diretório do .json ao invés do JSONObject.
         */
        //System.out.print("\nInforme o diretório do JSON: ");
        //diretorioJson = sc.nextLine();

        try {
            Object objetoJSON = parser.parse(new FileReader(diretorioJson));
            JSONArray listaMTJsonArray = new JSONArray();
            
            if(objetoJSON instanceof JSONArray jSONArray) 
                listaMTJsonArray = jSONArray;

            else if(objetoJSON instanceof JSONObject jSONObject)
                listaMTJsonArray.add(jSONObject);
            
            // Itera JSONArray e converte em MT
            for (Object obj : listaMTJsonArray) {
                jsonObject = (JSONObject) obj;
                //System.out.println(jsonObject);
                //NFA nfaExemplo = new NFA();

                //nfaExemplo.NFAfromJSON(jsonObject);

                //listaNFA.add(nfaExemplo);
            }

            // ----------------------------- TESTES ------------------------------
            //ArrayList<String> teste_states = new ArrayList<>((JSONArray) jsonObject.get("states"));
            //System.out.print(teste_states);

            ArrayList<String> transiction = new ArrayList<>((JSONArray) jsonObject.get("transiction"));
            //Object teste = jsonObject.get("transiction");

            // Map<String, Map<String, List<String>>> map = new HashMap<>();
            // Map<String, List<String>> i_map = new HashMap<>();
            // for (Object objRegra : transiction) {
    
            //     JSONObject regra = (JSONObject) objRegra;
            //     String state = regra.get("initial").toString();
            //     String symbol = regra.get("symbol").toString();
            //     ArrayList<String> in_tape = new ArrayList<>();
            //     in_tape.add(regra.get("end").toString());
            //     in_tape.addAll((ArrayList<String>) regra.get("in_tape"));
            //     in_tape.addAll((ArrayList<String>) regra.get("out_tape"));

            //     i_map.put(symbol, in_tape);
            //     map.put(state, i_map);

            //     System.out.println(map.get("q1"));
            //     System.out.println(state);
            //     //System.out.println(symbol);
            //     System.out.println(in_tape.get(2));
            // }


            JSONArray movArray = (JSONArray) jsonObject.get("transiction");
            TuringMachine mt = new TuringMachine();
            //System.out.println(mt.define_transiction(movArray));
            mt.finite_control(movArray, "0");
            //mt.setInput_symbols((JSONArray) jsonObject.get("input_symbols"));
            //System.out.print(mt.getInput_symbols());

            //transiction.forEach(s -> {
            //    System.out.println(s);
            //});

            for(int i=0; i < listaNFA.size(); i++){
                System.out.printf("\n========= NFA %d =========\n", i+1);
                System.out.print(listaNFA.get(i));
            }

        } catch (FileNotFoundException f) {

            System.out.print("O diretório: \"" + diretorioJson + "\" não foi encontrado.\n" +
            "Deseja tentar outro? (S | N): ");
            
            switch (sc.nextLine().toUpperCase()) {
                case "S" -> {
                    //Chamada para recomeçar programa
                    System.out.print("\nRecomeçando programa...\n");
                    System.out.println();
                    main(args);
                }
                case "N" -> {
                    System.out.print("\n      FIM!         \n");
                    System.out.println("      ^.^ bye!         ");
                }
                default -> {
                    System.out.print("\nOpção não existente!\n");
                    System.out.println("      ^.^ bye!         ");
                    //main(args);
                }
            } 
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nMensagem de erro: " + e.getMessage() +" \nNão é um arquivo de json válido!");
            System.out.printf("O formato do \"%s\" não segue o padrão estabelecido\n\n", diretorioJson);
        } catch (IOException e) {
            System.out.print("Erro de entrada! -> " + e);
        } catch (ParseException e) {
            System.out.print("Erro na conversão do arquivo! Arquivo JSON inválido! -> " + e);
        //} catch (ClassCastException e) {
            //System.out.print("Erro na conversão do arquivo! Algum campo do arquivo não segue o padrão definido. -> " + e);
        //}catch (Exception e) {
           // System.out.print("Não sei qual erro!");
        } finally {
            sc.close(); 
        }
    }
}
