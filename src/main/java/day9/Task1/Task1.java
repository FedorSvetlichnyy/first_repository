package day9.Task1;

public class Task1 {
    public static void main(String[] args) {
        //Human human = new Human("Вова");
        //human.printInfo();
        Student student = new Student("Петя", "И-2022");
        System.out.println("Название учебной группы студента " + student.getGroupName());
        //student.printInfo();
        Teacher teacher = new Teacher("Тамара Петровна", "Информатика");
        System.out.println("Название предмета у преподавателя " + teacher.getSubjectName());
        student.printInfo();
        teacher.printInfo();

    }
}
class Human{
    private String name;
    public Human(String name){
        this.name = name;
    }
    /*public void Human(){

    }*/
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void printInfo(){
        System.out.println("Этот человек с именем " + getName() + ".");
    }
}

class Student extends Human{
    private String groupName;

    public Student(String name, String groupName){
        super(name);
        this.groupName = groupName;
    }
    public String getGroupName(){
        return groupName;
    }
    public void printInfo(){
        super.printInfo();
        System.out.println("Этот студент с именем " + getName() + ".");
    }
}
class Teacher extends Human{
    private String subjectName;

    public Teacher(String name, String subjectName) {
        super(name);
        this.subjectName = subjectName;
    }
    public String getSubjectName(){
        return subjectName;
    }
    public void printInfo(){
        super.printInfo();
        System.out.println("Этот преподаватель с именем " + getName() + ".");
    }
}