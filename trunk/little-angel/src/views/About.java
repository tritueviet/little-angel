package views;

import Control.Controller;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.Command;
import com.sun.lwuit.Font;
import com.sun.lwuit.Form;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.events.ActionListener;

/**
 *
 * @author WALL
 */
public class About extends Form implements ActionListener {

    private Command backCommand= new Command("trở về");
    private String backView;

    public About() {
        setTitle("thông tin và giúp đỡ");
        Font font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
        TextArea textArea = null;

        textArea = new TextArea("Giúp đỡ:"
                + "\n\nLittle Angle giúp bạn bổ sung thông tin về cách nuôi dạy con, chế độ dinh dưỡng và những lời khuyên bổ ích dành cho các bậc cha mẹ đang có con nhỏ."
                + "\nPhần mềm được  xây dựng và cập nhật thường xuyên bởi Trần Minh Lân"
                + "\n\nThông tin:"
                + "\n\nFacebook: https://www.facebook.com/tran.minhlan"
                + "\nEmail: tranminhlan07t1@gmail.com "
                + "\n\nNhà phát triển: Tran Minh Lan "
                + "\nTên ứng dụng: Little Angle "
                + "\nPhiên bản: 1.0.1"
                + "\nCopyright  ©2013 Minh Lan. All rights reversed", 2, 10);

        textArea.setEditable(false);
        textArea.setGrowByContent(true);
        textArea.setUIID("Form");
        textArea.getStyle().setFont(font);
        addComponent(textArea);
        setBackCommand(backCommand);
        addCommand(backCommand);
        addCommandListener(this);
        //show();
    }

    public void actionPerformed(ActionEvent ae) {
        Controller.getInstance().showHome();
    }
}
