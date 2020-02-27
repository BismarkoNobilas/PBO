package Tugas2;
public class Persegi {
    int Sisi;
    private int luas, keliling;

    public void setSisi(int Sisi) {
        this.Sisi = Sisi;
    }
    public int getSisi(){
        return Sisi;
    }
    
    public void Luas(){
        luas=Sisi*Sisi;
        System.out.println("Luas Persegi = " + luas);
    }
    public void Keliling(){
        keliling=Sisi*4;
        System.out.println("Keliling Persegi = " + keliling);
    }

}