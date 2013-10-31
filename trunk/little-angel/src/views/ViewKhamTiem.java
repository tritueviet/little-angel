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
import com.sun.lwuit.list.ListCellRenderer;
import java.util.Date;
import javax.microedition.pim.Contact;

/**
 *
 * @author FOX
 */
public class ViewKhamTiem extends Form implements ActionListener {

    Form kham = new Form("khám thai");
    Form tiem = new Form("tiêm chủng");
    Command back;

    public ViewKhamTiem(int index) {
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Tabs t = new Tabs();

        t.addTab("khám", kham);
        t.addTab("tiêm", tiem);
        t.setTabPlacement(TOP);
        t.setSelectedIndex(index);
        addComponent(t);
        tiem.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        /*
        for (int i = 0; i < 5; i++) {
            Renderer c1 = new Renderer("mang thai", "" + i);
            kham.addComponent(c1);
        }
        */
        TextArea tea= new TextArea("- 3 tháng đầu khám thai 1 lần.    "
                + "\n- 3 tháng giữa khám thai 1 lần.    "
                + "\n- Tháng thứ 7,8 mỗi tháng khám 1 lần.    "
                + "\n- Tháng thứ 9: 2 tuần khám 1 lần.    "
                + "\n- 1 tuần cuối trước khi sanh khám 1 lần.",10,10);
        tea.setEditable(false);
        
        
        
        kham.addComponent(tea);
        
        for (int i = 0; i < Var.dd1.length; i++) {
            if (Var.dd1[i] == 1) {
                Renderer c1 = new Renderer(Var.v1[i], "1/11/2013");
                tiem.addComponent(c1);
            }
        }
        for (int i = 0; i < Var.dd2.length; i++) {
            if (Var.dd2[i] == 1) {
                Renderer c1 = new Renderer(Var.v2[i], "1/11/2013");
                tiem.addComponent(c1);
            }
        }
        tiem.setScrollableY(true);
        kham.setScrollableY(true);
        setScrollableY(true);

//        Label a = new Label("fsd");
//        tiem.addComponent(a);
//        
        back = new Command("Back");
        addCommandListener(this);
        setBackCommand(back);
        addCommand(back);
        show();

    }

    public void actionPerformed(ActionEvent ae) {
        Controller.getInstance().showRemind();
    }
}

class Renderer extends Container implements ListCellRenderer {

    private Label name = new Label("");
    private Label date = new Label("");
    private Label focus = new Label("");

    public Renderer(String name, String date) {
        setLayout(new BorderLayout());
        this.name.setText(name);
        this.date.setText(date);
        //addComponent(BorderLayout.WEST, pic);
        Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        //this.name.getStyle().setBgTransparency(0);
        this.name.getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
        //this.email.getStyle().setBgTransparency(0);
        cnt.addComponent(this.name);
        cnt.addComponent(this.date);
        addComponent(BorderLayout.CENTER, cnt);

        //focus.getStyle().setBgTransparency(100);
    }

    public Component getListCellRendererComponent(List list, Object value, int index, boolean isSelected) {

        return this;
    }

    public Component getListFocusComponent(List list) {
        return focus;
    }
}
