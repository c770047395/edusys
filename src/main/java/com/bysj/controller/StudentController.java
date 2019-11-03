package com.bysj.controller;

import com.bysj.pojo.Evalution;
import com.bysj.pojo.Orders;
import com.bysj.pojo.Student;
import com.bysj.service.EvalutionService;
import com.bysj.service.OrdersService;
import com.bysj.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private EvalutionService evalutionService;

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    public void setEvalutionService(EvalutionService evalutionService) {
        this.evalutionService = evalutionService;
    }

    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session,Model model){

        model.addAttribute("title","家长/学生");
        model.addAttribute("type","user");
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, RedirectAttributes modelMap){

        Student student = studentService.login(username, password);
        if(student == null){
            modelMap.addFlashAttribute("msg","用户名或密码错误");
            modelMap.addFlashAttribute("msg_type","danger");
            modelMap.addFlashAttribute("title","家长/学生");
            modelMap.addFlashAttribute("type","user");
            return "login";
        }
        session.setAttribute("user",student);
        session.setAttribute("type","user");
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
        model.addAttribute("type","user");
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
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/user/toLogin";
    }
    @RequestMapping("/deposit")
    public String deposit(HttpSession session, RedirectAttributes modelMap){
        Student user = (Student) session.getAttribute("user");
        user.setStatus(1);
        studentService.updateStudent(user);
        session.setAttribute("user",user);
        modelMap.addFlashAttribute("msg","缴纳押金成功");
        modelMap.addFlashAttribute("msg_type","success");
        return "redirect:/user/toDeposit";
    }
    @RequestMapping("/unDeposit")
    public String unDeposit(HttpSession session, RedirectAttributes modelMap){
        Student user = (Student) session.getAttribute("user");
        user.setStatus(0);
        studentService.updateStudent(user);
        session.setAttribute("user",user);
        modelMap.addFlashAttribute("msg","退还押金成功");
        modelMap.addFlashAttribute("msg_type","success");
        return "redirect:/user/toDeposit";
    }

    @RequestMapping("/toSetting")
    public String toSetting(){
        return "setting";
    }
    @RequestMapping("/toPassword")
    public String toPassword(){
        return "changePassword";
    }
    @RequestMapping("/toDeposit")
    public String toDeposit(){
        return "changeDeposit";
    }
    @RequestMapping("/updateUser")
    public String updateUser(HttpSession session,Student student,RedirectAttributes modelMap){
        Student user =(Student) session.getAttribute("user");
        user.setName(student.getName());
        user.setSex(student.getSex());
        user.setIdNumber(student.getIdNumber());
        user.setArea(student.getArea());
        user.setAddress(student.getAddress());
        user.setPhone(student.getPhone());
        studentService.updateStudent(user);
        session.setAttribute("user",user);
        modelMap.addFlashAttribute("msg","修改成功");
        modelMap.addFlashAttribute("msg_type","success");
        return "redirect:/user/toSetting";
    }
    @RequestMapping("/changePassword")
    public String changePassword(HttpSession session,String oldPassword,String newPassword,RedirectAttributes modelMap){
        Student user =(Student) session.getAttribute("user");
        if(!user.getPassword().equals(oldPassword)){
            modelMap.addFlashAttribute("msg","原密码错误");
            modelMap.addFlashAttribute("msg_type","warning");
            return "redirect:/user/toPassword";
        }
        if(oldPassword.equals(newPassword)){
            modelMap.addFlashAttribute("msg","新密码与原密码重复");
            modelMap.addFlashAttribute("msg_type","warning");
            return "redirect:/user/toPassword";
        }

        user.setPassword(newPassword);
        studentService.updateStudent(user);
        modelMap.addFlashAttribute("msg","修改成功");
        modelMap.addFlashAttribute("msg_type","success");
        return "redirect:/user/toPassword";
    }

    @RequestMapping("/toOrderManager")
    public String toOrderManager(Model model){
        List<Orders> ordersList = ordersService.queryAllOrders();
        model.addAttribute("ordersNum",ordersList.size());
        return "orderManager";
    }

    @RequestMapping("/toPubInfo")
    public String toPubInfo(){
        return "pubOrder";
    }

    @RequestMapping("/toQueryMe")
    public String toQueryMe(HttpSession session,Model model){
        Student user = (Student) session.getAttribute("user");
        List<Orders> ordersList = ordersService.queryOrdersByUserId(user.getId());
        model.addAttribute("list",ordersList);
        return "myOrders";
    }

    @RequestMapping("/toQueryAll")
    public String toQueryAll(Model model){
        List<Orders> ordersList = ordersService.queryAllOrders();
        model.addAttribute("list",ordersList);
        return "myOrders";
    }

    @RequestMapping("/pubInfo")
    public String pubInfo(HttpSession session,Orders orders,RedirectAttributes modelMap){
        Student user = (Student)session.getAttribute("user");
        orders.setStudent(user);
        ordersService.addOrders(orders);
        modelMap.addFlashAttribute("msg","发布成功");
        modelMap.addFlashAttribute("msg_type","success");
        return "redirect:/user/toQueryMe";
    }

    @RequestMapping("/orderDetail")
    public String orderDetail(int id,Model model){
        Orders orders = ordersService.queryOrdersById(id);
        model.addAttribute("order",orders);
        if(orders.getTeacher() != null) {
            List<Evalution> evalutionList = evalutionService.queryEvalutionByTeacherId(orders.getTeacher().getId());
            model.addAttribute("evalutionList", evalutionList);
        }
        return "orderDetail";
    }

    @RequestMapping("/confirmOrders")
    public String confirmOrders(int id,Model model){
        Orders orders = ordersService.queryOrdersById(id);
        orders.setStatus(2);
        orders.setFinTime(new Date());
        ordersService.updateOrders(orders);
        model.addAttribute("order",orders);
        return "orderDetail";
    }
    @RequestMapping("/rejuctOrders")
    public String rejuctOrders(int id,Model model){
        Orders orders = ordersService.queryOrdersById(id);
        orders.setStatus(0);
        orders.setTeacher(null);
        ordersService.updateOrders(orders);
        model.addAttribute("order",orders);
        return "orderDetail";
    }
    @RequestMapping("/unPub")
    public String unPub(int id,Model model){
        Orders orders = ordersService.queryOrdersById(id);
        orders.setStatus(-1);
        orders.setTeacher(null);
        ordersService.updateOrders(orders);
        model.addAttribute("order",orders);
        return "orderDetail";
    }
    @RequestMapping("/addEvalution")
    public String addEvalution(Evalution evalution,RedirectAttributes model){
        Evalution evalution1 = evalutionService.queryEvalutionById(evalution.getOrderId());
        if(evalution1!= null){
            evalution1.setPostTime(new Date());
            evalution1.setPostContent(evalution.getPostContent());
            evalution1.setToTeacher(evalution.getToTeacher());
            evalutionService.updateEvalution(evalution1);
        }else{
            evalution.setPostTime(new Date());
            evalutionService.addEvalution(evalution);
        }
        model.addAttribute("id",evalution.getOrderId());
        model.addFlashAttribute("msg","评价成功");
        model.addFlashAttribute("msg_type","success");
        return "redirect:/user/orderDetail";

    }

}
