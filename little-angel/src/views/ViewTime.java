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
import com.sun.lwuit.layouts.GridLayout;

/**
 *
 * @author FOX
 */
public class ViewTime extends Form implements ActionListener{
    Command back;
    TextField thour = new TextField(3);
    TextField tminute = new TextField(3);
    Button save;

    public ViewTime() {
        setLayout(new BorderLayout());

        Container center = new Container();
        center.setLayout(new GridLayout(3, 2));
        Label hour = new Label("Nhập giờ: ");
        Label minute = new Label("Nhập phút: ");
        

        center.addComponent(hour);
        center.addComponent(thour);
        center.addComponent(minute);
        center.addComponent(tminute);
        

        addComponent(BorderLayout.CENTER, center);
        save = new Button("Save");
        save.addActionListener(this);
        addComponent(BorderLayout.SOUTH, save);

        back = new Command("Back");
        addCommandListener(this);
        setBackCommand(back);
        addCommand(back);
        this.show();

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            Controller.getInstance().showKhamthai();
        }
        if (ae.getSource() == save) {
            if (thour.getText().length() > 0
                    && tminute.getText().length() > 0) {
                Var.stringc4 = thour.getText() + ":" + tminute.getText();
                Controller.getInstance().showKhamthai();
            }
        }
    }
}
