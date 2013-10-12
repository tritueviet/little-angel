/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Var;
import com.sun.lwuit.*;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.layouts.Layout;
import javax.microedition.pim.ContactList;

/**
 *
 * @author FOX
 */
public class ViewInform extends Form implements ActionListener {

    Command back;
    Button save;
    TextField b1inform;
    TextField b2inform;
    TextField b3inform;
    TextField b4inform;

    public ViewInform() {
        setLayout(new BorderLayout());
        Container north = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        Container b1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label b1name = new Label("Tên bé:");
        b1inform = new TextField();
        b1.addComponent(b1name);
        b1.addComponent(b1inform);

        Container b2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label b2name = new Label("Tháng tuổi:");
        b2inform = new TextField();;
        b2inform.setConstraint(TextField.NUMERIC);
        b2.addComponent(b2name);
        b2.addComponent(b2inform);


        Container b3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label b3name = new Label("Cân nặng:");
        b3inform = new TextField();
        b3inform.setConstraint(TextField.NUMERIC);
        b3.addComponent(b3name);
        b3.addComponent(b3inform);


        Container b4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label b4name = new Label("Chiều cao:");
        b4inform = new TextField();
        b4inform.setConstraint(TextField.NUMERIC);
        b4.addComponent(b4name);
        b4.addComponent(b4inform);

        north.addComponent(b1);
        north.addComponent(b2);
        north.addComponent(b3);
        north.addComponent(b4);
        north.getStyle().setMargin(0, 0, 0, 0);
        addComponent(BorderLayout.NORTH, north);
        Container south = new Container(new BorderLayout());
        save = new Button("Save");
        save.addActionListener(this);
        south.addComponent(BorderLayout.CENTER,save);
        addComponent(BorderLayout.SOUTH, south);
        back = new Command("Back");
        addCommandListener(this);
        setBackCommand(back);
        addCommand(back);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == save) {
            if (b1inform.getText().length() <= 0
                    || b2inform.getText().length() <= 0
                    || b3inform.getText().length() <= 0
                    || b4inform.getText().length() <= 0) {
                
            }
            else {
                Var.B2inform = b2inform.getText();
                Var.B3inform = b3inform.getText();
                Var.B4inform = b4inform.getText();
                Var.Babyname = b1inform.getText();
                Control.Controller.getInstance().showHome();
            }
        } else if (ae.getSource() == back) {
            Control.Controller.getInstance().showHome();
        }
    }
}
