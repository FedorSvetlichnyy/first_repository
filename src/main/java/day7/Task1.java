package day7;


public class Task1 {
    public static void main(String[] args) {
        Airplane airplane1 = new Airplane("“уполев", 1980, 135.5, 50.5);
        Airplane airplane2 = new Airplane("яковлев", 1999, 145.5, 50.5);
        Airplane.compareAirplanes(airplane1, airplane2);

    }
}