package AulaLab1;

public class CalculatorTest {

    public static void main(String[] args) {
        

        // Teste adição
        testAddition();

        // Teste subtração
        testSubtraction();

        // Adicionar teste de multiplicação

        // Adicionar teste de divisão


        System.out.println("Testes executados com sucesso!");
    
    }

    private static void testAddition() {

        assert Calculator.add(3, 5) == 8 : "Addition test 1 failed";

        assert Calculator.add(3, -1) == 2 : "Addition test 2 failed";

        assert Calculator.add(-4, -1) == -5 : "Addition test 3 failed";
        
    }

    private static void testSubtraction() {

        assert Calculator.subtract(5, 3) == 2 : "Subtraction test 1 failed";

        assert Calculator.subtract(3, -1) == 4 : "Subtraction test 2 failed";

        assert Calculator.subtract(-4, -1) == -3 : "Subtraction test 3 failed";
        
    }
       
}