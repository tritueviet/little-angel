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
import com.sun.lwuit.geom.Dimension;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
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
        thour.setConstraint(TextField.NUMERIC);
        tminute.setConstraint(TextField.NUMERIC);

        center.addComponent(hour);
        center.addComponent(thour);
        center.addComponent(minute);
        center.addComponent(tminute);
        hour.setPreferredSize(new Dimension(50, 30));
        thour.setPreferredSize(new Dimension(50, 30));
        minute.setPreferredSize(new Dimension(50, 30));
        tminute.setPreferredSize(new Dimension(50, 30));
        
        Container space = new Container();
        space.setPreferredSize(new Dimension(240, 200));

        addComponent(BorderLayout.CENTER, center);
        Container south = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        south.addComponent(space);
        save = new Button("Save");
        save.addActionListener(this);
        south.addComponent(save);
        addComponent(BorderLayout.SOUTH, south);

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
