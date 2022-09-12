package day6;

import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Маргарита Васильевна","Информатика");
        Student student = new Student("Петя"); //создаем объект студент с именем Петя
        teacher.evaluate("Петя"); //вызывыем метод оценки студента

        //знаю, что неверно решил, не хочу пока смотреть правильный код. Потом посмотрю ваш комментарий и исправлю.
        // но текст "Преподаватель Маргарита Васильевна оценил(а) студента с именем Петя по предмету Информатика на оценку хорошо." выводит

    }
}
class Teacher{
    private String nameTeacher;
    private String subject;
    public Teacher(String nameTeacher, String subject){
        this.nameTeacher = nameTeacher;
        this.subject = subject;
    }
    /*public String getSubject(){
       return subject;
    }
    public String getNameTeacher(){
        return nameTeacher;
    }*/

    public void evaluate(String student){
        String rating = ""; //объявляем переменную, которая будет показывать вместо цифр 2-5 "отлично" и тд
        Random random = new Random();
        int i = random.nextInt(4)+2; //случайное число от 2 до 5
        if(i == 5) rating = "отлично";
        if(i == 4) rating = "хорошо";
        if(i == 3) rating = "удовлетворительно";
        if(i == 2) rating = "неудовлетворительно";
        System.out.println("Преподаватель " + nameTeacher + " оценил(а) студента с именем " + student + " по предмету " + subject + " на оценку " + rating + ".");
    }
}
class Student{
    private String nameStudent;
    public Student(String nameStudent){
        this.nameStudent = nameStudent;
    }
    public String getNameStudent(){
        return nameStudent;
    }
}

