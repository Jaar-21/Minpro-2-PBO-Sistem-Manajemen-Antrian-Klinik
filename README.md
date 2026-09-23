# 🏥 Sistem Manajemen Pasien Klinik

> Mini Project 2 - Pemrograman Berorientasi Objek (PBO)

Program CRUD (Create, Read, Update, Delete) berbasis Java console untuk mengelola data pasien klinik, dengan dua jenis pasien: **Pasien Umum** dan **Pasien BPJS**. Program ini merupakan pengembangan dari Mini Project 1 dengan tambahan validasi input, encapsulation, inheritance, struktur MVC, dan polymorphism.

---

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

**Penjelasan peran tiap bagian:**
- **Model** (`model/`) — murni menyimpan & mengelola data pasien (Pasien, PasienUmum, PasienBPJS) lewat getter/setter, tanpa ada `System.out` di dalamnya. Setiap subclass meng-override `getInfoTambahan()` untuk menyediakan info spesifik dirinya (lihat bagian Polymorphism).
- **View** (`view/PasienView.java`) — satu-satunya class yang berisi `System.out.println`/`printf`. Bertugas menampilkan menu, tabel data pasien, dan pesan notifikasi. View memanggil `toString()` pada objek `Pasien` untuk mencetak baris data, tanpa perlu tahu apakah itu Pasien Umum atau BPJS.
- **Controller** (`main/Main.java` & `service/PasienCRUD.java`) — `Main.java` menangkap input user lalu meneruskannya ke `PasienCRUD` (business logic: tambah/update/hapus/panggil/cek data, simpan di `ArrayList`). Hasil operasi (boolean/objek) dikembalikan ke `Main`, yang kemudian memerintahkan `PasienView` untuk menampilkannya. `PasienCRUD` sendiri tidak pernah mencetak apa pun secara langsung.
- **Helper** (`helper/ValidasiInput.java`) — kelas bantu independen untuk memvalidasi input angka agar program tidak crash saat user salah input.

Dengan struktur ini, tiap lapisan punya satu tanggung jawab: **Model** = data, **View** = tampilan, **Controller** (Main + Service) = alur & logika — sehingga jika suatu saat tampilan ingin diganti (misalnya jadi GUI), cukup ganti isi `PasienView` tanpa menyentuh `Model` maupun `Service`.

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

📸 *Screenshot menu Tampilkan Pasien:*

`![Tampilkan Pasien](screenshots/1-tampilkan-pasien.png)`

---

### 2️⃣ Tambahkan Pasien
Menambahkan data pasien baru. Program akan meminta ID (divalidasi agar tidak duplikat), nama, umur (divalidasi 1–200), dan nomor telepon. Setelah itu user memilih jenis pasien:
- **Pasien Umum** → diminta jenis pembayaran (Tunai/Transfer)
- **Pasien BPJS** → diminta nomor BPJS

📸 *Screenshot menu Tambah Pasien:*

`![Tambah Pasien](screenshots/2-tambah-pasien.png)`

---

### 3️⃣ Update Pasien
Memperbarui data pasien (nama, umur, nomor telepon) berdasarkan ID yang dimasukkan. Jika ID tidak ditemukan, program akan memberi peringatan.

📸 *Screenshot menu Update Pasien:*

`![Update Pasien](screenshots/3-update-pasien.png)`

---

### 4️⃣ Menghapus Pasien
Menghapus data pasien berdasarkan ID dari seluruh list (list utama maupun list kategori umum/BPJS).

📸 *Screenshot menu Hapus Pasien:*

`![Hapus Pasien](screenshots/4-hapus-pasien.png)`

---

### 5️⃣ Panggil Pasien
Mensimulasikan pemanggilan pasien untuk masuk ruangan berdasarkan ID. Setelah dipanggil, data pasien otomatis dihapus dari antrian (dianggap sudah dilayani).

📸 *Screenshot menu Panggil Pasien:*

`![Panggil Pasien](screenshots/5-panggil-pasien.png)`

---

### 6️⃣ Keluar
Mengakhiri program.

📸 *Screenshot menu Keluar:*

`![Keluar](screenshots/6-keluar.png)`

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
Program menerapkan MVC secara penuh dengan package terpisah: `model/` (data), `view/` (tampilan), dan `main/` + `service/` (controller & logika bisnis). Penjelasan lengkap ada di bagian [🗂️ Struktur Program](#️-struktur-program-package) di atas. Poin pentingnya: **tidak ada satu pun `System.out` di dalam `model/` atau `service/`** — semua output terpusat di `view/PasienView.java`.

### 2. Polymorphism (Method Overriding)
Method `getInfoTambahan()` yang dideklarasikan di superclass `Pasien` (mengembalikan `"-"` secara default) di-**override** oleh kedua subclass:
- `PasienUmum.getInfoTambahan()` → mengembalikan info jenis pembayaran.
- `PasienBPJS.getInfoTambahan()` → mengembalikan info nomor BPJS.

Method `toString()` di class `Pasien` juga memanfaatkan `getInfoTambahan()` tadi untuk membentuk baris tabel yang lengkap. Saat `PasienView` melakukan `System.out.println(pasien)` di dalam loop `ArrayList<Pasien>`, Java otomatis menjalankan versi `getInfoTambahan()` sesuai objek aslinya (Pasien Umum atau Pasien BPJS) tanpa perlu pengecekan tipe (`instanceof`) manual — inilah inti dari polymorphism.

---

## ✅ Validasi Input

Class `ValidasiInput` (package `helper`) memastikan input angka dari user benar-benar berupa angka (misalnya saat memilih menu atau memasukkan umur). Jika user salah input (misalnya memasukkan huruf), program tidak akan crash, melainkan meminta user memasukkan ulang input yang valid.

Validasi tambahan lainnya di `Main.java`:
- Umur pasien harus di rentang 1–200.
- ID pasien tidak boleh duplikat saat menambah data baru.
- ID pasien harus ditemukan terlebih dahulu sebelum bisa di-update, dihapus, atau dipanggil.

---

## 🛠️ Cara Menjalankan Program

1. Clone repository ini.
2. Buka project menggunakan IDE Java (contoh: NetBeans/IntelliJ).
3. Jalankan file `Main.java`.
4. Ikuti instruksi menu yang muncul di console.

---

## 👤 Author

Dibuat oleh **Asus** — Mini Project 2, Mata Kuliah Pemrograman Berorientasi Objek.
