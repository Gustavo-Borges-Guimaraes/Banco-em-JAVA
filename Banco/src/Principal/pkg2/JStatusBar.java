package Principal.pkg2;

import java.awt.Dimension;
import javax.swing.JLabel;

public class JStatusBar extends JLabel{
    JStatusBar()
    {
        super("Pronto...");
        super.setPreferredSize(new Dimension(100,16));
    }
    public void setMessage(String msg){
        this.setText(msg);
    }
}
