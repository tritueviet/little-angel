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
    Command item2, item3, item4, item5;
    Command back;
    private int vt=0;
    public ViewChoice(final int vt) {
        setLayout(new BorderLayout());
        this.vt=vt;
        Var.viTriChoice=vt;
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
           
            item2 = new Command("kiến thức bổ sung", Image.createImage("/images/nenlam1.PNG"));
//            item3 = new Command("Sức khỏe", Image.createImage("/images/nenlam3.PNG"));
//            item4 = new Command("Nhắc nhở", Image.createImage("/images/nenlam4.PNG"));
            item5 = new Command("Chế độ dinh dưỡng", Image.createImage("/images/nenlam5.PNG"));
            list.addItem(item2);
//            list.addItem(item3);
//            list.addItem(item4);
            list.addItem(item5);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        list.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                int t = list.getSelectedIndex();
                    
                    if(t==0){
                        Controller.getInstance().showBoSung(vt);
                    }
                    if(t==1){
                        //  show cái mới của anh dữ liêu lấy sau
                        Controller.getInstance().showDinhDuong();
                        
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
