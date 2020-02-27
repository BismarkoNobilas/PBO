package Tugas2;

import static java.lang.Math.sqrt;

public class BangunPersegi extends Persegi{
    int sisi;

    public BangunPersegi(int sisi) {
        this.sisi = sisi;
    }
    public void HitungKubus() {
        int volumeK = sisi*sisi*sisi;
        int lpK = sisi*sisi*6;
        System.out.println("Volume Kubus dengan Sisi " + sisi + " adalah " + volumeK);
        System.out.println("Luas Permukaan Kubus dengan Sisi " + sisi + " adalah " + lpK);
    }
    public void HitungLimas() {
        double volumeL = sisi*sisi*sisi/3;
        double lpL = (sisi*sisi)+4*(sqrt((sisi^2)+(1/2*(sisi^2))));
        System.out.println("Volume Kubus dengan Sisi " + sisi + " adalah " + volumeL);
        System.out.println("Luas Permukaan Kubus dengan Sisi dan Tinggi " + sisi + " adalah " + lpL);
    }
}
