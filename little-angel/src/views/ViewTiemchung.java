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

    public ViewTiemchung() {
        setLayout(new BorderLayout());
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
        
        Container center1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        CheckBox cb1 = new CheckBox("irem1");
        CheckBox cb2 = new CheckBox("irem2");
        CheckBox cb3 = new CheckBox("irem3");
        CheckBox cb4 = new CheckBox("irem4");
        cb1.getStyle().setFont(createSystemFont);
        cb1.setPreferredSize(new Dimension(240, 30));
        cb2.getStyle().setFont(createSystemFont);
        cb2.setPreferredSize(new Dimension(240, 30));
        cb3.getStyle().setFont(createSystemFont);
        cb3.setPreferredSize(new Dimension(240, 30));
        cb4.getStyle().setFont(createSystemFont);
        cb4.setPreferredSize(new Dimension(240, 30));
        center.addComponent(cb1);
        center.addComponent(cb2);
        center.addComponent(cb3);
        
        Container ct4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        ct4.addComponent(cb4);
        center.addComponent(ct4);
        
        
        center.setPreferredSize(new Dimension(240, 120));
        center.setScrollableY(true);
        center1.addComponent(center);
        
        Container center2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        CheckBox cb1x = new CheckBox("irem1");
        CheckBox cb2x = new CheckBox("irem1");
        CheckBox cb3x = new CheckBox("irem1");
        CheckBox cb4x = new CheckBox("irem1");
        cb1x.getStyle().setFont(createSystemFont);
        cb1x.setPreferredSize(new Dimension(240, 30));
        cb2x.getStyle().setFont(createSystemFont);
        cb2x.setPreferredSize(new Dimension(240, 30));
        cb3x.getStyle().setFont(createSystemFont);
        cb3x.setPreferredSize(new Dimension(240, 30));
        cb4x.getStyle().setFont(createSystemFont);
        cb4x.setPreferredSize(new Dimension(240, 30));
        
        center2.addComponent(cb1x);
        center2.addComponent(cb2x);
        center2.addComponent(cb3x);
        center2.addComponent(cb4x);
        
        
        center2.setPreferredSize(new Dimension(240, 120));
        center2.setScrollableY(true);
        center1.addComponent(center2);
        addComponent(BorderLayout.CENTER, center1);
        
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
        save.setPreferredSize(new Dimension(240, 50));
        south.addComponent(save);
        
        addComponent(BorderLayout.SOUTH, south);
        south.setPreferredSize(new Dimension(240, 90));
        back = new Command("Back");
        addCommandListener(this);
        setBackCommand(back);
        addCommand(back);
        setScrollableY(true);
        this.show();
        
        show();
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            Controller.getInstance().showRemind();
        }
        if (ae.getSource() == save) {
        }
        if (ae.getSource() == bt) {
            Controller.getInstance().showViewTime2();            
        }
        
    }
}
