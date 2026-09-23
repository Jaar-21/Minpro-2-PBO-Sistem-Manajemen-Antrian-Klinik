/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.Pasien;
import model.PasienUmum;
import model.PasienBPJS;
import java.util.ArrayList;

/**
 * @author Asus
 */
public class PasienView {

    public void tampilkanMenu(){
        System.out.println("==========================================");
        System.out.println("      SISTEM MANAJEMEN PASIEN KLINIK");
        System.out.println("==========================================");
        System.out.println("1. Tampilkan Pasien");
        System.out.println("2. Tambahkan Pasien");
        System.out.println("3. Update Pasien");
        System.out.println("4. Menghapus Pasien");
        System.out.println("5. Panggil Pasien");
        System.out.println("6. Keluar");
    }

    public void tampilkanSubMenuTampilkan(){
        System.out.println("===== TAMPILKAN PASIEN =====");
        System.out.println("1. Pasien Umum");
        System.out.println("2. Pasien BPJS");
    }

    public void tampilkanPilihanJenisPasien(){
        System.out.println("1. Pasien Umum");
        System.out.println("2. Pasien BPJS");
    }

    public void tampilkanDaftarPasien(ArrayList<Pasien> listPasien){
        if (listPasien.isEmpty()){
            System.out.println("belum ada data pasien");
        } else {
            System.out.println("===== DAFTAR PASIEN =====");
            System.out.printf("%-10s | %-20s | %-6s | %-15s | %-15s\n",
                    "ID", "Nama", "Umur", "NO Telepon", "Info Tambahan");
            for (Pasien pasien : listPasien){
                System.out.println(pasien);
            }
        }
    }

    public void tampilkanDaftarPasienUmum(ArrayList<PasienUmum> listPasienUmum){
        if (listPasienUmum.isEmpty()){
            System.out.println("Belum ada data pasien umum");
        } else {
            System.out.println("===== PASIEN UMUM =====\n");
            System.out.printf("%-10s | %-20s | %-6s | %-15s | %-20s\n",
                    "ID", "Nama", "Umur", "NO Telepon", "Jenis Pembayaran");
            for (PasienUmum pasien : listPasienUmum){
                System.out.printf("%-10d | %-20s | %-6d | %-15s | %-20s\n",
                        pasien.getIdPasien(), pasien.getNama(), pasien.getUmur(),
                        pasien.getNoTelepon(), pasien.getJenisPembayaran());
            }
        }
    }

    public void tampilkanDaftarPasienBPJS(ArrayList<PasienBPJS> listPasienBPJS){
        if (listPasienBPJS.isEmpty()){
            System.out.println("Belum ada data pasien BPJS");
        } else {
            System.out.println("===== PASIEN BPJS =====\n");
            System.out.printf("%-10s | %-20s | %-6s | %-15s | %-20s\n",
                    "ID", "Nama", "Umur", "NO Telepon", "NO BPJS");
            for (PasienBPJS pasien : listPasienBPJS){
                System.out.printf("%-10d | %-20s | %-6d | %-15s | %-20s\n",
                        pasien.getIdPasien(), pasien.getNama(), pasien.getUmur(),
                        pasien.getNoTelepon(), pasien.getNomorBPJS());
            }
        }
    }

    public void pesan(String teks){
        System.out.println(teks);
    }
}
