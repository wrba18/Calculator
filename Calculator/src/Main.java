import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Введите первое слово");
        String firstString = scan.nextLine();

        if (    firstString == null ||
                !firstString.matches("[a-zA-Zа-яА-ЯёЁ!? ]+") ||
                firstString.length() > 40)
        {
            System.out.println("...");
            throw new IllegalArgumentException();
        }

        System.out.println("Введите второе слово");
        String secondString = scan.nextLine();

        if (    secondString == null ||
                !secondString.matches("[a-zA-Zа-яА-ЯёЁ!?0-10 ]+"))
        {
            System.out.println("...");
            throw new IllegalArgumentException();
        }

        System.out.println("Введите + - * /");
        String action = scan.nextLine();

        if (    action == null ||
                !action.matches("[/*+-]+"))
        {
            System.out.println("...");
            throw new IllegalArgumentException();
        }

        System.out.println("\"" + firstString + "\" " +
                            action + " \"" + secondString + "\"");

        switch (action){
            case "+": {
                String res = firstString + secondString;
                System.out.printf("\"" + res + "\"");
                break;
            }
            case "-": {
                String res = firstString.replaceAll(secondString, "");
                System.out.printf("\"" + res + "\"");
                break;
            }
            case "*": {
                int i = Integer.parseInt(secondString);
                if (!secondString.matches("[0-10]+") ) {
                    System.out.println("...");
                    throw new IllegalArgumentException();
                }
                String res = firstString.repeat(i);
                System.out.printf("\"" + res + "\"");
                break;
            }
            case "/": {
                int i = Integer.parseInt(secondString);
                if (i == 0 || !secondString.matches("[0-10]+") ) {
                    System.out.println("...");
                    throw new IllegalArgumentException();
                }
                String res = firstString.substring(0, secondString.length()/i);
                System.out.printf("\"" + res + "\"");
                break;
            }
        }
    }
}