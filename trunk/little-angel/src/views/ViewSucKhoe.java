/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Controller;
import Control.Var;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.layouts.BoxLayout;

/**
 *
 * @author FOX
 */
public class ViewSucKhoe extends Form implements ActionListener {

    Label cannang, chieucao, gioitinh, tuoi, nhanxet;
    String rate = "";
    Command back;

    public ViewSucKhoe() {
        setTitle("Sức khỏe");
        setLayout(new BorderLayout());
        Container north = new Container();
        north.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        tuoi = new Label("Tuổi:" + Var.THANG + "tháng");
        cannang = new Label("Cân nặng:" + Var.CANNANG + "kg");
        chieucao = new Label("Chiều cao:" + Var.CHIEUCAO + "cm");
        gioitinh = new Label("Giới tính:" + Var.SEX);
        tinh();
        nhanxet = new Label(rate);
        north.addComponent(tuoi);
        north.addComponent(cannang);
        north.addComponent(chieucao);
        north.addComponent(gioitinh);
        north.addComponent(nhanxet);
        addComponent(BorderLayout.NORTH, north);


        back = new Command("Back");
        addCommandListener(this);
        setBackCommand(back);
        addCommand(back);



    }

    public void tinh() {
        
        
        String gt = Var.SEX.toLowerCase().toString();
        int[] mau = {0, 1, 3, 6, 12, 18, 24, 36, 48, 60};
        int tg = Integer.parseInt(Var.THANG);
        double cn = Double.parseDouble(Var.CANNANG);
        double cc = Double.parseDouble(Var.CHIEUCAO);

        if (gt.equals("nam") == true) {
            for (int i = 0; i < mau.length; i++) {
                if (mau[i] == tg) {
                    if (cn > Var.MALE_OBESITY[i]) {
                        rate = "Bé thừa cân!";
                    } else if (cn > Var.MALE_W_STANDARD[i]) {
                        if (cc >= Var.MALE_H_STANDARD[i]) {
                            rate = "Bé phát triển tốt !";
                        } else if (cc >= Var.MALE_SHORT[i]) {
                            rate = "Bé có dấu hiệu thừa cân!";
                        } else {
                            rate = "Bé bị thừa cân và chiều cao phát triển kém !";
                        }
                    } else if (cn == Var.MALE_W_STANDARD[i]) {
                        if (cc == Var.MALE_H_STANDARD[i]) {
                            rate = "Bé phát triển theo chuẩn của WHO !";
                        } else if (cc > Var.MALE_SHORT[i]) {
                            rate = "Cần phát triển thêm chiều cao cho bé !";
                        } else {
                            rate = "Chiều cao của bé phát triển không tốt !";
                        }
                    } else if (cn > Var.MALE_MALNUTRITION[i]) {
                        if (cc > Var.MALE_H_STANDARD[i]) {
                            rate = "Bé bị thiếu cân !";
                        } else {
                            rate = "Có dấu hiệu suy dinh dưỡng !";
                        }
                    } else {
                        rate = "Suy dinh dưỡng !";
                    }
                    return;
                }

            }
            return;
        } else if (gt.equals("nu") == true) {
            for (int i = 0; i < mau.length; i++) {
                if (mau[i] == tg) {
                    if (cn > Var.FEMALE_OBESITY[i]) {
                        rate = "Bé thừa cân!";
                    } else if (cn > Var.FEMALE_W_STANDARD[i]) {
                        if (cc >= Var.FEMALE_H_STANDARD[i]) {
                            rate = "Bé phát triển tốt !";
                        } else if (cc >= Var.FEMALE_SHORT[i]) {
                            rate = "Bé có dấu hiệu thừa cân!";
                        } else {
                            rate = "Bé bị thừa cân và chiều cao phát triển kém !";
                        }
                    } else if (cn == Var.FEMALE_W_STANDARD[i]) {
                        if (cc == Var.FEMALE_H_STANDARD[i]) {
                            rate = "Bé phát triển theo chuẩn của WHO !";
                        } else if (cc > Var.FEMALE_SHORT[i]) {
                            rate = "Cần phát triển thêm chiều cao cho bé !";
                        } else {
                            rate = "Chiều cao của bé phát triển không tốt !";
                        }
                    } else if (cn > Var.FEMALE_MALNUTRITION[i]) {
                        if (cc > Var.FEMALE_H_STANDARD[i]) {
                            rate = "Bé bị thiếu cân !";
                        } else {
                            rate = "Có dấu hiệu suy dinh dưỡng !";
                        }
                    } else {
                        rate = "Suy dinh dưỡng !";
                    }
                    return;
                }
            }
            return;
        } else {
            return;
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            Controller.getInstance().showHome();
        }
    }
}
