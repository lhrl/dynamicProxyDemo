package proxy;

import service.UserService;

/**
 * Desc:静态代理
 * User:刘浪
 * Date: 2019/2/27 9:56
 */
public class StaticProxy implements UserService{

    private UserService target;

    public StaticProxy(UserService target) {
        this.target = target;
    }

    void before(){
        System.out.println("jack说话前的准备");
    }
    @Override
    public void say() {
        before();
        target.say();
        after();
    }

    void  after(){
        System.out.println("jack说完话了");
    }
}
