// Bismarko Nobilas 123180145
import java.util.Scanner;
public class Tugas1 {
    public static void main(String[] args) {
        String nama;
        int tertinggi, terrendah, total = 0;
        int [] nilai = new int[5];
        float ratarata;

        Scanner inputUser = new Scanner(System.in);
        System.out.println("MENU INPUT");
        System.out.print("Nama : ");
        nama = inputUser.nextLine();

        for (int i = 0; i < 5; i++){
            System.out.print("Nilai " + (i+1) + " : ");
            nilai[i] = inputUser.nextInt();
            total=total+nilai[i];
        }
        tertinggi  = nilai[0];
        terrendah  = nilai[0];
        ratarata = total/5;
        System.out.println("\nHasil : ");
        System.out.println("Nama : " + nama);
        for (int i = 0; i < 5; i++){
            if (tertinggi  < nilai[i]){
                tertinggi  = nilai[i];
            } else if (terrendah > nilai[i]){
                terrendah  = nilai[i];
            }
        }
        System.out.println("Nilai Tertinggi : " + tertinggi );
        System.out.println("Nilai Terendah : " + terrendah );
        System.out.println("Rata - rata : " + ratarata);
    }
}