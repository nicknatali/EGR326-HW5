/**
 * Creates GUI and TicTacToeLogic class object
 * @author Nick Natali
 * @author Renden Yoder
 */
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.io.File;

public class TicTacToeGUI extends JFrame  {
    //Logic variable
    private TicTacToeLogic board = new TicTacToeLogic("", "");

    //Swing Variables for Board
    JFrame frame;
    JPanel panel;
    private static JButton buttons[][] = new JButton[3][3]; //create 9 buttons

    //Swing Variables for Player 1
    JLabel player1;
    JLabel player1Name;
    JTextField player1NameEntry;
    JLabel player1WinsLabel;
    JLabel player1LossesLabel;
    Integer player1Wins = 0;
    Integer player1Lossess = 0;
    //Swing Variables for Player 2
    JLabel player2;
    JLabel player2Name;
    JTextField player2NameEntry;
    JLabel player2WinsLabel;
    JLabel player2LossesLabel;
    Integer player2Wins = 0;
    Integer player2Lossess = 0;
    //Swing Variables for Button Menu
    JButton newGameButton;
    JButton resetButton;
    JButton exitButton;
    //Message for users
    JLabel currMessage = new JLabel("Press 'New Game' to start playing!");

    /**
     * Constructs the GUI and displays it on the screen.
     */
    public TicTacToeGUI() {
        //Creates the frame with required variables
        frame = new JFrame ("Tic Tac Toe");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        //Create a panel for the score board
        JPanel scoreBoardContainer = new JPanel();
        scoreBoardContainer.setLayout(new GridLayout(1,2));
        //Create a panel for player one within the scoreboard container
        JPanel playerOnePanel = new JPanel();
        playerOnePanel.setLayout(new BoxLayout(playerOnePanel, BoxLayout.Y_AXIS));
        //Create a panel for player two within the scoreboard container
        JPanel playerTwoPanel = new JPanel();
        playerTwoPanel.setLayout(new BoxLayout(playerTwoPanel, BoxLayout.Y_AXIS));
        //Swing Variables for Player 1
        player1 = new JLabel("Player 1 (x): ");
        player1Name = new JLabel("Name: ");
        player1NameEntry = new JTextField("Player 1");
        player1WinsLabel = new JLabel("Wins: " + board.players[0].getWins());
        player1LossesLabel = new JLabel("Losses: " + board.players[0].getLosses());
        //Adds the objects to the player 1 panel
        playerOnePanel.add(player1);
        playerOnePanel.add(player1Name);
        playerOnePanel.add(player1NameEntry);
        playerOnePanel.add(player1WinsLabel);
        playerOnePanel.add(player1LossesLabel);
        playerOnePanel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        playerOnePanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 30, 10, 10), new EtchedBorder()));

        //Swing Variables for Player 2
        player2 = new JLabel("Player 2 (o): ");
        player2Name = new JLabel("Name: ");
        player2NameEntry = new JTextField("Player 2");
        player2WinsLabel = new JLabel("Wins: " + board.players[1].getWins());
        player2LossesLabel = new JLabel("Losses: " + board.players[1].getLosses());
        //Adds the objects to the player 2 panel
        playerTwoPanel.add(player2);
        playerTwoPanel.add(player2Name);
        playerTwoPanel.add(player2NameEntry);
        playerTwoPanel.add(player2WinsLabel);
        playerTwoPanel.add(player2LossesLabel);
        playerTwoPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        playerTwoPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 30), new EtchedBorder()));
        //Add the two panels to the container
        scoreBoardContainer.add(playerOnePanel);
        scoreBoardContainer.add(playerTwoPanel);
        //Add the entire panel to the frame
        frame.add(scoreBoardContainer, BorderLayout.NORTH);
        frame.pack();

        //Create a panel for the tic tac toe board
        panel = new JPanel();
        panel.setLayout(new GridLayout (3, 3));
        panel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        panel.setBackground(Color.gray);

        //Tic Tac Toe Buttons
        int[] nums = {0,1,2};
        for(int x : nums){
            for(int y : nums){
                buttons[x][y] = new JButton();
                panel.add(buttons[x][y]);
                buttons[x][y].addActionListener(e -> {
                    //Attempt to set the names for the players
                    String nameOfP1 = player1NameEntry.getText().replace("Name: ", "");
                    String nameOfP2 = player2NameEntry.getText().replace("Name: ", "");
                    //Set the players names
                    board.getPlayers()[0].setName(nameOfP1);
                    board.getPlayers()[1].setName(nameOfP2);
                    //Check if all requirements have been met
                    if(nameOfP1.equals("") || nameOfP2.equals("") || nameOfP1.equals(nameOfP2)){
                        //Alert user of their error
                        JOptionPane.showMessageDialog(null, "Illegal player name(s).");
                    } else if(!board.isFinished()) {
                        //Try to place a character at the given space
                        char move = board.setChoice(x, y);
                        if (move == 'X') {
                            currMessage.setText("It's " + board.getPlayers()[1].getName() + "'s turn!");
                            //If its player 1's turn and the spot is open, place an X
                            try {
                                Image img = ImageIO.read(new File("./x.png"));
                                buttons[x][y].setIcon(new ImageIcon(img));
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        } else if (move == 'O') {
                            currMessage.setText("It's " + board.getPlayers()[0].getName() + "'s turn!");
                            //If its player 2's turn and the spot is open, place an O
                            try {
                                Image img = ImageIO.read(new File("./o.png"));
                                buttons[x][y].setIcon(new ImageIcon(img));
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        }
                        //Check for a win and if there is one, update info
                        if (board.checkForWin()) {
                            if(board.getCurrPlayer().equals(board.getPlayers()[0])){
                                currMessage.setText(board.getPlayers()[1].getName() + " won!");
                            } else {
                                currMessage.setText(board.getPlayers()[0].getName() + " won!");
                            }
                            player1WinsLabel.setText("Wins: " + board.players[0].getWins());
                            player1LossesLabel.setText("Losses: " + board.players[0].getLosses());
                            player2WinsLabel.setText("Wins: " + board.players[1].getWins());
                            player2LossesLabel.setText("Losses: " + board.players[1].getLosses());
                            disableButtons();
                        }
                    }
                });
            }
        }
        //Set buttons as disabled at first
        disableButtons();
        //Add panel to frame
        frame.getContentPane().add (panel);
        frame.pack();
        frame.setSize(500, 500);

        /**
         * Buttons on bottom of GUI
         */
        panel = new JPanel();
        panel.setLayout(new GridLayout (2, 1));
        //Create a new panel for the button menu
        JPanel buttonMenu = new JPanel();
        buttonMenu.setLayout(new FlowLayout(FlowLayout.CENTER));

        //Button to make a new game
        newGameButton = new JButton("New Game");
        //Set new game button action
        newGameButton.addActionListener(e -> {
            String nameOfP1 = player1NameEntry.getText().replace("Name: ", "");
            String nameOfP2 = player2NameEntry.getText().replace("Name: ", "");
            if(nameOfP1.equals("") || nameOfP2.equals("") || nameOfP1.equals(nameOfP2)){
                JOptionPane.showMessageDialog(null, "Illegal player name(s).");
            } else {
                //Set the new game with the give names
                board.getPlayers()[0].setName(nameOfP1);
                board.getPlayers()[1].setName(nameOfP2);

                //Update message
                currMessage.setText("It's " + board.getPlayers()[0].getName() + "'s turn!");
                //Wipe board
                wipeBoard();
                //Wipe board in logic class
                board.newGame();
                //Set flag for a game in progress
                board.setFinished(false);
            }
        });

        //Button for resetting the entire game
        resetButton = new JButton("Reset");
        //Set reset button action
        resetButton.addActionListener(e -> {
            //Prepare dialog to confirm reset
            String warning = "This will end the game and set the win/loss stats to 0. Are you sure?";
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, warning, "Confirm Reset", dialogButton);
            //If yes is clicked
            if(dialogResult == 0) {
                //Update message
                currMessage.setText("Press 'New Game' to start playing!");
                //Wipe board
                wipeBoard();
                //Wipe board and scores in logic class
                board.reset();
                //Set flag for a game in progress
                board.setFinished(true);
                //Set buttons as disabled at first
                disableButtons();
                //Update score labels on board
                player1NameEntry.setText("Player 1");
                player2NameEntry.setText("Player 2");
                player1WinsLabel.setText("Wins: " + board.players[0].getWins());
                player1LossesLabel.setText("Losses: " + board.players[0].getLosses());
                player2WinsLabel.setText("Wins: " + board.players[1].getWins());
                player2LossesLabel.setText("Losses: " + board.players[1].getLosses());
            }
        });

        //Create exit button
        exitButton = new JButton("Exit");
        //Set action for button
        exitButton.addActionListener(e -> {System.exit(0);});
        //Add all buttons to panel
        buttonMenu.add(newGameButton);
        buttonMenu.add(resetButton);
        buttonMenu.add(exitButton);
        //Add border for buttom menu
        buttonMenu.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        buttonMenu.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new EtchedBorder()));
        //Add button menu to the panel
        panel.add(buttonMenu);

        //Create a panel for messages
        JPanel messageBox = new JPanel();
        messageBox.setLayout(new FlowLayout(FlowLayout.CENTER));
        //Add the current message to the message box
        messageBox.add(currMessage);
        //Add a border to the message box
        messageBox.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        messageBox.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(20, 20, 20, 20), new EtchedBorder()));
        //Add the messageBox to the panel
        panel.add(messageBox);

        //Add the panel to the frame and set visible
        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }


    /**
     * Resets all icons of the buttons on the board and signals that it is an active board
     */
    public void wipeBoard(){
        for(JButton[] row : buttons){
            for(JButton each : row){
                each.setBackground(Color.GRAY);
                each.setOpaque(true);
                each.setIcon(null);
            }
        }
    }


    /**
     * Sets background to red to signify a non-active state
     */
    public void disableButtons(){
        for(JButton[] row : buttons){
            for(JButton each : row){
                each.setBackground(Color.RED);
                each.setOpaque(true);
            }
        }
    }
}