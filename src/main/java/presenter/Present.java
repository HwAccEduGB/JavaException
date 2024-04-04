package presenter;

import model.PhoneBook;
import util.CheckData;
import view.TerminalDisplay;
import java.util.Scanner;

public class Present {
    PhoneBook phoneBook;
    TerminalDisplay display;

    public Present() {
        this.phoneBook = new PhoneBook();
        this.display = new TerminalDisplay();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        display.displayTerminalMenu();
        String currentLine = scanner.nextLine();
        if (CheckData.checkInputData(currentLine)) {
            String[] tempArr = CheckData.getLines();
            display.displayTerminalMessage(phoneBook.save(outputData(tempArr), tempArr[0]));
        } else {
            display.displayTerminalMessage(CheckData.getTrouble());
        }
        scanner.close();
    }

    private static String outputData(String[] inputData) {
        return "\nФамилия: " + inputData[0] + "\nИмя: " + inputData[1] + "\nОтчество: " + inputData[2] + "\nДата: " + inputData[3] + "\n№ тел.: " + inputData[4] + "\nПол: " + inputData[5];
    }
}

