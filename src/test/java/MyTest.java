import com.bysj.pojo.Orders;
import com.bysj.pojo.Student;
import com.bysj.service.OrdersService;
import com.bysj.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void queryAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrdersService ordersService = context.getBean("ordersService", OrdersService.class);
        Orders orders = new Orders();
        orders.setContent("没啥要求");
        orders.setPrice(120);
        orders.setWeekNum(2);
        orders.setSub("英语");
        orders.setLevel("三年级");

        List<Orders> ordersList = ordersService.queryOrdersByTeacherId(1);
        for (Orders orders1 : ordersList) {
            System.out.println(orders1);
        }


    }

}

