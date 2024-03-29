/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Controller;
import Control.Var;
import com.sun.lwuit.*;
import com.sun.lwuit.Label;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.geom.Dimension;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.layouts.GridLayout;
import com.sun.lwuit.spinner.Spinner;
import com.sun.lwuit.table.TableLayout;
import java.io.IOException;
import javax.microedition.lcdui.DateField;

/**
 *
 * @author FOX
 */
public class ViewKhamthai extends Form implements ActionListener{
    private final int DAY = 86400000;
    Command back ;
    Button bt = new Button("Save");
    Button c2date,c4date;
    public ViewKhamthai() {
        setLayout(new BorderLayout());
//        Controller.getInstance().registerTimerAlarm( System.currentTimeMillis() + 15000);
//        Controller.getInstance().registerTimerAlarm( System.currentTimeMillis() + 6000);
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
        addComponent(BorderLayout.NORTH,north);
        
        Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label c1 = new Label("Cai dat nhac nho kham thai");
        center.addComponent(c1); 
        Container center1 = new Container(new GridLayout(3,2));
        
        Label c2name = new Label("ngay co thai");
        c2date = new Button(Var.stringc2 );
        if(Var.stringc2.equals("_/_/_")==false){
            String x1 = Var.stringc2;
            String x2 = "";
            String x3 = "";
            String x4 = "";
            int i = 0;
            while(i<x1.length()){
                if(x1.charAt(i)!= '/'){ x2+=x1.charAt(i);i++;}
                else break;
            }
            System.out.println(""+x2);
            i++;
            while(i<x1.length()){
                if(x1.charAt(i)!= '/'){ x3+=x1.charAt(i);i++;}
                else break;
            }
            i++;
            System.out.println(""+x3);
            while(i<x1.length()){
                if(x1.charAt(i)!= '/'){ x4+=x1.charAt(i);i++;}
                else break;
            }
            System.out.println(""+x4);
            java.util.Calendar Ca = java.util.Calendar.getInstance();
            Ca.set(java.util.Calendar.DAY_OF_MONTH,Integer.parseInt(x2));
            Ca.set(java.util.Calendar.MONTH,Integer.parseInt(x3));
            Ca.set(java.util.Calendar.YEAR,Integer.parseInt(x4));
            Var.date_ = Ca.getTime();
           Ca.set(java.util.Calendar.HOUR,19);
           Ca.set(java.util.Calendar.MINUTE,0);
           Var.date_mang_thai = Ca.getTime();
           Var.date_tiem_chung = Ca.getTime();
           
        }
        c2date.addActionListener(this);
        center1.addComponent(c2name);
        center1.addComponent(c2date);
        c2name.setPreferredSize(new Dimension(50, 30));
        c2date.setPreferredSize(new Dimension(50, 30));
        
        Label c3name = new Label("so lan kham");
        TextField c3date = new TextField("4");
        c3date.setConstraint(TextField.NUMERIC);
        c3date.setEditable(false);
       
        center1.addComponent(c3name);
        center1.addComponent(c3date);
        
        Label c4name = new Label("thoi gian");
        c4date = new Button("19:00");
        c4date.addActionListener(this);
        center1.addComponent(c4name);
        center1.addComponent(c4date);
        c4name.setPreferredSize(new Dimension(50, 30));
        c4date.setPreferredSize(new Dimension(50, 30));
        
        center.addComponent(center1);
        addComponent(BorderLayout.CENTER,center);
        
        addComponent(BorderLayout.SOUTH,bt);
        bt.setPreferredSize(new Dimension(50, 30));
        bt.addActionListener(this);
        
        back = new Command("Back");
        addCommandListener(this);
        setBackCommand(back);
        addCommand(back);
        this.show();

    }
    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getSource()==back){
            Controller.getInstance().showRemind();
        }
        if(ae.getSource()==bt){
            if(Var.date_mang_thai != null){
            Controller.getInstance().registerTimerAlarm(Var.date_mang_thai.getTime()+90*86400*1000);
            Controller.getInstance().registerTimerAlarm(Var.date_mang_thai.getTime()+160*86400*1000);
            Controller.getInstance().registerTimerAlarm(Var.date_mang_thai.getTime()+260*86400*1000);
            Controller.getInstance().registerTimerAlarm(Var.date_mang_thai.getTime()+280*86400*1000);
            }
            
            Controller.getInstance().showKhamTiem(0);
        }
        if(ae.getSource()==c2date){
            Controller.getInstance().showViewDate();
        }
        if(ae.getSource()==c4date){
            //Controller.getInstance().showViewTime();
        }
    }
}
