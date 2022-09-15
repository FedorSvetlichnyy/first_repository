package day5;

public class Task1 {
    public static void main(String[] args) {

        Cars car = new Cars();
        car.setModel("Лада");
        car.setColor("красный");
        car.setYear(1978);
        System.out.println("У меня машина " + car.getModel() + ", цвет " + car.getColor() + ", " + car.getYear() + " года выпуска.");
    }
}
class Cars{
    private String model;
    private String color;
    private int year;
    public void setModel(String modelCars){
        model = modelCars;
    }
    public String getModel(){
        return model;
    }
    public void setColor(String colorCars){
        color = colorCars;
    }
    public String getColor(){
        return color;
    }
    public void setYear(int yearCars){
        year = yearCars;
    }
    public int getYear(){
        return year;
    }
}