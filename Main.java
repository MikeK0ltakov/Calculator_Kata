
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int i = 0;
        int j = 1;
        while (i<j) {
            Roma nmb = new Roma();
            Scanner scn = new Scanner(System.in);
            String calc = scn.nextLine();
            String[] actions = {"+", "-", "/", "*"};
            String[] reaction = {"\\+", "-", "/", "\\*"};
            int ind = -1;
            for (int x = 0; x < actions.length; x++)
                if (calc.contains(actions[x])) {
                    ind = x;
                    break;
                }
            if (ind == -1) {
                System.out.print("Неправильная операция над числами");
                return;
            }
            String[] data = calc.split(reaction[ind]);
            if (nmb.isRoman(data[0]) == nmb.isRoman(data[1])) {
                int a, b;
                boolean isRoman = nmb.isRoman(data[0]);
                if (isRoman) {
                    a = nmb.RomToInt(data[0]);
                    b = nmb.RomToInt(data[1]);
                }else{
                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[1]);
                }
                if (a > 10 | b > 10) {
                    System.out.print("Числа должны быть до 10 включительно");
                    break;
                }
                int result = switch (actions[ind]) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "/" -> a / b;
                    case "*" -> a * b;
                    default -> 0;
                };
                if(isRoman){
                    System.out.print(nmb.IntToRom(result) + "\n");
                }else{
                    System.out.print(result + "\n");
                }

            }else{
                System.out.print("Числа из разных алфавитов");
                break;
            }
        }
    }
}