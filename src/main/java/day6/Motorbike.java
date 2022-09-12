package day6;


class Motorbike {
    private String model;
    private String color;
    private int year;

    public Motorbike(String model, String color, int year){
        this.model = model;
        this.color = color;
        this.year = year;
    }

    void info(){
        System.out.println("Это мотоцикл");
    }

    int yearDifference(int inputYear){
        int years2 = inputYear - year;
        if (years2 < 0)
            years2 = -years2;
        return years2;
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
