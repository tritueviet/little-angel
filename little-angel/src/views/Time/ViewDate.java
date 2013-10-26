/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views.Time;

import Control.Controller;
import Control.Var;
import java.util.Calendar;
import java.util.Date;
import javax.microedition.lcdui.*;


/**
 *
 * @author FOX
 */
public class ViewDate extends Form implements CommandListener {
    Command save;
    Command back;
    DateField datefield;
    public ViewDate() {
        super("SMS Timer");
        datefield = new DateField("Set time:", DateField.DATE);
        datefield.setDate(new Date());

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
           Cal.setTime(datefield.getDate());
           Var.stringc2 = Cal.get(Cal.DAY_OF_MONTH)+"/"+Cal.get(Cal.MONTH)+"/" + Cal.get(Cal.YEAR);
           Controller.getInstance().showKhamthai();
       }
    }
}
