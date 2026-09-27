# Lab A1 – Vong doi Activity (Android Lifecycle)

Mon hoc: Lap trinh thiet bi di dong  
Ho va ten: Vo Phan Thanh Ngan  
MSSV: 231A010596  

## 2. Tinh nang chinh
- Ghi nhan Lifecycle Callbacks: Theo doi day du cac ham callback: onCreate, onStart, onResume, onPause, onStop, onRestart, onDestroy, va onSaveInstanceState.
- Hien thi giao dien:
  - Dinh man hinh hien thi ten bai Lab va thong tin sinh vien (Vo Phan Thanh Ngan – MSSV 231A010596).
  - Danh sach log hien thi thoi gian chinh xac toi miligiay (HH:mm:ss.SSS) va dinh dang monospace.
- Thao tac nut bam:
  - Xoa log: Lam sach vung hien thi log va dat lai bo dem buoc.
  - Gay loi: Thuc thi lenh thu nghiem phat sinh loi NullPointerException.
  - Thoat: Goi ham finish() de ket thuc Activity va quan sat callback onDestroy.

### Tinh nang nang cao (NC)
- NC1 (Bang dem Callback): Su dung LinkedHashMap<String, Integer> de dem va hien thi so lan moi ham callback duoc goi ngay phia tren vung log (vi du: onCreate: 1 | onStart: 1 | onResume: 1 |).
- NC2 (Xu ly ngoai le & Toast): Boc khoi lenh nut Gay loi trong try-catch, bat ngoai le NullPointerException, ghi vet loi Log.e va hien thi thong bao Toast giup ung dung khong bi vang (crash).

---

## 3. Cong nghe & Cau truc du an
- Ngon ngu: Java
- Min SDK: Android 7.0 (API 24) / Target SDK: Android 14+
- Cau truc thu muc chinh:
  app/src/main/
  ├── java/vn/edu/vhu/ltdd/a1lifecycle/
  │   └── MainActivity.java       # Xu ly vong doi, dem callback va bay loi
  └── res/
      ├── layout/
      │   └── activity_main.xml   # Giao dien chinh (TextView, Buttons, ScrollView)
      └── values/
          └── strings.xml         # Chua cac chuoi khai bao giao dien
