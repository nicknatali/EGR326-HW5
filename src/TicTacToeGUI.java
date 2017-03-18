/**
 * Created by NickNatali on 3/17/17.
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.util.Observer;

public class TicTacToeGUI extends JFrame {

    //Swing Variables for Board
    JFrame frame = new JFrame();
    JButton[][] boardButtons = new JButton[3][3];
    JButton newGame;
    JButton reset;
    JButton exit;

    //Swing Variables for Player 1
    JLabel player1 = new JLabel();
    JLabel player1Name = new JLabel();
    JTextArea player1NameEntry = new JTextArea();
    JLabel player1WinsLabel = new JLabel();
    JLabel player1LossesLabel = new JLabel();
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
        boardLayout();
//       // handleEvents();
//        doLayout();
        frame.setVisible(true);
    }

    //Sets up graphical components in the window
    public void boardLayout() {
        frame.setLayout(new BorderLayout());
        frame = new JFrame("Tic Tac Toe!");
        frame.setLocation(500, 500);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        player1 = new JLabel("Player 1 (X):");
        player1NameEntry = new JTextArea("Please enter your name...");
        player1Name.setText(String.valueOf(player1NameEntry));
        player1WinsLabel.setText(String.valueOf(player1Wins));
        player1LossesLabel.setText(String.valueOf(player1Lossess));



//
//
//        player2 = new JLabel("Player 2 (X):");
//        player2Name.setText(String.valueOf(player1NameEntry));
//        player2NameEntry = new JTextArea("Please enter your name...");
//        player2WinsLabel.setText(String.valueOf(player2Wins));
//        player2LossesLabel.setText(String.valueOf(player2Lossess));

        //GridLayout(int rows, int columns)

    }

    // sets up containers for layout in the window
    public void doLayout() {

//        frame.setLayout(new BorderLayout());
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(1, 2));
//
//        //Set up player 1
//        frame.add(player1, BorderLayout.NORTH);
//        frame.add(player1NameEntry, BorderLayout.NORTH);
//        frame.add(player1Name, BorderLayout.NORTH);
//        frame.add(player1WinsLabel, BorderLayout.NORTH);
//        frame.add(player1LossesLabel, BorderLayout.NORTH);

    }



}
