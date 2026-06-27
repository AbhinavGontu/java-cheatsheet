import java.util.Scanner;

public class basicCalculator{
    double calculator(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number : ");
        double first = scanner.nextDouble();
        System.out.println("Enter second number : ");
        double second = scanner.nextDouble();
        System.out.println("Enter operator : ");
        String operator = scanner.next();

        double ans = switch(operator){
            case "+" -> first+second;
            case "-" -> first-second;
            case "*" -> first*second;
            case "/" -> first/second;
            default -> -1;
        };
        return ans;
    }
    public static void main(String[] args) {
        basicCalculator bc = new basicCalculator();
        System.out.println( bc.calculator());
    }
}