package ru.lazarev.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lazarev.domain.Student;
import ru.lazarev.exception.NotFoundException;
import ru.lazarev.service.StudentService;

@Controller
@Slf4j
@RequestMapping("/student")
public class StudentController {

  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public String studentTable(Model model,
      @RequestParam(name = "titlePrefix", required = false) String titlePrefix) {
    model.addAttribute("students",
        studentService.findByTitleLike(titlePrefix == null ? "%%%" : "%" + titlePrefix + "%"));
    return "student_table";
  }

  @GetMapping("/{id}")
  public String studentForm(Model model, @PathVariable("id") Long id) {
    Student student = studentService.getById(id)
        .orElseThrow(() -> new NotFoundException("Student not found"));
    model.addAttribute("students", student);
    return "student_form";
  }

  @GetMapping("/new")
  public String studentForm(Model model) {
    model.addAttribute("students", new Student());
    return "student_form";
  }

  @DeleteMapping("/{id}")
  public String deleteStudent(@PathVariable("id") Long id) {
    studentService.delete(id);
    return "redirect:/student";
  }
}
