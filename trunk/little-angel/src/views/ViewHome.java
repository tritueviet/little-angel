/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Controller;
import Control.Var;
import com.sun.lwuit.*;
import com.sun.lwuit.Container;
import com.sun.lwuit.Form;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.geom.Dimension;
import com.sun.lwuit.layouts.BoxLayout;
import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author TRITUEVIET
 */
public class ViewHome extends Form implements ActionListener {

    public Container table = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    public Container tablename = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    public Button[] bt = new Button[81];
    public Label[] lb = new Label[81];
    Button img1;

    public ViewHome() {


        this.setLayout(new BoxLayout(BoxLayout.X_AXIS));
        Font createSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_LARGE);
        //  3 màu buttum khác  0 39 80
        try {
            bt[0] = new Button(Image.createImage("/images/iconbt2.png"));
            bt[39] = new Button(Image.createImage("/images/iconbt2.png"));
            bt[80] = new Button(Image.createImage("/images/iconbt2.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < 35; i++) {
            lb[i] = new Label((35 - (i - 1)) + " tháng tuổi");
            try {
                if (i != 0) {
                    bt[i] = new Button(Image.createImage("/images/iconbt1.png"));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        lb[35] = new Label(
                "4 tuần tuổi");
        lb[36] = new Label(
                "3 tuần tuổi ");
        lb[37] = new Label(
                "2 tuần tuổi ");
        lb[38] = new Label(
                "1 tuần tuổi ");

        lb[39] = new Label(
                "Sinh con");


        for (int i = 0;
                i
                < 39; i++) {
            try {
                bt[i] = new Button(Image.createImage("/images/iconbt1.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        for (int i = 40; i < 81; i++) {
            lb[i] = new Label("thai kỳ tuần " + (81 - i));
            try {
                if (i != 80) {
                    bt[i] = new Button(Image.createImage("/images/iconbt1.png"));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        for (int i = 0; i < 81; i++) {
            lb[i].getStyle().setFont(createSystemFont);
            lb[i].setPreferredSize(new Dimension(80, 25));
            bt[i].setPreferredSize(new Dimension(25, 25));

            bt[i].addActionListener(this);

            bt[i].getStyle().setBorder(null);
            bt[i].getStyle().setMargin(0, 0, 0, 0);
            bt[i].getPressedStyle().setMargin(0, 0, 0, 0);
            bt[i].getUnselectedStyle().setMargin(0, 0, 0, 0);
            bt[i].getSelectedStyle().setMargin(0, 0, 0, 0);
            bt[i].getStyle().setPadding(0, 0, 0, 0);
            bt[i].getPressedStyle().setPadding(0, 0, 0, 0);
            bt[i].getUnselectedStyle().setPadding(0, 0, 0, 0);
            bt[i].getSelectedStyle().setPadding(0, 0, 0, 0);

            lb[i].getStyle().setBorder(null);
            lb[i].getStyle().setMargin(0, 0, 0, 0);
            lb[i].getPressedStyle().setMargin(0, 0, 0, 0);
            lb[i].getUnselectedStyle().setMargin(0, 0, 0, 0);
            lb[i].getSelectedStyle().setMargin(0, 0, 0, 0);
            lb[i].getStyle().setPadding(0, 0, 0, 0);
            lb[i].getPressedStyle().setPadding(0, 0, 0, 0);
            lb[i].getUnselectedStyle().setPadding(0, 0, 0, 0);
            lb[i].getSelectedStyle().setPadding(0, 0, 0, 0);

            lb[i].setTickerEnabled(true);
            lb[i].setFocusable(true);
            lb[i].setTactileTouch(true);

            table.addComponent(bt[i]);
            tablename.addComponent(lb[i]);
        }

        addComponent(tablename);

        addComponent(table);

        table.getStyle().setMargin(0, 0, 0, 0);
        tablename.getStyle().setMargin(0, 0, 0, 0);
        Container baby = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container b1 = new Container(new BoxLayout(BoxLayout.X_AXIS));



        try {
            img1 = new Button(Image.createImage("/images/baby.PNG"));
            img1.setPreferredSize(new Dimension(39, 32));
            img1.setUIID("Demobutton");
            img1.addActionListener(this);
            img1.getStyle().setMargin(0, 0, 0, 0);
            img1.getPressedStyle().setMargin(0, 0, 0, 0);
            img1.getUnselectedStyle().setMargin(0, 0, 0, 0);
            img1.getSelectedStyle().setMargin(0, 0, 0, 0);
            img1.getStyle().setPadding(0, 0, 0, 0);
            img1.getPressedStyle().setPadding(0, 0, 0, 0);
            img1.getUnselectedStyle().setPadding(0, 0, 0, 0);
            img1.getSelectedStyle().setPadding(0, 0, 0, 0);
            Label img2 = new Label("Tên bé");
            if (Var.Babyname.length() > 0) {
                img2.setText(Var.Babyname);
            }
            b1.addComponent(img1);
            b1.addComponent(img2);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        baby.addComponent(b1);
        Container b2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label b2name = new Label("Tháng tuổi:");
        Label b2inform = new Label(Var.B2inform);

        b2.addComponent(b2name);

        b2.addComponent(b2inform);
        Container b3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label b3name = new Label("Cân nặng:");
        Label b3inform = new Label(Var.B3inform);

        b3.addComponent(b3name);

        b3.addComponent(b3inform);
        Container b4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label b4name = new Label("Chiều cao:");
        Label b4inform = new Label(Var.B4inform);

        b4.addComponent(b4name);

        b4.addComponent(b4inform);

        baby.addComponent(b2);

        baby.addComponent(b3);

        baby.addComponent(b4);

        baby.getStyle().setMargin(0, 0, 0, 0);
        addComponent(baby);
    }
//    protected void paint(Graphics g) {
//        g.setColor(0xffffff);
//        g.fillRect(0, 0, 240, 800);
//        g.setColor(0x333333);
//        g.fillRect(40,0,3, 800);
//        g.setColor(0xEE0000);
//        for(int i=0;i<33;i++){
//            g.fillArc(40, i*20+i*4, 4,4, 0, 360);
//        
//        }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == img1) {
            Controller.getInstance().showInform();
        }
        for (int i = 0; i < 81; i++) {
            if (ae.getSource() == bt[i] && i != 39) {
                Controller.getInstance().showChoice(i);
            }
        }
    }
}
