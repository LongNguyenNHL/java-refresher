import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

        // Tạo một HashMap<Integer, Student> — dùng id của sinh viên làm key
        HashMap<Integer, Student> studentMap = new HashMap<>();

        // Thêm vào ít nhất 4 sinh viên (có thể tái sử dụng data cũ hoặc data mới)
        studentMap.put(1, new Student("Long", 1, 3.5));
        studentMap.put(2, new Student("Diep", 2, 3.7));
        studentMap.put(3, new Student("Chi", 3, 3.9));
        studentMap.put(4, new Student("Yen", 4, 3.3));

        // Tra cứu (lookup) 1 sinh viên theo id, in ra thông tin
        Student studentExample = studentMap.get(1);
        System.out.println(studentExample);

        // Cập nhật GPA của 1 sinh viên đã có trong map (theo id)
        studentExample.setGpa(2.5);

        // Kiểm tra xem một id cụ thể có tồn tại trong map hay không, trước khi thao tác với nó (tránh lỗi NullPointerException nếu tra cứu id không tồn tại)
        if (studentMap.containsKey(5)) {
            System.out.println("Student with id 5 exists in the map.");
        } else {
            System.out.println("Student with id 5 does not exist in the map.");
        }

        // Duyệt qua toàn bộ map, in ra tất cả sinh viên
        for (Map.Entry<Integer,Student> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        System.out.println("size = " + stack.size());
        System.out.println(stack.pop());
        System.out.println("size = " + stack.size());
        stack.push(12);
        System.out.println("size = " + stack.size());
        System.out.println(stack.pop());
        System.out.println("size = " + stack.size());
        System.out.println(stack.pop());
//        System.out.println(stack.peek());
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
    }
}
