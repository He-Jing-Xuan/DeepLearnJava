package proxy.staticproxy;

import proxy.UserDao;
import proxy.dymaicproxy.UserInvocationHandler;
import proxy.iml.UserDaoImpl;
import proxy.pojo.User;

public class MainUser {
    public static void main(String[] args) {
        User  user = new User("小贺",23,"嘻嘻");
        UserDao userDao  = (UserDao) new UserInvocationHandler(new UserDaoImpl()).getBean();
        userDao.add(user);
        userDao.delede(user);
        userDao.login(user);
    }
}
