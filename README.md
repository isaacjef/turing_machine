# Rule 30 - Turing Machine 

A Regra 30 é uma das regras elementares de autômatos celulares introduzidas por Stephen Wolfram em 1983 (Wolfram 1983, 2002). Ela especifica a próxima cor em uma célula, dependendo de sua cor e de suas células vizinhas imediatas. Além da definição formal da Máquina de Turing, sua descrição e diagrama, criamos este código em Java que implementa os mesmos passos da MT proposta. 
Dependência Maven utilizada: com.googlecode.json-simple.

# 📜 Objetivos:
>     [X] Criar conversor .json da MT teórica;
>     [X] **Criar classe para para tratar os dados da MT;**
>     [X] **Criar classe para implementação das propriedades da MT**
>     [X] **Criar um painel para exibição do programa**
>     [ ] **c**

<img width="392" height="178" alt="image" src="https://github.com/user-attachments/assets/ba0e3d3f-0db5-4bf6-b270-9edc8118c3ba" />

# ... Diagrama da Máquina

A máquina foi criada considerando que há 8 combinações possíveis na Regra 30, e dentre elas, notamos uma característica em específico: - a célula do meio quando é 0 "#0#", leva a dois estados 0 e dois 1, o mesmo ocorre com o 1. 
Pensando nisso, criamos a seguinte lógica: 
> - O controle finito lerá a primeira célula (caractere) da entrada,
> - Vai para a esquerda e lê o símbolo branco, volta para a primeira célula (direita), e avança para a direita duas vezes.
> - Por fim, retorna para a esquerda, exatamente uma célula à frente da primeira.
> - O processo é repetido até que o controle finito alcance dois símbolos brancos em sequência e vai para o estado final.

<img width="936" height="328" alt="image" src="https://github.com/user-attachments/assets/a1fe8a5f-1657-497f-ba28-7c558c8a9876" />
<img width="833" height="322" alt="image" src="https://github.com/user-attachments/assets/6770838b-aaa8-46e1-bf58-a96bdec6bbb9" />
<img width="369" height="88" alt="image" src="https://github.com/user-attachments/assets/7fdea16f-a4a4-4d9b-9b49-850c040fcd7e" />


# 📦 Disposição do programa
     .
     ├── turing_machine
     │   └── src
     │       └── main
     │           └── java
     |                └── src
     |                    ├── ATM.java
     |                    ├── App.java
     |                    ├── TuringMachine.java
     |                    └── Main.java
     ├── target
     ├── README.md
     ├── pom.xml
     └── tm_rule30.json
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


