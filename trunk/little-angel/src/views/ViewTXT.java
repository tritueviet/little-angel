/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Controller;
import Control.Var;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Font;
import com.sun.lwuit.Form;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import event.Event;

/**
 *
 * @author TRITUEVIET
 */
public class ViewTXT extends Form implements ActionListener {

    private Command backCommand;
    int k;

    public ViewTXT( String string, String tittle) {
        super(tittle);
//        this.k=k;

        Controller.getInstance().categoryBar.setVisibility(false);
        refreshTheme();
        repaint();
        Font font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL);
        TextArea textArea = null;

        textArea = new TextArea(string.substring(1), 2, 20);


        textArea.setEditable(false);
        textArea.setGrowByContent(true);
        textArea.getStyle().setBgTransparency(0);
        //textArea.setUIID("Label");
        textArea.getStyle().setFont(font);
        Container contai = new Container();
        contai.addComponent(textArea);
        contai.setScrollable(true);
        contai.setScrollableX(false);
        addComponent(contai);
        // ta.setEditable(false);
        //setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        backCommand = new Command(Var.back);
        setBackCommand(backCommand);
        addCommand(backCommand);
        // addComponent(ta);
        addCommandListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getCommand() == backCommand) {
            Controller.getInstance().viewDinhDuong();
        }
    }
}