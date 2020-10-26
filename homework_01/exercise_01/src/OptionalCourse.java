public class OptionalCourse extends Course{
    public int maxStu;
    public OptionalCourse(int id, String name, int type, int stuNum, String teacher, int maxStu){
        super(id, name, type, stuNum, teacher);
        this.maxStu = maxStu;
    }

    public void show(){
        System.out.println("课程名称  课程类型  老师姓名  上课人数  课程编号  最大选修人数");
        System.out.println(name + type + name + stuNum + id + maxStu);
    }

    public String toString(){
        return super.toString() + " " + this.maxStu;
    }
}
