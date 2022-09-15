package day7;

class Airplane {
    private String manufacturer;
    private int year;
    private double length;
    private double weight;
    private int fuel;

    //���������� 2 ��������
    public static void compareAirplanes(Airplane a, Airplane b){
        if(a.getLength() > b.getLength())
        System.out.println("������ ������� ������.");
        else if (a.getLength() == b.getLength()){
            System.out.println("��� �����.");
        }
        else {
            System.out.println("������ ������� ������.");
        }
    }

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
    public double getLength() {
        return length;
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
        System.out.println("������������: " + manufacturer + ", ��� �������: " + year + ", �����: " + length + " �., ���: " + weight + " �., ���������� ������� � ����: " + fuel + " �.");
    }
    public int fillUp(int n){
        this.fuel = fuel + n;
        return fuel;
    }
}