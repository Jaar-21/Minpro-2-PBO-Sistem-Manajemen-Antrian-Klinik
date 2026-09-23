/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author Asus
 */
public class PasienUmum extends Pasien {
    protected String jenisPembayaran;

    public PasienUmum(int idPasien, String nama, int umur,
            String noTelepon, String jenisPembayaran){

        super(idPasien, nama, umur, noTelepon);
        this.jenisPembayaran = jenisPembayaran;
    }

    public void tampilkanPasienUmum(){

        System.out.printf("%-10d | %-20s | %-6d | %-15s | %-15s\n", idPasien, nama, umur, noTelepon, jenisPembayaran);
    }
    
    @Override
    public void tampilkanInfoPasien(){
        System.out.printf("%-10d | %-20s | %-6d | %-15s | Pembayaran: %-10s\n", idPasien, nama, umur, noTelepon, jenisPembayaran);
    }
}