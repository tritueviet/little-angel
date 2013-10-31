/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Time;

import Control.Controller;
import Control.Var;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import javax.microedition.lcdui.*;


/**
 *
 * @author FOX
 */
public class ViewTime extends Form implements CommandListener {
    Command save;
    Command back;
    DateField datefield;
    Date date = new Date();
    public ViewTime() {
        super("Time");
        datefield = new DateField("Set time:", DateField.DATE_TIME);

//        if(Var.date_mang_thai != null)
        datefield.setDate(Var.date_);
        back = new Command("Back", Command.BACK, 1);
        save = new Command("Save", Command.OK, 1);
        this.append(datefield);
        this.addCommand(save);
        this.addCommand(back);
        setCommandListener(this);
    }

    
    public void commandAction(Command c, Displayable d) {
       if(c==back){
           Controller.getInstance().showKhamthai();
       }
       if(c==save){
           Calendar Cal = Calendar.getInstance(); 
 //          Cal.setTime(datefield.getDate());
//           String s  = datefield.toString();
//           String hour = ""+s.charAt(11) + s.charAt(12);
//           System.out.println(""+hour);
//           String minute = ""+s.charAt(14) + s.charAt(15);
//           System.out.println(""+minute);
//           System.out.println(""+Cal.toString());
//           Cal.set(Calendar.HOUR, Integer.parseInt(hour));
//           Cal.set(Calendar.MINUTE, Integer.parseInt(minute));
           Var.date_mang_thai = datefield.getDate();
           
           Var.stringc4 = ""+Cal.get(Cal.HOUR)+":"+Cal.get(Cal.MINUTE);
           Controller.getInstance().showKhamthai();
       }
    }
}
