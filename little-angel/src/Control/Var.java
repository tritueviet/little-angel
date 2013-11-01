/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.Date;
import java.util.Vector;

/**
 *
 * @author FOX
 */
public class Var {
    public static int viTriChoice=0;
    public static String THANG = "*", CANNANG = "*", CHIEUCAO = "*", SEX = "*";
    public static String Babyname = "*";
    public static String maBe = "0";
    public static int choice = 0;
    public static String stringc2 = "_/_/_", stringc4 = "_:_";
    public static String stringtc = "_:_";
    public static String back = "trở về";
    public static Vector listBe = new Vector();
    public static Date date_mang_thai;
    public static Date date_tiem_chung;
    public static Date date_;
    public static String[] thongTinBoSung = {
        "các bước nấu bột cho trẻ",
        "các nhóm thực phẩm cho trẻ",
        "mẫu thực đơn tuần",
        "một số câu hỏi",
        "nguyên tắc bổ sung",
        "bắt đầu cho trẻ ăn bổ sung với lượng thức ăn ít và tăng dần khi trẻ lớn hơn, vẫn duy trì bú mẹ",
        "cho trẻ ăn bổ sung đặc dần và thay đổi loại thức ăn khi trẻ lớn đân, phù hợp với nhu cầu và khả năng tiêu hóa",
        "cho trẻ ăn đủ bốn nhóm thực phẩm để đảm bảo cungcấp đủ chất cho sự phát triển của trẻ",
        "cho trẻ ăn theo nhu cầu",
        "nuôi con bằng sữa mẹ hoàn toàn trong 6 tháng đầu",
        "tăng cường chăm sóc trẻ khi bị ốm",
        "tăng cường vi chất dinh dưỡng cho trẻ như vitamin A, sắt, kẽm…",
        "theo dõi cân nặng của trẻ thường xuyên và tiêm phòng đầy đủ",
        "thực hành vệ sinh cá nhân và an toàn thực phẩm tốt",
        "tiếp tục cho trẻ bú mẹ theo nhu cầu cho tới 2 tuổi",
        "mẫu thực đơn tuần cho trẻ 1 -2 tuổi",
        "mẫu thực đơn tuần cho trẻ 7 -9 tháng tuổi",
        "mẫu thực đơn tuần cho trẻ 9 -12 tháng tuổi",
        "một số thực đơn nấu cơm cho trẻ"
    };
    public static final double[] FEMALE_W_STANDARD = {3.2, 4.2, 5.8, 7.3, 8.9,
        10.2, 11.5, 13.9, 16.1, 18.2};
    public static final double[] FEMALE_MALNUTRITION = {2.4, 3.2, 4.5, 5.7, 7,
        8.1, 9, 10.8, 12.3, 13.7};
    public static final double[] FEMALE_OBESITY = {4.2, 5.5, 7.5, 9.3, 11.5,
        13.2, 14.8, 18.1, 21.5, 24.9};
    public static final double[] FEMALE_H_STANDARD = {49.1, 53.7, 57.1, 65.7,
        74, 80.7, 86.4, 95.1, 102.7, 109.4};
    public static final double[] FEMALE_SHORT = {45.4, 49.8, 55.6, 61.2, 68.9,
        74.9, 80, 87.4, 94.1, 99.9};
    // các thông s? dánh giá bé trai
    public static final double[] MALE_W_STANDARD = {3.3, 4.5, 6.4, 7.9, 9.6,
        10.9, 12.2, 14.3, 16.3, 18.3};
    public static final double[] MALE_MALNUTRITION = {2.4, 3.4, 5, 6.4, 7.7,
        8.8, 9.7, 11.3, 12.7, 14.1};
    public static final double[] MALE_OBESITY = {4.4, 5.8, 8, 9.8, 12, 13.7,
        15.3, 18.3, 21.2, 24.2};
    public static final double[] MALE_H_STANDARD = {49.9, 54.7, 58.4, 67.6,
        75.7, 82.3, 87.8, 96.1, 103.3, 110};
    public static final double[] MALE_SHORT = {46.1, 50.8, 57.3, 63.3, 71.0,
        76.9, 81.7, 88.7, 94.9, 100.7};
    public static String[] v1 = {"BCG", "r-HBvax", "DPT", "Vắc xin bại liệt uống",
        "Quinaxem", "Rouvax ", "Vắc xin sởi ", "Vắc xin uốn ván hấp phụ"};
    public static int[] dd1 = new int[v1.length];
    public static String[] v2 = {"Infanrix-hexa", "Pentaxim", "Tetraxim", "Tritanrix ", "Euvax ", "Engerix", "Rotarix ", "Vaxigrip", "Act- Hib", "Hiberix", "Avaxim ", "Trimovax (ROR)", "MMR II",
        "Priorix ", "Okavax ", "Varilrix", "Meningo A+C", "Pneumo 23", "Vắc xin uốn ván hấp phụ",
        "Gardasil ", "Cervavix"};
    public static int[] dd2 = new int[v2.length];
}
