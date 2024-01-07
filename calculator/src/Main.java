
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Введите выражение: Например 2 + 2 или V + II или 'Exit' для выхода!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("Exit")) {
                break;
            }

            if(!isValidInput(input)) {
                System.out.println("Калькулятор может работать только с арабскими или римскими цифрами одновременно");
                continue;
            }
            try {
                String result = calculator(input);
                System.out.println("Результат: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
                break;
            }
        }
    }
    public static boolean isRoman(String val) {
        for (int i = 0; i < Rim.array.length; i++) {
            if (val.equals(Rim.array[i])) {
                return true;
            }
        }
        return false;
    }
    public static boolean isValidInput(String input) {
        String[] split = input.split(" ");
        boolean hasRoman = false;
        boolean hasArabic = false;
        for (String s : split) {
            if (isArabic(s)) {
                hasArabic = true;
            } else if (isRoman(s)) {
                hasRoman = true;
            }
        }
        return !(hasArabic && hasRoman);
    }
    public static boolean isArabic(String val) {
        try {
            Integer.parseInt(val);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }




    public static String calc(String input) {
        String[] split = input.split(" ");

        String inputNum1;
        String inputNum2;
        boolean isRoman = false;
        //boolean isArabic;

        inputNum1 = split[0];
        inputNum2 = split[2];
        if (split.length != 3) throw new IllegalArgumentException("Неверный формат выражения");
        if (Rim.isRoman(split[0]) && Rim.isRoman(split[2])) {
            inputNum1 = String.valueOf(Rim.conv(split[0]));
            inputNum2 = String.valueOf(Rim.conv(split[2]));
            isRoman = true;

        }



        int a = Integer.parseInt(inputNum1);
        int b = Integer.parseInt(inputNum2);
        String operator = split[1];
        int result;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Неверная операция");
        }
        /*if(result < 1) {
            throw new IllegalArgumentException("Результат меньше единицы");
        }*/

        if (a < 0 || a > 10 || b < 0 || b > 10) {
            throw new IllegalArgumentException("Числа вне допустимого диапазона");
        }
        if (isRoman) {
            return Rim.convertToRoman(result);
        } else {
            return String.valueOf(result);
        }
    }




}
class Rim {
    static String[] array = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};

    public static boolean isRoman(String val) {
        for (int i = 0; i < array.length; i++) {
            if (val.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    public static int conv(String rim) {
        for (int i = 0; i < array.length; i++) {
            if (rim.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToRoman(int arabian) {
         return array[arabian];



    }


}
            


















