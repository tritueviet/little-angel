/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Controller;
import Control.Var;
import com.sun.lwuit.*;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.list.DefaultListModel;
import java.io.IOException;

/**
 *
 * @author FOX
 */
public class ViewRemind extends Form implements ActionListener{
    Button item1, item2, item3;
    Command back;
    public ViewRemind() {
        setLayout(new BorderLayout());
        Container north = new Container(new BoxLayout(BoxLayout.X_AXIS));
        try {
            Image img = Image.createImage("/images/baby.PNG");
            Label lb = new Label(img);
            Label lbname = new Label(Var.Babyname);
            if (Var.Babyname.length() == 0) {
                lbname.setText("Tên bé");
            }
            north.addComponent(lb);
            north.addComponent(lbname);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        addComponent(BorderLayout.NORTH, north);
        Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        try {
            item1 = new Button(Image.createImage("/images/khamthai1.png"));
            item1.setUIID("Demobutton");
            item2 = new Button(Image.createImage("/images/tiemchung1.png"));
            item3 = new Button(Image.createImage("/images/chambe1.png"));
            item2.setUIID("Demobutton");
            item3.setUIID("Demobutton");
            center.addComponent(item1);
            center.addComponent(item2);
            center.addComponent(item3);
            item1.addActionListener(this);
            item2.addActionListener(this);
            item3.addActionListener(this);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        addComponent(BorderLayout.CENTER,center);
        back = new Command("Back");
        addCommandListener(this);
        setBackCommand(back);
        addCommand(back);
        show();
         
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==item1){
            Controller.getInstance().showKhamthai();
        }
        if(ae.getSource()==item2){
            Controller.getInstance().showTiemchung();
        }
        if(ae.getSource()==item3){}
        if(ae.getSource()==back){
            Controller.getInstance().showChoice(Var.choice);
        }
    }
}
