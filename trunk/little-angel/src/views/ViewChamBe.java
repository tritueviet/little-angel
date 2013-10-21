/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Controller;
import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.List;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import java.util.Vector;

/**
 *
 * @author FOX
 */
public class ViewChamBe extends Form implements ActionListener{
    Vector v = new Vector();
    List list = new List(v);
    Command back;
    public void init(){
        v.addElement("cho ăn");
        v.addElement("bú sữa ngoài");
        v.addElement("Ngủ");
        v.addElement("Thay tã");
        v.addElement("Uống thuốc");
        v.addElement("Khám sức khỏe");
        v.addElement("Bú sữa ngoài");
        v.addElement("Khác ...");
    }
    public ViewChamBe(){
        init();
        setTitle("Chăm bé");
        setLayout(new BorderLayout());
        addComponent(BorderLayout.CENTER,list);
        list.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                int t = list.getSelectedIndex();
                if(t!=7)
                    Controller.getInstance().showReminder(v.elementAt(t).toString());
                else 
                    Controller.getInstance().showReminder("");
            }
        });
        back = new Command("Back");
        addCommandListener(this);
        setBackCommand(back);
        addCommand(back);
        show();
        
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){
            Controller.getInstance().showRemind();
        }
    }
}
