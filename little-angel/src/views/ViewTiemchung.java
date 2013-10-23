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
        CheckBox cb1 = new CheckBox("BCG");
        CheckBox cb2 = new CheckBox("r-HBvax");
        CheckBox cb3 = new CheckBox("DPT");
        CheckBox cb4 = new CheckBox("Vắc xin bại liệt uống");
        CheckBox cb5 = new CheckBox("Quinaxem");
        CheckBox cb6 = new CheckBox("Rouvax ");
        CheckBox cb7 = new CheckBox("Vắc xin sởi ");
        CheckBox cb8 = new CheckBox("Vắc xin uốn ván hấp phụ");
     
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
        center.addComponent(cb4);
        center.addComponent(cb5);
        center.addComponent(cb6);
        center.addComponent(cb7);
        center.addComponent(cb8);

        center.setPreferredSize(new Dimension(240, 120));
        center.setScrollableY(true);
        center1.addComponent(center);
        
        Container center2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
/*Infanrix-hexa 
Pentaxim
Tetraxim 
Tritanrix 
Euvax 
Engerix
Rotarix 
Vaxigrip 
Act- Hib
Hiberix
Avaxim 
Trimovax (ROR)
MMR II
Priorix 
Okavax 
Varilrix
Meningo A+C
Pneumo 23
Jevax
Vắc xin uốn ván hấp phụ
Gardasil 
Cervavix */

        CheckBox cb1x = new CheckBox("Infanrix-hexa");
        CheckBox cb2x = new CheckBox("Pentaxim");
        CheckBox cb3x = new CheckBox("Tetraxim");
        CheckBox cb4x = new CheckBox("Tritanrix ");
        CheckBox cb5x = new CheckBox("Euvax ");
        CheckBox cb6x = new CheckBox("Engerix");
        CheckBox cb7x = new CheckBox("Rotarix ");
        CheckBox cb8x = new CheckBox("Vaxigrip");
        CheckBox cb9x = new CheckBox("Act- Hib");
        CheckBox cb10x = new CheckBox("Hiberix");
        CheckBox cb11x = new CheckBox("Avaxim ");
        CheckBox cb12x = new CheckBox("Trimovax (ROR)");
        CheckBox cb13x = new CheckBox("MMR II");
        CheckBox cb14x = new CheckBox("Priorix ");
        CheckBox cb15x = new CheckBox("Okavax ");
        CheckBox cb16x = new CheckBox("Varilrix");
        CheckBox cb17x = new CheckBox("Meningo A+C");
        CheckBox cb18x = new CheckBox("Pneumo 23");
        CheckBox cb19x = new CheckBox("Vắc xin uốn ván hấp phụ");
        CheckBox cb20x = new CheckBox("Gardasil ");
        CheckBox cb21x = new CheckBox("Cervavix");
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
        center2.addComponent(cb5x);
        center2.addComponent(cb6x);
        center2.addComponent(cb7x);
        center2.addComponent(cb8x);
        center2.addComponent(cb9x);
        center2.addComponent(cb10x);
        center2.addComponent(cb11x);
        center2.addComponent(cb12x);
        center2.addComponent(cb13x);
        center2.addComponent(cb14x);
        center2.addComponent(cb15x);
        center2.addComponent(cb16x);
        center2.addComponent(cb17x);
        center2.addComponent(cb18x);
        center2.addComponent(cb19x);
        center2.addComponent(cb20x);
        center2.addComponent(cb21x);
        
        
        
        center2.setPreferredSize(new Dimension(240, 240));
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
        save.setPreferredSize(new Dimension(240, 60));
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
