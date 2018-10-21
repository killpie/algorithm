package proxy;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        Date date = new Date(0);
        System.out.println(date);
/*        UserDao userDao = new UserDao();

        System.out.println(userDao.getClass());
        ProxyFactory proxyFactory = new ProxyFactory(userDao);
        IUserDao u = (IUserDao) proxyFactory.getProxyInstance();
        System.out.println(u.getClass());
        u.save();*/
    }
}
