package proxy;

import proxy.UserDao;
import proxy.dymaicproxy.ProxyUserDymaic;
import proxy.dymaicproxy.UserInvocationHandler;
import proxy.iml.UserDaoImpl;
import proxy.pojo.User;
import proxy.staticproxy.ProxyUser;

public class MainUser {
    public static void main(String[] args) {
        User  user = new User("小贺",23,"嘻嘻");
        //静态代理
        UserDao userDao  = (UserDao) new ProxyUser(new UserDaoImpl(),new MyTransaction());
        //动态代理
        UserDao userDao1 = (UserDao) new ProxyUserDymaic(new UserDaoImpl(),new MyTransaction()).getBean();
        userDao1.login(user);
    }
}
