public class Hitung extends Tes{
    int hasil;
    int Hasil(){
        hasil = (khusus + tulis + koding + wawancara)/4;
        return hasil;
    }
    void Hasil(int nilai){
        if(nilai>85)
        {
            System.out.println("KETERANGAN = LOLOS");
            System.out.println("Selamat Kepada " + nim + " telah diterima sebagai " + terima);
        }
        else
        {
            System.out.println("KETERANGAN = GAGAL");
            System.out.println("Mohon maaf Kepada " + nim + " telah ditolak sebagai " + terima);
        }
    }
}
