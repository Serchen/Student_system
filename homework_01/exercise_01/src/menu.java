import java.util.Scanner;

public class menu {
    static User administrator = new User("admin", "296559");

    public static void main(String[] args) {
        Users.readStudents();
        Users.readTeachers();
        Courses.readCourses();
        Courses.readRecords();
        mainMenu();
        Courses.saveCourses();
        Users.saveTeachers();
        Users.saveStudents();
        Courses.saveRecords();
    }

    public static void adminMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("*****请选择操作方式*****");
        System.out.println("*****1、添加课程*****");
        System.out.println("*****2、删除课程*****");
        System.out.println("*****3、按照选课人数排序*****");
        System.out.println("*****4、显示课程列表*****");
        System.out.println("*****5、修改授课教师*****");
        System.out.println("*****6、显示学生列表*****");
        System.out.println("*****7、显示教师列表*****");
        System.out.println("*****8、恢复学生和教师初始密码*****");
        System.out.println("*****9、添加老师和学生*****");
        System.out.println("*****10、删除老师和学生*****");
        System.out.println("*****11、返回主菜单*****");
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                Courses.addCourses();
                break;
            case 2:
                Courses.DeleteCourse();
                break;
            case 3:
                Courses.SortCourseList();
                break;
            case 4:
                for (int i = 0; i < Courses.courseList.size(); i++)
                    Courses.courseList.get(i).show();
                break;
            case 5:
                Courses.rewriteTeacher();
                break;
            case 6:
                Users.showStudentList();
                break;
            case 7:
                Users.showTeacherList();
                break;
            case 8:
                Users.clearPassword();
                break;
            case 9:
                Users.addTeacherAndStudent();
                break;
            case 10:
                Users.deleteTeacherAndStudent();
                break;
            case 11:
                return;
        }
    }

    public static void teacherMenu(int id) {
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        for(int i=0; i<Users.teacherList.size(); i++){
            if(Users.teacherList.get(i).work_id == id){
                ans = i;
                break;
            }
        }
        System.out.println("*****请选择操作方式*****");
        System.out.println("*****1、修改登录密码*****");
        System.out.println("*****2、查看所授课程*****");
        System.out.println("*****3、查看所授课程的学生列表*****");
        System.out.println("*****4、返回主菜单*****");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                Users.teacherList.get(ans).SetPassWord();
                break;
            case 2:
                System.out.println("该教师所授的课程为：");
                System.out.println("课程名称  课程类型  老师姓名  上课人数  课程编号");
                for(int i = 0; i<Courses.courseList.size(); i++){
                    if(Courses.courseList.get(i).teacher.equals(Users.teacherList.get(ans).name)){
                        System.out.println(Courses.courseList.get(i).name+"   "
                                +Courses.courseList.get(i).type+"   "
                                +Courses.courseList.get(i).teacher+"   "
                                +Courses.courseList.get(i).stuNum +"   "
                                +Courses.courseList.get(i).id);
                    }
                }
                break;
            case 3:
                System.out.println("所授课程的学生名单如下：");
                String teacherName = null;
                for(int i=0; i<Users.teacherList.size(); i++){
                    if(Users.teacherList.get(i).work_id == id){
                        teacherName = Users.teacherList.get(i).name;
                    }
                }
                for(int i = 0; i<Courses.courseList.size(); i++){
                    if(Courses.courseList.get(i).teacher.equals(teacherName)){
                        System.out.println("课程名称：");
                        System.out.println(Courses.courseList.get(i).name);
                        System.out.println("学生姓名：");
                        for(int j = 0; j<Courses.courseList.get(i).stuRecords.size(); j++){
                            System.out.println(Courses.courseList.get(i).stuRecords.get(j));
                        }
                    }
                }
                break;
            case 4:
                return;
        }
    }

    public static void studentMenu(int id) {
        Scanner in = new Scanner(System.in);
        int ans = 0;
        for(int i=0; i<Users.studentList.size(); i++){
            if(Users.studentList.get(i).stu_id == id){
                ans = i;
                break;
            }
        }
        System.out.println("*****请输入您的选择：*****");
        System.out.println("*****1、修改登录密码*****");
        System.out.println("*****2、查看个人课程*****");
        System.out.println("*****3、选修课选课*****");
        System.out.println("*****4、返回主菜单*****");
        int choice = in.nextInt();
        switch (choice){
            case 1:
                Users.studentList.get(ans).SetPassWord();
                break;
            case 2:
                System.out.println("个人所选课程如下：");
                for(int i = 0; i<Courses.courseList.size(); i++){
                    for(int j = 0; j<Courses.courseList.get(i).stuRecords.size(); j++){
                        if(Courses.courseList.get(i).stuRecords.get(j).equals(Users.studentList.get(ans).name)){
                            System.out.println(Courses.courseList.get(i).name);
                        }
                    }
                }
                break;
            case 3:
                System.out.println("可选择的选修课课程如下：");
                for(int i = 0; i<Courses.courseList.size(); i++){
                    if(Courses.courseList.get(i).type == 0){
                        System.out.println(Courses.courseList.get(i).name);
                        System.out.println(Courses.courseList.get(i).id);
                    }
                }
                System.out.println("请输入您的选择号码：");
                int n = in.nextInt();
                for(int i = 0; i<Courses.courseList.size(); i++){
                    System.out.println(i+" "+ans);
                    if(Courses.courseList.get(i).id == n){
                        Courses.courseList.get(i).stuRecords.add(Users.studentList.get(ans).name);
                    }
                }
                System.out.println("选择成功！");
                break;
            case 4:
                return;

        }
    }

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("*****请选择登录方式*****");
            System.out.println("*****1、管理员登录 *****");
            System.out.println("*****2、教师登录  *****");
            System.out.println("*****3、学生登录  *****");
            System.out.println("*****4、退出系统 *****");
            System.out.println("请输入你的选择序号：");
            int c = sc.nextInt();
            if (c == 1) {
                System.out.println("请输入管理员密码：");
                String password = sc.next();
                if (administrator.getPassword().equals(password)) {
                    adminMenu();
                }
            } else if (c == 2) {
                System.out.println("请输入您的工号：");
                int id = sc.nextInt();
                System.out.println("请输入您的密码：");
                String pass = sc.next();
                for(Teacher teacher : Users.teacherList){
                    if(teacher.work_id == id){
                        if(teacher.getPassword().equals(pass)){
                            teacherMenu(id);
                        }
                        else{
                            System.out.println("密码有误，返回主界面");
                            mainMenu();
                        }
                    }
                }
            } else if (c == 3) {
                System.out.println("请输入您的学号：");
                int stu_ID = sc.nextInt();
                System.out.println("请输入您的密码：");
                String pass = sc.next();
                for(Student student : Users.studentList){
                    if(student.stu_id == stu_ID){
                        if(student.getPassword().equals(pass)){
                            studentMenu(stu_ID);
                        }
                        else{
                            System.out.println("密码有误，返回主界面");
                            mainMenu();
                        }
                    }
                }
            } else if (c == 4) {
                break;
            }
        }
    }
}
