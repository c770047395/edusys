package com.bysj.controller;

import com.bysj.pojo.Orders;
import com.bysj.pojo.Teacher;
import com.bysj.service.OrdersService;
import com.bysj.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherControllerr {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private OrdersService ordersService;

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session, Model model){
        if(session.getAttribute("user")!=null){
            return "redirect:/teacher/toMain";
        }
        model.addAttribute("title","家教老师");
        model.addAttribute("type","teacher");
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, RedirectAttributes modelMap){

        Teacher teacher = teacherService.login(username, password);
        if(teacher == null){
            modelMap.addFlashAttribute("msg","用户名或密码错误");
            modelMap.addFlashAttribute("msg_type","danger");
            modelMap.addFlashAttribute("title","家教老师");
            modelMap.addFlashAttribute("type","teacher");
            return "redirect:/teacher/toLogin";
        }
        session.setAttribute("user",teacher);
        session.setAttribute("type","teacher");
        return "redirect:/teacher/toMain";
    }

    @RequestMapping("/toMain")
    public String toMain(){
        return "main";
    }

    @RequestMapping("/toRegister")
    public String toRegister(Model model){
        model.addAttribute("title","家教老师");
        model.addAttribute("type","teacher");
        return "register";
    }
    @RequestMapping("register")
    public String register(Teacher teacher, RedirectAttributes modelMap){
        if(teacherService.queryTeacherByUsername(teacher.getUsername())!= null){
            modelMap.addFlashAttribute("msg","用户名已存在，注册失败");
            modelMap.addFlashAttribute("msg_type","danger");
            return "redirect:/teacher/toRegister";
        }
        int result = teacherService.addTeacher(teacher);
        if(result!= 1){
            modelMap.addFlashAttribute("msg","未知错误，请联系管理员");
            modelMap.addFlashAttribute("msg_type","danger");
            return "redirect:/teacher/toRegister";
        }
        modelMap.addFlashAttribute("msg","注册成功");
        modelMap.addFlashAttribute("msg_type","success");
        return "redirect:/teacher/toLogin";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/teacher/toLogin";
    }
    @RequestMapping("/deposit")
    public String deposit(HttpSession session, RedirectAttributes modelMap){
        Teacher user = (Teacher) session.getAttribute("user");
        user.setStatus(1);
        teacherService.updateTeacher(user);
        session.setAttribute("user",user);
        modelMap.addFlashAttribute("msg","缴纳押金成功");
        modelMap.addFlashAttribute("msg_type","success");
        return "redirect:/teacher/toDeposit";
    }
    @RequestMapping("/unDeposit")
    public String unDeposit(HttpSession session, RedirectAttributes modelMap){
        Teacher user = (Teacher) session.getAttribute("user");
        user.setStatus(0);
        teacherService.updateTeacher(user);
        session.setAttribute("user",user);
        modelMap.addFlashAttribute("msg","退还押金成功");
        modelMap.addFlashAttribute("msg_type","success");
        return "redirect:/teacher/toDeposit";
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
    public String updateUser(HttpSession session,Teacher teacher,RedirectAttributes modelMap){
        Teacher user =(Teacher) session.getAttribute("user");
        user.setPhone(teacher.getPhone());
        user.setDescription(teacher.getDescription());
        teacherService.updateTeacher(user);
        session.setAttribute("user",user);
        modelMap.addFlashAttribute("msg","修改成功");
        modelMap.addFlashAttribute("msg_type","success");
        return "redirect:/teacher/toSetting";
    }
    @RequestMapping("/changePassword")
    public String changePassword(HttpSession session,String oldPassword,String newPassword,RedirectAttributes modelMap){
        Teacher user =(Teacher) session.getAttribute("user");
        if(!user.getPassword().equals(oldPassword)){
            modelMap.addFlashAttribute("msg","原密码错误");
            modelMap.addFlashAttribute("msg_type","warning");
            return "redirect:/teacher/toPassword";
        }
        if(oldPassword.equals(newPassword)){
            modelMap.addFlashAttribute("msg","新密码与原密码重复");
            modelMap.addFlashAttribute("msg_type","warning");
            return "redirect:/teacher/toPassword";
        }

        user.setPassword(newPassword);
        teacherService.updateTeacher(user);
        modelMap.addFlashAttribute("msg","修改成功");
        modelMap.addFlashAttribute("msg_type","success");
        return "redirect:/teacher/toPassword";
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
        Teacher teacher = (Teacher) session.getAttribute("user");
        List<Orders> ordersList = ordersService.queryOrdersByTeacherId(teacher.getId());
        model.addAttribute("list",ordersList);
        return "myOrders";
    }

    @RequestMapping("/toQueryAll")
    public String toQueryAll(Model model){
        List<Orders> ordersList = ordersService.queryAllOrders();
        model.addAttribute("list",ordersList);
        return "myOrders";
    }



    @RequestMapping("/orderDetail")
    public String orderDetail(int id,Model model){
        Orders orders = ordersService.queryOrdersById(id);
        model.addAttribute("order",orders);
        return "orderDetail";
    }

    @RequestMapping("/postOrders")
    public String postOrders(HttpSession session,int id,Model model){
        ordersService.postOrders(id,((Teacher)session.getAttribute("user")).getId());
        return "redirect:/teacher/orderDetail?id="+id;
    }
    @RequestMapping("/unPost")
    public String unPost(int id,Model model){
        Orders orders = ordersService.queryOrdersById(id);
        orders.setStatus(0);
        orders.setTeacher(null);
        ordersService.updateOrders(orders);
        model.addAttribute("order",orders);
        return "orderDetail";
    }
}
