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
## 2026-09-09 (Thu Tu) - HashMap operations + ly thuyet Week 1

- Muc tieu: Thao tac voi HashMap<Integer, Student> - put, get, update, containsKey, duyet map.
  Hoan thanh cau hoi ly thuyet Week 1.
- Da lam: Hoan thanh ca 6 phan thuc hanh HashMap. Tra loi dung ca 4 cau ly thuyet
  (Big-O tra cuu, so sanh ArrayList/LinkedList, HashMap key trung, Set vs List)
- Vuong o dau:
    - Luc dau hieu nguoc: tuong ArrayList nhanh hon khi them/xoa giua danh sach,
      LinkedList nhanh hon khi truy cap ngau nhien - thuc ra la NGUOC LAI
      -> Sua lai dung: ArrayList nhanh truy cap (O(1), vung nho lien tuc, tinh thang dia chi),
      LinkedList nhanh them/xoa giua (O(1) NEU da dung san vi tri, vi chi doi 2 con tro noi)
    - Nhan ra diem quan trong: de them/xoa theo index cu the, LinkedList van phai duyet
      tu dau toi vi tri do truoc (O(N)) - nen thuc te khong nhanh hon ArrayList tru khi
      dang dung san vi tri (vd: dang duyet bang Iterator)
- Hoc duoc gi:
    - Reference vs value: object (nhu Student) khi lay ra tu List/Map la THAM CHIEU toi
      dung object goc trong bo nho, khong phai ban sao - nen sua truc tiep (setGpa) se
      anh huong ngay ca khi khong put() lai
    - Map.Entry<K,V>: dai dien cho 1 cap key-value lay ra tu entrySet() cua Map,
      dung khi can duyet ca key va value cung luc
    - HashMap tra cuu theo key trung binh la O(1) so voi ArrayList duyet tim la O(N)
    - HashMap put() voi key da ton tai se GHI DE (overwrite) gia tri cu, khong loi, khong them moi
    - Set dam bao tinh duy nhat, dung khi can danh sach khong trung lap (vd: id da dang ky)
    - ArrayList thuong la lua chon mac dinh tot hon LinkedList trong thuc te, vi truy cap
      theo index pho bien hon nhieu so voi truong hop thuc su tan dung duoc uu the O(1)
      cua LinkedList khi them/xoa

- Tong ket Week 1: HOAN THANH ca thuc hanh (Student class, ArrayList, HashMap)
  va ly thuyet, qua 3 buoi lien tiep.

---

## 2026-10-12 (Thu Hai) - Week 2: MyStack (array)

- Muc tieu: Tu cai dat Stack bang array, khong dung collection co san
- Da lam: Viet xong MyStack bang int[] (push, pop, peek, isEmpty), tu mo rong mang
  (nhan doi) khi day, nem EmptyStackException khi stack rong
- Vuong o dau:
    - Ban dau tra loi Stack la FIFO - sai. Stack la LIFO, FIFO la cua Queue
    - Ban dau viet MyStack bang cach boc ArrayList co san -> khong dung yeu cau de bai,
      phai viet lai bang int[] that
    - Loi dieu kien trong push: dung size > list.length nen khong bao gio mo rong dung luc,
      gay ArrayIndexOutOfBoundsException o lan push thu 2
      -> Sua thanh size >= list.length (mang day khi size bang do dai mang)
      -> Cach tim ra: trace tay tung buoc voi size = 1, list.length = 1
- Hoc duoc gi:
    - LIFO (Stack: push/pop cung o dinh) vs FIFO (Queue: them cuoi, lay dau)
    - Mo rong mang bang cach nhan doi -> trung binh push van O(1); tang tung 1 o
      thi moi push la O(N). Khoi tao size 1 an toan vi size * 2 khong bao gio bang 0
    - Dieu kien bien: dieu kien chi dung khi chuong trinh da hong thi khong bao ve duoc gi
    - Obsolete reference: pop() chi giam size, o mang van giu tham chieu toi object cu
      nen GC khong don duoc. Voi mang object phai gan null cho o do (luu gia tri vao
      bien tam truoc khi gan null). Voi int[] thi khong can vi la kieu nguyen thuy
- Con lai: chay lai test stack rong rieng (pop() ngay khi vua tao) de xac nhan
  EmptyStackException; MyQueue; bai kiem tra dau ngoac; nang MyStack len Generic <T> o Week 4

---