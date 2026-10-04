import javax.swing.JOptionPane;

public class TicTacToePrompts {
    private TicTacToeFrame frame;
    private String player;

    public TicTacToePrompts(TicTacToeFrame frame, String player) {
        this.frame = frame;
        this.player = player;
    }

    public void Illegal(){
        JOptionPane.showMessageDialog(null,"Space is taken. Choose another.");
    }

    public void PlayAgain() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Want to play again?", JOptionPane.YES_NO_OPTION);

        if(dialogResult == JOptionPane.YES_OPTION) {
            frame.ResetGame();
        } else {
            JOptionPane.showMessageDialog(null, "Thank you for playing!", "Tic Tac Toe!", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public void Winner() {
        JOptionPane.showMessageDialog(null, "Winner! Player " + player + " wins!", "Winner!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void EarlyTie() {
        JOptionPane.showMessageDialog(null, "There are no more winnable moves! Tie game!", "Tie Game!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void Tie() {
        JOptionPane.showMessageDialog(null, "Tie game. You filled the board!", "Tie Game!", JOptionPane.INFORMATION_MESSAGE);
    }
}
