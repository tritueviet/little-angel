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
import com.sun.lwuit.list.DefaultListModel;

/**
 *
 * @author FOX
 */
public class ViewChoice extends Form implements ActionListener{
    public List list = new List();
    public ViewChoice(int vt){
         list.setModel(new DefaultListModel());
         Command item1 = new Command("Item1");
         Command item2 = new Command("Item2");
         Command item3 = new Command("Item3");
         list.addItem(item1);
         list.addItem(item2);
         list.addItem(item3);
         list.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                int t = list.getSelectedIndex();
                


            }
        });
         addComponent(list);
         Command back = new Command("Back");
         addCommandListener(this);
         setBackCommand(back);
         addCommand(back);
         show();
        
    }

    public void actionPerformed(ActionEvent ae) {
        Controller.getInstance().showHome(); 
    }
}
