# 🏥 Sistem Manajemen Pasien Klinik

> Mini Project 2 - Pemrograman Berorientasi Objek (PBO)

Program CRUD (Create, Read, Update, Delete) berbasis Java console untuk mengelola data pasien klinik, dengan dua jenis pasien: **Pasien Umum** dan **Pasien BPJS**. Program ini merupakan pengembangan dari Mini Project 1 dengan tambahan validasi input, encapsulation, inheritance, struktur MVC, dan polymorphism.

---

# Sistem Manajemen Antrian Pasien pada Klinik

## Identitas Mahasiswa

| Keterangan        | Data                           |
| ----------------- | ------------------------------ |
| **Nama**          | Ahmad Fajar Novia              |
| **NIM**           | 2509116041                     |
| **Program Studi** | Sistem Informasi               |
| **Fakultas**      | Fakultas Teknik                |
| **Universitas**   | Universitas Mulawarman         |
| **Praktikum**   | Pemrograman Berorientasi Objek |
| **Project**       | Mini Project 2                 |


## 📋 Deskripsi Singkat

Program ini mensimulasikan sistem antrian dan pendataan pasien di sebuah klinik. Melalui menu interaktif berbasis console, pengguna (admin/petugas) dapat menampilkan, menambahkan, memperbarui, menghapus, dan memanggil pasien. Setiap pasien dibedakan menjadi dua kategori pembayaran: **Umum** (Tunai/Transfer) dan **BPJS** (menggunakan nomor BPJS).

Saat program dijalankan, satu data dummy pasien (Pasien Umum bernama "Ahmad") sudah otomatis tersedia sehingga fitur *Tampilkan Pasien* langsung bisa dicoba tanpa harus input data terlebih dahulu.

---

## 🗂️ Struktur Program (Package)

Program ini disusun mengikuti pola **MVC (Model-View-Controller)** dengan pemisahan tanggung jawab yang jelas antar package:

```
src/
├── main/
│   └── Main.java              → Controller: mengatur alur program, menerima input,
│                                  memanggil Service & View
│
├── model/
│   ├── Pasien.java            → Model (superclass): data & perilaku dasar pasien
│   ├── PasienUmum.java        → Model (subclass): data pasien umum
│   └── PasienBPJS.java        → Model (subclass): data pasien BPJS
│
├── view/
│   └── PasienView.java        → View: satu-satunya tempat System.out untuk
│                                  menampilkan menu & data pasien ke layar
│
├── service/
│   └── PasienCRUD.java        → Controller/Business Logic: operasi tambah, hapus,
│                                  update, panggil pasien, serta menyimpan data (ArrayList).
│                                  Tidak mencetak apa pun ke layar.
│
└── helper/
    └── ValidasiInput.java     → Helper/Utility: validasi input angka dari user
```

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

<img width="712" height="680" alt="Screenshot 2026-09-23 233325" src="https://github.com/user-attachments/assets/127d29f4-0802-4cfc-b115-bb0f9aac0333" />


---

### 2️⃣ Tambahkan Pasien
Menambahkan data pasien baru. Program akan meminta ID (divalidasi agar tidak duplikat), nama, umur (divalidasi 1–200), dan nomor telepon. Setelah itu user memilih jenis pasien:
- **Pasien Umum** → diminta jenis pembayaran (Tunai/Transfer)
- **Pasien BPJS** → diminta nomor BPJS

<img width="750" height="495" alt="Screenshot 2026-09-23 233202" src="https://github.com/user-attachments/assets/4043acf6-8247-4912-beac-c6a118670e5e" />


---

### 3️⃣ Update Pasien
Memperbarui data pasien (nama, umur, nomor telepon) berdasarkan ID yang dimasukkan. Jika ID tidak ditemukan, program akan memberi peringatan.

<img width="672" height="727" alt="Screenshot 2026-09-23 233422" src="https://github.com/user-attachments/assets/c65dd97f-8814-430f-a84f-8db101716d5d" />


---

### 4️⃣ Menghapus Pasien
Menghapus data pasien berdasarkan ID dari seluruh list (list utama maupun list kategori umum/BPJS).

<img width="690" height="318" alt="Screenshot 2026-09-23 233443" src="https://github.com/user-attachments/assets/5d5f8e72-9640-4e84-b6a5-ea264a719a1b" />

---

### 5️⃣ Panggil Pasien
Mensimulasikan pemanggilan pasien untuk masuk ruangan berdasarkan ID. Setelah dipanggil, data pasien otomatis dihapus dari antrian (dianggap sudah dilayani).

<img width="662" height="593" alt="Screenshot 2026-09-23 233506" src="https://github.com/user-attachments/assets/45640522-2737-43f2-9621-bdfda2734293" />


---

### 6️⃣ Keluar
Mengakhiri program.

<img width="398" height="215" alt="Screenshot 2026-09-23 233522" src="https://github.com/user-attachments/assets/e0bca856-361b-4406-8bad-a5b9d567cbf4" />


---

## 🔒 Penerapan Encapsulation

Encapsulation diterapkan pada class `Pasien` beserta turunannya:
- Seluruh atribut (`idPasien`, `nama`, `umur`, `noTelepon`, `nomorBPJS`, `jenisPembayaran`) bersifat **`protected`**, sehingga tidak bisa diakses langsung dari luar package tanpa melalui method.
- Atribut `idPasien` dibuat **`final`** dan hanya memiliki **getter** (`getIdPasien()`), tanpa setter — karena ID pasien tidak boleh diubah setelah dibuat.
- Atribut lain memiliki **getter dan setter lengkap** (`getNama()`/`setNama()`, `getUmur()`/`setUmur()`, `getNoTelepon()`/`setNoTelepon()`) sehingga proses pembacaan maupun pengubahan data harus melalui method yang terkontrol, bukan diakses langsung dari luar class.
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
- **Model** (`model/`) — murni menyimpan & mengelola data pasien (Pasien, PasienUmum, PasienBPJS) lewat getter/setter, tanpa ada `System.out` di dalamnya. Setiap subclass meng-override `getInfoTambahan()` untuk menyediakan info spesifik dirinya (lihat bagian Polymorphism).
- **View** (`view/PasienView.java`) — satu-satunya class yang berisi `System.out.println`/`printf`. Bertugas menampilkan menu, tabel data pasien, dan pesan notifikasi. View memanggil `toString()` pada objek `Pasien` untuk mencetak baris data, tanpa perlu tahu apakah itu Pasien Umum atau BPJS.
- **Controller** (`main/Main.java` & `service/PasienCRUD.java`) — `Main.java` menangkap input user lalu meneruskannya ke `PasienCRUD` (business logic: tambah/update/hapus/panggil/cek data, simpan di `ArrayList`). Hasil operasi (boolean/objek) dikembalikan ke `Main`, yang kemudian memerintahkan `PasienView` untuk menampilkannya. `PasienCRUD` sendiri tidak pernah mencetak apa pun secara langsung.
- **Helper** (`helper/ValidasiInput.java`) — kelas bantu independen untuk memvalidasi input angka agar program tidak crash saat user salah input.

### 2. Polymorphism (Method Overriding)
Method `getInfoTambahan()` yang dideklarasikan di superclass `Pasien` (mengembalikan `"-"` secara default) di-**override** oleh kedua subclass:
- `PasienUmum.getInfoTambahan()` → mengembalikan info jenis pembayaran.
  <img width="349" height="94" alt="image" src="https://github.com/user-attachments/assets/4dd7ba91-99e4-410e-8a0a-b3215810b0e8" />

- `PasienBPJS.getInfoTambahan()` → mengembalikan info nomor BPJS.
  <img width="489" height="93" alt="image" src="https://github.com/user-attachments/assets/5cfd2b4e-9f5d-4fa4-85ec-cf5dee1f82e7" />

Method `toString()` di class `Pasien` juga memanfaatkan `getInfoTambahan()` tadi untuk membentuk baris tabel yang lengkap. Saat `PasienView` melakukan `System.out.println(pasien)` di dalam loop `ArrayList<Pasien>`, Java otomatis menjalankan versi `getInfoTambahan()` sesuai objek aslinya (Pasien Umum atau Pasien BPJS) tanpa perlu pengecekan tipe (`instanceof`) manual — inilah inti dari polymorphism.

---

## ✅ Validasi Input

Class `ValidasiInput` (package `helper`) memastikan input angka dari user benar-benar berupa angka (misalnya saat memilih menu atau memasukkan umur). Jika user salah input (misalnya memasukkan huruf), program tidak akan crash, melainkan meminta user memasukkan ulang input yang valid.

 <img width="697" height="334" alt="image" src="https://github.com/user-attachments/assets/00c077c0-f6ba-4998-a20f-2935d9ac50f9" />

Validasi tambahan lainnya di `Main.java`:
- Umur pasien harus di rentang 1–200.
- ID pasien tidak boleh duplikat saat menambah data baru.
- ID pasien harus ditemukan terlebih dahulu sebelum bisa di-update, dihapus, atau dipanggil.

---
