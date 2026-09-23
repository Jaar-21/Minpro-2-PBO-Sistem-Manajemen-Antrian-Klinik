/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import model.PasienUmum;
import model.PasienBPJS;
import model.Pasien;
import java.util.ArrayList;


/**
 *
 * @author Asus 
 */
public class PasienCRUD {
    private ArrayList<Pasien> listPasien = new ArrayList<>();
    private ArrayList<PasienUmum> listPasienUmum = new ArrayList<>();
    private ArrayList<PasienBPJS> listPasienBPJS = new ArrayList<>();
    

public PasienCRUD() {
    PasienUmum pasienUmum = new PasienUmum(    
            1, "Ahmad", 20, "08123456789", "Tunai");
    
    listPasien.add(pasienUmum);
    listPasienUmum.add(pasienUmum);
}
    public boolean cekIdPasien(int idPasien){
    for (Pasien pasien : listPasien){
        if (pasien.getIdPasien() == idPasien){
            return true;
        }
    }
    return false;
} 

    
///tambahkan pasien
    
    public void tambahPasienUmum(PasienUmum pasien){
        listPasien.add(pasien);
        listPasienUmum.add(pasien);
        System.out.println("Pasien umum ditambahkan");
    }

    public void tambahPasienBPJS(PasienBPJS pasien){
        listPasien.add(pasien);
        listPasienBPJS.add(pasien);
        System.out.println("Pasien BPJS ditambahkan");
    }
    
    ///tampilkan pasien umum
    public void tampilkanPasienUmum(){
    if (listPasienUmum.isEmpty()){
        System.out.println("Belum ada data pasien umum");
    }else{
        System.out.println("===== PASIEN UMUM =====\n");
        System.out.printf("%-10s | %-20s | %-6s | %-15s | %-20s\n",
                "ID", "Nama", "Umur", "NO Telepon", "Jenis Pembayaran");
        
        for (PasienUmum pasien : listPasienUmum){
            pasien.tampilkanPasienUmum();
        }
    }
}
    ///tampilkan pasien bpjs
    public void tampilkanPasienBPJS(){
    if (listPasienBPJS.isEmpty()){
        System.out.println("Belum ada data pasien BPJS");
    }else{
        System.out.println("===== PASIEN BPJS =====\n");
        System.out.printf("%-10s | %-20s | %-6s | %-15s | %-20s\n",
                "ID", "Nama", "Umur", "NO Telepon", "NO BPJS");
        
        for (PasienBPJS pasien : listPasienBPJS){
            pasien.tampilkanPasienBPJS();
        }
    }
}
    
    ///tampilkan pasien
    public void tampilkanPasien(){
        if (listPasien.isEmpty()){
            System.out.println("belum ada data pasien");
        }else{
            System.out.println("===== DAFTAR PASIEN =====");
            System.out.printf("%-10s | %-20s | %-6s | %-15s | %-15s\n","ID", "Nama", "Umur", "NO Telepon", "Info Tambahan");
        for (Pasien pasien : listPasien){
            pasien.tampilkanInfoPasien();
        }
        }
        
    }
    ///hapus pasien
    public void hapusPasien(int idPasien){
        boolean dihapus = listPasien.removeIf(pasien -> pasien.getIdPasien() == idPasien);
        listPasienUmum.removeIf(pasien -> pasien.getIdPasien() == idPasien);
        listPasienBPJS.removeIf(pasien -> pasien.getIdPasien() == idPasien);

        if (dihapus){
            System.out.println("pasien berhasil dihapus");
        }else{
            System.out.println("ID pasien tidak ditemukan");
        }
    }
    ///update pasien
    public void updatePasien(int idPasien, String namaBaru, int umurBaru, String noTeleponBaru){
        Pasien pasienDitemukan = null;
        for (Pasien pasien : listPasien){
            if (pasien.getIdPasien()== idPasien){
                pasienDitemukan = pasien;
                break;
            }
        }
        if (pasienDitemukan != null){
            pasienDitemukan.setNama(namaBaru);
            pasienDitemukan.setUmur(umurBaru);
            pasienDitemukan.setNoTelepon(noTeleponBaru);
            System.out.println("pasien berhasil diupdate");
        }else{
            System.out.println("ID pasien tidak ditemukan");
        }
    }
    ///panggil pasien
    public void panggilPasien(int idPasien){
        Pasien pasienDipanggil = null;
        
        for (Pasien pasien : listPasien){
            if (pasien.getIdPasien()== idPasien){
                pasienDipanggil = pasien;
                break;
            }
        }
        if (pasienDipanggil != null){
            System.out.println("Panggilan atas nama Pasien "+ pasienDipanggil.getNama() + " Silahkan memasuki ruangan");

            listPasien.removeIf(pasien -> pasien.getIdPasien() == idPasien);
            listPasienUmum.removeIf(pasien -> pasien.getIdPasien() == idPasien);
            listPasienBPJS.removeIf(pasien -> pasien.getIdPasien() == idPasien);
            
        }else{
            System.out.println("ID pasien tidak ditemukan");
        }
    }
    
}

