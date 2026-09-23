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

    /// tambah pasien
    public void tambahPasienUmum(PasienUmum pasien){
        listPasien.add(pasien);
        listPasienUmum.add(pasien);
    }

    public void tambahPasienBPJS(PasienBPJS pasien){
        listPasien.add(pasien);
        listPasienBPJS.add(pasien);
    }

    public ArrayList<Pasien> getListPasien(){
        return listPasien;
    }

    public ArrayList<PasienUmum> getListPasienUmum(){
        return listPasienUmum;
    }

    public ArrayList<PasienBPJS> getListPasienBPJS(){
        return listPasienBPJS;
    }

    /// hapus pasien 
    public boolean hapusPasien(int idPasien){
        boolean dihapus = listPasien.removeIf(pasien -> pasien.getIdPasien() == idPasien);
        listPasienUmum.removeIf(pasien -> pasien.getIdPasien() == idPasien);
        listPasienBPJS.removeIf(pasien -> pasien.getIdPasien() == idPasien);
        return dihapus;
    }

    /// update pasien 
    public boolean updatePasien(int idPasien, String namaBaru, int umurBaru, String noTeleponBaru){
        Pasien pasienDitemukan = null;
        for (Pasien pasien : listPasien){
            if (pasien.getIdPasien() == idPasien){
                pasienDitemukan = pasien;
                break;
            }
        }
        if (pasienDitemukan != null){
            pasienDitemukan.setNama(namaBaru);
            pasienDitemukan.setUmur(umurBaru);
            pasienDitemukan.setNoTelepon(noTeleponBaru);
            return true;
        }
        return false;
    }

    /// panggil pasien 
    public Pasien panggilPasien(int idPasien){
        Pasien pasienDipanggil = null;

        for (Pasien pasien : listPasien){
            if (pasien.getIdPasien() == idPasien){
                pasienDipanggil = pasien;
                break;
            }
        }
        if (pasienDipanggil != null){
            listPasien.removeIf(pasien -> pasien.getIdPasien() == idPasien);
            listPasienUmum.removeIf(pasien -> pasien.getIdPasien() == idPasien);
            listPasienBPJS.removeIf(pasien -> pasien.getIdPasien() == idPasien);
        }
        return pasienDipanggil;
    }
}