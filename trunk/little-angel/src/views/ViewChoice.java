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
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.list.DefaultListModel;
import java.io.IOException;

/**
 *
 * @author FOX
 */
public class ViewChoice extends Form implements ActionListener {

    public List list = new List();
    Command item1, item2, item3, item4, item5;
    Command back;
    public ViewChoice(int vt) {
        setLayout(new BorderLayout());
        Container north = new Container(new BoxLayout(BoxLayout.X_AXIS));
        try {
            Image img =  Image.createImage("/images/baby.PNG");
            Label lb = new Label(img);
            Label lbname = new Label(Var.Babyname);
            if(Var.Babyname.length()==0){
                lbname.setText("Tên bé");
            }
            north.addComponent(lb);
            north.addComponent(lbname);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        addComponent(BorderLayout.NORTH,north);
        
        list.setModel(new DefaultListModel());
        
        try {
            item1 = new Command("Bạn nên làm", Image.createImage("/images/nenlam1.PNG"));
            item2 = new Command("Bạn không nên làm", Image.createImage("/images/nenlam1.PNG"));
            item3 = new Command("Sức khỏe", Image.createImage("/images/nenlam3.PNG"));
            item4 = new Command("Nhắc nhở", Image.createImage("/images/nenlam4.PNG"));
            item5 = new Command("Chế độ dinh dưỡng", Image.createImage("/images/nenlam5.PNG"));
            list.addItem(item1);
            list.addItem(item2);
            list.addItem(item3);
            list.addItem(item4);
            list.addItem(item5);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        list.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                int t = list.getSelectedIndex();
                    if(t==3){
                          Controller.getInstance().showRemind();
                    }


            }
        });
        addComponent(BorderLayout.CENTER,list);
        back = new Command("Back");
        addCommandListener(this);
        setBackCommand(back);
        addCommand(back);
        show();

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== back){
            Controller.getInstance().showHome();
        }
    }
}
