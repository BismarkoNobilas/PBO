package Tugas2;

import static java.lang.Math.sqrt;

public class LimasPersegiPanjang extends PersegiPanjang{
    int panjang;
    int lebar;
    @Override
    public void Hitung(int panjang, int lebar)
    {
        this.lebar = lebar;
        this.panjang = panjang;
    }
    @Override
    public void Hitung(int tinggi) {
        double volumeL = panjang*lebar*tinggi/3;
        double lpL = (panjang*lebar)+4*(sqrt((tinggi^2)+(1/2*(panjang^2))));
        System.out.println("Volume Limas Persegi Panjang = " + volumeL);
        System.out.println("Luas Permukaan Limas Persegi Panjang = " + lpL);
    }
}
