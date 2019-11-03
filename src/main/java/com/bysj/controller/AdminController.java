package com.bysj.controller;

import com.bysj.pojo.Admin;
import com.bysj.pojo.Orders;
import com.bysj.pojo.Student;
import com.bysj.pojo.Teacher;
import com.bysj.service.AdminService;
import com.bysj.service.OrdersService;
import com.bysj.service.StudentService;
import com.bysj.service.TeacherService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private OrdersService ordersService;

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session, Model model){
        model.addAttribute("title","管理员");
        model.addAttribute("type","admin");
        return "login";
    }
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, RedirectAttributes modelMap){

        Admin admin = adminService.login(username, password);
        if(admin == null){
            modelMap.addFlashAttribute("msg","用户名或密码错误");
            modelMap.addFlashAttribute("msg_type","danger");
            modelMap.addFlashAttribute("title","管理员");
            modelMap.addFlashAttribute("type","admin");
            return "redirect:/admin/toLogin";
        }
        session.setAttribute("user",admin);
        session.setAttribute("type","admin");
        return "redirect:/admin/toMain";
    }

    @RequestMapping("/toMain")
    public String toMain(){
        return "admin/main";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/admin/toLogin";
    }

    @RequestMapping("/toSetting")
    public String toSetting(){
        return "admin/setting";
    }
    @RequestMapping("/toPassword")
    public String toPassword(){
        return "admin/changePassword";
    }
    @RequestMapping("/updateUser")
    public String updateUser(HttpSession session,String phone,RedirectAttributes modelMap){
        Admin admin =(Admin) session.getAttribute("user");
        admin.setPhone(phone);
        adminService.updateAdmin(admin);
        session.setAttribute("user",admin);
        modelMap.addFlashAttribute("msg","修改成功");
        modelMap.addFlashAttribute("msg_type","success");
        return "redirect:/admin/toSetting";
    }
    @RequestMapping("/changePassword")
    public String changePassword(HttpSession session,String oldPassword,String newPassword,RedirectAttributes modelMap){
        Admin user =(Admin) session.getAttribute("user");
        if(!user.getPassword().equals(oldPassword)){
            modelMap.addFlashAttribute("msg","原密码错误");
            modelMap.addFlashAttribute("msg_type","warning");
            return "redirect:/admin/toPassword";
        }
        if(oldPassword.equals(newPassword)){
            modelMap.addFlashAttribute("msg","新密码与原密码重复");
            modelMap.addFlashAttribute("msg_type","warning");
            return "redirect:/admin/toPassword";
        }

        user.setPassword(newPassword);
        adminService.updateAdmin(user);
        modelMap.addFlashAttribute("msg","修改成功");
        modelMap.addFlashAttribute("msg_type","success");
        return "redirect:/admin/toPassword";
    }

    @RequestMapping("/toTeacherManager")
    public String toTeacherManager(){
        return "admin/teacherManager";
    }
    @RequestMapping("/toCheckTeacher")
    public String toCheckTeacher(Model model){
        List<Teacher> teacherList = teacherService.queryTeacherByStatus(-1);
        model.addAttribute("list",teacherList);
        return "admin/teacherList";
    }
    @RequestMapping("/toTeacher")
    public String toTeacher(Model model){
        List<Teacher> teacherList = teacherService.queryAllTeacher();
        model.addAttribute("list",teacherList);
        return "admin/teacherList";
    }
    @RequestMapping("/teacherDetail")
    public String toTeacherDetail(int id,Model model){
        Teacher teacher = teacherService.queryTeacherById(id);
        List<Orders> orders = ordersService.queryOrdersByTeacherId(id);
        model.addAttribute("teacher",teacher);
        model.addAttribute("orders",orders);
        return "admin/teacherDetail";
    }
    @RequestMapping("/teacherOk")
    public String teacherOk(int id,Model model){
        Teacher teacher = teacherService.queryTeacherById(id);
        teacher.setStatus(0);
        teacherService.updateTeacher(teacher);
        model.addAttribute("id",id);
        return "redirect:/admin/teacherDetail";
    }
    @RequestMapping("/teacherFail")
    public String teacherFail(int id,Model model){
        Teacher teacher = teacherService.queryTeacherById(id);
        teacher.setStatus(-2);
        teacherService.updateTeacher(teacher);
        model.addAttribute("id",id);
        return "redirect:/admin/teacherDetail";
    }
    @RequestMapping("/teacherBan")
    public String teacherBan(int id,Model model){
        Teacher teacher = teacherService.queryTeacherById(id);
        teacher.setStatus(2);
        teacherService.updateTeacher(teacher);
        model.addAttribute("id",id);
        return "redirect:/admin/teacherDetail";
    }
    @RequestMapping("/toUser")
    public String toUser(Model model){
        List<Student> userList = studentService.queryAllStudent();
        model.addAttribute("list",userList);
        return "admin/userList";
    }
    @RequestMapping("/userDetail")
    public String userDetail(int id,Model model){
        Student student = studentService.queryStudentById(id);
        List<Orders> orders = ordersService.queryOrdersByUserId(id);
        model.addAttribute("student",student);
        model.addAttribute("orders",orders);
        return "admin/userDetail";
    }
    @RequestMapping("/userBan")
    public String userBan(int id,Model model){
        Student student = studentService.queryStudentById(id);
        student.setStatus(2);
        studentService.updateStudent(student);
        model.addAttribute("id",id);
        return "redirect:/admin/userDetail";
    }
    @RequestMapping("/toManager")
    public String toManager(Model model){
        List<Admin> adminList = adminService.queryAllAdmin();
        model.addAttribute("list",adminList);
        return "admin/managerList";
    }
    @RequestMapping("/addManager")
    public String addManager(Admin admin,RedirectAttributes model){
        Admin admin1 = adminService.queryAdminByUsername(admin.getUsername());
        if(admin1!=null){
            model.addFlashAttribute("msg","用户名已存在");
            model.addFlashAttribute("msg_type","danger");

            return "redirect:/admin/toManager";
        }
        adminService.addAdmin(admin);
        model.addFlashAttribute("msg","添加成功");
        model.addFlashAttribute("msg_type","success");

        return "redirect:/admin/toManager";
    }

}
