package day9.Task2;

public class TestFigures {
    public static void main(String[] args) {
        /*Circle circle = new Circle("Red",5.0);
        circle.area();
        circle.perimeter();
        Rectangle rectangle = new Rectangle("Black",2.0, 3.0);
        rectangle.area();
        rectangle.perimeter();
        Triangle triangle = new Triangle("White",5.0, 5.0, 5.0);
        triangle.area();
        triangle.perimeter();*/
        Figure figure = new Rectangle("Orange", 40, 15);

        Figure[] figures = {
                new Triangle("Red", 10, 10, 10),
                new Triangle("Green", 10, 20, 30),
                new Triangle("Red", 10, 20, 15),
                new Rectangle("Red", 5, 10),
                new Rectangle("Orange", 40, 15),
                new Circle("Red", 4),
                new Circle("Red", 10),
                new Circle("Blue", 5)
        };
        calculateRedPerimeter(figures);
        System.out.println();
        calculateRedArea(figures);
    }
    public static double calculateRedPerimeter(Figure[] figures){
        double summ = 0.0;
        for(int i = 0; i< figures.length; i++) {
            if(figures[i].getColor() == "Red")
            summ = summ + figures[i].perimeter();
        }
        System.out.printf("�������� ���� ������� ����� ����� %.2f", summ);
        return summ; //���������� ����� ����������
    };
    public static double calculateRedArea(Figure[] figures){
        double summArea = 0.0;
        for(int i = 0; i< figures.length; i++) {
            if(figures[i].getColor() == "Red")
            summArea = summArea + figures[i].area();
        }
        System.out.printf("������� ���� ������� ����� ����� %.2f", summArea);
        return summArea; //���������� ����� ��������
    };
}
abstract class Figure{
    private String color;
    public Figure(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    public abstract double area();
    public abstract double perimeter();

}
class Circle extends Figure{
    private double radius; // ������

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        double area = radius * radius * Math.PI;
        //System.out.println("������� ����� ����� " + area);
        return area;
    }

    @Override
    public double perimeter() {
        double perimeter = 2 * radius * Math.PI;
        //System.out.println("�������� ����� ����� " + perimeter);
        return perimeter;
    }
}
class Rectangle extends Figure{
    private double width; //������
    private double height; // ������
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        double area = width * height;
        //System.out.println("������� �������������� ������ " + area);
        return area;
    }

    @Override
    public double perimeter() {
        double perimeter = (width + height)*2;
        //System.out.println("�������� �������������� ����� " + perimeter);
        return perimeter;
    }
}
class Triangle extends Figure{
    private double length1;
    private double length2;
    private double length3;

    public Triangle(String color, double length1, double length2, double length3) {
        super(color);
        this.length1 = length1;
        this.length2 = length2;
        this.length3 = length3;
    }

    @Override
    public double area() {
        double s = (length1 + length2 + length3)*0.5;
        double area = Math.sqrt(s*(s-length1)*(s-length2)*(s-length3));
        //System.out.println("������� ������������ ����� " + area);
        return area;
    }

    @Override
    public double perimeter() {
        double perimeter = length1 + length2 + length3;
        //System.out.println("�������� ������������ ����� " + perimeter);
        return perimeter;
    }
}

