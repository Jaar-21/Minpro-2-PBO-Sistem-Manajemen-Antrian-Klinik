/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Asus
 */
public class Pasien {
    protected final int idPasien;
    protected String nama;
    protected int umur;
    protected String noTelepon;

    public Pasien(int idPasien, String nama, int umur, String noTelepon){
        this.idPasien = idPasien;
        this.nama = nama;
        this.umur = umur;
        this.noTelepon = noTelepon;
    }

    public int getIdPasien(){
        return idPasien;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public int getUmur(){
        return umur;
    }

    public void setUmur(int umur){
        this.umur = umur;
    }

    public String getNoTelepon(){
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon){
        this.noTelepon = noTelepon;
    }

    public String getInfoTambahan(){
        return "-";
    }

    @Override
    public String toString(){
        return String.format("%-10d | %-20s | %-6d | %-15s | %s",
                idPasien, nama, umur, noTelepon, getInfoTambahan());
    }
}
