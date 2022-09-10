package day5;


public class Task2 {
    public static void main(String[] args) {
        Bike bike1 = new Bike("ява", "красный", 2005);
        System.out.println("ћотоцикл: модель " + bike1.getModel() +  ", цвет " + bike1.getColor() + ", год выпуска " + bike1.getYear());

    }
}

class Bike{
    private String model;
    private String color;
    private int year;

    public Bike(String model, String color, int year){
        this.model = model;
        this.color = color;
        this.year = year;
    }

    public String getModel(){
        return model;
    }
    public String getColor(){
        return color;
    }
    public int getYear(){
        return year;
    }
}
