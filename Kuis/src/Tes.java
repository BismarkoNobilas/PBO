
import java.util.InputMismatchException;
import java.util.Scanner;
public class Tes{
    Scanner scanInput = new Scanner(System.in);
    int tulis, koding, wawancara, khusus, nim;
    String nama, terima;
    void isiTes(){
        System.out.println("Input NIM : ");
        nim=scanInput.nextInt();
        System.out.println("Input Nama : ");
        nama=scanInput.next();
        System.out.println("Input Nilai Tes Tulis : ");
        this.tulis=scanInput.nextInt();
        System.out.println("Input Nilai Tes Coding : ");
        this.koding=scanInput.nextInt();
        System.out.println("Input Nilai Tes Wawancara : ");
        this.wawancara=scanInput.nextInt();
    }
    void khususAs() {
        System.out.println("Input Nilai Tes Microteaching : ");
        this.khusus=scanInput.nextInt();
        this.terima="Asisten";
    }
    void khususAd() {
        System.out.println("Input Nilai Tes Jaringan : ");
        this.khusus=scanInput.nextInt();
        this.terima="Admin";
    }
}
