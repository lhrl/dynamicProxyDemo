package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Desc:
 * User:刘浪
 * Date: 2019/2/27 10:02
 */
public class DynamicProxyHandler  implements InvocationHandler{

    private Object target;

    public DynamicProxyHandler(Object target) {
        this.target = target;
    }

    void before(){
        System.out.println("调用之前的增强");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(target, args);
        after();
        return invoke;
    }

    void after(){
        System.out.println("调用之后的增强");
    }
}
