package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class CheckData {
    private static String trouble;
    private static String[] lines;

    public static String getTrouble() {
        return trouble;
    }

    public static String[] getLines() {
        return lines;
    }

    public static boolean checkInputData(String inputData){
        if (!inputData.isEmpty()){
            lines = inputData.split(" ");
        }else {
            trouble = "не введено никаких данных";
            return false;
        }

        if (checkLengthString(lines)) {
            if (checkName(lines[0]+lines[1]+lines[2])) {
                if (checkDate(lines[3])) {
                    if (checkPhoneNumber(lines[4])) {
                        if (checkSex(lines[5])) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkLengthString(String[] inputString){
        if (inputString.length == 6){
            return true;
        }else {
            trouble = "Неверно указано количество введенных данных";
            return false;
        }
    }

    private static boolean checkDate(String elem){
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yy");
            LocalDate.parse(elem, dtf);
        }catch (DateTimeParseException e) {
            trouble = "неверно указана введенная дата: " + elem;
            return false;
        }
        return true;
    }

    private static boolean checkSex(String elem){
        if (elem.equalsIgnoreCase("m") | elem.equalsIgnoreCase("f")){
            return true;
        }else {
            trouble = "неверно указан пол" + elem;
            return false;
        }
    }
    private static boolean checkName(String elem){
        if (Pattern.matches("[a-zA-Z]+", elem )){
            return true;
        }else {
            trouble = "неверно введенно ФИО";
            return false;
        }
    }

    private static boolean checkPhoneNumber(String phoneNum){
        try {
            Long.parseLong(phoneNum);
            return true;
        }catch (NumberFormatException e){
            trouble = "неверно введен номер телефона " + phoneNum;
        }
        return false;
    }
}
