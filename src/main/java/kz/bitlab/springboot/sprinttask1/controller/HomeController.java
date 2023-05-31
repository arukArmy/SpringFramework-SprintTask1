package kz.bitlab.springboot.sprinttask1.controller;

import kz.bitlab.springboot.sprinttask1.db.DBManager;
import kz.bitlab.springboot.sprinttask1.db.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value = "/")
    public String indexPage(Model model){
        ArrayList<Student> studentArray = DBManager.getStudents();
        model.addAttribute("students", studentArray);
        return "index";
    }

    @GetMapping(value = "/add-student")
    public String addStudentPage(Model model){
        return "addstudent";
    }

    @PostMapping(value = "/add-student")
    public String addStudent(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "surname") String surname,
            @RequestParam(name = "exam") int exam
    ){
        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setExam(exam);
        if (exam >= 90){
            student.setMark("A");
        }else if (exam >= 75){
            student.setMark("B");
        }else if (exam >= 60){
            student.setMark("C");
        }else if (exam >= 50){
            student.setMark("D");
        }else {
            student.setMark("F");
        }
        DBManager.addStudent(student);

        return "redirect:/";
    }

}
