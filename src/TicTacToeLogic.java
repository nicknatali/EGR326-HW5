/**
 * Class to perform logical operations for game
 * @author Nick Natali
 * @author Renden Yoder
 */
public class TicTacToeLogic {
    private char[][] gameBoard = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};
    private boolean isFinished = true;
    Player[] players = new Player[2];
    private Player currPlayer;


    /**
     * Constructor for logic of game
     * @param player1 name for player1
     * @param player2 name for player2
     */
    public TicTacToeLogic(String player1, String player2) {
        players[0] = new Player(player1);
        players[1] = new Player(player2);
        currPlayer = players[0];
    }


    /**
     * Sets the choice of the player if possible
     * @param row row of choice
     * @param col col of choice
     * @return char representing if the player has made a valid move
     */
    public char setChoice(int row, int col) {
        if(!isOccupied(row, col)){
            if(currPlayer.equals(players[0])){
                gameBoard[row][col] = 'X';
                currPlayer = players[1];
                return 'X';
            } else{
                gameBoard[row][col] = 'O';
                currPlayer = players[0];
                return 'O';
            }
        }
        return ' ';
    }


    /**
     * Checks if position is free on board
     * @param row row of choice
     * @param col col of choice
     * @return boolean value
     */
    public boolean isOccupied(int row, int col){
        return gameBoard[row][col] != ' ';
    }


    /**
     * Gets whether there should be a current game in session
     * @return boolean value
     */
    public boolean isFinished() {
        return isFinished;
    }


    /**
     * Sets whether there should be a current game in session
     * @param finished boolean for what state isFinished should be
     */
    public void setFinished(boolean finished) {
        isFinished = finished;
    }


    /**
     * Gets current players
     * @return the array of players
     */
    public Player[] getPlayers() {
        return players;
    }


    /**
     * Gets current player
     * @return the current players
     */
    public Player getCurrPlayer() {
        return currPlayer;
    }


    /**
     * Checks board to see if a player has won yet and then decides which player gets points
     * @return boolean for if any player has won
     */
    public boolean checkForWin() {
        //Make a string builder to hold board values
        StringBuilder charSeq = new StringBuilder();
        StringBuilder charSeqVert = new StringBuilder();
        //Interate over board and create a sequence
        for(int i = 0; i < 3; i++){
            charSeq.append("|");
            charSeqVert.append("|");
            for(int j = 0; j < 3; j++){
                charSeq.append(gameBoard[i][j]);
                charSeqVert.append(gameBoard[j][i]);
            }
        }
        //Create a winner
        Player winner = null;
        //Check for a winner
        if(charSeq.toString().contains("XXX")){
            winner = players[0];
        } else if(charSeq.toString().contains("OOO")){
            winner = players[1];
        } else if(charSeqVert.toString().contains("XXX")){
            winner = players[0];
        } else if(charSeqVert.toString().contains("OOO")){
            winner = players[1];
        } else if(charSeq.charAt(1) == 'X' && charSeq.charAt(6) == 'X' && charSeq.charAt(11) == 'X'){
            winner = players[0];
        } else if(charSeq.charAt(3) == 'X' && charSeq.charAt(6) == 'X' && charSeq.charAt(9) == 'X'){
            winner = players[0];
        } else if(charSeq.charAt(1) == 'O' && charSeq.charAt(6) == 'O' && charSeq.charAt(11) == 'O'){
            winner = players[1];
        } else if(charSeq.charAt(3) == 'O' && charSeq.charAt(6) == 'O' && charSeq.charAt(9) == 'O'){
            winner = players[1];
        }
        //Add win to that winner
        if(winner != null && winner.equals(players[0])){
            players[0].addWin();
            players[1].addLoss();
            isFinished = true;
            return true;
        } else if(winner != null && winner.equals(players[1])){
            players[1].addWin();
            players[0].addLoss();
            isFinished = true;
            return true;
        }
        return false;
    }


    /**
     * Resets all values on the board and resets players scores
     */
    public void reset() {
        //Set the current player as player 1
        currPlayer = players[0];
        //Wipe board values
        newGame();
        //Reset players scores
        players[0].reset();
        players[1].reset();
    }


    /**
     * Resets all values on the board
     */
    public void newGame() {
        //Set the current player as player 1
        currPlayer = players[0];
        //Reset all value on the board
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                gameBoard[i][j] = ' ';
            }
        }
    }
}
