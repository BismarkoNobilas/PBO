
import java.util.InputMismatchException;
import java.util.Scanner;
public class SeleksiLab implements Lab{
    Scanner scanInput = new Scanner(System.in);
    int banyak,nilai;
    public void AsistenLab(){
        System.out.println("");
        System.out.println("FORM PENDAFTARAN ASISTEN LABORATORIUM");
        System.out.println("Banyak input : ");
        System.out.println("");
        banyak = scanInput.nextInt();
        for(int i=0;i<banyak;i++){
            try
            {
                Hitung baru = new Hitung();
                baru.isiTes();
                baru.khususAs();
                int nilai= baru.Hasil();
                System.out.println("Nilai Akhir = " + nilai);
                baru.Hasil(nilai);
            }catch(InputMismatchException ex){
                System.out.println("Input Harus Bilangan Bulat!!");
                System.out.println("Masukan Ulang!!!");
                i--;
            }
            System.out.println("");
        }
    }
    public void AdminLab(){
        System.out.println("");
        System.out.println("FORM PENDAFTARAN ADMIN LABORATORIUM");
        System.out.println("Banyak input : ");
        System.out.println("");
        banyak = scanInput.nextInt();
        for(int i=0;i<banyak;i++){
            try
            {
                Hitung baru = new Hitung();
                baru.isiTes();
                baru.khususAd();
                int nilai= baru.Hasil();
                System.out.println("Nilai Akhir = " + nilai);
                baru.Hasil(nilai);
            }catch(InputMismatchException ex){
                System.out.println("Input Harus Bilangan Bulat!!");
                System.out.println("Masukan Ulang!!!");
                i--;
            }
            System.out.println("");
        }
        
    }
}
