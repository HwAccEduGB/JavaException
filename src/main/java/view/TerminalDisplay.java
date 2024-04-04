package view;

public class TerminalDisplay  {
    public void displayTerminalMenu() {
        System.out.println("введите одной строкой данные через пробел:\n " +
                "фамилия имя отчество (англ)\n " +
                "дата рождения - строка в формате dd.mm.yy\n " +
                "номер телефона\n " +
                "пол(f/m)\n");
    }

    public void displayTerminalMessage(String message) {
        System.out.println(message);
    }
}
