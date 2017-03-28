import javax.swing.*;

/**
 * Created by NickNatali on 3/17/17.
 */
public class TicTacToeMain {

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new TicTacToeGUI();
            }
        });
    }
}