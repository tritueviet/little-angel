/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.nokia.mid.ui.CategoryBar;
import com.nokia.mid.ui.ElementListener;
import com.nokia.mid.ui.IconCommand;
import com.sun.lwuit.Display;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;
import event.Event;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Image;
import views.*;

/**
 *
 * @author TRITUEVIET
 */
public class Controller {

    private static Controller instance = null;
    private static Resources theme;
    public CategoryBar categoryBar;
    private Image icon;
    private Main main;

    private Controller() {
        // Init here
        // getCurrentLocation();
        init();
    }

    public void init() {
        IconCommand[] iconCommands = new IconCommand[4];

        for (int i = 0; i < iconCommands.length; i++) {
            try {
                icon = Image.createImage("/images/icon" + (i + 1) + ".png");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            iconCommands[i] = new IconCommand("", icon, null, Command.SCREEN, 1);

        }
        categoryBar = new CategoryBar(iconCommands, true);
        // categoryBar.setHighlightColour(bankId);

        categoryBar.setElementListener(new CategoryElementListener());

        categoryBar.setVisibility(true);

    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void chay(Main main) {
        this.main = main;
        if (1 == 0) {
            LoadScreen load = new LoadScreen(main);
            javax.microedition.lcdui.Display.getDisplay(main).setCurrent(load);
            load.start();

            load = null;

            categoryBar.setVisibility(false);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        categoryBar.setVisibility(true);
        handleEvent(Event.ACTION_HOME, null);
    }

    public void handleEvent(int eventType, Event evt) {
        switch (eventType) {
            case Event.ACTION_HOME:
                showHome();
                    break;
                
                    
        }
    }
    
    public void showHome(){
        if(categoryBar.getVisibility()==false)
            categoryBar.setVisibility(true);
        ViewHome viewHome= new ViewHome();
        //javax.microedition.lcdui.Display.getDisplay(main).setCurrent(viewHome);
        viewHome.show();
    
    }
    public void showHotLine(){
        ViewHotLine viewhot = new ViewHotLine();
        viewhot.show();
    
    }
    public void showChoice(int i){
        ViewChoice viewchoice= new ViewChoice(i);
        //javax.microedition.lcdui.Display.getDisplay(main).setCurrent(viewHome);
        viewchoice.show();
    
    }
    public void showInform(){
        if(categoryBar.getVisibility()==true)
            categoryBar.setVisibility(false);
        ViewInform view = new ViewInform();
        view.show();
    }
    public void showRemind(){
        if(categoryBar.getVisibility()==true)
            categoryBar.setVisibility(false);
        ViewRemind view = new ViewRemind();
        view.show();
    }
    
    
    
    public void exit() {
        //   saveConfig();
        main.destroyApp(true);
    }
//    public static void loadTheme() {
//        try {
//            if (theme == null) {
//                theme = Resources.open("/themes/full_touch_theme.res");
//            }
//            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
//        } catch (Throwable ex) {
//        }
//    }
    class CategoryElementListener implements ElementListener {

        public void notifyElementSelected(CategoryBar bar, int selectedIndex) {
            if (bar == categoryBar) {
                if (selectedIndex == 0) {
                    showHome();
                } else if (selectedIndex == 1) {
                    // autoFinder();
                } else if (selectedIndex == 2) {
                    showHotLine();
                } else if (selectedIndex == 3) {
                    // showOptionATM();
                } else {
                    try {
                        exit();
                    } catch (Exception ex) {
                        System.out.println("k thoats ddc ");
                    }
                }

            }
        }
    }
}