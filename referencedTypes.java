import java.util.Scanner;

public class referencedTypes{
    public static void main(String[] args) {
        System.out.println("Enter name: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        System.out.println("Enter Age");
        int age = scan.nextInt();
        System.out.println("Name : " + name +"\nAge : "+age);
    }
}