/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kirimbarangfix;

/**
 *
 * @author Nadifsa
 */

public class Data {
    private String nm_pengirim;
    private String asal;
    private String hp_pengirim;
    private String nm_penerima;
    private String tujuan;
    private String alamat;
    private String hp_penerima;
    private String jenkim;
    private String jenbar;
    private String berat;
    private int hartot;

    public Data(String vnm_pengirim, String vasal, String vhp_pengirim, String vnm_penerima, String vtujuan, String vhp_penerima, String valamat, String vjenkim, String vjenbar, String vberat) {
        nm_penerima = vnm_penerima;
        tujuan = vtujuan;
        alamat = valamat;
        hp_penerima = vhp_penerima;
            nm_pengirim = vnm_pengirim;
            asal = vasal;
            hp_pengirim = vhp_pengirim;
            jenkim = vjenkim;
            jenbar = vjenbar;
            berat = vberat;
    }
    public Data(int vhartot){
        hartot = vhartot;
    }
    public Data(String vnm_pengirim, String vhp_pengirim) {
            nm_pengirim = vnm_pengirim;
            hp_pengirim = vhp_pengirim;
    }
    public Data(String vnm_penerima, String vhp_penerima, String valamat) {
        nm_penerima = vnm_penerima;
        alamat = valamat;
        hp_penerima = vhp_penerima;
    }

    public int getHartot() {
        return hartot;
    }
    public String getnm_pengirim() {
            return nm_pengirim;
    }
    public String getasal() {
            return asal;
    }
    public String gethp_pengirim() {
            return hp_pengirim;
    }
    public String getnm_penerima() {
            return nm_penerima;
    }
    public String gettujuan() {
            return tujuan;
    }
    public String gethp_penerima() {
            return hp_penerima;
    }
    public String getalamat() {
        return alamat;
    }

    public String getjenkim() {
        return jenkim;
    }

    public String getjenbar() {
        return jenbar;
    }

    public String getberat() {
        return berat;
    }

}
