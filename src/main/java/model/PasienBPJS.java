/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author Asus
 */


public class PasienBPJS extends Pasien {
    protected String nomorBPJS;

    public PasienBPJS(int idPasien, String nama, int umur,
            String noTelepon, String nomorBPJS){

        super(idPasien, nama, umur, noTelepon);
        this.nomorBPJS = nomorBPJS;
    }

    public void tampilkanPasienBPJS(){
        System.out.printf("%-10d | %-20s | %-6d | %-15s | %-15s\n", idPasien, nama, umur, noTelepon, nomorBPJS);
    }
    
    @Override
    public void tampilkanInfoPasien(){
        System.out.printf("%-10d | %-20s | %-6d | %-15s | BPJS: %-10s\n", idPasien, nama, umur, noTelepon, nomorBPJS);
    }
}
