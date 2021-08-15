package proxy.iml;

import proxy.UserDao;
import proxy.pojo.User;

public class UserDaoImpl implements UserDao {

    @Override
    public void add(User user) {
        System.out.println("添加用户"+ user);
    }

    @Override
    public void delede(User user) {
      System.out.println("删除用户："+user);
    }

    @Override
    public void login(User user) {
        System.out.println("用户登录啦"+user);
    }
}
