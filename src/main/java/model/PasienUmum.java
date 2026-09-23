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

    public String getJenisPembayaran(){
        return jenisPembayaran;
    }

    public void setJenisPembayaran(String jenisPembayaran){
        this.jenisPembayaran = jenisPembayaran;
    }

    @Override
    public String getInfoTambahan(){
        return "Pembayaran: " + jenisPembayaran;
    }
}
