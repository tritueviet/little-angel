/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Controller;
import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BoxLayout;

/**
 *
 * @author FOX
 */
public class ViewResult extends Form implements ActionListener {
    Command back = new Command("back");
    String namex2;
    String namex4;
    public ViewResult(String namex2,String namex4){
        this.namex2 = namex2;
        this.namex4 = namex4;
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Label x1 = new Label("Remind about");
        Label x2 = new Label(namex2);
        Label x3 = new Label("Time");
        Label x4 = new Label(namex4);
        addComponent(x1);
        addComponent(x2);
        addComponent(x3);
        addComponent(x4);
        addCommandListener(this);
        setBackCommand(back);
        addCommand(back);
        show();
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back)
        Controller.getInstance().showChamBe();
    }
    
}
