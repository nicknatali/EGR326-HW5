/**
 * Created by NickNatali on 3/23/17.
 */
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BoardButtons extends JButton implements ActionListener {

    //Image for the XO buttons
    ImageIcon X,O;
    //If zero do nothing, if 1 it is x if 2 it is zero
    int value=0;

        public BoardButtons(){
            X=new ImageIcon(this.getClass().getResource("X.png"));
            O=new ImageIcon(this.getClass().getResource("O.png"));
            this.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e){
            value++;
            value%=3;
            switch(value){
                case 0:
                    setIcon(null);
                    break;
                case 1:
                    setIcon(X);
                    break;
                case 2:
                    setIcon(O);
                    break;
            }
        }


}
