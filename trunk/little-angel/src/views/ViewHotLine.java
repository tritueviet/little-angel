/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.List;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.list.DefaultListModel;

/**
 *
 * @author FOX
 */
public class ViewHotLine extends Form {
    public List list = new List();
    public Command cm[] = new Command[5];
    public ViewHotLine(){
        list.setModel(new DefaultListModel());
        for(int i= 0;i<5;i++){
            cm[i] = new Command("sdt thu"+i);
            list.addItem(cm[i]);
        }
        addComponent(list);
         list.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                int t = list.getSelectedIndex();
                


            }
        });
        show();
    
    }
}
