/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Var;
import com.nokia.lwuit.components.PopupChoiceGroup;
import com.sun.lwuit.*;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.geom.Dimension;
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
    TextField b5inform;

    public ViewInform() {
        setLayout(new BorderLayout());
        setTitle("thông tin bé");
        Container north = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        Container b1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label b1name = new Label("Tên bé:        ");
        if (Var.Babyname.equals("*")) {
            b1inform = new TextField("");
        } else {
            b1inform = new TextField(Var.Babyname);
        }
        b1.addComponent(b1name);
        b1.addComponent(b1inform);

        Container b2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label b2name = new Label("Tháng tuổi:");


        if (Var.THANG.equals("*")) {
            b2inform = new TextField("");
        } else {
            b2inform = new TextField(Var.THANG);
        }
        b2inform.setConstraint(TextField.NUMERIC);
        b2.addComponent(b2name);
        b2.addComponent(b2inform);


        Container b3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label b3name = new Label("Cân nặng:   ");
        if (Var.CANNANG.equals("*")) {
            b3inform = new TextField("");
        } else {
            b3inform = new TextField(Var.CANNANG);
        }
        b3inform.setConstraint(TextField.NUMERIC);
        b3.addComponent(b3name);
        b3.addComponent(b3inform);


        Container b4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label b4name = new Label("Chiều cao:   ");
        if (Var.CHIEUCAO.equals("*")) {
            b4inform = new TextField("");
        } else {
            b4inform = new TextField(Var.CHIEUCAO);
        }
        b4inform.setConstraint(TextField.NUMERIC);
        b4.addComponent(b4name);
        b4.addComponent(b4inform);

        Container b5 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label b5name = new Label("Giới tính:     ");
        String[] str = {"nam", "nữ"};
        final ComboBox combo = new ComboBox(str);
        combo.setSelectedIndex(0);

        combo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                Var.SEX = combo.getSelectCommandText();
            }
        });
        if (Var.SEX.equals("*")) {
            b5inform = new TextField("");
        } else {
            b5inform = new TextField(Var.SEX);
        }
        b5inform.setConstraint(TextField.ANY);
        b5.addComponent(b5name);
        b5.addComponent(combo);
//        b5.addComponent(b5inform);

        north.addComponent(b1);
        north.addComponent(b2);
        north.addComponent(b3);
        north.addComponent(b4);
        north.addComponent(b5);
        //north.getStyle().setMargin(0, 0, 0, 0);
        addComponent(BorderLayout.CENTER, north);

//        Container center = new Container(new BoxLayout(BoxLayout.X_AXIS));
//        center.setPreferredSize(new Dimension(240, 70));
//        addComponent(BorderLayout.CENTER, center);
//        
        //Container south = new Container(new BorderLayout());
        save = new Button("Save");
        save.addActionListener(this);
        //south.addComponent(BorderLayout.CENTER, save);
        save.setPreferredSize(new Dimension(240, 50));
        addComponent(BorderLayout.SOUTH, save);

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
                    || b4inform.getText().length() <= 0
                    || b5inform.getText().length() <= 0) {
            } else {

                Var.THANG = b2inform.getText();
                Var.CANNANG = b3inform.getText();
                Var.CHIEUCAO = b4inform.getText();
                Var.Babyname = b1inform.getText();
                Var.SEX = b5inform.getText();

                for (int i = 0; i < Var.listBe.size(); i = i + 6) {
                    if (Var.maBe == Integer.parseInt(Var.listBe.elementAt(i).toString())) {
                        for (int j = 0; j < 6; j++) {
                            Var.listBe.removeElementAt(i);
                        }
                        Var.listBe.addElement(Var.maBe + "");
                        Var.listBe.addElement(Var.Babyname);
                        Var.listBe.addElement(Var.CANNANG);
                        Var.listBe.addElement(Var.CHIEUCAO);
                        Var.listBe.addElement(Var.THANG);
                        Var.listBe.addElement(Var.SEX);
                        
                        break;
                    }
                }

                Control.Controller.getInstance().showHome();
            }
        } else if (ae.getSource() == back) {
            Control.Controller.getInstance().showHome();
        }
    }
}
