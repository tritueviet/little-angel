/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Controller;
import Control.Var;
import com.sun.lwuit.Command;
import com.sun.lwuit.Component;
import com.sun.lwuit.Container;
import com.sun.lwuit.Font;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.List;
import com.sun.lwuit.Tabs;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.list.ListCellRenderer;
import java.util.Calendar;

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
         int a[]={31,28,31,30,31,30,31,31,30,31,30,31};
         Calendar Cal = Calendar.getInstance();
           Cal.setTime(Var.date_);
            int day = Cal.get(Cal.DATE);
            int month = Cal.get(Cal.MONTH)+1;
            int year = Cal.get(Cal.YEAR);
            int sum = 0;
            for(int i =0;i<month-1;i++)
                sum+=a[i];
            sum+=day;
            System.out.println(""+sum);
            System.out.println(""+month);
            
            int x1 = sum+90;
            int y1= year;
            if(x1 >365){
                y1 = year +1;
                x1-=365;
            }
            System.out.println(""+x1);
            int d1,m1,i1 = 0;
            for(i1 =0;i1<12;i1++){
                if(x1- a[i1]<0) break;
                else x1-=a[i1];
            }
            System.out.println(""+i1);
            m1 = i1+1;
            d1 = x1;
            
            int x2 = sum+160;
             System.out.println(""+x2);
            int y2= year;
            if(x2 >365){
                y2 = year +1;
                x2-=365;
            }
            int d2,m2,i2 = 0;
            for(i2 =0;i2<12;i2++){
                if(x2- a[i2]<0) break;
                else x2-=a[i2];
            }
            System.out.println(""+i2);
            m2 = i2+1;
            d2 = x2;
            
            int x3 = sum+260;
             System.out.println(""+x3);
            int y3= year;
            if(x3 >365){
                y3 = year +1;
                x3-=365;
            }
            int d3,m3,i3 = 0;
            for(i3 =0;i3<12;i3++){
                if(x3- a[i3]<0) break;
                else x3-=a[i3];
            }
            m3 = i3+1;
            d3 = x3;
            int x4 = sum+280;
            int y4= year;
            if(x4 >365){
                y4 = year +1;
                x4-=365;
            }
            int d4,m4,i4 = 0;
            for(i4 =0;i4<12;i4++){
                if(x4- a[i4]<0) break;
                else x4-=a[i4];
            }
            m4 = i4+1;
            d4 = x4;
           
        TextArea tea= new TextArea("lan kham 1:"+ d1+"-"+m1+"-"+y1
                + "\n "+"lan kham 2:"+ d2+"-"+m2+"-"+y2
                + "\n "+"lan kham 3:"+ d3+"-"+m3+"-"+y3
                + "\n "+"lan kham 4:"+ d4+"-"+m4+"-"+y4
                + "\n",10,10);
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
