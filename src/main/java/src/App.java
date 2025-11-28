package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.filechooser.FileNameExtensionFilter;

public class App {
    public static void main(String[] args) {

        JFrame tela = new JFrame();
        JPanel painel_de_entrada = new JPanel();
        JPanel painel_escolha = new JPanel();
        JPanel painel_Pai = new JPanel();
        JInternalFrame tmPainel = new JInternalFrame();
        JTextArea console = new JTextArea();

        Border leftBorder = BorderFactory.createMatteBorder(1, 1, 2, 1, Color.BLACK); // (top, left, bottom, right, borderColor)

        // Configurar painel Pai
        painel_Pai.setLayout(null);
        painel_Pai.setPreferredSize(new Dimension(600, 2500));

        // Configuração de painel 2
        Border leftBorder2 = BorderFactory.createMatteBorder(2, 1, 1, 1, Color.BLACK);
        painel_escolha.setBorder(leftBorder2);
        painel_escolha.setLayout(null);
        painel_escolha.setBounds(0, 0, 600, 200);
        
        // Configuração de titulo
        JTextField titulo2 = new JTextField();
        titulo2.setFocusable(false);
        titulo2.setText("  Escolha sua Maquina de Turing");
        titulo2.setBounds(0, 0, painel_escolha.getWidth(), 33);
        titulo2.setBorder(leftBorder);

        JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
        fc.setFileFilter(new FileNameExtensionFilter("Arquivos tipo JSON", "json"));

        // Configuração de botão
        JButton botao2 = new JButton(" Carregar ");
        botao2.setBounds(245, titulo2.getHeight()+2, 100, 30);
        botao2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                int retorno = fc.showOpenDialog(tela);
                String nomeArquivo = "";

                if (retorno == JFileChooser.APPROVE_OPTION) {
                    File arquivoSelecionado = fc.getSelectedFile();
                    
                    // Aqui você coloca a lógica para ler o arquivo
                    System.out.println("Arquivo escolhido: " + arquivoSelecionado.getName());
                    painel_escolha.setSize(painel_escolha.getWidth(), 975);
                    painel_de_entrada.setLocation(painel_de_entrada.getX(), painel_escolha.getHeight()+10);
                    nomeArquivo = arquivoSelecionado.getName();

                    console.setText((String) Main.abrir().get(0));
                    TuringMachine tm = (TuringMachine) Main.abrir().get(1);
                    
                    tmPainel.setVisible(true);
                    
                    // arquivoSelecionado.getName()
                    // Nome do arquivo para passar para função que converte o JSON para TM
                }

                tmPainel.setTitle(nomeArquivo);
        
            }

        });

        
        // Configuração painel interno
        tmPainel.setLayout(null);
        tmPainel.setSize(painel_escolha.getWidth()-4, 900);
        tmPainel.setLocation(2, botao2.getHeight()+titulo2.getHeight()+7); // Posição X, Y dentro do painel pai
        tmPainel.setClosable(true);
        tmPainel.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        tmPainel.setVisible(false);

        //Configuração area de texto
        
        console.setBounds(0, 0, tmPainel.getWidth(), tmPainel.getHeight());
        console.setFocusable(false);
        console.setVisible(true);
        
        //ADD: Painel interno
        tmPainel.add(console);

        tmPainel.addInternalFrameListener(new InternalFrameAdapter() {
    
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                // Esse código roda DEPOIS que a janela sumiu
                System.out.println("Aviso: O JInternalFrame foi fechado completamente.");
                painel_escolha.setSize(painel_escolha.getWidth(), 200);
                painel_de_entrada.setLocation(painel_de_entrada.getX(), painel_escolha.getHeight()+10);

                // Remover Maquina de Turing, para carregamento de outra
                // Equivalente a substituir a entrada da função que converte o JSON para TM
            }

        });

        // Configuração de painel 1
        painel_de_entrada.setLayout(null);
        painel_de_entrada.setBounds(100, painel_escolha.getHeight()+10, 400, 90);
        //painel_escolha.getWidth()+2
        painel_de_entrada.setBorder(leftBorder);

        // Configuração de titulo
        JTextField titulo = new JTextField();
        titulo.setFocusable(false);
        titulo.setText("  Insira uma entrada na Maquina de Turing");
        titulo.setBounds(0, 0, painel_de_entrada.getWidth(), painel_de_entrada.getHeight()/3);
        titulo.setBorder(leftBorder);

        // Configuração de texto
        String info1 = "ENTRADA: ";
        JLabel labelInfo1 = new JLabel();
        labelInfo1.setText(info1);
        //labelInfo1.setBackground(Color.RED);
        labelInfo1.setBounds(10, 40, 80, 30);

        // Configuração de caixa de entrada
        JTextField campoEntrada = new JTextField();
        //campoEntrada.def
        campoEntrada.setBounds(labelInfo1.getHorizontalAlignment() + labelInfo1.getWidth(), labelInfo1.getY(), 100, 30);
        campoEntrada.addFocusListener( new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
                if(campoEntrada.getText().equals("  Insira a fita  ")) {
                    campoEntrada.setText("");
                    campoEntrada.setForeground(Color.BLACK); // Muda a cor para texto real
                } 
                
            }

            @Override
            public void focusLost(FocusEvent e) {

                if(campoEntrada.getText().isEmpty()) {
                    campoEntrada.setText("  Insira a fita  ");
                    campoEntrada.setForeground(Color.GRAY);
                }
                
            }
            
        });

        // Configuração de botão
        JButton botao0 = new JButton("");
        String textoBotao1 = "|   ENVIAR   →";
        JButton botao1 = new JButton(textoBotao1);
        int posicaoHorizontal = campoEntrada.getHorizontalAlignment() + campoEntrada.getWidth() + labelInfo1.getHorizontalAlignment() + labelInfo1.getWidth();
        botao1.setBounds(posicaoHorizontal, labelInfo1.getY(), textoBotao1.length()*9, 30);
        botao1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String in_tape = "";

                if( testEntrada(campoEntrada.getText()) ) {

                    if( tmPainel.isShowing() ) {
                        TuringMachine tm = new TuringMachine();
                        tm = (TuringMachine) Main.abrir().get(1);

                        tm.finite_control(tm, campoEntrada.getText());
                        System.out.println();
                    }

                    in_tape = campoEntrada.getText();

                } else {
                    campoEntrada.setText("  Insira a fita  ");
                    campoEntrada.setForeground(Color.GRAY);
                    // Talvez enviar Pop-up de aviso
                }
                 
                System.out.println("Fita de entrada: " + in_tape);
            }

        });

        //ADD: painel Pai
        painel_Pai.add(painel_de_entrada);
        painel_Pai.add(painel_escolha);

        //ADD: painel de entrada
        painel_de_entrada.add(titulo);
        painel_de_entrada.add(botao0);
        painel_de_entrada.add(botao1);
        painel_de_entrada.add(labelInfo1);
        painel_de_entrada.add(campoEntrada);

        //ADD: Painel de escolha
        painel_escolha.add(titulo2);
        painel_escolha.add(botao2);
        painel_escolha.add(tmPainel);
        

        // Configuração de painel de rolagem
        JScrollPane scrollPane = new JScrollPane(painel_Pai);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // ADD: Tela
        tela.add(scrollPane, BorderLayout.CENTER);

        // Denifições da tela
        tela.setBounds(10, 10, 635, 700);
        tela.setTitle("MÁQUINA DE TURING");
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Encerrar programa quando fechar tela
        tela.setVisible(true);
        
    }

    public void entrada() {

    }

    private static boolean testEntrada(String str) {
        String regex = "[01#]+";
        return Pattern.matches(regex, str);
    }
}

// Para finalizar: https://www.youtube.com/watch?v=Ghb0owCoaEc
