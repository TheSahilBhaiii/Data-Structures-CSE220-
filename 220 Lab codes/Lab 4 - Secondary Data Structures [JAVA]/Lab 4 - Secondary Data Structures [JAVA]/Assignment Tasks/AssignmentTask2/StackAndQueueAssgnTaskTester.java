public class StackAndQueueAssgnTaskTester {

    // You have to write this method
    // YOU MUST SUBMIT THIS METHOD
    // Hint: You need to traverse each characters of the String
    public static void evalMathExpression(String expression) {
        // You can create Stack and Queue object here to use
        // To Do

    }

    // DO NOT CHANGE ANYTHING IN THE DRIVER CODE
    public static void main(String[] args) {
        
        System.out.println("================ Test 01 ================");

        System.out.println("This should print:");
        System.out.println("Postfix: 3 5 2 8 - * +\nResult: -27");
        System.out.println("-----------------------------------------");
        System.out.println("Your Output:");
        evalMathExpression("3 + 5 * (2 - 8)");
        System.out.println("=========================================");

        System.out.println("================ Test 02 ================");

        System.out.println("This should print:");
        System.out.println("Invalid Expression");
        System.out.println("-----------------------------------------");
        System.out.println("Your Output:");
        evalMathExpression("(2 + 3)) * ((4 - 1)");
        System.out.println("=========================================");

        System.out.println("================ Test 03 ================");

        System.out.println("This should print:");
        System.out.println("Postfix: 7 6 5 2 ^ * 3 + + 4 2 / -\nResult: 158");
        System.out.println("-----------------------------------------");
        System.out.println("Your Output:");
        evalMathExpression("7 + (6 * 5^2 + 3) - (4 / 2)");
        System.out.println("=========================================");

        System.out.println("================ Test 04 ================");

        System.out.println("This should print:");
        System.out.println("Postfix: 10 2 + 6 * 3 /\nResult: 24");
        System.out.println("-----------------------------------------");
        System.out.println("Your Output:");
        evalMathExpression("(10 + 2) * 6 / 3");
        System.out.println("=========================================");

        System.out.println("================ Test 05 ================");

        System.out.println("This should print:");
        System.out.println("Invalid Expression");
        System.out.println("-----------------------------------------");
        System.out.println("Your Output:");
        evalMathExpression("[2 + 3) * (4 - (5 * 6))]");
        System.out.println("=========================================");

    }
}
