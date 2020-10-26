public class RequiredCourse extends Course {
    public int credit;  //学分

    public RequiredCourse(int id, String name, int type, int stuNum, String teacher, int credit){
        super(id, name, type, stuNum, teacher);
        this.credit = credit;
    }

    public void show(){
        System.out.println("课程名称  课程类型  老师姓名  上课人数  课程编号  必修课学分");
        System.out.println(name + type + name + stuNum + id + credit);
    }

    public String toString(){
        return super.toString() + " " + this.credit;
    }

}
