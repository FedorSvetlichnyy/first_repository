package day6;

class Car {
    private String model;
    private String color;
    private int year;

    void info(){
        System.out.println("Это автомобиль");
    }

    int yearDifference(int inputYear){
        int years1 = inputYear - year;
        if (years1 < 0)
            years1 = -years1;
        return years1;
    }

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