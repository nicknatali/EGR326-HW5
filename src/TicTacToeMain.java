/**
 * Calls the GUI application and starts the game
 * @author Nick Natali
 * @author Renden Yoder
 */
import javax.swing.*;

public class TicTacToeMain {
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new TicTacToeGUI();
            }
        });
    }
}