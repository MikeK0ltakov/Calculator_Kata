import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String calcf = scn.nextLine();
        String answer = calculator.calc(calcf);
        System.out.print(answer);
    }
}
class calculator {
    public static String calc(String arg) {
        Roma nmb = new Roma();
        String[] actions = {"+", "-", "/", "*"};
        String[] reaction = {"\\+", "-", "/", "\\*"};
        int ind = -1;
        try {
            for (int x = 0; x < actions.length; x++)
                if (arg.contains(actions[x])) {
                    ind = x;
                    break;
                }
            if (ind == -1) {
                throw new ArithmeticException("Неправильная операция над числами");
            }
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
        String[] data = arg.split(reaction[ind]);
        try{
            if (data.length > 2){
                throw new ArithmeticException("Числе должно быть 2");
            }
        }
        catch (ArithmeticException e){
            System.out.print(e);
        }
        try {
            if (nmb.isRoman(data[0]) == nmb.isRoman(data[1])) {
                int a,b;
                boolean isRoman = nmb.isRoman(data[0]);
                try {
                    if (isRoman) {
                        a = nmb.RomToInt(data[0]);
                        b = nmb.RomToInt(data[1]);
                    } else {
                        a = Integer.parseInt(data[0]);
                        b = Integer.parseInt(data[1]);
                    }
                    int result = switch (actions[ind]) {
                        case "+" -> a + b;
                        case "-" -> a - b;
                        case "/" -> a / b;
                        case "*" -> a * b;
                        default -> 0;};
                    if (a > 10 | b > 10 | a < 0 | b < 0) {
                        throw new ArithmeticException("Числа должны быть от 1 до 10 включительно");
                    }
                    if (isRoman) {
                        return nmb.IntToRom(result);
                    }
                    else {
                        return Integer.toString(result);
                    }
                }
                catch (ArithmeticException e) {
                    System.out.println(e);
                }
            }
            else {
                throw new ArithmeticException("Числа из разных алфавитов");
            }
        }
        catch (ArithmeticException e) {
            System.out.println(e);
        }
        return Integer.toString(Integer.parseInt(arg));
    }
}
