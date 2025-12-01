# Rule 30 - Turing Machine 

A Regra 30 é uma das regras elementares de autômatos celulares introduzidas por Stephen Wolfram em 1983 (Wolfram 1983, 2002). Ela especifica a próxima cor em uma célula, dependendo de sua cor e de suas células vizinhas imediatas. Além da definição formal da Máquina de Turing, sua descrição e diagrama, criamos este código em Java que implementa os mesmos passos da MT proposta. 
Dependência Maven utilizada: com.googlecode.json-simple.

# 📜 Objetivos:
>     [X] Criar conversor .json da MT teórica;
>     [X] **Criar classe para para tratar os dados da MT;**
>     [X] **Criar classe para implementação das propriedades da MT**
>     [X] **Criar um painel para exibição do programa**

# 🖥️ Diagrama da Máquina

A máquina foi criada considerando que há 8 combinações possíveis na Regra 30, e aproveitando-se do seguinte padrão: quando a célula do meio é 0 "#0#" ou 1 "#1#", leva a duas saídas "0" e duas "1", respectivamente. 
<p align="center">
     <img width="246" height="250" alt="Captura de tela 2025-12-01 000556" src="https://github.com/user-attachments/assets/90de5466-f3a9-4a5d-b39d-033b0dfc1a9f" />
</p>

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
     <img width="909" height="189" alt="image" src="https://github.com/user-attachments/assets/9c7a9c2c-bb82-4b81-bec3-1e2adc33c5bd" />
     <img width="185" height="58" alt="image" src="https://github.com/user-attachments/assets/e85df6df-f8f9-472f-9bab-d3e310c23173" />
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
     |                    ├── Resultados.java
     |                    ├── JGraficoPixel.java
     |                    ├── TuringMachine.java
     |                    └── Main.java
     ├── target
     ├── README.md
     ├── pom.xml
     └── tm_rule30.json
     .

# 🔧 Principais Classes e Funções

<p align="center">
     <img width="756" height="387" alt="image" src="https://github.com/user-attachments/assets/437e1814-85f7-49c3-8f84-2e7c1937cf6d" />
     <img width="1518" height="715" alt="image" src="https://github.com/user-attachments/assets/bf50adae-bf82-470e-9df5-113c1de5be98" />
     <img width="1296" height="597" alt="image" src="https://github.com/user-attachments/assets/b8968732-73a0-4358-88fd-8cc1baea931b" />
</p>

# ✒️ Autores: 
| [<img src="https://avatars.githubusercontent.com/u/99749672?v=4" width=115><br><sub>Gabriel Alexandre</sub>](https://https://github.com/aieFaria) |  [<img src="https://lh3.googleusercontent.com/a-/ALV-UjUSbAUZs8fIDLpE2IxgftQvn59uYcg5JtGjnglwGdLloMGgyXM=s50-c-k-no" width=115><br><sub>Isaac Jerferson</sub>](https://github.com/guilhermeonrails) |  [<img src="https://avatars.githubusercontent.com/u/160502160?v=4" width=115><br><sub>Raislson Bernardo</sub>](https://github.com/alexfelipe) |
| :---: | :---: | :---: |


