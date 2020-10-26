import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Teacher extends User{
    public int work_id;     //教师工号
    public String level;      //教师职位，比如教授、副教授

    public Teacher(String name, String password, int work_id, String level){
        super(name, password);
        this.work_id = work_id;
        this.level = level;
    }

    public Teacher(){

    }

    public String toString(){
        return name + " " + getPassword() + " " + work_id +" " + level;
    }

    public void show(){
        System.out.println("教师姓名  教师工号  教师职位");
        System.out.println(name+"  "+work_id+"  "+level);
    }

}
