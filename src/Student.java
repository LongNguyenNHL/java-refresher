/**
 * Student model class - Week 1 Collections Framework exercise
 *
 * Muc tieu buoi hoc 16h-16h30, thu Hai 7/9:
 * - Chi can hoan thanh class nay, khong can lam ca 4 phan bai tap
 * - Tu viet, khong copy AI - de ban that su hieu va noi duoc trong phong van
 *
 * Goi y cac field can co (tu quyet dinh, day chi la goi y):
 * - id, name, một vai field khac phu hop (vd: gpa, enrolledCourses...)
 */
public class Student {

    // TODO: khai bao cac field o day
    private String name;
    private int id;
    private double gpa;

    // TODO: constructor

    public Student (String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String toString() {
        return "Student{" + "name=" + name + ", id=" + id + ", gpa=" + gpa + '}';
    }
    // TODO: getters/setters

    // TODO: toString() - se can khi in ra ArrayList/HashMap sau nay

    // TODO: (tuy chon) equals() va hashCode() - se can neu dung trong HashSet/HashMap key

}
