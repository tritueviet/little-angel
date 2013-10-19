/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.sun.lwuit.Form;
import com.sun.lwuit.Tabs;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;

/**
 *
 * @author FOX
 */
public class ViewKhamTiem extends Form implements ActionListener{
    public ViewKhamTiem(){
        Tabs t = new Tabs();
        Form kham = new Form("Kham thai");
        Form tiem = new Form("tiem chung");
        t.addTab("kham",kham);
        t.addTab("tiem",tiem);
        addComponent(t);
        show();
        
    }
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
