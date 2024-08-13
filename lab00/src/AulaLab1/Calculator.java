package AulaLab1;

import java.util.Scanner;  

class Calculator {


    public static void main(String[] args) {    

        /*
        Essa classe implementa as operaçãoes de soma e subtração
        de dois números lidos na entrada e imprime o resultado

        Parametros: None
        Return: None
        */
        
        Scanner sc = new Scanner(System.in);
        String op = sc.nextLine();

        int a = sc.nextInt();
        int b = sc.nextInt();

        if (op.equals("add")) {
            System.out.println(add(a, b));
        }
        else if (op.equals("sub")) {
            System.out.println(subtract(a, b));
        }

        // adicionar divisão e multiplicação
    }


    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }
}