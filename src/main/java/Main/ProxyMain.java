package Main;

import proxy.DynamicProxyHandler;
import service.UserService;
import serviceImpl.UserServiceImpl;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * Desc:
 * User:刘浪
 * Date: 2019/2/27 9:58
 */
public class ProxyMain {

    /**
     * 静态代理
     * 缺点 每个实现类都必须有一个代理类 会出现类爆炸
     * @param args
     */
    /*public static void main(String[] args) {
        UserService userService=new StaticProxy(new UserServiceImpl());
        userService.say();
    }*/


    /**
     * 动态代理
     * @param args
     */
    public static void main(String[] args) {
        UserService userService =(UserService) Proxy.newProxyInstance(ProxyMain.class.getClassLoader(), UserServiceImpl.class.getInterfaces(), new DynamicProxyHandler(new UserServiceImpl()));
        System.out.println(userService);
        userService.say();

        //接下来我们看看jdk生成的动态代理字节码, 如：public final class $Proxy0 extends Proxy implements UserService

        String path="d:/$Proxy0.class";

        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", UserServiceImpl.class.getInterfaces());

        FileOutputStream out=null;

        try {
            out=new FileOutputStream(path);
            out.write(bytes);
            out.flush();
            System.out.println("生成动态代理字节码操作完成");


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
