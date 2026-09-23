/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import service.PasienCRUD;
import helper.ValidasiInput;
import model.PasienUmum;
import model.PasienBPJS;
import java.util.Scanner;
/**
 *
 * @author Asus
 */
public class Main {
    public static void main(String[] args) {
        PasienCRUD crud = new PasienCRUD();
        Scanner scanner = new Scanner(System.in);
        boolean berjalan = true;
        
        while (berjalan){
            System.out.println("==========================================");
            System.out.println("      SISTEM MANAJEMEN PASIEN KLINIK");
            System.out.println("==========================================");            
            System.out.println("1. Tampilkan Pasien");
            System.out.println("2. Tambahkan Pasien");
            System.out.println("3. Update Pasien");
            System.out.println("4. Menghapus Pasien");
            System.out.println("5. Panggil Pasien");
            System.out.println("6. Keluar");

            int pilihan = ValidasiInput.inputInteger(scanner, "Pilih menu 1-6 : ");
            
            switch (pilihan){
                
                case 1:
                    System.out.println("===== TAMPILKAN PASIEN =====");
                    System.out.println("1. Pasien Umum");
                    System.out.println("2. Pasien BPJS");

                    int jenisPasien = ValidasiInput.inputInteger(scanner, "Pilih jenis pasien : ");

                    switch (jenisPasien){
                        case 1:
                            crud.tampilkanPasienUmum();
                            break;

                        case 2:
                            crud.tampilkanPasienBPJS();
                            break;

                    default:
                        System.out.println("Jenis pasien tidak valid");
                    }
                    break;
                
                
                case 2:
                    crud.tampilkanPasien();
                    System.out.println("=====TAMBAH PASIEN=====");
                    
                    int id = ValidasiInput.inputInteger(scanner, "Masukkan ID Pasien : ");
                    
                    if (crud.cekIdPasien(id)){ 
                        System.out.println("ID pasien sudah digunakan");
                        break;
                    }
                    
                    System.out.print("masukkan nama pasien : ");
                    String nama = scanner.nextLine();
                    
                    int umur = ValidasiInput.inputInteger(scanner, "Masukkan umur pasien : ");
                    if (umur <= 0 || umur > 200) {
                    System.out.println("Umur harus antara (1 - 200)");
                    break;}
                    
                    System.out.print("masukkan no telepon(+62 / 08) : ");
                    String noTelepon = scanner.nextLine();
                    
                    System.out.println("1. Pasien Umum");
                    System.out.println("2. Pasien BPJS");
                    int jenis = ValidasiInput.inputInteger(scanner, "Pilih jenis pasien : ");


                    if (jenis == 1) {
                        System.out.print("Masukkan jenis Pembayaran(Tunai / Transfer : ");
                        String jenisPembayaran = scanner.nextLine();

                        PasienUmum pasienUmumBaru = new PasienUmum( id, nama, umur, noTelepon, jenisPembayaran);
                        crud.tambahPasienUmum(pasienUmumBaru);
                        break;
                        
                    } else if (jenis == 2) {
                        System.out.print("Masukkan nomor BPJS : ");
                        String nomorBPJS = scanner.nextLine();

                        PasienBPJS pasienBPJSBaru = new PasienBPJS(id, nama, umur, noTelepon, nomorBPJS);
                        crud.tambahPasienBPJS(pasienBPJSBaru);

                    } else {
                        System.out.println("Jenis pasien tidak valid");
                        break;
                    }

                    break;
            
                case 3:
                    crud.tampilkanPasien();
                    System.out.println("=====UPDATE PASIEN=====");
                  
                    int idUpdate = ValidasiInput.inputInteger(scanner, "Masukkan ID Pasien : ");
                    if (!crud.cekIdPasien(idUpdate)){ 
                        System.out.println("ID pasien tidak ditemukan");
                        break;
                    }                    
                    
                    System.out.print("Nama baru : ");
                    String namaBaru = scanner.nextLine();
                    
                    int umurBaru = ValidasiInput.inputInteger(scanner, "Masukkan umur pasien : ");
                    if (umurBaru <=0 || umurBaru > 200){
                        System.out.println("Umur harus antara (1 - 200)");
                    break;}
                    
                    System.out.print("nomor telepon baru(+62 / 08) : ");
                    String noTeleponBaru = scanner.nextLine();
                    
                    crud.updatePasien(idUpdate, namaBaru, umurBaru, noTeleponBaru);
                    break;
                    
                case 4:
                    crud.tampilkanPasien();
                    System.out.println("=====HAPUS DATA PASIEN=====");
                    
                    int idHapus = ValidasiInput.inputInteger(scanner, "Masukkan ID Pasien yang ingin dihapus : ");
                    
                    crud.hapusPasien(idHapus);
                    break;
                    
                case 5:
                    crud.tampilkanPasien();
                    System.out.println("=====PANGGIL PASIEN=====");
                    int idPanggil = ValidasiInput.inputInteger(scanner, "Masukkan ID Pasien : ");
                    
                    crud.panggilPasien(idPanggil);
                    break;
                    
                case 6:
                    berjalan = false;
                    System.out.println("program selesai");
                    break;
                    
                default:
                    System.out.println("pilihan tidak valid");
                                 
            }
        }
            
       scanner.close();
    }
}