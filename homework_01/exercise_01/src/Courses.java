import java.io.*;
import java.util.*;

public class Courses {

    static Vector<Course> courseList = new Vector<>();

//    static HashMap<String, Vector<String>>SelectRecord = new HashMap<>();
//
//    static Set<String> key = SelectRecord.keySet();
//    static List<String> list = new ArrayList<>(key);

    public static void addCourse(){
        if(courseList.size() < 1)
            courseList.add(Course.inputCourse(1));
        else{
            courseList.add(Course.inputCourse(courseList.size()+1));
        }
    }

    public static void addCourses(){
        int i = 1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("请输入第" + (i++) + "次添加的课程的信息");
            addCourse();
            System.out.println("想继续输入，请输入y，否则输入n");
        } while (!sc.next().equals("n"));
        menu.adminMenu();
    }

    public static void SortCourseList(){
        for(int i = 0; i< courseList.size(); i++)
        {
            for(int j = i+1; j< courseList.size(); j++)
            {
                Course k = courseList.get(j);
                Course c = courseList.get(i);
                if(c.stuNum < k.stuNum){
                    courseList.set(i, k);
                    courseList.set(j, c);
                }
            }
        }
        System.out.println("排序完成！");
        menu.adminMenu();
    }
    public static void SearchCourseByTeacher(){
        System.out.println("请输入要查找的老师名称");
        Scanner in = new Scanner(System.in);
        String teacher_name = in.next();
        for (Course tmp : courseList) {
            if (tmp.teacher.equals(teacher_name)) {
                tmp.show();
            }
        }
    }

    public static void rewriteTeacher(){
        System.out.println("请输入你想要修改的课程编号");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        for (Course course : courseList) {
            if (course.id == choice) {
                System.out.println("请输入修改后的老师姓名：");
                course.teacher = sc.next();
            }
        }
        menu.adminMenu();
    }

    public static void DeleteCourse(){
        System.out.println("请输入想要删除的课程名称");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        for(int i = 0; i< courseList.size(); i++)
        {
            if(courseList.get(i).name.equals(name)){
                courseList.remove(i);
                break;
            }
        }
        menu.adminMenu();
    }

    //将Courses列表中的课程内容存入存储课程的文件中
    public static void saveCourses(){
        File file = new File("C:\\Users\\Chen Yining\\IdeaProjects\\homework_01\\exercise_01\\src\\CoursesList.txt");
        try{
            if(!file.exists()){
                file.createNewFile();   //如果文件不存在，则创建一个文件
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            for(int i = 0; i<Courses.courseList.size(); i++){
                out.write(Courses.courseList.get(i).toString() + "\r\n");
            }
            out.flush();
            out.close();
            System.out.println("课程信息保存成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readCourses(){
        try{
            BufferedReader bw = new BufferedReader(new InputStreamReader
                    (new FileInputStream("C:\\Users\\Chen Yining\\IdeaProjects\\homework_01\\exercise_01\\src\\CoursesList.txt")));
            String data;
            while((data = bw.readLine()) != null){
                String[] ans = data.split(" ");
                int id = Integer.parseInt(ans[0]);
                String name = ans[1];
                int type = Integer.parseInt(ans[2]);
                int stuNum = Integer.parseInt(ans[3]);
                String teacher = ans[4];
                int credit = Integer.parseInt(ans[5]);
                if(type == 0){
                    Courses.courseList.add(new RequiredCourse(id, name, type, stuNum, teacher, credit));
                }
                else{
                    Courses.courseList.add(new OptionalCourse(id, name, type, stuNum, teacher, credit));
                }
            }
            bw.close();
            System.out.println("课程信息读取成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveRecords(){
        File file = new File("C:\\Users\\Chen Yining\\IdeaProjects\\homework_01\\exercise_01\\src\\Records.txt");
        try{
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            for (Course course : courseList) {
                out.write(course.toCourseString() + "\r\n");
            }
            out.flush();
            out.close();
            System.out.println("选课信息存储完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readRecords(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader
                    (new FileInputStream("C:\\Users\\Chen Yining\\IdeaProjects\\homework_01\\exercise_01\\src\\Records.txt")));
            String data;
            int cnt=0;
            while((data = br.readLine()) != null){
                String[] ans = data.split(" ");
                int len = Integer.parseInt(ans[0]);
                if(len != 0){
                    courseList.get(cnt).stuRecords.addAll(Arrays.asList(ans).subList(1, len + 1));
                }
                cnt++;
            }
            System.out.println("选课信息读取完毕");
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
