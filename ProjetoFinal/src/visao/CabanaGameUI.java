package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class CabanaGameUI extends JFrame {
    
    private JPanel gamePanel;
    private Timer gameTimer;
    private Random random = new Random();
    private int pontos = 0;
    private JButton targetButton;
    private int tempoRestante = 30;
    private JLabel pontosLabel, timerLabel;
    
    public CabanaGameUI() {
        setTitle("Cabana Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        gamePanel = new JPanel(null); // Layout nulo para posicionamento livre
        gamePanel.setBackground(Color.BLACK);
        
        // Pontuação
        pontosLabel = new JLabel("Pontos: 0");
        pontosLabel.setForeground(Color.WHITE);
        pontosLabel.setFont(new Font("Arial", Font.BOLD, 20));
        pontosLabel.setBounds(20, 20, 200, 30);
        gamePanel.add(pontosLabel);
        
        // Temporizador
        timerLabel = new JLabel("Tempo: 30s");
        timerLabel.setForeground(Color.WHITE);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        timerLabel.setBounds(650, 20, 150, 30);
        gamePanel.add(timerLabel);
        
        // Botão alvo
        targetButton = new JButton("Clique!");
        targetButton.setBackground(Color.RED);
        targetButton.setForeground(Color.WHITE);
        targetButton.setBounds(350, 250, 100, 40);
        targetButton.addActionListener(e -> {
            pontos += 10;
            pontosLabel.setText("Pontos: " + pontos);
            moverBotao();
            
            // Aumenta a dificuldade
            if (pontos % 50 == 0) {
                Dimension size = targetButton.getSize();
                if (size.width > 40) {
                    targetButton.setSize(size.width - 10, size.height - 5);
                }
            }
        });
        gamePanel.add(targetButton);
        
        // Instruções
        JLabel instrucoes = new JLabel("<html><center>Clique no botão vermelho!<br>Ganhe o máximo de pontos em 30 segundos.</center></html>");
        instrucoes.setForeground(Color.YELLOW);
        instrucoes.setHorizontalAlignment(SwingConstants.CENTER);
        instrucoes.setBounds(200, 100, 400, 50);
        gamePanel.add(instrucoes);
        
        // Timer do jogo
        gameTimer = new Timer(1000, e -> {
            tempoRestante--;
            timerLabel.setText("Tempo: " + tempoRestante + "s");
            
            if (tempoRestante <= 0) {
                fimDeJogo();
            }
        });
        gameTimer.start();
        
        add(gamePanel);
        setLocationRelativeTo(null);
    }
    
    private void moverBotao() {
        int x = random.nextInt(getWidth() - targetButton.getWidth());
        int y = random.nextInt(getHeight() - targetButton.getHeight() - 100) + 100;
        targetButton.setLocation(x, y);
    }
    
    private void fimDeJogo() {
        gameTimer.stop();
        targetButton.setEnabled(false);
        
        JOptionPane.showMessageDialog(this,
                "Fim de jogo!\nSua pontuação: " + pontos,
                "Tempo Esgotado",
                JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
    
    // Para testar independentemente
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CabanaGameUI().setVisible(true);
        });
    }
}