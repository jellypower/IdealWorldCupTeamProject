import java.awt.*;
import javax.swing.*;

public class Driver {
    public static void main(String[] args){
        JFrame f = new JFrame("이상형 월드컵");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UserDefinedInstalizingWorldCupPanel startPanel = new UserDefinedInstalizingWorldCupPanel();
        PrimaryPanel primary = new PrimaryPanel();
        f.getContentPane().add(primary);


        f.pack();
        f.setVisible(true);

    }
}
//change MS949
