/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinh
 */
public class Tool {

    public double getDouble(double min, double max, String msg) {
        double input;
        Scanner sc = new Scanner(System.in);
        do {

            //prevent wrong type
            if (!sc.hasNextDouble()) {
                sc.next();
                System.out.print(msg + ": ");
                System.out.print("Please enter again: ");
            } else {
                input = sc.nextDouble();
                //checking for min max
                if (!CheckTool.maxMinDouble(input, max, min)) {
                    System.out.print(msg + ": ");
                    System.out.print("Please enter again: ");
                } else {
                    break;
                }
            }
        } while (true);

        return input;
    }

    public int getInt(int min, int max, String msg) {
        int input;
        Scanner sc = new Scanner(System.in);
        do {

            //prevent wrong type
            if (!sc.hasNextInt()) {
                sc.next();
                System.out.print(msg + ": ");
                System.out.print("Please enter again: ");
            } else {
                input = sc.nextInt();
                //checking for min max
                if (!CheckTool.maxMinInt(input, max, min)) {
                    System.out.print(msg + ": ");
                    System.out.print("Please enter again: ");
                } else {
                    break;
                }
            }
        } while (true);

        return input;
    }

    public String inputString(String inputMessage, String message) {
        String temp;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(inputMessage + ": ");
                temp = sc.nextLine();
                if (temp.trim().length() == 0) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println(message);
            }
        } while (true);

        return temp;
    }

    public Date getDate() {
        Date date = null;
        Scanner sc = new Scanner(System.in);
        Date now = new Date();
        Date start = null;
//        Date before1 = DateFormat.getDateInstance().parse("03/08/2021");
        do {
            System.out.println("Today: " + now);
            String pattern = "(0?[0-9]|[12][0-9]|3[01])\\/(0?[0-9]|1[0-2])\\/(0?[0-9]|0?[0-9]|0?[0-9]|[0-9]|[0-9]{4})";
            System.out.print("input date (dd/MM/yyyy): ");
            String input = sc.nextLine();
            if (input.matches(pattern)) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false);
                try {
                    start = dateFormat.parse("08/03/2021");
                } catch (ParseException ex) {
                    System.out.println(ex);
                }
                try {
                    date = dateFormat.parse(input);
                } catch (ParseException e) {
                    System.out.println("Invalid date!!");
                }
            } else {
                System.out.println("Invalid date!!");
            }
        } while (date == null || date.after(now) || date.before(start));
        return date;
    }

    public boolean checkDate(Date date1, Date date2) {
        long diffrence;
        do {
            long diff = Math.abs(date2.getTime() - date1.getTime());
            TimeUnit time = TimeUnit.DAYS;
            diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
            if (diffrence < 28 || diffrence > 84) {
                return false;
            } else {
                return true;
            }
        } while (diffrence > 28 || diffrence < 84);
    }

    public String inputPlace(String warning) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        System.out.println(" ------------------------------------------------------------------------------------------------------------------------------- \n"
                + "|     1.An Giang           11.Bình Thuận        21.Gia Lai	31.Khánh Hòa	41.Ninh Bình	51.Sơn La	61.Vĩnh Long	|\n"
                + "|     2.Bà Rịa – Vũng Tàu  12.Cà Mau            22.Hà Giang	32.Kiên Giang	42.Ninh Thuận	52.Tây Ninh	62.Vĩnh Phúc	|\n"
                + "|     3.Bắc Giang          13.Cần Thơ		23.Hà Nam	33.Kon Tum	43.Phú Thọ	53.Thái Bình	63.Yên Bái	|\n"
                + "|     4.Bắc Kạn            14.Cao Bằng		24.Hà Nội	34.Lai Châu	44.Phú Yên	54.Thái Nguyên			|\n"
                + "|     5.Bạc Liêu           15.Đà Nẵng		25.Hà Tĩnh	35.Lâm Đồng	45.Quảng Bình	55.Thanh Hóa			|\n"
                + "|     6.Bắc Ninh           16.Đắk Lắk		26.Hải Dương	36.Lạng Sơn	46.Quảng Nam	56.Thừa Thiên Huế		|\n"
                + "|     7.Bến Tre            17.Đắk Nông		27.Hải Phòng	37.Lào Cai	47.Quảng Ngãi	57.Tiền Giang			|\n"
                + "|     8.Bình Dương         18.Điện Biên		28.Hậu Giang	38.Long An	48.Quảng Ninh	58.TP Hồ Chí Minh		|\n"
                + "|     9.Bình Định          19.Đồng Nai		29.Hòa Bình	39.Nam Định	49.Quảng Trị	59.Trà Vinh			|\n"
                + "|     10.Bình Phước        20.Đồng Tháp		30.Hưng Yên	40.Nghệ An	50.Sóc Trăng	60.Tuyên Quang			|\n"
                + " ------------------------------------------------------------------------------------------------------------------------------- ");
        System.out.println("Your number choice:");
        String result = "";
        String[] tinh = {"An Giang", "BR-VũngTàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận",
            "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội",
            "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn",
            "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh",
            "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "T.Thiên Huế", "Tiền Giang", "TP HCM", "Trà Vinh",
            "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái"};
        boolean check = false;
        do {
            try {
                n = getInt(1, 63, "input number 1 to 63");
                result = tinh[n - 1];
                check = true;
            } catch (Exception e) {
                System.out.println(warning);
            }
        } while (check == false);
        return result;
    }

    public String dayToString(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        return ft.format(date);
    }
}
