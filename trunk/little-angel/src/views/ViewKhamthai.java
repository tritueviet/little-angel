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
        c2date = new Button(Var.stringc2);
        c2date.addActionListener(this);
        center1.addComponent(c2name);
        center1.addComponent(c2date);
        
        Label c3name = new Label("so lan kham");
        TextField c3date = new TextField();
        center1.addComponent(c3name);
        center1.addComponent(c3date);
        
        Label c4name = new Label("thoi gian");
        c4date = new Button(Var.stringc4);
        c4date.addActionListener(this);
        center1.addComponent(c4name);
        center1.addComponent(c4date);
        
        center.addComponent(center1);
        addComponent(BorderLayout.CENTER,center);
        
//        Spinner dateSpinner = Spinner.createDate(System.currentTimeMillis() - 1000 * DAY,
//                System.currentTimeMillis() + 1000 * DAY, System.currentTimeMillis(),
//                '-', Spinner.DATE_FORMAT_MM_DD_YYYY);
//        
//        c2date.setConstraint(DateField.DATE_TIME);
//        c4date.setConstraint(DateField.DATE_TIME);
        
//        Container c5 = new Container(new BoxLayout(BoxLayout.X_AXIS));
//        c5.addComponent(bt);
        addComponent(BorderLayout.SOUTH,bt);
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
            Controller.getInstance().showKhamTiem();
        }
        if(ae.getSource()==c2date){
            Controller.getInstance().showViewDate();
        }
        if(ae.getSource()==c4date){
            Controller.getInstance().showKhamTiem();
        }
    }
}
