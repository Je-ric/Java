    package Color_Game;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.io.File;
    import java.io.IOException;
    import java.util.Timer;
    import java.util.TimerTask;


    class ImagePanel extends JPanel {
        private Image[] backgroundImages;
        private int currentFrame = 0;

        public ImagePanel(Image[] backgroundImages) {
            this.backgroundImages = backgroundImages;
            startAnimation();
        }

        private void startAnimation() {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    repaint();
                    currentFrame = (currentFrame + 1) % backgroundImages.length;
                }
            }, 0, 100); 
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImages != null && backgroundImages.length > 0) {
                Image backgroundImage = backgroundImages[currentFrame];
                int width = getWidth();
                int height = getHeight();
                g.drawImage(backgroundImage, 0, 0, width, height, this);
            }
        }
    }

    public class ColorGame {
        public static void main(String[] args) {
            JFrame landingFrame = new JFrame("Color Game");
            landingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // landingFrame.setSize(1200, 700);
            landingFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            landingFrame.setUndecorated(true); 
            
            Image[] frames = new Image[50]; 

            for (int i = 0; i < 50; i++) {
                String fileName = String.format("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\Background Frames\\ezgif-frame-%03d.jpg", i + 1);
                frames[i] = new ImageIcon(fileName).getImage();
            }
            

            ImagePanel panel = new ImagePanel(frames);
        
            panel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(250, 0, 0, 0); 
            gbc.anchor = GridBagConstraints.CENTER;
            
            
            
            
            

            


    ImageIcon playIcon = new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\PlayButton.png");
    ImageIcon exitIcon = new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\ExitButton.png");


    JButton playButton = new JButton(playIcon);
    JButton exitButton = new JButton(exitIcon);


    playButton.setPreferredSize(new Dimension(250, 100));
    exitButton.setPreferredSize(new Dimension(250, 100));



            
            panel.add(playButton, gbc);
            gbc.gridy = 1; 
            gbc.insets = new Insets(30, 0, 30, 0); 
            panel.add(exitButton, gbc);
            
            
            landingFrame.add(panel);
            landingFrame.setLocationRelativeTo(null);
            landingFrame.setVisible(true);
            
            Font customFont = null;
            try {
                String fontPath = "C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\Font\\GamepauseddemoRegular-RpmY6.ttf";
                customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(30f);
            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
                
            }
            
            if (customFont != null) {
                playButton.setFont(customFont);
                exitButton.setFont(customFont);
            }
            

    playButton.setOpaque(false);
    playButton.setContentAreaFilled(false);
    playButton.setBorderPainted(false);
    playButton.setFocusPainted(false);
    playButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 

    exitButton.setOpaque(false);
    exitButton.setContentAreaFilled(false);
    exitButton.setBorderPainted(false);
    exitButton.setFocusPainted(false);
    exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
    // For playButton
    playButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            playButton.setIcon(new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\PlayHover.png"));
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            playButton.setIcon(new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\PlayButton.png"));
        }
    });

    // For exitButton
    exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            exitButton.setIcon(new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\ExitHover.png"));
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            exitButton.setIcon(new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\ExitButton.png"));
        }
    });


            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    landingFrame.dispose();
            
                    JFrame difficultyFrame = new JFrame("Choose Difficulty");
                    // difficultyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    // difficultyFrame.setSize(1200, 700);
                    difficultyFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    difficultyFrame.setUndecorated(true);
            
                    JPanel difficultyPanel = new JPanel() {
                        @Override
                        protected void paintComponent(Graphics g) {
                            super.paintComponent(g);
                            Image background = new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\BG1.png").getImage();
                            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
                        }
                    };
                    difficultyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 150)); 
    

                    ImageIcon easyIcon = new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\EasyButton.png");
    ImageIcon mediumIcon = new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\MediumButton.png");
    ImageIcon hardIcon = new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\HardButton.png");


    JButton easyButton = new JButton(easyIcon);
    JButton mediumButton = new JButton(mediumIcon);
    JButton hardButton = new JButton(hardIcon);

    easyButton.setOpaque(false);
    easyButton.setContentAreaFilled(false);
    easyButton.setBorderPainted(false);
    easyButton.setFocusPainted(false);
    easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 

    mediumButton.setOpaque(false);
    mediumButton.setContentAreaFilled(false);
    mediumButton.setBorderPainted(false);
    mediumButton.setFocusPainted(false);
    mediumButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 

    hardButton.setOpaque(false);
    hardButton.setContentAreaFilled(false);
    hardButton.setBorderPainted(false);
    hardButton.setFocusPainted(false);
    hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); 

    // For easyButton
    easyButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            easyButton.setIcon(new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\EasyHover.png"));
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            easyButton.setIcon(new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\EasyButton.png"));
        }
    });

    // For mediumButton
    mediumButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            mediumButton.setIcon(new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\MediumHover.png"));
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            mediumButton.setIcon(new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\MediumButton.png"));
        }
    });

    // For hardButton
    hardButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            hardButton.setIcon(new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\HardHover.png"));
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            hardButton.setIcon(new ImageIcon("C:\\Users\\LenovoPc\\Documents\\VsCode\\Project Drafts\\Color_Game\\HardButton.png"));
        }
    });


                    Insets buttonInsets = new Insets(10, 0, 10, 0); 
                    easyButton.setMargin(buttonInsets);
                    mediumButton.setMargin(buttonInsets);
                    hardButton.setMargin(buttonInsets);
                    difficultyPanel.add(easyButton);
                    difficultyPanel.add(mediumButton);
                    difficultyPanel.add(hardButton);
            
                    difficultyFrame.add(difficultyPanel);
                    difficultyFrame.setVisible(true);
            
                    easyButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            final Easy easy = new Easy();
                            easy.setVisible(true);
                            difficultyFrame.dispose();
                        }
                    });
            
                    mediumButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            final Medium medium = new Medium();
                            medium.setVisible(true);
                            difficultyFrame.dispose();
                        }
                    });
            
                    hardButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            final Hard hard = new Hard();
                            hard.setVisible(true);
                            difficultyFrame.dispose();
                        }
                    });
                }
            });

            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            
            landingFrame.setLocationRelativeTo(null);
            landingFrame.setVisible(true);
            
        }

        
    }

