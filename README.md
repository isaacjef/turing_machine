# 🚀 Conversor_NFA_em_DFA
Objetivo: 
- Desenvolver uma Máquina de Turing teórica que aplica a Regra 30 (Rule30) a uma fita.
- Desenvolver um código que receba um arquivo JSON representando uma Máquina de Turing, contendo o alfabeto, estados e transições da Máquina. O código também pode receber uma fita (entrada), e através da função de transição da Máquina de Turing convertida, deve devolver um saída.
- O código deve ser bem estruturado, e as saídas devem estar de acordo com o padrão teórico. Ex: (q0, 0) -> (q1, X, R)    

> MAVEN

> Dependência utilizada: com.googlecode.json-simple

<img width="392" height="178" alt="image" src="https://github.com/user-attachments/assets/ba0e3d3f-0db5-4bf6-b270-9edc8118c3ba" />

# 📜 Objetivos:
    [  ] **Criar conversor .json em MT; **
    [  ] **Criar classe para leitura das propriedades da Máquina de Turing;**
    [  ] **Criar método para leitura das fitas, de acordo com a MT**
    [  ] **c**
    [  ] **c**

# 💾 Status do prjeto
> :construction: Projeto finalizado :construction:

# 📦 Disposição do programa
     .
     ├── conversor_nfa_dfa
     │   └── src
     │       └── main
     │           └── java
     |                └── src
     |                    ├── AutomatoFinito.java
     |                    ├── DFA.java
     |                    ├── NFA.java
     |                    └── Main.java
     ├── target
     ├── README.md
     ├── pom.xml
     └── exemplo.json
        ├── blackjack_test.exs
        └── test_helper.exs
    
     .

# 🔧 Principais Funções

    Main.java
        → main(String[] args);
        Função de execução principal do programa;
        Recebe como entrada o diretório, nome do arquivo json lido e converte em objeto do tipo JSON.
    
    NFA.java
        → NFAfromJSON(JSONObject json);
        Converte um objeto do tipo JSON em um objeto da classe NFA.
    
    DFA.java
        → DFAfromNFA(NFA nfa);
        Converte um objeto da classe NFA em um objeto da classe DFA;
        Inlcui o passo a passo de conversão NFA em um DFA.
        
        → DFAtoJSON();
        Converte um DFA em um JSON;

# ✒️ Autores: 
| [<img src="https://avatars.githubusercontent.com/u/99749672?v=4" width=115><br><sub>Gabriel Alexandre</sub>](https://https://github.com/aieFaria) |  [<img src="https://lh3.googleusercontent.com/a-/ALV-UjUSbAUZs8fIDLpE2IxgftQvn59uYcg5JtGjnglwGdLloMGgyXM=s50-c-k-no" width=115><br><sub>Isaac Jerferson</sub>](https://github.com/guilhermeonrails) |  [<img src="https://avatars.githubusercontent.com/u/160502160?v=4" width=115><br><sub>Raislson Bernardo</sub>](https://github.com/alexfelipe) |
| :---: | :---: | :---: |


