package src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

    //public static TuringMachine 
    //String[] args
    //public static List<Object> abrir() throws IOException, org.json.simple.parser.ParseException {
    /*public static void main(String[] args) throws IOException, org.json.simple.parser.ParseException {
        Scanner sc = new Scanner(System.in);
        String diretorioJson = "tm_rule30.json";
        JSONObject jsonObject = new JSONObject();
        JSONParser parser = new JSONParser();

        Object objetoJSON = parser.parse(new FileReader(diretorioJson));
        JSONArray listaMTJsonArray = new JSONArray();
        listaMTJsonArray.add(objetoJSON);

        for (Object obj : listaMTJsonArray) {
            jsonObject = (JSONObject) obj;
        }

        TuringMachine mt = new TuringMachine();
        mt.MTfromJSON(jsonObject);
        //JSONArray movArray = (JSONArray) jsonObject.get("transiction");

        mt.finite_control(mt, "0011001000100");
        //System.out.println(mt.toString());

        List<Object> retorno = new ArrayList<>();
        retorno.add(mt.toString());
        retorno.add(new TuringMachine());
        //return retorno;

        //System.out.print("\nInforme o diretório do JSON: ");
        //diretorioJson = sc.nextLine();
        /*try {
            Object objetoJSON = parser.parse(new FileReader(diretorioJson));
            JSONArray listaMTJsonArray = new JSONArray();

            if (objetoJSON instanceof JSONArray jSONArray) {
                listaMTJsonArray = jSONArray; 
            }else if (objetoJSON instanceof JSONObject jSONObject) {
                listaMTJsonArray.add(jSONObject);
            }

            // Itera JSONArray e converte em MT
            for (Object obj : listaMTJsonArray) {
                jsonObject = (JSONObject) obj;

                //NFA nfaExemplo = new NFA();
                //nfaExemplo.NFAfromJSON(jsonObject);
                //listaNFA.add(nfaExemplo);
            }

            // ----------------------------- TESTES ------------------------------
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
            //String state = jsonObject.get("initial_state").toString();
            JSONArray movArray = (JSONArray) jsonObject.get("transiction");
            TuringMachine mt = new TuringMachine();
            mt.MTfromJSON(jsonObject);
            //mt.finite_control(movArray, "000100");


            //transiction.forEach(s -> {
            //    System.out.println(s);
            //});
            ArrayList<Object> teste = new ArrayList<>();
            //teste.add("0");
            //teste.add(mt);

            System.out.print(mt.toString());
<<<<<<< Updated upstream
=======

            return new ArrayList<Object>(List.of("0", mt));
            //for (int i = 0; i < listaNFA.size(); i++) {
               //System.out.printf("\n========= NFA %d =========\n", i + 1);
                //System.out.print(listaNFA.get(i));
            //}
>>>>>>> Stashed changes

        } catch (FileNotFoundException f) {

            System.out.print("O diretório: \"" + diretorioJson + "\" não foi encontrado.\n"
                    + "Deseja tentar outro? (S | N): ");

            switch (sc.nextLine().toUpperCase()) {
                case "S" -> {
                    System.out.print("\nRecomeçando programa...\n");
                    System.out.println();
                    //main(args);
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
            System.out.println("\nMensagem de erro: " + e.getMessage() + " \nNão é um arquivo de json válido!");
            System.out.printf("O formato do \"%s\" não segue o padrão estabelecido\n\n", diretorioJson);
        } catch (IOException e) {
            System.out.print("Erro de entrada! -> " + e.getMessage());
        } catch (ParseException e) {
            System.out.print("Erro na conversão do arquivo! Arquivo JSON inválido! -> " + e);
        } catch (ClassCastException e) {
            System.out.print("Erro na conversão do arquivo! Algum campo do arquivo não segue o padrão definido. -> " + e);
        } catch (Exception e) {
            System.out.print("Generic Exception! + " + e.getMessage());
        } finally {
            sc.close();
        }
    }*/

    public static List<Object> abrir() {
        Scanner sc = new Scanner(System.in);
        String diretorioJson = "tm_rule30.json";
        JSONObject jsonObject = new JSONObject();
        JSONParser parser = new JSONParser();
        List<Object> retorno = new ArrayList<>();

        try {
            Object objetoJSON = parser.parse(new FileReader(diretorioJson));
            JSONArray listaMTJsonArray = new JSONArray();

            if (objetoJSON instanceof JSONArray jSONArray) {
                listaMTJsonArray = jSONArray; 
            }else if (objetoJSON instanceof JSONObject jSONObject) {
                listaMTJsonArray.add(jSONObject);
            }

            // Itera JSONArray e converte em MT
            for (Object obj : listaMTJsonArray) {
                jsonObject = (JSONObject) obj;
            }
            
            TuringMachine mt = new TuringMachine();
            mt.MTfromJSON(jsonObject);

            retorno.add(mt.toString());
            retorno.add(mt);

            return retorno;

        } catch (FileNotFoundException f) {
            System.out.print("O diretório: \"" + diretorioJson + "\" não foi encontrado.\n"
                + "Deseja tentar outro? (S | N): ");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nMensagem de erro: " + e.getMessage() + " \nNão é um arquivo de json válido!");
            System.out.printf("O formato do \"%s\" não segue o padrão estabelecido\n\n", diretorioJson);
        } catch (IOException e) {
            System.out.print("Erro de entrada! -> " + e);
        } catch (ParseException e) {
            System.out.print("Erro na conversão do arquivo! Arquivo JSON inválido! -> " + e);
        } catch (Exception e) {
            System.out.print("Não sei qual erro!");
        } finally {
            sc.close();
        }
        return retorno;
    }
}
