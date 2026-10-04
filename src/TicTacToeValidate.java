import javax.swing.JOptionPane;

public class TicTacToeValidate {
    private TicTacToeTile[][] boardGUI;
    private String player = "";
    private int moveCount = 0;
    private TicTacToePrompts prompt;
    private TicTacToeFrame frame;

    public TicTacToeValidate(TicTacToeFrame frame, TicTacToeTile[][] board, String player, int moveCount) {
        this.frame = frame;
        this.boardGUI = board;
        this.player = player;
        this.moveCount = moveCount;
        prompt = new TicTacToePrompts(this.frame, this.player);
    }

    public boolean checkForWinner(String player){
        boolean winner = false;
        winner = CheckRows(player);

        if(CheckRows(player) || CheckColumns(player) || CheckDiagonal(player)) {
            winner = true;
            prompt.PlayAgain();
        } else {
            CheckBoard();
            if(moveCount > 5 && moveCount < 8){
                EarlyCheck();
            }
        }
        return winner;
    }

    public boolean CheckColumns(String player){
        boolean win = false;
        for(int i = 0; i < 3; i++){
            if(boardGUI[0][i].getText().equals(" ")) {
            } else {
                if(boardGUI[0][i].getText().equals(player) && boardGUI[1][i].getText().equals(player) && boardGUI[2][i].getText().equals(player)){
                    prompt.Winner();
                    win = true;
                }
            }
        }
        return win;
    }

    public boolean CheckRows(String player){
        boolean win = false;
        for(int i = 0; i < 3; i++){
            if(boardGUI[i][0].getText().equals(" ")) {
            } else {
                if(boardGUI[i][1].getText().equals(player) && boardGUI[i][0].getText().equals(player) && boardGUI[i][2].getText().equals(player)){
                    prompt.Winner();
                    win = true;
                }
            }
        }
        return win;
    }

    public boolean CheckDiagonal(String player){
        boolean win = false;
        if (boardGUI[0][0].getText().equals(" ")){
        } else {
            if(boardGUI[0][0].getText().equals(player) && boardGUI[1][1].getText().equals(player) && boardGUI[2][2].getText().equals(player)){
                prompt.Winner();
                win = true;
            }
        }
        if(win == false){
            if(boardGUI[0][2].getText().equals(" ")){

            } else {
                if(boardGUI[0][2].getText().equals(player) && boardGUI[1][1].getText().equals(player) && boardGUI[2][0].getText().equals(player)){
                    prompt.Winner();
                    win = true;
                }
            }
        }

        return win;
    }

    public void CheckBoard(){
        boolean full = true;
        for(int i = 0; i < 3; i++){
            for(int c = 0; c < 3; c++){
                if(boardGUI[i][c].getText().equals(" ")){
                    full = false;
                }
            }
        }
        if(full == true){
            prompt.Tie();
            prompt.PlayAgain();
        }
    }

    public void EarlyCheck()
    {
        boolean tie = true;
        //Rows
        for(int r = 0; r < 3; r++)
        {
            if(boardGUI[r][0].getText().equals(boardGUI[r][1].getText()))
                if(boardGUI[r][2].getText().equals(" "))
                    tie = false;

            if(boardGUI[r][0].getText().equals(boardGUI[r][2].getText()))
                if(boardGUI[r][1].getText().equals(" "))
                    tie = false;

            if(boardGUI[r][1].getText().equals(boardGUI[r][2].getText()))
                if(boardGUI[r][0].getText().equals(" "))
                    tie = false;
        }

        //Columns
        for(int r = 0; r < 3; r++){
            if(boardGUI[0][r].getText().equals(boardGUI[1][r].getText())) {
                if (boardGUI[2][r].getText().equals(" ")) {
                    tie = false;
                }
            }
            if(boardGUI[0][r].getText().equals(boardGUI[2][r].getText())){
                if(boardGUI[1][r].getText().equals(" ")){
                    tie = false;
                }
            }
            if(boardGUI[1][r].getText().equals(boardGUI[2][r].getText())){
                if(boardGUI[0][r].getText().equals(" ")) {
                    tie = false;
                }
            }
        }

        //Diagonal
        if(boardGUI[0][0].getText().equals(boardGUI[1][1].getText())) {
            if (boardGUI[2][2].getText().equals(" ")) {
                tie = false;
            }
        }
        if(boardGUI[0][0].getText().equals(boardGUI[2][2].getText())) {
            if (boardGUI[1][1].getText().equals(" ")) {
                tie = false;
            }
        }
        if(boardGUI[1][1].getText().equals(boardGUI[2][2].getText())) {
            if (boardGUI[0][0].getText().equals(" ")) {
                tie = false;
            }
        }
        if(boardGUI[0][2].getText().equals(boardGUI[1][1].getText())){
            if(boardGUI[2][2].getText().equals(" ")) {
                tie = false;
            }
        }

        if(boardGUI[0][2].getText().equals(boardGUI[2][0].getText())) {
            if (boardGUI[1][1].getText().equals(" ")) {
                tie = false;
            }
        }

        if(boardGUI[1][1].getText().equals(boardGUI[2][0].getText())) {
            if (boardGUI[0][0].getText().equals(" ")) {
                tie = false;
            }
        }
        if(tie == true) {
            prompt.EarlyTie();
            prompt.PlayAgain();
        }

    }
}
