/**
 * Created by NickNatali on 3/17/17.
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.util.Observer;

public class TicTacToeGUI extends JFrame  {

    /**
     * Initially when the program loads, the game is
     not yet begun. In this state, the main game buttons are disabled and cannot be clicked.
     The user is able to edit the players' names. The initial name text is
     "Player 1" for the first player and "Player 2" for the second player. If
     the user types an illegal player name, a dialog box (option pane)
     appears reading, "Illegal player name(s)." and the game does not begin.
     */

    //Swing Variables for Board
    JFrame frame;
    JPanel panel;
    private static JButton buttons[] = new JButton[9]; //create 9 buttons

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

    boolean isGameStarted;



    /**
     * Constructs the GUI and displays it on the screen.
     */
    public TicTacToeGUI() {
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
        player1NameEntry = new JTextField();
        player1WinsLabel = new JLabel("Wins: ");
        player1LossesLabel = new JLabel("Losses: ");


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
        player2NameEntry = new JTextField();
        player2WinsLabel = new JLabel("Wins: ");
        player2LossesLabel = new JLabel("Losses: ");

        playerTwoPanel.add(player2);
        playerTwoPanel.add(player2Name);
        playerTwoPanel.add(player2NameEntry);
        playerTwoPanel.add(player2WinsLabel);
        playerTwoPanel.add(player2LossesLabel);

        playerTwoPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        playerTwoPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 30), new EtchedBorder()));



        scoreBoardContainer.add(playerOnePanel);
        scoreBoardContainer.add(playerTwoPanel);

        frame.add(scoreBoardContainer, BorderLayout.NORTH);
        frame.pack();

        //Create a panel for the tic tac toe board
        panel = new JPanel();
        panel.setLayout (new GridLayout (3, 3));
        panel.setBorder (BorderFactory.createLineBorder (Color.darkGray, 3));
        panel.setBackground (Color.gray);

        //Tic Tac Toe Buttons
        for(int i=0; i<=8; i++){
            buttons[i] = new JButton();
            panel.add(buttons[i]);
        }

        frame.getContentPane().add (panel);
        frame.pack();
        frame.setSize(500, 500);


        /**
         * Buttons on bottom of GUI
         */
        JPanel buttonMenu = new JPanel();
        buttonMenu.setLayout(new FlowLayout(FlowLayout.CENTER));

        newGameButton = new JButton("New Game");
        resetButton = new JButton("Reset");
        exitButton = new JButton("Exit");

        buttonMenu.add(newGameButton);
        buttonMenu.add(resetButton);
        buttonMenu.add(exitButton);


        buttonMenu.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        buttonMenu.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), new EtchedBorder()));

        frame.add(buttonMenu, BorderLayout.SOUTH);

        frame.setVisible(true);
    }


    public void newGame() {

        if(!isGameStarted || player1Name.getText() == "" || player2Name.getText() == "") {

            exitButton.setEnabled(false);
            resetButton.setEnabled(false);

            //Loop through Board Buttons
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setEnabled(false);
            }

        } else if(newGameButton.getModel().isPressed() && player1Name.getText() != "" && player2Name.getText() != "" ) {


            newGameButton.addActionListener(e -> {
                System.out.println("It works.");

                exitButton.setEnabled(true);
                resetButton.setEnabled(true);

                //Loop through Board Buttons
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                }
                isGameStarted = true;

            });

        } else {
                player1NameEntry.addActionListener(e -> {
                        //If the user enters a null name for Player 1
                        if(player1NameEntry.getText() == "") {



                        } else {


                        }
                });

            player2NameEntry.addActionListener(e -> {
                //If the user enters a null name for Player 1
                if(player2NameEntry.getText() == "") {



                } else {


                }
            });


            }
        }

    }

}