import java.util.ArrayList;
import java.util.List;

public abstract class Oyuncu {
    private int oyuncuID; // Oyuncu ID'si
    private String oyuncuAdi; // Oyuncunun adı
    private int skor; // Oyuncunun skoru
    protected ArrayList<SavasAraclari> kartListesi; // Oyuncunun elindeki kartları tutan liste

    // Parametresiz yapıcı
    public Oyuncu() {
        this.oyuncuID = -1;
        this.oyuncuAdi = "?";
        this.skor = 0;
        this.kartListesi = new ArrayList<>();
    }

    // Parametreli yapıcı
    public Oyuncu(int oyuncuID, String oyuncuAdi, int skor) {
        this.oyuncuID = oyuncuID;
        this.oyuncuAdi = oyuncuAdi;
        this.skor = skor;
        this.kartListesi = new ArrayList<>();
    }


    // Skoru gösteren metot
    public void skorGoster() {
        System.out.println("Oyuncu Adı: " + this.oyuncuAdi + " | Skor: " + this.skor);
    }

    // Abstract metot: Kart seçimi, alt sınıflarda farklı şekilde çalışacak


    // Getter ve Setter metodları

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public List<SavasAraclari> getKartListesi() {
        return kartListesi;
    }

    public void setKartListesi(ArrayList<SavasAraclari> kartListesi) {
        this.kartListesi = kartListesi;
    }
}