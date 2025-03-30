
package Color_Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Hard extends JFrame {
    private JButton rollButton;
    private JLabel resultLabel;
    private JLabel scoreLabel;  
    private JPanel colorPanel;
    private JPanel bottomPanel; 
    private int score = 1500;
    private List<Integer> bets = new ArrayList<>();
    private List<JLabel> selectedColorsLabels = new ArrayList<>();

    public List<JLabel> getSelectedColorsLabels() {
        return selectedColorsLabels;
    }
    public void setSelectedColorsLabels(List<JLabel> selectedColorsLabels) {
        this.selectedColorsLabels = selectedColorsLabels;
    }

     private String[] colors = {"Green", "Red", "Blue", "Pink", "White", "Yellow", "Orange", "Gray", "Cyan", "Magenta"};
    private Random random = new Random();
    

    
  public Hard() {
    setTitle("Color Game");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //setSize(1200, 700); 
    setLayout(new BorderLayout());
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setUndecorated(true);
    setVisible(true);

        

        
  JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bgImage = new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\BG.png");
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        setContentPane(backgroundPanel);

        resultLabel = new JLabel();
        resultLabel.setForeground(Color.WHITE); 

        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setForeground(Color.WHITE); 
        
        rollButton = new JButton();
        colorPanel = new JPanel();
        bottomPanel = new JPanel(new GridLayout(1, 3));
        
        
        
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (bets.isEmpty()) {
                    JOptionPane.showMessageDialog(Hard.this, "Please place at least one bet before rolling!");
                } else {
                    rollDiceAnimation();
                }
            }
        });

        ImageIcon initialIcon = new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\RollButton.png");
        rollButton.setIcon(initialIcon);

        rollButton.setOpaque(false);
        rollButton.setContentAreaFilled(false);
        rollButton.setBorderPainted(false);
        rollButton.setFocusPainted(false);
        rollButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
    

        rollButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ImageIcon rollDiceHoverIcon = new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\RollHover.png");
                rollButton.setIcon(rollDiceHoverIcon);
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ImageIcon rollDiceNormalIcon = new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\RollButton.png");
                rollButton.setIcon(rollDiceNormalIcon);
            }
        });


        // --------------------------------------------


        ImageIcon backButtonIcon = new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\BackButton.png");
        JButton backButton = new JButton(backButtonIcon);

        
    backButton.setOpaque(false);
    backButton.setContentAreaFilled(false);
    backButton.setBorderPainted(false);
    backButton.setFocusPainted(false);
    backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 

    backButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            backButton.setIcon(new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\BackHover.png"));
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            backButton.setIcon(new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\BackButton.png"));
        }
    });
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ColorGame.main(new String[0]); // Assuming your main method in ColorGame handles the difficulty selection frame
        
                // Close the current Easy frame
                Hard.this.dispose();
            }
        });

        
        // Add the back button to the Easy frame
        // bottomPanel.add(backButton);

        // --------------------------------------------- 
        JPanel mainPanel = new JPanel(new BorderLayout());

        mainPanel.add(colorPanel, BorderLayout.CENTER);

        JPanel bottomContent = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomContent.setBackground(Color.BLACK);
        bottomContent.add(resultLabel);
        bottomContent.add(rollButton);
        bottomContent.add(scoreLabel);
        bottomContent.add(backButton);
        
        int preferredWidth = 1000; // Set your desired width here
Dimension preferredSize = new Dimension(preferredWidth, bottomContent.getPreferredSize().height);
bottomContent.setPreferredSize(preferredSize);

        mainPanel.add(bottomContent, BorderLayout.SOUTH);
        System.out.println("Hard");
        add(mainPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.NORTH); 
        displayAllColors();
        displayInitialColors();
        

    }

 private void displayInitialColors() {

        int gapSize = 30; 

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, gapSize, 10); 
        colorPanel.setLayout(flowLayout);

        int topGap = 50; 
        colorPanel.setBorder(BorderFactory.createEmptyBorder(topGap, 0, 0, 0));

        colorPanel.setOpaque(false); 

        int borderThickness = 4;

        for (int i = 0; i < 3; i++) {
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(320, 320)); 

            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, borderThickness));

            colorPanel.add(panel);
        }
if (colorPanel.getParent() instanceof JComponent) {
        ((JComponent) colorPanel.getParent()).setOpaque(false);
    }
        colorPanel.revalidate();
    }
  
    private void placeBet(String color) {
        if (bets.size() < 3) {
            int betAmount = 100;
            int colorIndex = getColorIndex(color);
    
            if (!bets.contains(colorIndex)) {
                bets.add(colorIndex);
                score -= betAmount;
                if (score < 0) {
                    score += betAmount;
                    JOptionPane.showMessageDialog(Hard.this, "Score cannot go negative!");
                } else {
                    scoreLabel.setText("Score: " + score);
    
                    System.out.println("Bet placed on: " + color);
                    System.out.println("Remaining score: " + score);
    
                    Component[] components = colorPanel.getComponents();
                    for (Component comp : components) {
                        // Update UI to indicate the selected color for betting
                        if (comp instanceof JButton && ((JButton) comp).getText().equalsIgnoreCase(color)) {
                            comp.setBackground(Color.LIGHT_GRAY);
                            comp.setEnabled(false);
                        }
                    }
    
                    updateSelectedColorsInResult();
                }
            } else {
                JOptionPane.showMessageDialog(Hard.this, "You have already placed a bet on " + color + "!");
            }
        } else {
            JOptionPane.showMessageDialog(Hard.this, "You have placed maximum bets!");
        }
    }
 
 

 
    private void updateSelectedColorsInResult() {
        StringBuilder betColors = new StringBuilder("You bet on: ");
        for (Integer bet : bets) {
            betColors.append(colors[bet]).append(", ");
        }
      resultLabel.setText( betColors.substring(0, betColors.length() - 2));
    }
    
    
        private void rollDiceAnimation() {
            rollButton.setEnabled(false); 
            Timer timer = new Timer(200, new ActionListener() {
                int count = 0;
                int[] diceResults = new int[3];
    
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count < 10) {
                        diceResults = rollDice();
                        displayRollingColors(diceResults);
                        count++;
                    } else {
                        ((Timer) e.getSource()).stop();
                        displayFinalResult(diceResults);
                        rollButton.setEnabled(true); 
                    }
                }
            });
            timer.start();
        }



    private int[] rollDice() {
        int[] results = new int[3];
        for (int i = 0; i < 3; i++) {
            results[i] = random.nextInt(colors.length);
        }
        return results;
    }
    
    
    private void displayRollingColors(int[] diceResults) {
        colorPanel.removeAll();
    
        int gapSize = 30;
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, gapSize, 10);
        colorPanel.setLayout(flowLayout);
    
        int topGap = 50;
        colorPanel.setBorder(BorderFactory.createEmptyBorder(topGap, 0, 0, 0));
        colorPanel.setOpaque(false);
    
        int borderThickness = 4;
    
        for (int i = 0; i < 3; i++) {
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(320, 320));
            panel.setBackground(getColorByIndex(diceResults[i])); // Set the color based on dice result
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, borderThickness));
    
            JLabel diceLabel = new JLabel(String.valueOf(colors[diceResults[i]])); // Display the color name
        diceLabel.setForeground(Color.BLACK);
        panel.add(diceLabel); // Add color name to the panel
    
            colorPanel.add(panel);
        }
    
        if (colorPanel.getParent() instanceof JComponent) {
            ((JComponent) colorPanel.getParent()).setOpaque(false);
        }
    
        colorPanel.revalidate();
    }


    
    

    private void displayFinalResult(int[] diceResults) {
        if (score <= 0) {
            gameOver();
            return;
        }
    
        // Update the "You bet" text with the chosen colors
        updateSelectedColorsInResult();
    
        // Display the dice results next to the "You bet" text
        StringBuilder resultText = new StringBuilder(resultLabel.getText());
        resultText.append(" | Dice Results: ");
        for (int result : diceResults) {
            resultText.append(colors[result]).append(", ");
        }
        resultLabel.setText(resultText.substring(0, resultText.length() - 2));
    
        int[] colorCounts = new int[10];
        for (int result : diceResults) {
            colorCounts[result]++;
        }
    
        int scoreChange = 0;
    
        for (Integer bet : bets) {
            scoreChange += colorCounts[bet] * 100; // Increase score based on user's bets matching the dice results
        }
    
        score += scoreChange;
        scoreLabel.setText("Score: " + score);
    
        bets.clear();
    }


 private void resetGame() {
    
    score = 1500;
    scoreLabel.setText("Score: " + score);
    bets.clear();

    Component[] components = colorPanel.getComponents();
    for (Component comp : components) {
        if (comp instanceof JButton) {
            comp.setBackground(null);
            comp.setEnabled(true);
        }
    }

}


  private void gameOver() {
    resultLabel.setText("Game Over!");

    rollButton.setEnabled(false);

    int choice = JOptionPane.showConfirmDialog(
        Hard.this,
        "Do you want to play again?",
        
        "Game Over",
        JOptionPane.YES_NO_OPTION
    );

    if (choice == JOptionPane.YES_OPTION) {
        resetGame();
    } else {
        
    }
}
  
  private void displayAllColors() {
    colorPanel.removeAll();
    //int buttonSize = 80; 
    Insets buttonMargin = new Insets(5, 10, 5, 10); 

    bottomPanel.setLayout(new GridLayout(2, 5, 10, 10)); // 2 rows, 5 columns
    bottomPanel.setOpaque(false);

    // bottomPanel.setLayout(new GridLayout(0, 3, 10, 10)); 
    // bottomPanel.setOpaque(false); 

    for (String color : colors) {
        JButton colorButton = new JButton();
        colorButton.setBackground(getColorByName(color));
        colorButton.setPreferredSize(new Dimension(220, 100)); //buttonSize
        colorButton.setMargin(buttonMargin); 

        colorButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (bets.size() < 3) {
                    placeBet(color);
                } else {
                    JOptionPane.showMessageDialog(Hard.this, "You have placed maximum bets!");
                }
            }
        });

        bottomPanel.add(colorButton);
    }
}




    private int getColorIndex(String color) {
        for (int i = 0; i < colors.length; i++) {
            if (colors[i].equalsIgnoreCase(color)) {
                return i;
            }
        }
        return -1;
    }

       private Color getColorByIndex(int index) {
        switch (index) {
            case 0:
                return Color.GREEN;
            case 1:
                return Color.RED;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.PINK;
            case 4:
                return Color.WHITE;
            case 5:
                return Color.YELLOW;
            case 6:
                return Color.ORANGE;
            case 7:
                return Color.GRAY;
            case 8:
                return Color.CYAN;
            case 9:
                return Color.MAGENTA;
            default:
                return Color.LIGHT_GRAY;
        }
    }
    
    private Color getColorByName(String colorName) {
        switch (colorName) {
            case "Green":
                return Color.GREEN;
            case "Red":
                return Color.RED;
            case "Blue":
                return Color.BLUE;
            case "Pink":
                return Color.PINK;
            case "White":
                return Color.WHITE;
            case "Yellow":
                return Color.YELLOW;
            case "Orange":
                return Color.ORANGE;
            case "Purple":
                return Color.GRAY;
            case "Cyan":
                return Color.CYAN;
            case "Magenta":
                return Color.MAGENTA;
            default:
                return Color.LIGHT_GRAY;
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Hard().setVisible(true));
    }
}


