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
    Button img1, sucKhoe, NhacNho;
    
    Command cmdAdd;
    
    public ViewHome() {
        try {
            cmdAdd= new Command("thêm",Image.createImage("/images/add.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        setDefaultCommand(cmdAdd);
        addCommandListener(this);
        
        this.setLayout(new BoxLayout(BoxLayout.X_AXIS));
        Font createSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL);
        for (int i = 0; i < 35; i++) {
            lb[i] = new Label((35 - (i - 1)) + " tháng tuổi");
            try {
                if (i != 80 || i != 0 || i != 39) {
                    bt[i] = new Button(Image.createImage("/images/iconbt1.png"));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try {

            bt[35] = new Button(Image.createImage("/images/iconbt1.png"));
            bt[36] = new Button(Image.createImage("/images/iconbt1.png"));
            bt[37] = new Button(Image.createImage("/images/iconbt1.png"));
            bt[38] = new Button(Image.createImage("/images/iconbt1.png"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        lb[35] = new Label("4 tuần tuổi");
        lb[36] = new Label("3 tuần tuổi ");
        lb[37] = new Label("2 tuần tuổi ");
        lb[38] = new Label("1 tuần tuổi ");

        lb[39] = new Label("Sinh con");

        for (int i = 40; i < 81; i++) {
            lb[i] = new Label("thai kỳ tuần " + (81 - i));
            try {
                if (i != 80 || i != 0 || i != 39) {
                    bt[i] = new Button(Image.createImage("/images/iconbt1.png"));
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        //  3 màu buttum khác  0 39 80
        try {
            bt[0] = new Button(Image.createImage("/images/iconbt2.png"));
            bt[39] = new Button(Image.createImage("/images/iconbt2.png"));
            bt[80] = new Button(Image.createImage("/images/iconbt2.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
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
        table.getStyle().setMargin(0, 0, 0, 0);
        tablename.getStyle().setMargin(0, 0, 0, 0);
        Container con = new Container();
        con.setScrollableY(true);
        con.addComponent(tablename);
        con.addComponent(table);
        con.getStyle().setMargin(5, 5, 7, 7);
        
        
        addComponent(con);
        setScrollableY(false);
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
            Label lbName = new Label("Tên bé:");
            if (Var.Babyname.length() > 0) {
                lbName.setText(Var.Babyname);
            }
            b1.addComponent(img1);
            b1.addComponent(lbName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        baby.addComponent(b1);
        Container b2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label b2name = new Label("Tháng tuổi:");
        Label b2inform = new Label(Var.THANG);

        b2.addComponent(b2name);

        b2.addComponent(b2inform);
        Container b3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label b3name = new Label("Cân nặng:");
        Label b3inform = new Label(Var.CANNANG);

        b3.addComponent(b3name);

        b3.addComponent(b3inform);
        Container b4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label b4name = new Label("Chiều cao:");
        Label b4inform = new Label(Var.CHIEUCAO);

        b4.addComponent(b4name);

        b4.addComponent(b4inform);

        baby.addComponent(b2);

        baby.addComponent(b3);

        baby.addComponent(b4);
        Container b5 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label b5name = new Label("Giới tính:");
        Label b5inform = new Label(Var.SEX);
        b5.addComponent(b5name);
        b5.addComponent(b5inform);
        baby.addComponent(b5);
        baby.getStyle().setMargin(0, 0, 0, 0);
        
        try {
            sucKhoe = new Button("Sức khỏe", Image.createImage("/images/nenlam3.PNG"));
            NhacNho = new Button("Nhắc nhở", Image.createImage("/images/nenlam4.PNG"));
            NhacNho.addActionListener(this);
            sucKhoe.addActionListener(this);
            sucKhoe.setUIID("Demobutton");
            NhacNho.setUIID("Demobutton");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        sucKhoe.addActionListener(this);
        NhacNho.addActionListener(this);
        baby.addComponent(sucKhoe);
        baby.addComponent(NhacNho);
        addComponent(baby);
        baby.setScrollableY(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==NhacNho){
            Controller.getInstance().showRemind();
        }
        else if(ae.getSource()==sucKhoe){
            Controller.getInstance().showSucKhoe();
        }else
        if (ae.getSource() == img1) {
            Controller.getInstance().showInform();
        }
        else  if(ae.getSource()==cmdAdd){
            Var.listBe.addElement(Var.maBe+"");
            Var.listBe.addElement(Var.Babyname);
            Var.listBe.addElement(Var.CANNANG);
            Var.listBe.addElement(Var.CHIEUCAO);
            Var.listBe.addElement(Var.THANG);
            Var.listBe.addElement(Var.SEX);
            
            Var.maBe=(Integer.parseInt(Var.maBe)+1)+"";
            Var.Babyname="*";
            Var.CANNANG="*";
            Var.CHIEUCAO="*";
            Var.THANG="*";
            Var.SEX="*";
            
            Controller.getInstance().showHome();
            
        }
         else   
        for (int i = 0; i < 81; i++) {
            if (ae.getSource() == bt[i] && i != 39) {
                Controller.getInstance().showChoice(i);
            }
        }
       
        
        
    }
}
