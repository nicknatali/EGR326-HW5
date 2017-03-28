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

    //Swing Variables for Board
    JFrame frame;
    JPanel panel;
    private static JButton buttons[] = new JButton[9]; //create 9 buttons

    //Swing Variables for Player 1
    JLabel player1;
    JLabel player1Name;
    JTextArea player1NameEntry;
    JLabel player1WinsLabel;
    JLabel player1LossesLabel;
    Integer player1Wins = 0;
    Integer player1Lossess = 0;

    //Swing Variables for Player 2
    JLabel player2;
    JLabel player2Name;
    JTextArea player2NameEntry;
    JLabel player2WinsLabel;
    JLabel player2LossesLabel;
    Integer player2Wins = 0;
    Integer player2Lossess = 0;

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


        /**
         * This was my attempt of getting the name and text area on one line.
         *
        playerOnePanel.setLayout(new GridBagLayout());
        frame.getContentPane().add(playerOnePanel);
        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.EAST;
        GridBagConstraints right = new GridBagConstraints();
        right.weightx = 2.0;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;

         * Then when you add it to the panel you add it like
         * playerOnePanel.add(player1NameEntry, right);
         */


        //Swing Variables for Player 1
        player1 = new JLabel("Player 1 (x): ");
        player1Name = new JLabel("Name: ");
        player1NameEntry = new JTextArea();
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
        player2NameEntry = new JTextArea();
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
        frame.setVisible(true);
        frame.setSize(500, 500);// set frame size and let teh game begin
    }

}