package proxy;

public class UserDao implements IUserDao{
    public void save(){
        System.out.println("已经保存数据");
    }
}
