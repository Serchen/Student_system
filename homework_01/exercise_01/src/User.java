import java.util.Scanner;

public class User {
    public String name; //用户名
    private String password;    //用户密码

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public User(){

    }

    //显示用户信息
    public void show(){
        System.out.println("用户名"+name);
    }

    //获得帐户的密码
    public String getPassword(){
        return this.password;
    }

    public void newPassword(){
        password = "123456";
    }

    //修改帐户密码
    public void SetPassWord(){
        System.out.println("请输入原密码");
        Scanner sc = new Scanner(System.in);
        String tmp = sc.next();
        if(this.password.equals(tmp)){
            System.out.println("请输入修改之后的密码");
            String ans = sc.next();
            System.out.println("请再次输入修改之后的密码");
            String ans1 = sc.next();
            if(ans.equals(ans1))
                this.password = ans;
            else
                System.out.println("两次密码输入不一致");
        }
    }

}

