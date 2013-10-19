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
public class ViewDate extends Form implements ActionListener {

    Command back;
    TextField tday = new TextField(3);
    TextField tmonth = new TextField(3);
    TextField tyear = new TextField(4);
    Button save;

    public ViewDate() {
        setLayout(new BorderLayout());

        Container center = new Container();
        center.setLayout(new GridLayout(3, 2));
        Label day = new Label("Nhập ngày: ");
        Label month = new Label("Nhập tháng: ");
        Label year = new Label("Nhập năm: ");

        center.addComponent(day);
        center.addComponent(tday);
        center.addComponent(month);
        center.addComponent(tmonth);
        center.addComponent(year);
        center.addComponent(tyear);

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
            if (tday.getText().length() > 0
                    && tday.getText().length() > 0
                    && tday.getText().length() > 0) {
                Var.stringc2 = tday.getText() + "/" + tmonth.getText() + "/" + tyear.getText();
                Controller.getInstance().showKhamthai();
            }
        }
    }
}
