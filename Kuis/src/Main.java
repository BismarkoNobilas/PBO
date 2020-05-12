
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int kembali='y', pilih;
        Scanner scanInput = new Scanner(System.in);
        do{
            Lab daftar = new SeleksiLab();
            System.out.println("MENU FORM PENDAFTARAN");
            System.out.println("1. Asisten Praktikum");
            System.out.println("2. Admin Laboratorium");
            System.out.println("Pilih Jenis Form : ");
            pilih = scanInput.nextInt();
            if(pilih==1)
            {
                daftar.AsistenLab();
            }else if (pilih==2)
            {
                daftar.AdminLab();
            } else
            {
                System.out.println("Input Menu Tidah sesuai");
            }
            System.out.println("Kembali Kemenu? (y/n)");
            kembali = scanInput.next().charAt(0);
        }
        while(kembali=='y'||kembali=='Y');
    }    
}
