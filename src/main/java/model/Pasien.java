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

    public void setUmur(int umur){
        this.umur = umur;
    }

    public void setNoTelepon(String noTelepon){
        this.noTelepon = noTelepon;
    }

    public void tampilkanInfoPasien(){
        System.out.printf("%-10d | %-20s | %-6d | %-15s\n",idPasien, nama, umur, noTelepon);
}
}
