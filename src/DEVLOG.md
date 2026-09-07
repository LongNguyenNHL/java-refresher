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
