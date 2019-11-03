package com.bysj.controller;

import com.bysj.pojo.Evalution;
import com.bysj.pojo.Orders;
import com.bysj.pojo.Teacher;
import com.bysj.service.EvalutionService;
import com.bysj.service.OrdersService;
import com.bysj.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private EvalutionService evalutionService;

    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    public void setOrdersService(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    public void setEvalutionService(EvalutionService evalutionService) {
        this.evalutionService = evalutionService;
    }

    @RequestMapping("/toLogin")
    public String toLogin(HttpSession session, Model model){

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
        if(teacher.getStatus() < 0 ){
            session.setAttribute("user",teacher);
            return "redirect:/teacher/toUpload";
        }
        session.setAttribute("user",teacher);
        session.setAttribute("type","teacher");
        return "redirect:/teacher/toMain";
    }

    @RequestMapping("/toUpload")
    public String toUpload(Model model){
        model.addAttribute("type","teacher");
        return "teacherUpload";
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
        teacher.setStatus(-2);
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
    @RequestMapping("/upload")
    public String  fileUpload2(HttpSession session,String age,String school,String role,String idNumber,@RequestParam("pic") CommonsMultipartFile pic,@RequestParam("cert") CommonsMultipartFile ceri, HttpServletRequest request) throws IOException {
        Teacher user = (Teacher) session.getAttribute("user");
        user.setRole(role);
        user.setAge(age);
        user.setSchool(school);
        user.setIdNumber(idNumber);
        user.setStatus(-1);
        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/cert");
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        //上传文件地址
        System.out.println("上传文件cert保存地址："+realPath);

        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        ceri.transferTo(new File(realPath +"/"+ user.getId()+".jpg"));

        //上传路径保存设置
        String path1 = request.getServletContext().getRealPath("/pic");
        File realPath1 = new File(path1);
        if (!realPath1.exists()){
            realPath1.mkdir();
        }
        //上传文件地址
        System.out.println("上传文件pic保存地址："+realPath1);

        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        pic.transferTo(new File(realPath1 +"/"+ user.getId()+".jpg"));

        teacherService.updateTeacher(user);
        session.setAttribute("user",user);

        return "redirect:/teacher/toUpload";
    }

    @RequestMapping("/addEvalution")
    public String addEvalution(Evalution evalution, RedirectAttributes model){
        Evalution evalution1 = evalutionService.queryEvalutionById(evalution.getOrderId());
        if(evalution1!= null){
            evalution1.setAnTime(new Date());
            evalution1.setAnContent(evalution.getPostContent());
            evalution1.setToUser(evalution.getToTeacher());
            evalutionService.updateEvalution(evalution1);
        }else{
            evalution1.setAnTime(new Date());
            evalution1.setAnContent(evalution.getPostContent());
            evalution1.setToUser(evalution.getToTeacher());
            evalutionService.addEvalution(evalution);
        }
        model.addAttribute("id",evalution.getOrderId());
        model.addFlashAttribute("msg","评价成功");
        model.addFlashAttribute("msg_type","success");
        return "redirect:/teacher/orderDetail";

    }
}
