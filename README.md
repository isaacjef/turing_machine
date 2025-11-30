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
<p align="center">
     <img width="758" height="272" alt="image" src="https://github.com/user-attachments/assets/75c1c9d1-2f3e-4ab7-a020-f75db1448d69" />
     <img width="1027" height="648" alt="image" src="https://github.com/user-attachments/assets/31c7c52d-7473-4859-a8af-cfc96c724af8" />
     <img width="369" height="88" alt="image" src="https://github.com/user-attachments/assets/7fdea16f-a4a4-4d9b-9b49-850c040fcd7e" /> 
</p>
Máquina descrita no formato JSON:
<p align="center">
     <img width="828" height="180" alt="image" src="https://github.com/user-attachments/assets/d5a25de2-43b3-4bb1-bf09-f5593b4574e5" />
</p>

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

# 🔧 Principais Classes e Funções

<img width="695" height="361" alt="image" src="https://github.com/user-attachments/assets/32c90601-b04b-4322-a894-216c21abface" />

<img width="1191" height="560" alt="image" src="https://github.com/user-attachments/assets/02d7b86e-6f9f-4184-b459-7918e3e4a6ac" />



# ✒️ Autores: 
| [<img src="https://avatars.githubusercontent.com/u/99749672?v=4" width=115><br><sub>Gabriel Alexandre</sub>](https://https://github.com/aieFaria) |  [<img src="https://lh3.googleusercontent.com/a-/ALV-UjUSbAUZs8fIDLpE2IxgftQvn59uYcg5JtGjnglwGdLloMGgyXM=s50-c-k-no" width=115><br><sub>Isaac Jerferson</sub>](https://github.com/guilhermeonrails) |  [<img src="https://avatars.githubusercontent.com/u/160502160?v=4" width=115><br><sub>Raislson Bernardo</sub>](https://github.com/alexfelipe) |
| :---: | :---: | :---: |


