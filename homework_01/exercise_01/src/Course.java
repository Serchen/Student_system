import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;
import java.util.Vector;

public class Course {
    public int stuNum;
    public int id, type;
    public String teacher, name;
    public Vector<String> stuRecords = new Vector<>();
    public String toCourseString(){
        StringBuilder tmp = new StringBuilder();
        tmp.append(stuRecords.size());
        tmp.append(" ");
        for (String stuRecord : stuRecords) {
            tmp.append(stuRecord);
            tmp.append(" ");
        }
        tmp = new StringBuilder(tmp.toString().trim());
        return tmp.toString();
    }
    public Course(int id, String name, int type, int stuNum, String teacher){
        this.id = id;
        this.name = name;
        this.stuNum = stuNum;
        this.teacher = teacher;
        this.type = type;
    }

    public Course(){};

    public void show(){
        System.out.println("课程名称  课程类型  老师姓名  上课人数  课程编号");
        System.out.println(name+"   "+type+"   "+teacher+"   "+stuNum+"   "+id);
    }

    public String toString(){
        return id + " " + name + " " + type + " " + stuNum + " " + teacher;
    }

    public static Course inputCourse(int id){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入课程名称：");
        String name = sc.next();
        System.out.println("请输入课程类型，0表示选修，1表示必修");
        int type = sc.nextInt();
        System.out.println("请输入上课教师的姓名");
        String teacher = sc.next();
        System.out.println("请输入上课总人数：");
        int stuNum = sc.nextInt();
        Course c;
        if(type == 1){
            System.out.println("请输入学分");
            int credit = sc.nextInt();
            c = new RequiredCourse(id, name, type, stuNum, teacher, credit);
        }
        else{
            System.out.println("请输入最大选课人数");
            int maxStu = sc.nextInt();
            c = new OptionalCourse(id, name, type, stuNum, teacher, maxStu);
        }
        return c;
    }
}
