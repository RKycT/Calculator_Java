import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    //Mark that uses to check whether the entered numbers are roman
    static boolean mark = false;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("This calculator will work until you'll write \"Stop\"");
        while (true) {
            input = scanner.nextLine();

            if (Objects.equals(input, "stop") || Objects.equals(input, "Stop")) break;

            if (String.valueOf(input.charAt(0)).equals("I") || String.valueOf(input.charAt(0)).equals("V") || String.valueOf(input.charAt(0)).equals("X")) {
                input = Convert(input);
            }

            System.out.println(calc(input));
            mark = false;
        }
    }

    static String Convert(String input) {
        mark = true;
        int i = 0;
        String operation;
        String num = "";
        String result = "";
        while (!String.valueOf(input.charAt(i)).equals(" ") && !String.valueOf(input.charAt(i)).equals("+") && !String.valueOf(input.charAt(i)).equals("-") && !String.valueOf(input.charAt(i)).equals("*") && !String.valueOf(input.charAt(i)).equals("/")) {
            num += (String.valueOf(input.charAt(i)));
            i++;
        }
        if (input.charAt(i) == ' ') {
            i++;
            operation = String.valueOf(input.charAt(i));
            i++;
            if (input.charAt(i) == ' ') i++;
        } else {
            operation = String.valueOf(input.charAt(i));
            i++;
            if (input.charAt(i) == ' ') i++;
        }

        switch (num) {
            case "I":
                num = "1";
                break;

            case "II":
                num = "2";
                break;

            case "III":
                num = "3";
                break;

            case "IV":
                num = "4";
                break;

            case "V":
                num = "5";
                break;

            case "VI":
                num = "6";
                break;

            case "VII":
                num = "7";
                break;

            case "VIII":
                num = "8";
                break;

            case "IX":
                num = "9";
                break;

            case "X":
                num = "10";
                break;
            default:

                break;
        }
        result = num + " " + operation + " ";
        num = "";
        input = input.substring(i, input.length());

        for (i = 0; i < input.length(); i++) {
            num += (String.valueOf(input.charAt(i)));
        }
        switch (num) {
            case "I":
                num = "1";
                break;

            case "II":
                num = "2";
                break;

            case "III":
                num = "3";
                break;

            case "IV":
                num = "4";
                break;

            case "V":
                num = "5";
                break;

            case "VI":
                num = "6";
                break;

            case "VII":
                num = "7";
                break;

            case "VIII":
                num = "8";
                break;

            case "IX":
                num = "9";
                break;

            case "X":
                num = "10";
                break;
            default:

                break;
        }
        result += num;

        return result;
    }

    static String convBack (int arabNums) {
        mark = false;
        String result = "";

        if (arabNums == 100)
            return "C";

        int dozens = arabNums / 10;
        int units = arabNums % 10;

        switch (dozens) {
            case (1) -> result = "X";
            case (2) -> result = "XX";
            case (3) -> result = "XXX";
            case (4) -> result = "XL";
            case (5) -> result = "L";
            case (6) -> result = "LX";
            case (7) -> result = "LXX";
            case (8) -> result = "LXXX";
            case (9) -> result = "XC";
        }
        switch (units) {
            case (1) -> result += "I";
            case (2) -> result += "II";
            case (3) -> result += "III";
            case (4) -> result += "IV";
            case (5) -> result += "V";
            case (6) -> result += "VI";
            case (7) -> result += "VII";
            case (8) -> result += "VIII";
            case (9) -> result += "IX";
        }

        return  result;
    }

    static String calc (String input) {
        int i = 0;
        String num1 = "";
        String num2 = "";
        String operation;
        String result = "";

        while (!String.valueOf(input.charAt(i)).equals(" ") && !String.valueOf(input.charAt(i)).equals("+") && !String.valueOf(input.charAt(i)).equals("-") && !String.valueOf(input.charAt(i)).equals("*") && !String.valueOf(input.charAt(i)).equals("/")) {
            num1 += String.valueOf(input.charAt(i));
            i++;
        }
        if (input.charAt(i) == ' ') {
            i++;
            operation = String.valueOf(input.charAt(i));
            i++;
            if (input.charAt(i) == ' ') i++;
        } else {
            operation = String.valueOf(input.charAt(i));
            i++;
            if (input.charAt(i) == ' ') i++;
        }

        num2 = input.substring(i, input.length());

        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);

        if ((a < 11 && a > 0) && (b < 11 && b > 0))
            switch (operation) {
                case "+":
                    result = String.valueOf(a + b);
                    break;

                case "-":
                    result = String.valueOf(a - b);
                    break;

                case "*":
                    result = String.valueOf(a * b);
                    break;

                case "/":
                    result = String.valueOf(a / b);
                    break;

                default:
                    return "Operation exception: incorrect reading";
            }

        if (mark) {
            if ((input.contains("-") && a <= b) || (input.contains("/") && a < b))
                return "Input exception: In roman numerals isn't available negative and zero value";
            else {
                result = String.valueOf(
                    convBack(Integer.parseInt(result)));
            }
            return result;
        }

        return result;
    }
}