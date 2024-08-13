package AulaLab1;

import java.math.RoundingMode;

public class Increment {

    // Ache o bug
    
    public static void main(String[] args) {
        double i = 0;
        double stop = 1.5;
        double cond = 1.0;
        double div = 0;

        while (div != 1 && i < stop) {
            div = i/cond;
            System.out.println(i);
            i = i + 0.1;
        }



    }
}
