/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Controller;
import com.sun.lwuit.*;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.list.ListCellRenderer;
import javax.microedition.pim.Contact;

/**
 *
 * @author FOX
 */
public class ViewKhamTiem extends Form implements ActionListener{
     Form kham = new Form("Kham thai");
     Form tiem = new Form("tiem chung");
     Command back;
    public ViewKhamTiem(){
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Tabs t = new Tabs();
       
        t.addTab("kham",kham);
        t.addTab("tiem",tiem);
        addComponent(t);
        tiem.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        for(int i= 0;i<5;i++)
        {
            ContactsRenderer c1 = new ContactsRenderer("mang thai",""+i);
            ContactsRenderer c2 = new ContactsRenderer("tiem chung","" +i);
            kham.addComponent(c1);
            tiem.addComponent(c2);
        }
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
class ContactsRenderer extends Container implements ListCellRenderer {

  private Label name = new Label("");
  private Label email = new Label("");
  private Label pic = new Label("");
  private Label focus = new Label("");

  public ContactsRenderer(String name,String email) {
      setLayout(new BorderLayout());
      this.name.setText(name);
      this.email.setText(email);
      addComponent(BorderLayout.WEST, pic);
      Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
      //this.name.getStyle().setBgTransparency(0);
      this.name.getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_MEDIUM));
      //this.email.getStyle().setBgTransparency(0);
      cnt.addComponent(this.name);
      cnt.addComponent(this.email);
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
