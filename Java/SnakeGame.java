import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakeGame extends JFrame implements ActionListener, KeyListener {
    private static final int TILE_SIZE = 20;
    private static final int GRID_SIZE = 20;
    private static final int GAME_SPEED = 100; // in milliseconds

    private Timer timer;
    private int[][] grid;
    private int snakeLength;
    private int[] snakeX, snakeY;
    private int direction;

    public SnakeGame() {
        setTitle("Snake Game");
        setSize(GRID_SIZE * TILE_SIZE, GRID_SIZE * TILE_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        grid = new int[GRID_SIZE][GRID_SIZE];
        snakeX = new int[GRID_SIZE * GRID_SIZE];
        snakeY = new int[GRID_SIZE * GRID_SIZE];
        snakeLength = 1;
        direction = KeyEvent.VK_RIGHT;

        timer = new Timer(GAME_SPEED, this);
        timer.start();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        initializeGame();
    }

    private void initializeGame() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = 0;
            }
        }

        snakeX[0] = GRID_SIZE / 2;
        snakeY[0] = GRID_SIZE / 2;
        grid[GRID_SIZE / 2][GRID_SIZE / 2] = 1; // Snake head
        spawnFood();
    }

    private void spawnFood() {
        int foodX, foodY;
        do {
            foodX = (int) (Math.random() * GRID_SIZE);
            foodY = (int) (Math.random() * GRID_SIZE);
        } while (grid[foodX][foodY] != 0); // Ensure food doesn't spawn on the snake

        grid[foodX][foodY] = -1; // Food
    }

    private void move() {
        int newHeadX = snakeX[0];
        int newHeadY = snakeY[0];

        switch (direction) {
            case KeyEvent.VK_UP:
                newHeadY--;
                break;
            case KeyEvent.VK_DOWN:
                newHeadY++;
                break;
            case KeyEvent.VK_LEFT:
                newHeadX--;
                break;
            case KeyEvent.VK_RIGHT:
                newHeadX++;
                break;
        }

        // Check if the new head position is within the boundaries
        if (newHeadX < 0 || newHeadX >= GRID_SIZE || newHeadY < 0 || newHeadY >= GRID_SIZE) {
            gameOver();
            return;
        }

        // Check if the new head position is on the snake's body
        if (grid[newHeadX][newHeadY] != 0 && grid[newHeadX][newHeadY] != -1) {
            gameOver();
            return;
        }

        // Check if the new head position is on food
        if (grid[newHeadX][newHeadY] == -1) {
            snakeLength++;
            spawnFood();
        } else {
            // Move the tail
            int tailX = snakeX[snakeLength - 1];
            int tailY = snakeY[snakeLength - 1];
            grid[tailX][tailY] = 0;
        }

        // Move the head
        for (int i = snakeLength - 1; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }
        snakeX[0] = newHeadX;
        snakeY[0] = newHeadY;

        // Update the grid
        for (int i = 0; i < snakeLength; i++) {
            grid[snakeX[i]][snakeY[i]] = 1; // Snake body
        }
    }

    private void gameOver() {
        timer.stop();
        JOptionPane.showMessageDialog(this, "Game Over! Your score: " + (snakeLength - 1));
        initializeGame();
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j] == 1) {
                    g.setColor(Color.GREEN);
                } else if (grid[i][j] == -1) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if ((key == KeyEvent.VK_LEFT && direction != KeyEvent.VK_RIGHT) ||
                (key == KeyEvent.VK_RIGHT && direction != KeyEvent.VK_LEFT) ||
                (key == KeyEvent.VK_UP && direction != KeyEvent.VK_DOWN) ||
                (key == KeyEvent.VK_DOWN && direction != KeyEvent.VK_UP)) {
            direction = key;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SnakeGame snakeGame = new SnakeGame();
            snakeGame.setVisible(true);
        });
    }
}
