/**
 * Created by NickNatali on 3/17/17.
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.util.Observer;

public class TicTacToeGUI extends JFrame  {

    //Swing Variables for Board
    JFrame frame;
    JPanel panel;
    private static JButton buttons[] = new JButton[9]; //create 9 buttons

    /**
     * Constructs the GUI and displays it on the screen.
     */
    public TicTacToeGUI() {
        frame = new JFrame ("Tic Tac Toe");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        //Create a panel for the score board
        JPanel scoreBoardContainer = new JPanel();
        JPanel playerOnePanel = new JPanel();
        JPanel playerTwoPlanel = new JPanel();

        playerOnePanel.add(new JLabel("Player 1 (x): "));
        playerOnePanel.add(new JLabel("Name: "));
        playerOnePanel.add(new JTextArea());
        playerOnePanel.add(new JLabel("Wins: "));
        playerOnePanel.add(new JLabel("Losses: "));


        playerTwoPlanel.add(new JLabel("Player 1 (x): "));
        playerTwoPlanel.add(new JLabel("Name: "));
        playerTwoPlanel.add(new JTextArea());
        playerTwoPlanel.add(new JLabel("Wins: "));
        playerTwoPlanel.add(new JLabel("Losses: "));

        scoreBoardContainer.setLayout(new GridLayout(1,2));
        scoreBoardContainer.add(playerOnePanel);
        scoreBoardContainer.add(playerTwoPlanel);

        frame.add(scoreBoardContainer);

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