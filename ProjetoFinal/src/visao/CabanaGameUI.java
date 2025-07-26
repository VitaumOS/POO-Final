package visao;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class CabanaGameUI extends JFrame {
    
    private JPanel gamePanel;
    private JLabel freddyLabel;
    private Timer jumpScareTimer;
    private Timer moveTimer;
    private Random random = new Random();
    private int pontos = 0;
    private JLabel pontosLabel;
    
    public CabanaGameUI() {
        setTitle("FNAF Mini-Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        
        gamePanel = new JPanel(null); // Layout nulo para posicionamento livre
        gamePanel.setBackground(Color.BLACK);
        gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                verificarClique(e.getX(), e.getY());
            }
        });
        
        // Pontuação
        pontosLabel = new JLabel("Pontos: 0");
        pontosLabel.setForeground(Color.WHITE);
        pontosLabel.setFont(new Font("Arial", Font.BOLD, 24));
        pontosLabel.setBounds(20, 20, 200, 30);
        gamePanel.add(pontosLabel);
        
        // Carregar imagem do Freddy
        ImageIcon freddyIcon = new ImageIcon(getClass().getResource("/img/fazbear_icon.png"));
        freddyLabel = new JLabel(freddyIcon);
        freddyLabel.setBounds(random.nextInt(700), random.nextInt(500), 
                              freddyIcon.getIconWidth(), freddyIcon.getIconHeight());
        gamePanel.add(freddyLabel);
        
        // Timer para mover o Freddy
        moveTimer = new Timer(1500, e -> moverFreddy());
        moveTimer.start();
        
        // Timer para jumpscare depois de 30 segundos
        jumpScareTimer = new Timer(30000, e -> gameOver());
        jumpScareTimer.setRepeats(false);
        jumpScareTimer.start();
        
        add(gamePanel);
        setLocationRelativeTo(null);
    }
    
    private void verificarClique(int x, int y) {
        // Verificar se clicou no Freddy
        Rectangle freddyBounds = freddyLabel.getBounds();
        if (freddyBounds.contains(x, y)) {
            pontos += 10;
            pontosLabel.setText("Pontos: " + pontos);
            moverFreddy();
            
            // Acelerar o jogo a cada 50 pontos
            if (pontos % 50 == 0) {
                int delay = moveTimer.getDelay();
                if (delay > 500) {
                    moveTimer.setDelay(delay - 100);
                }
            }
        }
    }
    
    private void moverFreddy() {
        freddyLabel.setLocation(random.nextInt(700), random.nextInt(500));
    }
    
    private void gameOver() {
        moveTimer.stop();
        
        // Exibir jumpscare
        try {
            gamePanel.setBackground(Color.RED);
            JOptionPane.showMessageDialog(this, 
                "GAME OVER!\nPontuação: " + pontos, 
                "Five Nights at Freddy's", 
                JOptionPane.WARNING_MESSAGE);
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}