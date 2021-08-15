package proxy.staticproxy;

import proxy.MyTransaction;
import proxy.UserDao;
import proxy.pojo.User;

public class ProxyUser implements UserDao {
    private final UserDao userDao;
    private final MyTransaction transaction;
    public ProxyUser(UserDao userDao,MyTransaction transaction){
        this.userDao = userDao;
        this.transaction = transaction;
    }

    @Override
    public void add(User user) {
        transaction.before();
        userDao.add(user);
        transaction.after();
    }

    @Override
    public void delede(User user) {

    }

    @Override
    public void login(User user) {

    }
}
