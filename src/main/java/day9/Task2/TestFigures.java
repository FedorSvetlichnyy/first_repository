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
        System.out.printf("Периметр всех красных фигур равен %.2f", summ);
        return summ; //возвращаем сумму периметров
    };
    public static double calculateRedArea(Figure[] figures){
        double summArea = 0.0;
        for(int i = 0; i< figures.length; i++) {
            if(figures[i].getColor() == "Red")
            summArea = summArea + figures[i].area();
        }
        System.out.printf("Площадь всех красных фигур равна %.2f", summArea);
        return summArea; //возвращаем сумму площадей
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
    private double radius; // радиус

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        double area = radius * radius * Math.PI;
        //System.out.println("Площадь круга равна " + area);
        return area;
    }

    @Override
    public double perimeter() {
        double perimeter = 2 * radius * Math.PI;
        //System.out.println("Периметр круга равен " + perimeter);
        return perimeter;
    }
}
class Rectangle extends Figure{
    private double width; //ширина
    private double height; // высота
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        double area = width * height;
        //System.out.println("Площадь прямоугольника равена " + area);
        return area;
    }

    @Override
    public double perimeter() {
        double perimeter = (width + height)*2;
        //System.out.println("Периметр прямоугольника равен " + perimeter);
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
        //System.out.println("Площадь треугольника равна " + area);
        return area;
    }

    @Override
    public double perimeter() {
        double perimeter = length1 + length2 + length3;
        //System.out.println("Периметр треугольника равен " + perimeter);
        return perimeter;
    }
}

