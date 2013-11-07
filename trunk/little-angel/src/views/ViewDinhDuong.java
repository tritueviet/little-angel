/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Controller;
import Control.Var;
import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.List;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;

/**
 *
 * @author TRITUEVIET
 */
public class ViewDinhDuong extends Form {

    List list=null;
    Command backk= new Command("trở về");
    
    public ViewDinhDuong() {
        
        
        list = new List(Var.thongTinBoSung);
        list.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                Controller.getInstance().showTXT(list.getSelectedIndex());
            }
        });
        addComponent(list);
        setBackCommand(backk);
        addCommandListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                Controller.getInstance().showChoice(Var.viTriChoice);
            }
        });
        addCommand(backk);
    }
}
