package day6;

public class Task2 {
    public static void main(String[] args) {
        Airplane boing = new Airplane("Туполев", 1980, 125.5, 50.5);
        boing.setYear(2015);
        boing.setLength(134.8);
        boing.fillUp(5);
        boing.fillUp(36);
        boing.info();
    }
}
class Airplane{
    private String manufacturer;
    private int year;
    private double length;
    private double weight;
    private int fuel;

    public Airplane(String manufacturer, int year, double length, double weight){
        this.manufacturer = manufacturer;
        this.year = year;
        this.length = length;
        this.weight = weight;
        this.fuel = 0;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer = manufacturer;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setLength(double length){
        this.length = length;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public void setFuel(int fuel){
        this.fuel = fuel;
    }
    public int getFuel(){
        return fuel;
    }
    void info(){
        System.out.println("Изготовитель: " + manufacturer + ", год выпуска: " + year + ", длина: " + length + " м., вес: " + weight + " т., количество топлива в баке: " + fuel + " л.");
    }
    public int fillUp(int n){
        this.fuel = fuel + n;
        return fuel;
    }
}