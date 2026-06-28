import java.util.*;

class Employee{
    String name;
    String dept;
    Double salary;
    public Employee(String name, String dept, double salary){
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public boolean equals(Employee obj){
        return "Engineering" == obj.dept;
    }
}

class compareByDept implements Comparator<Employee>{
        @Override
        public int compare(Employee obj1, Employee obj2){
            return obj1.dept.compareTo(obj2.dept);
        }

}
class compareBySalary implements Comparator<Employee>{
        @Override
        public int compare(Employee obj1, Employee obj2){
            if (obj1.salary < obj2.salary)
                return 1;
            else if( obj1.salary > obj2.salary)
                return -1;
            return 0;
        }
}
public class EmployeeTest{
    public static void main(String[] args) {
        List<Employee> empObj = new ArrayList<>(8);
        empObj.add(new Employee("Abhinav","IT",10));
        empObj.add(new Employee("A","Engineering",11));
        empObj.add(new Employee("B","IT",1));
        empObj.add(new Employee("C","Engineering",12));
        empObj.add(new Employee("D","Engineering",9));
        empObj.add(new Employee("E","IT",15));
        empObj.add(new Employee("F","Engineering",7));

        Comparator comparator = new compareByDept();
        Collections.sort(empObj, comparator);

        for(Employee emp: empObj){
            if( (new Employee("C","Engineering",19).equals(emp)))
                System.out.println(emp.name+ " "+emp.dept);
        }

        Comparator comparator1 = new compareBySalary();
        Collections.sort(empObj, comparator1);
        int count = 0;
        for(Employee emp: empObj){
            System.out.println(emp.name+ " "+emp.salary);
            count++;
            if(count == 3) break;
        }
        
    }

}
