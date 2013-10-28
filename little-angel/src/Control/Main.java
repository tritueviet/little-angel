package Control;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.lwuit.Display;
import java.util.Date;
import javax.microedition.midlet.*;

/**
 * @author TRITUEVIET
 */
public class Main extends MIDlet {

    public Main() {
        Display.init(this);
        Controller.getInstance().loadConfig();
        Controller.getInstance().loadVector();
    }

    
    public void startApp() {
        
        Controller.getInstance().chay(this);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
        Controller.getInstance().updateConfig();
        Controller.getInstance().loadConfig();
        Controller.getInstance().updateConfig();
        notifyDestroyed();
    }
}
