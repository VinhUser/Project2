/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Vinh
 */
public class Injection implements Serializable{

    public String injectionID;
    public String place1ST;
    public Date date1ST;
    public String place2ST;
    public Date date2ST;
    public String studentID;
    public String studentName;
    public String vaccineID;
    public String vaccineName;
    public long datLeft;
    Tool tool = new Tool();
    
//    public Injection() {
//        this.injectionID = "___";
//        this.place1ST = "___";
//        this.date1ST = "___";
//        this.place2ST = "___";
//        this.date2ST = "___";
//        this.studentID = "___";
//        this.vaccineID = "___";
//        this.datLeft = 0;
//        this.studentName = "___";
//        this.vaccineName = "___";
//    }
        
    public Injection(String injectionID, String place1ST, Date date1ST, String place2ST, Date date2ST, String studentId, String studentName, String vaccineID, String vaccineName) {
        this.injectionID = injectionID;
        this.place1ST = place1ST;
        this.date1ST = date1ST;
        this.place2ST = place2ST;
        this.date2ST = date2ST;
        this.studentID = studentId;
        this.studentName = studentName;
        this.vaccineID = vaccineID;
        this.vaccineName = vaccineName;
    }
    public Injection() {
    }
    public Injection(String injectID, String place1ST, Date date1ST, String studentId,String studentName, String vaccineID, String vaccineName) {
        this.injectionID = injectID;
        this.place1ST = place1ST;
        this.date1ST = date1ST;
        this.place2ST = place2ST;
        this.date2ST = date2ST;
        this.studentID = studentId;
        this.studentName = studentName;
        this.vaccineID = vaccineID;
        this.vaccineName = vaccineName;
    }

    public String getInjectID() {
        return injectionID;
    }

    public void setInjectID(String injectID) {
        this.injectionID = injectID;
    }

    public String getPlace1ST() {
        return place1ST;
    }

    public void setPlace1ST(String place1ST) {
        this.place1ST = place1ST;
    }

    public Date getDate1STt() {
        return date1ST;
    }

    public void setDate1STt(Date date1STt) {
        this.date1ST = date1STt;
    }

    public String getPlace2ST() {
        return place2ST;
    }

    public void setPlace2ST(String place2ST) {
        this.place2ST = place2ST;
    }

    public Date getDate2ST() {
        return date2ST;
    }

    public void setDate2ST(Date date2ST) {
        this.date2ST = date2ST;
    }

    public String getStudentId() {
        return studentID;
    }

    public void setStudentId(String studentId) {
        this.studentID = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getVaccineID() {
        return vaccineID;
    }

    public void setVaccineID(String vaccineID) {
        this.vaccineID = vaccineID;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public long getDatLeft() {
        return datLeft;
    }

    public void setDatLeft(long datLeft) {
        this.datLeft = datLeft;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }
    
    public String checkValidInjection() {
        if (injectionID == null) {
            return "injection ID is require";
        }
        if (place1ST == null) {
            return "first place is require";
        }
        if (date1ST == null) {
            return "first date is require";
        }
        if (studentID == null) {
            return "student ID is require";
        }
        if (vaccineID == null) {
            return "vaccine ID is require";
        }
        return "checked";
    }
    public void print(){
        System.out.printf("%-15s|%-15s|%-25s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n",
                injectionID, studentID, studentName, vaccineID, vaccineName, place1ST, tool.dayToString(date1ST), place2ST, tool.dayToString(date2ST));
    }

    @Override
    public String toString() {
        return "Injection{" + "injectionID=" + injectionID + ", place1ST=" + place1ST + ", date1ST=" + date1ST + ", place2ST=" + place2ST + ", date2ST=" + date2ST + ", studentID=" + studentID + ", studentName=" + studentName + ", vaccineID=" + vaccineID + ", vaccineName=" + vaccineName + ", datLeft=" + datLeft + ", tool=" + tool + '}';
    }
    
}
