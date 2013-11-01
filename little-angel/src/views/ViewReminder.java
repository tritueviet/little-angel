/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;


import Control.Controller;
import Control.Var;
import java.util.Calendar;
import java.util.Date;
import javax.microedition.lcdui.*;


/**
 *
 * @author FOX
 */
public class ViewReminder extends Form implements CommandListener {
    Command save;
    Command back;
    DateField datefield;
    String tittle;
    public ViewReminder(String tittle) {
        super("Reminder");
        this.tittle = tittle;
        TextField tf = new TextField("Remind about",tittle , 10, TextField.ANY);
        append(tf);
        datefield = new DateField("Set time:", DateField.DATE_TIME);
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
           Controller.getInstance().showChamBe();
       }
       if(c==save){
           Controller.getInstance().registerTimerAlarm(datefield.getDate().getTime());
           Calendar Cal = Calendar.getInstance();
           Cal.setTime(datefield.getDate());
           String c2 = Cal.get(Cal.DATE)+"-"+Cal.get(Cal.MONTH)+"-"+Cal.get(Cal.YEAR) +
                   "   "+Cal.get(Cal.HOUR)+":"+Cal.get(Cal.MINUTE);
           Controller.getInstance().showResult(tittle, c2);
       }
    }
}

