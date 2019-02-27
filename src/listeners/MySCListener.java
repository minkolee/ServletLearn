package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MySCListener implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = (ServletContext) sce.getSource();
        String wife = sc.getInitParameter("mywife");
        System.out.println("被监听对象启动了");
        System.out.println("--------------------打印初始配置参数------------------------"+wife);

//        //开启一个定时调度任务
//        Timer timer = new Timer();
//        // 定时执行任务,方法有重载 , 这里使用任务名,第一次开始,间隔时间. 直接传入匿名对象, 这里必须实现run方法才行
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("定时任务");
//            }
//        }, new Date(), 5000);


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("被监听对象销毁了");
    }
}
