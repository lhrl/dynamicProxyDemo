package serviceImpl;

import service.UserService;

/**
 * Desc:
 * User:刘浪
 * Date: 2019/2/27 9:54
 */
public class UserServiceImpl implements UserService {
    @Override
    public void say() {
        System.out.println("jack say hello");
    }
}
