package Tugas2;
import java.util.Scanner;
public class Bangun2Dimensi {
    public static void main(String[] args) {
        int pilih,ulg=1;
        Scanner scanInput = new Scanner(System.in);
        System.out.println("Bangun 2 Deimensi");
        System.out.println("1. Persegi");
        System.out.println("2. Persegi Panjang");
        System.out.println("Pilih Menu : ");
        pilih = scanInput.nextInt();
        switch(pilih){
            case 1:
            {
                int sisi;
                Persegi hitPersegi = new Persegi();
                System.out.println("Hitung Persegi");
                System.out.println("Panjang Sisi = ");
                sisi = scanInput.nextInt();
                hitPersegi.setSisi(sisi);   
                hitPersegi.Luas();
                hitPersegi.Keliling();
                do
                {
                    int input;
                    System.out.println("\nBangun Lanjut : ");
                    System.out.println("1. Kubus");
                    System.out.println("2. Limas Persegi");
                    System.out.println("3. Exit");
                    System.out.println("Input = ");
                    input = scanInput.nextInt();
                    if(input==1)
                    {
                        System.out.println(sisi);
                        BangunPersegi hitKubus = new BangunPersegi(sisi);
                        hitKubus.HitungKubus();
                    }
                    else if(input==2)
                    {
                        
                        BangunPersegi hitLimas = new BangunPersegi(sisi);
                        hitLimas.setSisi(sisi);
                        hitLimas.HitungLimas();
                    }
                    else if(input==3)
                    {
                        ulg++;
                    }
                    else
                    {
                        System.out.println("ERROR!!!");
                        break;
                    }
                }while(ulg==1);
                break;
            }
            case 2:
            {
                int panjang, lebar;
                PersegiPanjang hitPP = new PersegiPanjang();
                System.out.println("Hitung Persegi Panjang");
                System.out.println("Panjang = ");
                panjang = scanInput.nextInt();
                System.out.println("Lebar = ");
                lebar = scanInput.nextInt();
                hitPP.Hitung(panjang,lebar);
                hitPP.Keliling();
                do
                {
                    int input,tinggi;
                    System.out.println("\nBangun Lanjut : ");
                    System.out.println("1. Balok");
                    System.out.println("2. Limas Persegi Panjang");
                    System.out.println("3. Exit");
                    System.out.println("Input = ");
                    input = scanInput.nextInt();
                    if(input==1)
                    {
                        System.out.println("Tinggi = ");
                        tinggi = scanInput.nextInt();
                        hitPP.Hitung(tinggi);
                    }
                    else if(input==2)
                    {
                        System.out.println("Tinggi = ");
                        tinggi = scanInput.nextInt();
                        PersegiPanjang hitLimas = new LimasPersegiPanjang();
                        hitLimas.Hitung(panjang,lebar);
                        hitLimas.Hitung(tinggi);
                    }
                    else if(input==3)
                    {
                        ulg++;
                    }
                    else
                    {
                        System.out.println("ERROR!!!");
                        break;
                    }
                }while(ulg==1);
                break;
            }
            default:
            {
                System.out.println("ERROR!!!!");
                break;
            }
        }
    }
}

