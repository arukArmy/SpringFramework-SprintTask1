package kz.bitlab.springboot.sprinttask1.db;

import java.util.ArrayList;

public class DBManager {

    private static final ArrayList<Student> students = new ArrayList<>();
    private static Long id = 6L;

    static {

        students.add(new Student(1L, "Berik", "Hudaybergen", 90, "A"));
        students.add(new Student(2L, "Munira", "Serikov", 74, "C"));
        students.add(new Student(3L, "Erlan", "Baykuaovt", 56, "D"));
        students.add(new Student(4L, "Nurbolat", "Hudaybergenov", 95, "A"));
        students.add(new Student(5L, "Diyorbek", "Akimbayev", 35, "F"));

    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public static void addStudent(Student student) {
        student.setId(id);
        id++;
        students.add(student);
    }

    public static Student getStudent(Long id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }


}
