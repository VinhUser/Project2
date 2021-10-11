/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Vinh
 */
public class InjectionManagnments implements Function<Injection> {

    ArrayList<Injection> injectionList = new ArrayList<Injection>();

    MenuManagnments menu = new MenuManagnments();
    Tool tool = new Tool();
    FileReader in = null;
    FileWriter out = null;
    BufferedReader br = null;
    String decoyString;
    String[] listString;

    public boolean isEmpty() {
        return injectionList.isEmpty();
    }

    public void loadFromFile() {
        try {
            in = new FileReader("injection.dat");
            br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                listString = line.split(";");
                //ID;firstPlace;secondPlace;firstDate;secondDate;studentID;vaccineID
                //injection ID
                String injectionID = listString[0].equals("null") ? null : listString[0];
                //student ID
                String studentID = listString[1].equals("null") ? null : listString[1];
                //student name
                String studentName = listString[2].equals("null") ? null : listString[2];
                //vaccint ID
                String vaccineID = listString[3].equals("null") ? null : listString[3];
                //vaccine Name
                String vaccineName = listString[4].equals("null") ? null : listString[4];
                //first place
                String place1ST = listString[5].equals("null") ? null : listString[5];
                //second place
                String place2ST = listString[6].equals("null") ? null : listString[6];
                //first date
                Date date1ST = null;
                String firstDateString = listString[7].equals("null") ? null : listString[7];
                if (firstDateString != null) {
                    date1ST = new SimpleDateFormat("dd/MM/yyyy").parse(firstDateString);
                }
                //second date
                Date date2ST = null;
                String secondDateString = listString[8].equals("null") ? null : listString[8];
                if (secondDateString != null) {
                    date2ST = new SimpleDateFormat("dd/MM/yyyy").parse(secondDateString);
                }

                //create new injection
                Injection newInjection = new Injection(injectionID, place1ST, date1ST, place2ST, date2ST, studentID, studentName, vaccineID, vaccineName);

                injectionList.add(newInjection);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void print() {
        if (injectionList.isEmpty()) {
            System.out.println("There's no injection!");
            return;
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s|%-15s|%-25s|%-15s|%-15s|%-15s|%-15s|%-15s|\n", "ID", "student ID", "student Name", "vaccine Name", "first place", "first date", "second place", "second date");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Injection injection : injectionList) {
            System.out.printf("%-15s|%-15s|%-25s|%-15s|%-15s|%-15s|%-15s|%-15s|\n",
                    injection.injectionID, injection.studentID, injection.studentName, injection.vaccineName, injection.place1ST, tool.dayToString(injection.date1ST), injection.place2ST, tool.dayToString(injection.date2ST));
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void printWithInjectionList(ArrayList<Injection> injectionList) {
        if (injectionList.isEmpty()) {
            System.out.println("There's no injection!");
            return;
        }

        System.out.printf("%-15s|%-15s|%-25s|%-15s|%-15s|%-15s|%-15s|%-15s|\n", "ID", "student ID", "student Name", "vaccine Name", "first place", "first date", "second place", "second date");
        for (Injection injection : injectionList) {
            System.out.printf("%-15s|%-15s|%-25s|%-15s|%-15s|%-15s|%-15s|%-15s|\n",
                    injection.injectionID, injection.studentID, injection.studentName, injection.vaccineName, injection.place1ST, tool.dayToString(injection.date1ST), injection.place2ST, tool.dayToString(injection.date2ST));
        }
    }

    public void printAnInjection(Injection injection) {
        System.out.printf("%-15s|%-15s|%-25s|%-15s|%-15s|%-15s|%-15s|%-15s|\n", "ID", "student ID", "student Name", "vaccine Name", "first place", "first date", "second place", "second date");
        System.out.printf("%-15s|%-15s|%-25s|%-15s|%-15s|%-15s|%-15s|%-15s|\n",
                injection.injectionID, injection.studentID, injection.studentName, injection.vaccineName, injection.place1ST, tool.dayToString(injection.date1ST), injection.place2ST, tool.dayToString(injection.date2ST));
    }

    public Injection addInjection(StudentManagnments studentManager, VaccineManagnments vaccineManager) {
        boolean isLoop = true;
        boolean isTrue = false;
//        Injection newInjection = new Injection();
        String injectionID, studentID, studentName = "", vaccineID, vaccineName = "", place1ST, place2ST = null;
        Date date1ST, date2ST = null;
        //id injection
        do {
            injectionID = tool.inputString("input id ", "input id ");
            isTrue = isIdDuplicate(injectionID);
            if (!isTrue) {
                break;
            }
            System.out.println("This ID already existed");
        } while (true);
//        newInjection.setInjectID(injectionID);
        //student
        do {
            studentManager.print();
            studentID = tool.inputString("Input student ID", "").trim().toUpperCase();
            isTrue = studentManager.isIdDuplicate(studentID);
            if (!isTrue) {
                System.out.println("The student ID must be existed");
                continue;
            }
            isTrue = isStudentIDDuplicate(studentID);
            if (isTrue) {
                System.out.println("The student id already have in injection list");
                continue;
            } else {
                break;
            }

        } while (true);
        //studentName
        studentName = studentManager.searchByID(studentID).getName();
        //vaccine
        do {
            vaccineManager.print();
            vaccineID = tool.inputString("Input vaccine id ", "");
            isTrue = vaccineManager.isIdDuplicate(vaccineID);
            if (isTrue) {
                break;
            } else {
                System.out.println("ID of vaccine must be existed");
            }

        } while (true);
        vaccineName = vaccineManager.searchByID(vaccineID).getName();
        //place1ST        
        place1ST = tool.inputPlace("choose 1..63: ");
        //date1ST
        date1ST = tool.getDate();
        Injection inj = new Injection(injectionID, place1ST, date1ST, studentID, studentName, vaccineID, vaccineName);
        return inj;
    }

    public void addInjcetion(Injection injection) {
        injectionList.add(injection);
    }

    @Override
    public void delete() {
        String id;
        int n;
        System.out.print("input Injection to search ");
        id = tool.inputString("id ", "id ");
        Injection xxx = searchByID(id);
        if (xxx == null) {
            System.out.println("Not found!! No Injection to be remove");
        } else {
            System.out.println("Injection found!!!");
            System.out.println("here Injection you want to remove");
            printAnInjection(xxx);
            System.out.println("Do you want to remove the Injection?");
            System.out.println("'Yes' input 1 | 'No' input 2");
            System.out.print("Your choice: ");
            n = tool.getInt(1, 2, "input 1 or 2");

            if (n == 1) {
                injectionList.remove(xxx);
                System.out.println("remove success");
            } else {
                System.out.println("remove fail");
            }
            System.out.println("after remove Injection");
            print();
        }
    }

    @Override
    public Injection searchByID(String ID) {
        for (Injection injection : injectionList) {
            if (injection.injectionID.equals(ID)) {
                return injection;
            }
        }
        return null;
    }

//    public Injection searchInjectionByPlace() {
//        int n;
//        System.out.println(" ------------------------------------------------------------------------------------------------------------------------------- \n"
//                + "|     1.An Giang           11.Bình Thuận        21.Gia Lai	31.Khánh Hòa	41.Ninh Bình	51.Sơn La	61.Vĩnh Long	|\n"
//                + "|     2.Bà Rịa – Vũng Tàu  12.Cà Mau            22.Hà Giang	32.Kiên Giang	42.Ninh Thuận	52.Tây Ninh	62.Vĩnh Phúc	|\n"
//                + "|     3.Bắc Giang          13.Cần Thơ		23.Hà Nam	33.Kon Tum	43.Phú Thọ	53.Thái Bình	63.Yên Bái	|\n"
//                + "|     4.Bắc Kạn            14.Cao Bằng		24.Hà Nội	34.Lai Châu	44.Phú Yên	54.Thái Nguyên			|\n"
//                + "|     5.Bạc Liêu           15.Đà Nẵng		25.Hà Tĩnh	35.Lâm Đồng	45.Quảng Bình	55.Thanh Hóa			|\n"
//                + "|     6.Bắc Ninh           16.Đắk Lắk		26.Hải Dương	36.Lạng Sơn	46.Quảng Nam	56.Thừa Thiên Huế		|\n"
//                + "|     7.Bến Tre            17.Đắk Nông		27.Hải Phòng	37.Lào Cai	47.Quảng Ngãi	57.Tiền Giang			|\n"
//                + "|     8.Bình Dương         18.Điện Biên		28.Hậu Giang	38.Long An	48.Quảng Ninh	58.TP Hồ Chí Minh		|\n"
//                + "|     9.Bình Định          19.Đồng Nai		29.Hòa Bình	39.Nam Định	49.Quảng Trị	59.Trà Vinh			|\n"
//                + "|     10.Bình Phước        20.Đồng Tháp		30.Hưng Yên	40.Nghệ An	50.Sóc Trăng	60.Tuyên Quang			|\n"
//                + " ------------------------------------------------------------------------------------------------------------------------------- ");
//        String[] tinh = {"An Giang", "BR-VũngTàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Dương", "Bình Định", "Bình Phước", "Bình Thuận",
//            "Cà Mau", "Cần Thơ", "Cao Bằng", "Đà Nẵng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai", "Hà Giang", "Hà Nam", "Hà Nội",
//            "Hà Tĩnh", "Hải Dương", "Hải Phòng", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa", "Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn",
//            "Lào Cai", "Long An", "Nam Định", "Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Phú Yên", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh",
//            "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "T.Thiên Huế", "Tiền Giang", "TP HCM", "Trà Vinh",
//            "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái"};
//        do {
//            System.out.println("Your number choice:");
//            n = tool.getInt(1, 63, "input number 1 to 63");
//            for (Injection injection : injectionList) {
//
//                if (injection.place1ST.equals(tinh[n - 1])) {
//                    injection.print();
//                }
//            }
//        } while (n < 1 || n > 63);
//        return null;
//    }
    public Injection searchInjectionByVaccineID(String ID) {
        int count = 0;
        ID = ID.trim().toUpperCase();
        for (Injection injection : injectionList) {
            if (injection.vaccineID.equals(ID)) {
                System.out.println("This is injection for if");
                injection.print();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Not Found!!");
        }
        return null;
    }
//    public void searchByVaccineID() {
//        String id;
//        System.out.print("input Injection to search ");
//        id = tool.inputString("id ", "id ");
//        Injection xxx = searchInjectionByVaccineID(id);
//        if (xxx == null) {
//            System.out.println("Not found!! No Injection to be search");
//        } else {
//            System.out.println("Injection found!!!");
//            System.out.println("here Injection you want to remove");
//            printAnInjection(xxx);
//            
//        }
//    }
    public Injection searchInjectionByStudentID(String ID) {
        int count = 0;
        ID = ID.trim().toUpperCase();
        for (Injection injection : injectionList) {
            if (injection.studentID.equals(ID)) {
                System.out.println("This is injection for if");
                injection.print();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Not Found!!");
        }
        return null;
    }
//    public void searchInjectionStudentByID(){
//        String id;
//    }

    public Injection updateInjection() {
        String id;
        int n;
        System.out.print("input Injection to search ");
        id = tool.inputString("id ", "id ");
        Injection xxx = searchByID(id);
        if (xxx == null) {
            System.out.println("Not found!! No Injection to be update");
        } else {
            if (xxx.place2ST != null || xxx.date2ST != null) {
                System.out.println("student have compiled 2 injection");
            } else {
                System.out.println("Injection found!!!");
                System.out.println("here Injection you want to update");
                printAnInjection(xxx);
                System.out.println("Do you want to update the Injection?");
                System.out.println("'Yes' input 1 | 'No' input 2");
                System.out.print("Your choice: ");
                n = tool.getInt(1, 2, "input 1 or 2");
                //place2ST
                if (n == 1) {
                    //date2ST
                    do {
                        Date x = tool.getDate();
                        if (tool.checkDate(xxx.date1ST, x) == true) {
                            //place2ST
                            xxx.place2ST = tool.inputPlace("choose 1..63: ");
                            xxx.date2ST = x;
                            break;
                        } else {
                            System.out.println("Cann't Update because not enough time using vaccine!!");
                            break;
                        }
                    } while (xxx.date2ST.before(xxx.date1ST));
                } else {
                    System.out.println("update fail");
                }
            }
        }
        return null;
    }
//    public ArrayList<Injection> findInjectionByStudentName(StudentManagnments studentManagenments, String name) {
//        ArrayList<Injection> nameIncluded = new ArrayList<Injection>();
//        name = name.trim().toUpperCase();
//        for (Injection injection : nameIncluded) {
//            Student newStudent = studentManagenments.searchByID(injection.studentID);
//            if (newStudent == null) {
//                continue;
//            }
//            if (newStudent.name.toUpperCase().contains(name)) {
//                nameIncluded.add(injection);
//            }
//        }
//        return nameIncluded;
//    }

    @Override
    public boolean isIdDuplicate(String ID
    ) {
        for (Injection injection : injectionList) {
            if (injection.injectionID.equals(ID)) {
                return true;
            }
        }
        return false;
    }

    public boolean isStudentIDDuplicate(String studentID) {
        for (Injection injection : injectionList) {
            if (injection.studentID.equals(studentID)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return injectionList.size();
    }

    public void writeFile(File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        String ortherString;
        String result = new String("");
        for (Injection injection : injectionList) {
            ortherString = injection.injectionID + ";" + injection.studentID + ";" + injection.studentName + ";" + injection.vaccineID + ";" + injection.vaccineName + ";" + injection.place1ST + ";" + injection.place2ST + ";" + tool.dayToString(injection.date1ST) + ";" + tool.dayToString(injection.date2ST) + "\n";
            result = result + ortherString;
        }
        writer.write(result);
        System.out.println("write success...");
        writer.close();
    }
}
