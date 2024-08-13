package AulaLab1;
import java.util.Scanner;  

public class Echo {
    public static void main(String[] args) {
        String inputVar = readString();
        System.out.println("Echo: " + inputVar);
    }

    private static int readNumber() {
        Scanner scn = new Scanner(System.in);
        int inputNumber = scn.nextInt();
        return inputNumber;
    }

    private static String readString() {
        Scanner scn = new Scanner(System.in);
        String inputString = scn.nextLine();
        return inputString;
    }

}
