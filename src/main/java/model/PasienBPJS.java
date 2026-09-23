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

    public String getNomorBPJS(){
        return nomorBPJS;
    }

    public void setNomorBPJS(String nomorBPJS){
        this.nomorBPJS = nomorBPJS;
    }

    @Override
    public String getInfoTambahan(){
        return "BPJS: " + nomorBPJS;
    }
}
