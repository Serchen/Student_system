import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class Users {
    static Vector<Student> studentList = new Vector<>();
    static Vector<Teacher> teacherList = new Vector<>();

    public Users(){

    }

    public static void showStudentList(){
        System.out.println("学生姓名   学号   所在班级");
        for (Student student : studentList) {
            System.out.println(student.name + "  " + student.stu_id + "  " + student.Class);
        }
        Scanner sc = new Scanner(System.in);
        if(sc.next().equals("y"))
            menu.adminMenu();
    }

    public static void showTeacherList(){
        System.out.println("教师姓名  工号  教师职位");
        for (Teacher teacher : teacherList) {
            System.out.println(teacher.name + "  " + teacher.work_id + "  " + teacher.level);
        }
        Scanner sc = new Scanner(System.in);
        if(sc.next().equals("y"))
            menu.adminMenu();
    }

    public static void clearPassword(){
        for (Student student : studentList) {
            student.newPassword();
        }
        for (Teacher teacher : teacherList) {
            teacher.newPassword();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("密码初始化成功！");
        if(sc.next().equals("y"))
            menu.adminMenu();
    }

    public static void deleteTeacherAndStudent(){
        System.out.println("请输入你想删除的对象：");
        System.out.println("1、删除教师");
        System.out.println("2、删除学生");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                System.out.println("请输入你想删除的教师的工号：");
                int tmp = sc.nextInt();
                for(int i=0; i<teacherList.size(); i++){
                    if(teacherList.get(i).work_id == tmp){
                        teacherList.remove(i);
                        break;
                    }
                }
                System.out.println("删除成功！");
                break;
            case 2:
                System.out.println("请输入你想删除的学生的学号：");
                int demo = sc.nextInt();
                for(int i=0; i<studentList.size(); i++){
                    if(studentList.get(i).stu_id == demo){
                        studentList.remove(i);
                        break;
                    }
                }
                System.out.println("删除成功！");
                break;
        }
    }

    public static void addTeacherAndStudent(){
        System.out.println("请输入你想添加的对象：");
        System.out.println("1、添加教师");
        System.out.println("2、添加学生");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice == 1){
            System.out.println("请输入教师的姓名：");
            String name = sc.next();
            System.out.println("教师的初始密码设置为123456");
            System.out.println("请输入教师的工号：");
            int id = sc.nextInt();
            System.out.println("请输入教师的评级");
            String level = sc.next();
            teacherList.add(new Teacher(name, "123456", id, level));
            System.out.println("录入教师信息成功！");
        }
        else if(choice == 2){
            System.out.println("请输入学生的姓名：");
            String name = sc.next();
            System.out.println("学生的初始密码设置为123456");
            System.out.println("请输入学生的学号：");
            int id = sc.nextInt();
            System.out.println("请输入学生的班级");
            String class_num = sc.next();
            studentList.add(new Student(name, "123456", id, class_num));
            System.out.println("录入学生信息成功！");
        }
        if(sc.next().equals("y"))
            menu.adminMenu();
    }

//    public static void showStudents(){
//        System.out.println("学生姓名  所在班级  学号");
//        for (Student student : studentList) {
//            System.out.println(student.name + "  " + student.Class + "  "
//                    + student.stu_id);
//        }
//    }
//
//    public static void showTeachers(){
//        System.out.println("教师姓名  职位  工号");
//        for (Teacher teacher : teacherList) {
//            System.out.println(teacher.name + "  " + teacher.level + "  "
//                    + teacher.work_id);
//        }
//    }

    public static void saveStudents(){
        File file = new File("C:\\Users\\Chen Yining\\IdeaProjects\\homework_01\\exercise_01\\src\\Students.txt");
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            for(Student student : studentList){
                out.write(student.toString() + "\r\n");
            }
            out.flush();
            out.close();
            System.out.println("学生信息保存成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveTeachers(){
        File file = new File("C:\\Users\\Chen Yining\\IdeaProjects\\homework_01\\exercise_01\\src\\Teachers.txt");
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            for (Teacher teacher : teacherList) {
                out.write(teacher.toString() + "\r\n");
            }
            out.flush();
            out.close();
            System.out.println("教师信息保存成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readTeachers(){
        try{
            BufferedReader bw = new BufferedReader(new InputStreamReader
                    (new FileInputStream("C:\\Users\\Chen Yining\\IdeaProjects\\homework_01\\exercise_01\\src\\Teachers.txt")));
            String data;
            while((data = bw.readLine()) != null){
                String[] ans = data.split(" ");
                String name = ans[0];
                String password = ans[1];
                int workID = Integer.parseInt(ans[2]);
                String level = ans[3];
                teacherList.add(new Teacher(name, password, workID, level));
            }
            System.out.println("教师信息读取完毕");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readStudents(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader
                    (new FileInputStream("C:\\Users\\Chen Yining\\IdeaProjects\\homework_01\\exercise_01\\src\\Students.txt")));
            String data;
            while((data = br.readLine()) != null){
                String[] ans = data.split(" ");
                String name = ans[0];
                String password = ans[1];
                int stuID = Integer.parseInt(ans[2]);
                String Class = ans[3];
                studentList.add(new Student(name, password, stuID, Class));
            }
            System.out.println("学生信息读取成功！");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
