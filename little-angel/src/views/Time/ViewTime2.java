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
public class ViewTime2 extends Form implements CommandListener {
    Command save;
    Command back;
    DateField datefield;
    public ViewTime2() {
        super("Time");
        datefield = new DateField("Set time:", DateField.TIME);
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
           Controller.getInstance().showTiemchung();
       }
       if(c==save){
           Calendar Cal = Calendar.getInstance();
           Cal.setTime(datefield.getDate());
           Var.stringc4 = Cal.get(Cal.HOUR)+":"+Cal.get(Cal.MINUTE);
           Controller.getInstance().showTiemchung();
       }
    }
}
