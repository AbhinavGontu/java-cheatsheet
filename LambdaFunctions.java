import java.util.*;

public class LambdaFunctions{
    public static void main(String[] args) {
    List<String> names = Arrays.asList("Alice","bob","Charlie","dave","Eve");
    // names.stream()
    //     .filter(name -> name.length() > 3)
    //     .forEach(System.out::println);
    // names.stream()
    //     .map(name -> name.toUpperCase())
    //     .forEach(System.out::println);
    // names.stream()
    //     .sorted()
    //     .forEach(System.out::println);
    // names.forEach(System.out::println);
    
    names.stream()
        .filter(name -> name.length()>3)
        .map(String::toUpperCase)
        .sorted()
        .forEach(System.out::println);



    }
}