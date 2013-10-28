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
import com.sun.lwuit.list.DefaultListModel;
import java.io.IOException;

/**
 *
 * @author FOX
 */
public class ViewTiemchung extends Form implements ActionListener {
    
    Command back;
    Button save;
    Button bt;
    
    CheckBox []c1 = new CheckBox[Var.v1.length] ;     
    CheckBox []c2 = new CheckBox[Var.v2.length] ;     
    public ViewTiemchung() {
        
        setLayout(new BorderLayout());
        setTitle("tiêm chủng");
        Font createSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL);
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
        Container center1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        for( int i = 0;i<Var.v1.length;i++){
             c1[i] = new CheckBox(Var.v1[i].toString());
             c1[i].getStyle().setFont(createSystemFont);
             c1[i].setPreferredSize(new Dimension(240, 30));
             c1[i].addActionListener(this);
             if(Var.dd1[i]==1) c1[i].setSelected(true);
             center1.addComponent(c1[i]);
             
        }
        //center1.setPreferredSize(new Dimension(240, 120));
        center1.setScrollableY(true);
        center.addComponent(center1);
        Container center2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        for(int i = 0;i<Var.v2.length;i++){
             c2[i] = new CheckBox(Var.v2[i].toString());
             c2[i].getStyle().setFont(createSystemFont);
             c2[i].setPreferredSize(new Dimension(240, 30));
             c2[i].addActionListener(this);
             if(Var.dd2[i]==1) c2[i].setSelected(true);
             center2.addComponent(c2[i]);
        }
        //center2.setPreferredSize(new Dimension(240, 240));
        center2.setScrollableY(true);
        center.addComponent(center2);
        addComponent(BorderLayout.CENTER, center);
        
        Container south = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container south1 = new Container(new GridLayout(2, 2));
        
        Label la = new Label("thoi gian");
        bt = new Button(Var.stringtc);
        bt.addActionListener(this);
        south1.addComponent(la);
        south1.addComponent(bt);
        la.setPreferredSize(new Dimension(50, 30));
        bt.setPreferredSize(new Dimension(50, 30));
        
        Label la2 = new Label("so lan");
        TextField bt2 = new TextField("2");
        bt2.setConstraint(TextField.NUMERIC);
        bt2.setEditable(false);
        la2.setPreferredSize(new Dimension(50, 30));
        bt2.setPreferredSize(new Dimension(50, 30));
        south1.addComponent(la2);
        south1.addComponent(bt2);
        
        south.addComponent(south1);
        
        save = new Button("Save");
        save.setPreferredSize(new Dimension(240, 90));
        save.addActionListener(this);
        south.addComponent(save);
        
        addComponent(BorderLayout.SOUTH, south);
        south.setPreferredSize(new Dimension(240, 120));
        back = new Command("Back");
        addCommandListener(this);
        setBackCommand(back);
        addCommand(back);
        setScrollableY(true);
        this.show();
        
        show();
    }
    
    public void actionPerformed(ActionEvent ae) {
        for(int i= 0;i<c1.length;i++){
            if(ae.getSource()== c1[i]){
                if(c1[i].isSelected()){
                    Var.dd1[i] = 1;
                }
                else {
                    Var.dd1[i] = 0;
                }
            }
        }
        for(int i= 0;i<c2.length;i++){
            if(ae.getSource()== c2[i]){
                if(c2[i].isSelected()){
                    Var.dd2[i] = 1;
                }
                else {
                    Var.dd2[i] = 0;
                }
            }
        }
        if (ae.getSource() == back) {
            Controller.getInstance().showRemind();
        }
        if (ae.getSource() == save) {
            Controller.getInstance().registerTimerAlarm(Var.date_mang_thai.getTime());
            Controller.getInstance().showKhamTiem(1);
        }
        if (ae.getSource() == bt) {
            Controller.getInstance().showViewTime2();            
        }
        
    }
}
