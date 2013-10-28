/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Var;
import com.sun.lwuit.ComboBox;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import java.util.Vector;

/**
 *
 * @author TRITUEVIET
 */
public class ViewSetting extends Form {

    ComboBox combo;

    public ViewSetting() {
        Vector item = new Vector();
        int chon = 0;
        boolean ok = false;
        for (int i = 1; i < Var.listBe.size(); i = i + 6) {
            item.addElement(Var.listBe.elementAt(i));
            if (Var.maBe == Integer.parseInt(Var.listBe.elementAt(i - 1) + "")) {
                ok = true;
            }
            if (ok == false) {
                chon++;
            }
        }
        combo = new ComboBox(item);
        combo.setSelectedIndex(chon);
        combo.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                int selec= combo.getSelectedIndex()*6;
                
                Var.maBe=Integer.parseInt(Var.listBe.elementAt(selec)+"");
                Var.Babyname = Var.listBe.elementAt(selec+1).toString();
                Var.CANNANG = Var.listBe.elementAt(selec+2).toString();
                Var.CHIEUCAO = Var.listBe.elementAt(selec+3).toString();
                Var.THANG = Var.listBe.elementAt(selec+4).toString();
                Var.SEX = Var.listBe.elementAt(selec+5).toString();
            }
        });
        setTitle("cài đặt");
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        addComponent(new Label("chọn bé: "));

    }
}
