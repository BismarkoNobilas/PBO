package Tugas2;
public class PersegiPanjang {
    private int panjang, lebar, tinggi;

    public void Hitung(int panjang, int lebar)
    {
        this.lebar = lebar;
        this.panjang = panjang;
        int luas=panjang*lebar;
        System.out.println("Luas PersegiPanjang = " + luas);
    }
    public void Keliling(){
        int keliling=2*(panjang+lebar);
        System.out.println("Keliling PersegiPanjang = " + keliling);
    }
    public void Hitung(int tinggi)
    {
        this.tinggi = tinggi;
        int volume=panjang*lebar*tinggi;
        System.out.println("Volume Balok = " + volume);
        int lp=(2*panjang*lebar)+(2*panjang*tinggi)+(2*lebar*tinggi);
        System.out.println("Luas Permuakaan Balok = " + lp);
    }

    public int getPanjang() {
        return panjang;
    }

    public int getLebar() {
        return lebar;
    }

    public int getTinggi() {
        return tinggi;
    }
    
}