# 🏥 Sistem Manajemen Pasien Klinik

> Mini Project 2 - Pemrograman Berorientasi Objek (PBO)

Program CRUD (Create, Read, Update, Delete) berbasis Java console untuk mengelola data pasien klinik, dengan dua jenis pasien: **Pasien Umum** dan **Pasien BPJS**. Program ini merupakan pengembangan dari Mini Project 1 dengan tambahan validasi input, encapsulation, inheritance, struktur MVC, dan polymorphism.

---

## 📋 Deskripsi Singkat

Program ini mensimulasikan sistem antrian dan pendataan pasien di sebuah klinik. Melalui menu interaktif berbasis console, pengguna (admin/petugas) dapat menampilkan, menambahkan, memperbarui, menghapus, dan memanggil pasien. Setiap pasien dibedakan menjadi dua kategori pembayaran: **Umum** (Tunai/Transfer) dan **BPJS** (menggunakan nomor BPJS).

Saat program dijalankan, satu data dummy pasien (Pasien Umum bernama "Ahmad") sudah otomatis tersedia sehingga fitur *Tampilkan Pasien* langsung bisa dicoba tanpa harus input data terlebih dahulu.

---

## 🗂️ Struktur Program (Package)

Program ini disusun mengikuti pola **MVC (Model-View-Controller)** yang disesuaikan untuk aplikasi console, dengan pembagian package sebagai berikut:

```
src/
├── main/
│   └── Main.java              → Controller: menampilkan menu, menerima input, mengatur alur program
│
├── model/
│   ├── Pasien.java            → Model (superclass): data & perilaku dasar pasien
│   ├── PasienUmum.java        → Model (subclass): data pasien umum
│   └── PasienBPJS.java        → Model (subclass): data pasien BPJS
│
├── service/
│   └── PasienCRUD.java        → Controller/Business Logic: operasi tambah, hapus, update,
│                                  panggil pasien, serta menyimpan data (ArrayList) dan
│                                  logika penampilan data (View sederhana ke console)
│
└── helper/
    └── ValidasiInput.java     → Helper/Utility: validasi input angka dari user
```

**Penjelasan peran tiap bagian:**
- **Model** (`model/`) — merepresentasikan struktur data pasien (Pasien, PasienUmum, PasienBPJS) beserta method untuk mengakses/mengubah datanya (getter, setter) dan method untuk menampilkan info dirinya sendiri.
- **Controller** (`main/Main.java` & `service/PasienCRUD.java`) — `Main.java` bertugas menampilkan menu dan menangkap input user, lalu meneruskan permintaan ke `PasienCRUD` yang berisi seluruh logika bisnis (tambah/update/hapus/panggil/cek data) serta menyimpan data dalam `ArrayList`.
- **View** — karena ini aplikasi console (bukan GUI), tampilan berupa `System.out.println`/`printf` yang tersebar di `Main` (tampilan menu) dan `Pasien`/`PasienCRUD` (tampilan data pasien).
- **Helper** (`helper/ValidasiInput.java`) — kelas bantu independen untuk memvalidasi input angka agar program tidak crash saat user salah input.

---

## ⚙️ Alur Program & Tampilan Menu

Saat program dijalankan, akan muncul menu utama:

```
==========================================
      SISTEM MANAJEMEN PASIEN KLINIK
==========================================
1. Tampilkan Pasien
2. Tambahkan Pasien
3. Update Pasien
4. Menghapus Pasien
5. Panggil Pasien
6. Keluar
```

### 1️⃣ Tampilkan Pasien
Menampilkan daftar pasien berdasarkan kategori (Pasien Umum atau Pasien BPJS). User memilih kategori terlebih dahulu, lalu data akan ditampilkan dalam format tabel rapi.

<img width="712" height="680" alt="image" src="https://github.com/user-attachments/assets/d35d7de2-a1bb-4dcd-bdc5-99366ec45722" />


---

### 2️⃣ Tambahkan Pasien
Menambahkan data pasien baru. Program akan meminta ID (divalidasi agar tidak duplikat), nama, umur (divalidasi 1–200), dan nomor telepon. Setelah itu user memilih jenis pasien:
- **Pasien Umum** → diminta jenis pembayaran (Tunai/Transfer)
- **Pasien BPJS** → diminta nomor BPJS

<img width="750" height="495" alt="image" src="https://github.com/user-attachments/assets/f0bc70b3-18b6-4278-b7be-51b08ae8deb6" />


---

### 3️⃣ Update Pasien
Memperbarui data pasien (nama, umur, nomor telepon) berdasarkan ID yang dimasukkan. Jika ID tidak ditemukan, program akan memberi peringatan.

<img width="672" height="727" alt="image" src="https://github.com/user-attachments/assets/8763cfc3-672e-40f7-91e9-e7b35e39e8c0" />


---

### 4️⃣ Menghapus Pasien
Menghapus data pasien berdasarkan ID dari seluruh list (list utama maupun list kategori umum/BPJS).

<img width="690" height="318" alt="image" src="https://github.com/user-attachments/assets/a17e244c-b68b-4f78-88ff-da651e4c1458" />


---

### 5️⃣ Panggil Pasien
Mensimulasikan pemanggilan pasien untuk masuk ruangan berdasarkan ID. Setelah dipanggil, data pasien otomatis dihapus dari antrian (dianggap sudah dilayani).

<img width="662" height="593" alt="image" src="https://github.com/user-attachments/assets/0066be1f-c9eb-46e8-8674-1f2f174fe81d" />


---

### 6️⃣ Keluar
Mengakhiri program.

<img width="398" height="215" alt="image" src="https://github.com/user-attachments/assets/2b4809fd-e67d-402e-96b2-71d73ae93973" />


---

## 🔒 Penerapan Encapsulation

Encapsulation diterapkan pada class `Pasien` beserta turunannya:
- Seluruh atribut (`idPasien`, `nama`, `umur`, `noTelepon`, `nomorBPJS`, `jenisPembayaran`) bersifat **`protected`**, sehingga tidak bisa diakses langsung dari luar package tanpa melalui method.
- Atribut `idPasien` dibuat **`final`** dan hanya memiliki **getter** (`getIdPasien()`), tanpa setter — karena ID pasien tidak boleh diubah setelah dibuat.
- Atribut lain memiliki **getter dan setter** (`getNama()`, `setNama()`, `setUmur()`, `setNoTelepon()`) sehingga proses pengubahan data harus melalui method yang terkontrol, bukan diakses/diubah secara sembarangan.
- Pada `PasienCRUD`, atribut `ArrayList` (`listPasien`, `listPasienUmum`, `listPasienBPJS`) bersifat **`private`**, sehingga data hanya bisa diakses melalui method-method publik di dalam class tersebut (`tambahPasienUmum()`, `hapusPasien()`, dsb).

---

## 🧬 Penerapan Inheritance

- **Superclass**: `Pasien` — berisi atribut dan method umum yang dimiliki semua jenis pasien (id, nama, umur, no telepon, getter/setter, dan method `tampilkanInfoPasien()`).
- **Subclass 1**: `PasienUmum` — mewarisi `Pasien` dan menambahkan atribut `jenisPembayaran`.
- **Subclass 2**: `PasienBPJS` — mewarisi `Pasien` dan menambahkan atribut `nomorBPJS`.

Kedua subclass menggunakan `super(...)` pada constructor untuk memanfaatkan constructor milik superclass, sehingga tidak perlu menulis ulang logika inisialisasi atribut dasar.

---

## ✨ Penerapan Nilai Tambah

### 1. Struktur MVC
Sudah dijelaskan di bagian [🗂️ Struktur Program](#️-struktur-program-package) di atas — program dipisah menjadi package `model` (Model), `main` & `service` (Controller), dengan tampilan (View) berupa output console yang terintegrasi pada method-method di `model` dan `service`.

### 2. Polymorphism (Method Overriding)
Method `tampilkanInfoPasien()` yang dideklarasikan di superclass `Pasien` di-**override** oleh kedua subclass:
- `PasienUmum.tampilkanInfoPasien()` → menampilkan info tambahan berupa jenis pembayaran.
- `PasienBPJS.tampilkanInfoPasien()` → menampilkan info tambahan berupa nomor BPJS.

Dengan polymorphism ini, saat method `tampilkanInfoPasien()` dipanggil dari sebuah objek bertipe `Pasien` (misalnya saat looping `ArrayList<Pasien> listPasien`), Java secara otomatis menjalankan versi method sesuai objek aslinya (Pasien Umum atau Pasien BPJS) tanpa perlu pengecekan tipe manual.

---

## ✅ Validasi Input

Class `ValidasiInput` (package `helper`) memastikan input angka dari user benar-benar berupa angka (misalnya saat memilih menu atau memasukkan umur). Jika user salah input (misalnya memasukkan huruf), program tidak akan crash, melainkan meminta user memasukkan ulang input yang valid.

Validasi tambahan lainnya di `Main.java`:
- Umur pasien harus di rentang 1–200.
- ID pasien tidak boleh duplikat saat menambah data baru.
- ID pasien harus ditemukan terlebih dahulu sebelum bisa di-update, dihapus, atau dipanggil.

---


## 👤 Author

Dibuat oleh **Asus** — Mini Project 2, Mata Kuliah Pemrograman Berorientasi Objek.
