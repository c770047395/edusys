package com.bysj.controller;

import com.bysj.pojo.Orders;
import com.bysj.pojo.Student;
import com.bysj.service.OrdersService;
import com.bysj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private OrdersService ordersService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session,Model model){
        if(session.getAttribute("user")!=null){
            return "redirect:/user/toMain";
        }
        model.addAttribute("title","家长/学生");
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){

        Student student = studentService.login(username, password);
        if(student == null){
            model.addAttribute("msg","用户名或密码错误");
            model.addAttribute("msg_type","danger");
            return "login";
        }
        session.setAttribute("user",student);
        return "redirect:/user/toMain";
    }

    @RequestMapping("/toMain")
    public String toMain(HttpSession session,Model model){
        List<Orders> ordersList = ordersService.queryOrdersByUserId(((Student) session.getAttribute("user")).getId());
        model.addAttribute("list",ordersList);
        return "main";
    }

    @RequestMapping("/toRegister")
    public String toRegister(Model model){
        model.addAttribute("title","家长/学生");
        return "register";
    }
    @RequestMapping("register")
    public String register(Student student, RedirectAttributes modelMap){
        if(studentService.queryStudentByUsername(student.getUsername())!= null){
            modelMap.addFlashAttribute("msg","用户名已存在，注册失败");
            modelMap.addFlashAttribute("msg_type","danger");
            return "redirect:/user/toRegister";
        }
        int result = studentService.addStudent(student);
        if(result!= 1){
            modelMap.addFlashAttribute("msg","未知错误，请联系管理员");
            modelMap.addFlashAttribute("msg_type","danger");
            return "redirect:/user/toRegister";
        }
        modelMap.addFlashAttribute("msg","注册成功");
        modelMap.addFlashAttribute("msg_type","success");
        return "redirect:/user/toLogin";
    }

}
