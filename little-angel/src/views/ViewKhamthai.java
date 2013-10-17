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
        
        Container c2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label c2name = new Label("ngay co thai");
        TextField c2date = new TextField();
        c2.addComponent(c2name);
        c2.addComponent(c2date);
        center.addComponent(c2);
        
        Container c3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label c3name = new Label("so lan kham");
        TextField c3date = new TextField();
        c3.addComponent(c3name);
        c3.addComponent(c3date);
        center.addComponent(c3);
        
        Container c4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label c4name = new Label("thoi gian");
        TextField c4date = new TextField();
        c4.addComponent(c4name);
        c4.addComponent(c4date);
        center.addComponent(c4);
        addComponent(BorderLayout.CENTER,center);
        
        Spinner dateSpinner = Spinner.createDate(System.currentTimeMillis() - 1000 * DAY,
                System.currentTimeMillis() + 1000 * DAY, System.currentTimeMillis(),
                '-', Spinner.DATE_FORMAT_MM_DD_YYYY);
        
        c2date.setConstraint(DateField.DATE_TIME);
        c4date.setConstraint(DateField.DATE_TIME);
        
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
    }
}
