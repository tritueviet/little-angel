/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Var;
import com.sun.lwuit.CheckBox;
import com.sun.lwuit.Container;
import com.sun.lwuit.Form;
import com.sun.lwuit.Image;
import com.sun.lwuit.Label;
import com.sun.lwuit.List;
import com.sun.lwuit.geom.Dimension;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.list.DefaultListModel;
import java.io.IOException;

/**
 *
 * @author FOX
 */
public class ViewTiemchung extends Form{
    public ViewTiemchung(){
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
        List list = new List(new DefaultListModel());
        
        try {
            CheckBox cb1 = new CheckBox("irem1", Image.createImage("/images/baby.PNG"));
            CheckBox cb2 = new CheckBox("irem1", Image.createImage("/images/baby.PNG"));
            CheckBox cb3 = new CheckBox("irem1", Image.createImage("/images/baby.PNG"));
            CheckBox cb4 = new CheckBox("irem1", Image.createImage("/images/baby.PNG"));
//            center1.addComponent(cb4);
//            center1.addComponent(cb3);
//            center1.addComponent(cb2);
//            center1.addComponent(cb1);
            list.addItem(cb1);
            list.addItem(cb2);
            list.addItem(cb3);
            list.addItem(cb4);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        center.addComponent(list);
        center.setPreferredSize(new Dimension(240, 50));
        center.setScrollableY(true);
        addComponent(BorderLayout.CENTER,center);
        show();
    }
}
