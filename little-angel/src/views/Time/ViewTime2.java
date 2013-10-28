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
        datefield = new DateField("Set time:", DateField.DATE_TIME);
        if(Var.date_mang_thai != null)
        datefield.setDate(Var.date_tiem_chung);

        back = new Command("Back", Command.BACK, 1);
        save = new Command("Save", Command.OK, 1);
        this.append(datefield);
        this.addCommand(save);
        this.addCommand(back);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == back) {
            Controller.getInstance().showTiemchung();
        }
        if (c == save) {
            Calendar Cal = Calendar.getInstance();
            Cal.setTime(datefield.getDate());
            Var.date_tiem_chung = datefield.getDate();
            Var.stringtc = Cal.get(Cal.DAY_OF_MONTH) + "/" + Cal.get(Cal.MONTH) + "/"
             + Cal.get(Cal.YEAR) + " " + Cal.get(Cal.HOUR) + ":" + Cal.get(Cal.MINUTE);
            Controller.getInstance().showTiemchung();
        }
    }
}
