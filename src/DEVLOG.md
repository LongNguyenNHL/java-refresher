# DEVLOG - Java Week 1: Collections Framework

Ghi lai ngan gon sau moi buoi hoc: hom nay lam gi, vuong o dau, hoc duoc gi.
Muc dich: vua la tai lieu on tap, vua la "cau chuyen" ke lai trong phong van.

---

## 2026-09-07 (Thu Hai)

- Muc tieu: Viet Student model class
- Da lam: Hoan thanh class Student (fields, constructor, getter/setter, toString).
  Tu quyet dinh id la immutable (khong co setId), gpa co the doi (co setGpa).
- Vuong o dau:
    - Vet constructor sai return type (co return this va co return type Student,
      trong khi constructor khong duoc co return type)
    - Quen access modifier private cho field va constructor luc dau
- Hoc duoc gi:
    - Encapsulation: field nen private, chi truy cap qua getter/setter
    - Design decision can co ly do (vd: id immutable vi la dinh danh co dinh)
    - Buoi nay de vi da co nen OOP tu truoc (shopping-cart project) —
      trong tam that su cua Week 1 (ArrayList, HashMap, Big-O) van chua den
---

## 2026-09-08 (Thu Ba) - ArrayList operations

- Muc tieu: Thao tac voi ArrayList<Student> - them, in, tim GPA cao nhat, xoa theo id, sort giam dan
- Da lam: Hoan thanh ca 5 phan. Tu viet duoc vong lap tim max, xoa theo id, va sort dung lambda + Comparator
- Vuong o dau:
    - Gap loi ConcurrentModificationException khi xoa phan tu trong luc dung for-each de duyet list
      -> Sua bang cach doi sang vong lap for duyet nguoc theo index (tu i = list.size() giam dan)
    - Khoi tao maxGPA bang so cung (0, roi 3.5) - khong tong quat, phu thuoc vao du lieu test
      -> Sua bang cach lay gia tri tu list.get(0).getGpa() thay vi hard-code
- Hoc duoc gi:
    - Khong nen xoa phan tu ArrayList trong luc duyet bang for-each - phai dung vong lap index
      (duyet nguoc) hoac Iterator.remove()
    - Comparator/lambda: list.sort((s1, s2) -> ...) la cach viet gon cho viec tu dinh nghia
      cach so sanh 2 doi tuong Student (vi Java khong biet san cach so sanh class tu tao)
    - Dao vi tri tham so trong ham compare (s2 truoc s1) se dao chieu sap xep (tang dan <-> giam dan)
    - Nen tranh khoi tao gia tri so sanh (nhu maxGPA) bang so co dinh - nen lay tu chinh du lieu
      dang xu ly de code tong quat hon

---
