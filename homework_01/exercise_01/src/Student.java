public class Student extends User {
    public int stu_id;  //学号
    public String Class;    //所在班级

    public Student(String name, String password, int stu_id, String Class){
        super(name, password);
        this.stu_id = stu_id;
        this.Class = Class;
    }

    public Student(){

    }

    public String toString(){
        return name + " " + getPassword() + " " + stu_id + " " + Class;
    }

    public void show(){
        System.out.println("学生姓名  学生学号  所在班级");
        System.out.println(name+"  "+stu_id+"  "+Class);
    }

}
