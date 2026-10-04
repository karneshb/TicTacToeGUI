import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToeFrame extends JFrame {
    TicTacToeTile[][] boardGUI;
    JPanel mainPanel, gamePanel, quitPanel, buttonPanel;
    JButton btnQuit;

    TicTacToeValidate validate;
    TicTacToePrompts prompt;
    String player = "X";
    int moveCount = 0;
    boolean start = true;

    Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension screenSize = kit.getScreenSize();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width * 3/4;

    public TicTacToeFrame() {
        super ("Tic Tac Toe");

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        createGamePanel();
        createQuitPanel();

        add(mainPanel);
        prompt = new TicTacToePrompts(this, player);

        setSize(screenWidth/2, screenHeight/2);
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        setLocation(x, y);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createGamePanel() {
        gamePanel = new JPanel();
        boardGUI = new TicTacToeTile[3][3];
        gamePanel.setLayout(new GridLayout(3, 3));

        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                int currentRow = row;
                int currentCol = col;
                boardGUI[row][col] = new TicTacToeTile(row, col);
                boardGUI[row][col].setText(" ");
                boardGUI[row][col].addActionListener((ActionEvent ae) -> {set(currentRow, currentCol);});
                gamePanel.add(boardGUI[row][col]);
                gamePanel.add(boardGUI[row][col]);
            }
            mainPanel.add(gamePanel, BorderLayout.CENTER);
        }
    }

    private void createQuitPanel(){
        quitPanel = new JPanel();
        buttonPanel = new JPanel();
        btnQuit = new JButton("Quit");
        btnQuit.addActionListener((ActionEvent ae) -> {System.exit(0);});

        quitPanel.setLayout(new BorderLayout());

        buttonPanel.add(btnQuit);
        quitPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(quitPanel, BorderLayout.SOUTH);
    }

    public void set(int i, int j){
        if(start == true){
            player = "X";
            start = false;
        }

        if(boardGUI[i][j].getText().equals(" ")){
            boardGUI[i][j].setText(player);
            if(moveCount >= 4) {
                validate = new TicTacToeValidate(this, boardGUI, player, moveCount);
                validate.checkForWinner(player);
            }
            if(player == "X") {
                player = "O";
            }else {
                player = "X";
            }
            moveCount++;
        } else {
            prompt.Illegal();
        }
    }

    public void ResetGame() {
        for(int r = 0; r < 3; r++){
            for(int c = 0; c <3; c++){
                boardGUI[r][c].setText(" ");
            }
            player = "X";
            moveCount = 0;
            start = true;
        }
    }
}
