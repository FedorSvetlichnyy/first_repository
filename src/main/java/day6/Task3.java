package day6;

import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("��������� ����������","�����������");
        Student student = new Student("����"); //������� ������ ������� � ������ ����
        teacher.evaluate("����"); //�������� ����� ������ ��������

        //����, ��� ������� �����, �� ���� ���� �������� ���������� ���. ����� �������� ��� ����������� � ��������.
        // �� ����� "������������� ��������� ���������� ������(�) �������� � ������ ���� �� �������� ����������� �� ������ ������." �������

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
        String rating = ""; //��������� ����������, ������� ����� ���������� ������ ���� 2-5 "�������" � ��
        Random random = new Random();
        int i = random.nextInt(4)+2; //��������� ����� �� 2 �� 5
        if(i == 5) rating = "�������";
        if(i == 4) rating = "������";
        if(i == 3) rating = "�����������������";
        if(i == 2) rating = "�������������������";
        System.out.println("������������� " + nameTeacher + " ������(�) �������� � ������ " + student + " �� �������� " + subject + " �� ������ " + rating + ".");
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

