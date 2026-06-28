import java.lang.*;
import java.util.*;
import java.util.stream.*;

public class EmployeeStreams{
    public static void main(String[] args) {
        List<Employee> empObj = new ArrayList<>(List.of(
            new Employee("Alice","Eng",90000),
            new Employee("Bob","HR",55000),
            new Employee("Dave","HR",60000),
            new Employee("Charlie","Eng",75000),
            new Employee("Eve","Eng",95000)));
        EmployeeStreams esObj = new EmployeeStreams();
        System.out.println("Avg Salary for Engineering dept is "+esObj.avgSalary(empObj));
        System.out.println("Highest Salary is given to "+ esObj.highestPaid(empObj));

        Map<String, List<Employee>> groupEmployees 
        =   empObj.stream()
                .collect(Collectors.groupingBy( emp -> emp.dept));

        groupEmployees.forEach((dept,emps)->
        System.out.println(dept +" -> "+ emps.stream()
        .map(e -> e.name).collect(Collectors.toList())));

        Map<String, Long> deptCount = 
        empObj.stream()
            .collect(Collectors.groupingBy(
            emp -> emp.dept, Collectors.counting()));
        
        deptCount.forEach((dept, num) ->
                System.out.println(dept+" - "+ num)); 
    
    
    }
    String highestPaid(List<Employee> empObj){
        return empObj.stream()
                .max(Comparator.comparingDouble(obj->obj.salary))
                .map(obj-> obj.name)
                .orElse("none");
    }

    double avgSalary(List<Employee> empObj){
        return empObj.stream()
            .filter(obj -> obj.dept.equals("Eng"))
            .mapToDouble(obj -> obj.salary)
            .average()
            .orElse(0.0);
    }
}
class Employee{
    String name;
    String dept;
    double salary;

    public Employee(String name, String dept, double salary){
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}