import java.util.*;

public class classes
{   public static void main(String[] args) {

    List<Shape> shapes = new ArrayList<>();
    shapes.add(new Circle(5));
    shapes.add(new Rectangle(4,5));
    shapes.add(new Triangle(3,4));

    for(Shape s: shapes){ 
        System.out.println("Area is "+s.area());
    }
    }
}
class Circle extends Shape implements Printable{
    double r;

    public Circle(double r){ this.r = r;
    }
    
    @Override
    public double area(){
        return 3.1416*r*r;
    }

    @Override 
    public void printDetails(){
        System.out.println("radius is "+r);
        System.out.println("Area of the circle is "+area());

    } 

}
class Triangle extends Shape implements Printable{
    double b;
    double h;
    public Triangle(double b, double h) {
        this.b = b;
        this.h = h;
    }
    @Override
    public double area(){
        return 0.5*b*h;
        
    }
    @Override
    public void printDetails(){
        System.out.println("Base is "+b+"\nHeight is "+h);
        System.out.println("Area of the triangle is "+area());

    } 

}class Rectangle extends Shape implements Printable{
    double l;
    double b;
    public Rectangle(double l, double b){
        this.l = l;
        this.b = b;
    }
    @Override
    public double area(){
        return b*l;
        
    }
    @Override
    public void printDetails(){
        System.out.println("Breadth is "+b+"\nLength is "+l);
        System.out.println("Area of the rectangle is "+area());

    }

} 

