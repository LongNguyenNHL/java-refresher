import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Tạo một ArrayList<Student>, thêm vào ít nhất 4 sinh viên khác nhau
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Long", 1, 3.5));
        list.add(new Student("Diep", 2, 3.7));
        list.add(new Student("Chi", 3, 3.9));
        list.add(new Student("Yen", 4, 3.3));

        // In ra toàn bộ danh sách (dùng toString() bạn đã viết)
        System.out.println(list);


        // Tìm và in ra sinh viên có GPA cao nhất trong danh sách
        double maxGPA = list.get(0).getGpa();
        Student studentMaxGPA = null;
        for (Student student : list) {
            if (student.getGpa() > maxGPA) {
                maxGPA = student.getGpa();
                studentMaxGPA = student;
            }
        }
        System.out.println("Student with max GPA: " + studentMaxGPA);

        // Xoá 1 sinh viên khỏi danh sách theo id
        for (int i = list.size(); i > 0; i--) {
            if (list.get(i - 1).getId() == 2) {
                list.remove(i - 1);
            }
        }

        // Sắp xếp danh sách theo GPA giảm dần, in lại kết quả
        list.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
