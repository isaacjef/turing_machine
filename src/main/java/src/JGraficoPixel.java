package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class JGraficoPixel extends JPanel {

    private List<String> dados;
    private int N;
    private int scale;

    public int getscale() {
        return this.scale;
    }

    public void setscale(int scale) {
        this.scale = scale;
    }

    public List<String> getDados() {
        return this.dados;
    }

    public void setDados(List<String> dados) {
        this.dados = dados;

        if (dados != null) {

            this.N = this.dados.getFirst().length();
            this.setPreferredSize(new Dimension(N * scale, N * scale));
            
        }
    }

    public JGraficoPixel(){ }

    public JGraficoPixel(List<String> dados) {
        this.dados = dados;
        
        if (dados.getLast().length() > 0) {

            this.N = dados.getLast().length();
            this.setPreferredSize(new Dimension(N * scale, N * scale));
            
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (dados == null || dados.size() == 0) return;

        for (int y = 0; y < dados.size(); y++) {
            String linhaAtual = dados.get(y);

            for (int x = 0; x < N; x++) {
                
                if (x >= linhaAtual.length()) break;

                char caracter = linhaAtual.charAt(x);

                switch (caracter) {
                    case '1':
                        g.setColor(Color.BLACK);
                    break;

                    case '0':
                        g.setColor(Color.WHITE);
                    break;

                    case ' ':
                        g.setColor(Color.WHITE);
                    break;

                    case '#':
                        g.setColor(Color.WHITE);
                    break;
                
                    default:
                        g.setColor(Color.GRAY);
                        break;
                }

                g.fillRect(x * scale, y * scale, scale, scale);
                
                g.setColor(Color.GRAY);
                g.drawRect(x * scale, y * scale, scale, scale);
            }
        }
    }  
}
