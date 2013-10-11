/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Controller;
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
public class ViewHome extends Form implements ActionListener{

    public Container table = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    public Container tablename = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    public Button[] bt = new Button[33];
    public Label[] lb = new Label[33];

    public ViewHome() {
        this.setLayout(new BoxLayout(BoxLayout.X_AXIS));
        Font createSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);
        for (int i = 0; i < 24; i++) {
            if (i == 0) {
                lb[i] = new Label("2 tuổi ");
            } else if (i == 12) {
                lb[i] = new Label("1 tuổi ");
            } else {
                lb[i] = new Label((24 - i) + "tháng ");
            }
        }
        lb[24] = new Label("0 tuổi ");
        for(int i = 25;i<33;i++){
            lb[i] = new Label((33 - i+1) + "tháng ");
        }
        for (int i = 0; i < 33; i++) {
            try {
                bt[i] = new Button(Image.createImage("/images/iconbt.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            lb[i].getStyle().setFont(createSystemFont);
            lb[i].setPreferredSize(new Dimension(70, 20));
            bt[i].setPreferredSize(new Dimension(20, 20));
            
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

            table.addComponent(bt[i]);
            tablename.addComponent(lb[i]);
        }
        addComponent(tablename);
        addComponent(table);
        table.getStyle().setMargin(0, 0, 0, 0);
        tablename.getStyle().setMargin(0, 0, 0, 0);


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
        for(int i=0;i<33;i++){
            if(ae.getSource()==bt[i]){
                Controller.getInstance().showChoice(i);
            }
        }
    }
}
