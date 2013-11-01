/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import views.Time.ViewDate;
import views.Time.ViewTime;
import views.Time.ViewTime2;
import com.nokia.mid.ui.CategoryBar;
import com.nokia.mid.ui.ElementListener;
import com.nokia.mid.ui.IconCommand;
import com.sun.lwuit.animations.CommonTransitions;
import com.sun.lwuit.animations.Transition;
import com.sun.lwuit.animations.Transition3D;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;
import event.Event;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.io.PushRegistry;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Image;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import models.readData;
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
    private String nameRecord = "recoddrddds";
    private String nameVector = "nameVector2";

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

    public void viewBoSung(int k) {
        if (categoryBar.getVisibility() == true) {
            categoryBar.setVisibility(false);
        }
        readData read = new readData();
        ViewBoSung viewBoSung = new ViewBoSung(k, read.read(k));
        viewBoSung.setTransitionOutAnimator(CommonTransitions.createSlide(
                CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        
        viewBoSung.show();
    }

    public void showHome() {
        //Transition3D tr = Transition3D.createCube(300, true);
        
        if (categoryBar.getVisibility() == false) {
            categoryBar.setVisibility(true);
        }
        ViewHome viewHome = new ViewHome();
        viewHome.setTransitionOutAnimator(CommonTransitions.createSlide(
                CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        //javax.microedition.lcdui.Display.getDisplay(main).setCurrent(viewHome);
        viewHome.show();

    }

    public void showHotLine() {
        ViewHotLine viewhot = new ViewHotLine();
        viewhot.setTransitionOutAnimator(CommonTransitions.createSlide(
                CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        viewhot.show();

    }

    public void showChoice(int i) {
        if (categoryBar.getVisibility() == true) {
            categoryBar.setVisibility(false);
        }
        ViewChoice viewchoice = new ViewChoice(i);
        viewchoice.setTransitionOutAnimator(CommonTransitions.createSlide(
                CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        
        //javax.microedition.lcdui.Display.getDisplay(main).setCurrent(viewHome);
        viewchoice.show();

    }

    public void showInform() {
        if (categoryBar.getVisibility() == true) {
            categoryBar.setVisibility(false);
        }
        ViewInform view = new ViewInform();
        view.setTransitionOutAnimator(CommonTransitions.createSlide(
                CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        view.show();
    }

    public void showRemind() {
        if (categoryBar.getVisibility() == true) {
            categoryBar.setVisibility(false);
        }
        ViewRemind view = new ViewRemind();
        view.setTransitionOutAnimator(CommonTransitions.createSlide(
                CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        view.show();
    }

    public void showKhamthai() {
        if (categoryBar.getVisibility() == true) {
            categoryBar.setVisibility(false);
        }
        ViewKhamthai view = new ViewKhamthai();
        view.setTransitionOutAnimator(CommonTransitions.createSlide(
                CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        view.show();
    }

    public void showTiemchung() {
        if (categoryBar.getVisibility() == true) {
            categoryBar.setVisibility(false);
        }
        ViewTiemchung view = new ViewTiemchung();
        view.setTransitionOutAnimator(CommonTransitions.createSlide(
                CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        view.show();
    }

    public void showKhamTiem(int index) {
        if (categoryBar.getVisibility() == true) {
            categoryBar.setVisibility(false);
        }
        ViewKhamTiem view = new ViewKhamTiem(index);
        view.setTransitionOutAnimator(CommonTransitions.createSlide(
                CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        view.show();
    }

    public void showChamBe() {
        if (categoryBar.getVisibility() == true) {
            categoryBar.setVisibility(false);
        }
        ViewChamBe view = new ViewChamBe();
        view.setTransitionOutAnimator(CommonTransitions.createSlide(
                CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        view.show();
    }

    public void showResult(String namex2, String namex4) {
        if (categoryBar.getVisibility() == true) {
            categoryBar.setVisibility(false);
        }
        ViewResult view = new ViewResult(namex2, namex4);
        view.setTransitionOutAnimator(CommonTransitions.createSlide(
                CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        view.show();
    }

    public void showSucKhoe() {

        if (Var.CANNANG.equals("*") || Var.Babyname.equals("*") || Var.CHIEUCAO.equals("*") || Var.SEX.equals("*") || Var.THANG.equals("*")) {
            Alert a = new Alert("thông báo", " bạn cần nhập các trường thông tin. ", null, AlertType.INFO);
            javax.microedition.lcdui.Display.getDisplay(main).setCurrent(a);
        } else {
            if (categoryBar.getVisibility() == true) {
                categoryBar.setVisibility(false);
            }
            ViewSucKhoe view = new ViewSucKhoe();
            view.setTransitionOutAnimator(CommonTransitions.createSlide(
                CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
            view.show();
        }
    }

    public void registerTimerAlarm(long timePeriodToAutoStart) {
        try {
            PushRegistry.registerAlarm(main.getClass().getName(), timePeriodToAutoStart);

        } catch (ClassNotFoundException ex) {
            System.out.println("" + ex);
        } catch (ConnectionNotFoundException ex) {
            System.out.println("" + ex);
        }
    }

    public void showReminder(String tittle) {
        if (categoryBar.getVisibility() == true) {
            categoryBar.setVisibility(false);
        }
        ViewReminder view = new ViewReminder(tittle);
        
        Display display = Display.getDisplay(main);
        display.setCurrent(view);
    }

    public void showSetting() {
        ViewSetting viewSetting = new ViewSetting();
        viewSetting.setTransitionOutAnimator(CommonTransitions.createSlide(
                CommonTransitions.SLIDE_HORIZONTAL, true, 1000));
        viewSetting.show();

    }

    public void showViewDate() {
        if (categoryBar.getVisibility() == true) {
            categoryBar.setVisibility(false);
        }
        ViewDate view = new ViewDate();
        Display display = Display.getDisplay(main);
        display.setCurrent(view);
    }

    public void showViewTime() {
        if (categoryBar.getVisibility() == true) {
            categoryBar.setVisibility(false);
        }
        ViewTime view = new ViewTime();
        Display display = Display.getDisplay(main);
        display.setCurrent(view);
    }

    public void showViewTime2() {
        if (categoryBar.getVisibility() == true) {
            categoryBar.setVisibility(false);
        }
        ViewTime2 view = new ViewTime2();
        Display display = Display.getDisplay(main);
        display.setCurrent(view);
    }

    public void exit() {
        //   saveConfig();
        main.destroyApp(true);
    }

    public void loadVector() {
        try {
            RecordStore rs = RecordStore.openRecordStore(nameVector, true);
            if (rs.getNumRecords() == 0) {
                System.out.println("creat");
                rs.closeRecordStore();
                createVector();
                return;
            }
            byte[] data;
            //Read language
            RecordEnumeration re = rs.enumerateRecords(null, null, false);

            /*for (int i = 0; i < rs.getNumRecords(); i++) {
            data = rs.getRecord(i);
            Var.vectorFavorite.addElement(new String(data));
            }
             * 
             */
            Var.listBe.removeAllElements();

            while (re.hasNextElement()) {
                String s = new String(re.nextRecord());
                Var.listBe.addElement(s);
            }
            System.out.println("size list:" + Var.listBe.size());
            rs.closeRecordStore();
        } catch (RecordStoreException ex) {
            System.out.println("loi doc recod");
            ex.printStackTrace();
        }
    }

    public void updateVector() {
        try {
            RecordStore rs = RecordStore.openRecordStore(nameVector, true);
            RecordEnumeration re = rs.enumerateRecords(null, null, false);

            int rid = 0;
            while (re.hasNextElement()) {
                rid = re.nextRecordId();
                rs.deleteRecord(rid);
            }

            byte[] data;
            for (int i = 0; i < Var.listBe.size(); i++) {
                data = ((String) Var.listBe.elementAt(i)).getBytes();
                //rs.setRecord(i, data, 0, data.length);
                rs.addRecord(data, 0, data.length);
            }
            rs.closeRecordStore();

        } catch (RecordStoreException ex) {
            System.out.println("loi doc rms");
            ex.printStackTrace();
        }
    }

    private void createRecord() {
        try {
            RecordStore rs = RecordStore.openRecordStore(nameRecord, true);
            RecordEnumeration re = rs.enumerateRecords(null, null, false);
            byte[] data;
            data = Var.maBe.getBytes();
            rs.addRecord(data, 0, data.length);
            data = Var.Babyname.getBytes();
            rs.addRecord(data, 0, data.length);
            data = Var.CANNANG.getBytes();
            rs.addRecord(data, 0, data.length);
            data = Var.CHIEUCAO.getBytes();
            rs.addRecord(data, 0, data.length);
            data = Var.THANG.getBytes();
            rs.addRecord(data, 0, data.length);
            data = Var.SEX.getBytes();
            rs.addRecord(data, 0, data.length);
            data = Var.stringc2.getBytes();
            rs.addRecord(data, 0, data.length);

            rs.closeRecordStore();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

    public void loadConfig() {
        try {
            RecordStore rs = RecordStore.openRecordStore(nameRecord, true);
            RecordEnumeration re = rs.enumerateRecords(null, null, false);
            if (rs.getNumRecords() == 0) {
                rs.closeRecordStore();
                re.destroy();
                createRecord();
                System.out.println("creat");
                return;
            }
            byte[] data;

            String s = new String(re.nextRecord());
            Var.maBe = s;

            s = new String(re.nextRecord());
            Var.Babyname = s;

            s = new String(re.nextRecord());
            Var.CANNANG = s;

            s = new String(re.nextRecord());
            Var.CHIEUCAO = s;

            s = new String(re.nextRecord());
            Var.THANG = s;

            s = new String(re.nextRecord());
            Var.SEX = s;

            s = new String(re.nextRecord());
            Var.stringc2 = s;



            rs.closeRecordStore();
        } catch (RecordStoreException ex) {
            System.out.println("loi doc recod");
            ex.printStackTrace();
        }
        System.out.println("" + Var.Babyname);
        System.out.println("" + Var.CANNANG);
        System.out.println("" + Var.CHIEUCAO);
        System.out.println("" + Var.THANG);
        System.out.println("" + Var.SEX);

    }

    public void updateConfig() {
        try {
            //if()RecordStore.deleteRecordStore(nameRecord);
            RecordStore rms = RecordStore.openRecordStore(nameRecord, true);
            RecordEnumeration ree = rms.enumerateRecords(null, null, false);
            int rid = 0;
            while (ree.hasNextElement()) {
                rid = ree.nextRecordId();
                rms.deleteRecord(rid);
            }
            rms.closeRecordStore();

            rms = RecordStore.openRecordStore(nameRecord, true);
            ree = rms.enumerateRecords(null, null, false);
            rid = 0;
            while (ree.hasNextElement()) {
                rid = ree.nextRecordId();
                rms.deleteRecord(rid);
            }
            rms.closeRecordStore();

            RecordStore rs = RecordStore.openRecordStore(nameRecord, true);
            RecordEnumeration re = rs.enumerateRecords(null, null, false);
            byte[] data;
            data = Var.maBe.getBytes();
            rs.addRecord(data, 0, data.length);

            data = Var.Babyname.getBytes();
            rs.addRecord(data, 0, data.length);

            data = Var.CANNANG.getBytes();
            rs.addRecord(data, 0, data.length);
            data = Var.CHIEUCAO.getBytes();
            rs.addRecord(data, 0, data.length);
            data = Var.THANG.getBytes();
            rs.addRecord(data, 0, data.length);
            data = Var.SEX.getBytes();
            rs.addRecord(data, 0, data.length);
            data = Var.stringc2.getBytes();
            rs.addRecord(data, 0, data.length);


            rs.closeRecordStore();
        } catch (RecordStoreException ex) {
            System.out.println("loi doc rms");
            ex.printStackTrace();
        }
        System.out.println("update");
        System.out.println("" + Var.maBe);
        System.out.println("" + Var.Babyname);
        System.out.println("" + Var.CANNANG);
        System.out.println("" + Var.CHIEUCAO);
        System.out.println("" + Var.THANG);
        System.out.println("" + Var.SEX);
    }

    private void createVector() {
        try {
            RecordStore rs = RecordStore.openRecordStore(nameVector, true);
            RecordEnumeration re = rs.enumerateRecords(null, null, false);
            byte[] data;
//            data = (1 + "").getBytes();
//            rs.setRecord(1, data, 0, data.length);
            rs.closeRecordStore();
        } catch (RecordStoreException ex) {
            ex.printStackTrace();
        }
    }

    public static void loadTheme() {
        try {
            if (theme == null) {
                theme = Resources.open("/themes/theme.res");
            }
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
        } catch (Throwable ex) {
        }
    }

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
                    showSetting();
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