/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import service.PasienCRUD;
import helper.ValidasiInput;
import model.Pasien;
import model.PasienUmum;
import model.PasienBPJS;
import view.PasienView;
import java.util.Scanner;

/**.
 * @author Asus
 */
public class Main {
    public static void main(String[] args) {
        PasienCRUD crud = new PasienCRUD();
        PasienView view = new PasienView();
        Scanner scanner = new Scanner(System.in);
        boolean berjalan = true;

        while (berjalan){
            view.tampilkanMenu();

            int pilihan = ValidasiInput.inputInteger(scanner, "Pilih menu 1-6 : ");

            switch (pilihan){

                case 1:
                    view.tampilkanSubMenuTampilkan();

                    int jenisPasien = ValidasiInput.inputInteger(scanner, "Pilih jenis pasien : ");

                    switch (jenisPasien){
                        case 1:
                            view.tampilkanDaftarPasienUmum(crud.getListPasienUmum());
                            break;

                        case 2:
                            view.tampilkanDaftarPasienBPJS(crud.getListPasienBPJS());
                            break;

                        default:
                            view.pesan("Jenis pasien tidak valid");
                    }
                    break;


                case 2:
                    view.tampilkanDaftarPasien(crud.getListPasien());
                    view.pesan("=====TAMBAH PASIEN=====");

                    int id = ValidasiInput.inputInteger(scanner, "Masukkan ID Pasien : ");

                    if (crud.cekIdPasien(id)){
                        view.pesan("ID pasien sudah digunakan");
                        break;
                    }

                    System.out.print("masukkan nama pasien : ");
                    String nama = scanner.nextLine();

                    int umur = ValidasiInput.inputInteger(scanner, "Masukkan umur pasien : ");
                    if (umur <= 0 || umur > 200) {
                        view.pesan("Umur harus antara (1 - 200)");
                        break;
                    }

                    System.out.print("masukkan no telepon(+62 / 08) : ");
                    String noTelepon = scanner.nextLine();

                    view.tampilkanPilihanJenisPasien();
                    int jenis = ValidasiInput.inputInteger(scanner, "Pilih jenis pasien : ");

                    if (jenis == 1) {
                        System.out.print("Masukkan jenis Pembayaran(Tunai / Transfer) : ");
                        String jenisPembayaran = scanner.nextLine();

                        PasienUmum pasienUmumBaru = new PasienUmum(id, nama, umur, noTelepon, jenisPembayaran);
                        crud.tambahPasienUmum(pasienUmumBaru);
                        view.pesan("Pasien umum ditambahkan");

                    } else if (jenis == 2) {
                        System.out.print("Masukkan nomor BPJS : ");
                        String nomorBPJS = scanner.nextLine();

                        PasienBPJS pasienBPJSBaru = new PasienBPJS(id, nama, umur, noTelepon, nomorBPJS);
                        crud.tambahPasienBPJS(pasienBPJSBaru);
                        view.pesan("Pasien BPJS ditambahkan");

                    } else {
                        view.pesan("Jenis pasien tidak valid");
                    }
                    break;

                case 3:
                    view.tampilkanDaftarPasien(crud.getListPasien());
                    view.pesan("=====UPDATE PASIEN=====");

                    int idUpdate = ValidasiInput.inputInteger(scanner, "Masukkan ID Pasien : ");
                    if (!crud.cekIdPasien(idUpdate)){
                        view.pesan("ID pasien tidak ditemukan");
                        break;
                    }

                    System.out.print("Nama baru : ");
                    String namaBaru = scanner.nextLine();

                    int umurBaru = ValidasiInput.inputInteger(scanner, "Masukkan umur pasien : ");
                    if (umurBaru <= 0 || umurBaru > 200){
                        view.pesan("Umur harus antara (1 - 200)");
                        break;
                    }

                    System.out.print("nomor telepon baru(+62 / 08) : ");
                    String noTeleponBaru = scanner.nextLine();

                    boolean updateBerhasil = crud.updatePasien(idUpdate, namaBaru, umurBaru, noTeleponBaru);
                    view.pesan(updateBerhasil ? "pasien berhasil diupdate" : "ID pasien tidak ditemukan");
                    break;

                case 4:
                    view.tampilkanDaftarPasien(crud.getListPasien());
                    view.pesan("=====HAPUS DATA PASIEN=====");

                    int idHapus = ValidasiInput.inputInteger(scanner, "Masukkan ID Pasien yang ingin dihapus : ");

                    boolean hapusBerhasil = crud.hapusPasien(idHapus);
                    view.pesan(hapusBerhasil ? "pasien berhasil dihapus" : "ID pasien tidak ditemukan");
                    break;

                case 5:
                    view.tampilkanDaftarPasien(crud.getListPasien());
                    view.pesan("=====PANGGIL PASIEN=====");
                    int idPanggil = ValidasiInput.inputInteger(scanner, "Masukkan ID Pasien : ");

                    Pasien pasienDipanggil = crud.panggilPasien(idPanggil);
                    if (pasienDipanggil != null){
                        view.pesan("Panggilan atas nama Pasien " + pasienDipanggil.getNama() + " Silahkan memasuki ruangan");
                    } else {
                        view.pesan("ID pasien tidak ditemukan");
                    }
                    break;

                case 6:
                    berjalan = false;
                    view.pesan("program selesai");
                    break;

                default:
                    view.pesan("pilihan tidak valid");

            }
        }

        scanner.close();
    }
}
