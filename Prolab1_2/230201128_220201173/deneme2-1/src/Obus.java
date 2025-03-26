// Obus Sınıfı
public class Obus extends KaraAraclari {
    private int dayaniklilik;
    private int vurus;
    private String altSinif;
    private int denizVurusAvantaji;

    // Constructor
    public Obus() {
        super();
        this.setVurus(10);
        this.setDayaniklilik(20);
        this.setAltSinif("Obus");
        this.setDenizVurusAvantaji(5);
    }

    public Obus(int dayaniklilik, int vurus, int seviyePuani, int denizVurusAvantaji) {
        super(seviyePuani); // KaraAraçları constructor'ını çağırır
        this.dayaniklilik = dayaniklilik;
        this.vurus = vurus;
        this.altSinif = "Obüs"; // Alt sınıf bilgisi
        this.denizVurusAvantaji = denizVurusAvantaji;
    }

    public Obus(int i) {
        super();
        this.setVurus(10);
        this.setDayaniklilik(20);
        this.setAltSinif("Obus");
        this.setDenizVurusAvantaji(5);
        this.setIsim("obus"+i);
    }

    // Getter ve Setter Metotları
    @Override
    public String getIsim() {return this.isim;}

    @Override
    public void setIsim(String isim) {this.isim = isim;}

    @Override
    public int getDayaniklilik() {
        return dayaniklilik;
    }

    @Override
    public void setDayaniklilik(int dayaniklilik) {
        this.dayaniklilik = dayaniklilik;
    }

    @Override
    public int getVurus() {
        return vurus;
    }

    @Override
    public void setVurus(int vurus) {
        this.vurus = vurus;
    }

    @Override
    public String getAltSinif() {
        return altSinif;
    }

    @Override
    public void setAltSinif(String altSinif) {
        this.altSinif = altSinif;
    }

    @Override
    public int getDenizVurusAvantaji() {
        return denizVurusAvantaji;
    }

    @Override
    public void setDenizVurusAvantaji(int denizVurusAvantaji) {
        this.denizVurusAvantaji = denizVurusAvantaji;
    }

    // KartPuaniGoster metodunun özelleştirilmesi
    @Override
    public void KartPuaniGoster() {
        super.KartPuaniGoster(); // Üst sınıftaki bilgileri gösterir
        System.out.println("Obüs Özellikleri:");
        System.out.println("Alt Sınıf: " + altSinif);
        System.out.println("Deniz Vuruş Avantajı: " + denizVurusAvantaji);
        System.out.println("Seviye Puanı: " + seviyePuani);
    }

    // DurumGuncelle metodunun özelleştirilmesi
    @Override
    public void DurumGuncelle(int saldırıDegeri) {
        System.out.println("Obüs saldırıya uğruyor! Saldırı Değeri: " + saldırıDegeri);
        this.dayaniklilik -= saldırıDegeri; // Dayanıklılık saldırı değeri kadar azalır
        if (this.dayaniklilik > 0) {
            this.seviyePuani += 20; // Dayanıklılık pozitifse seviye puanı artar
        } else {
            this.seviyePuani -= 10; // Dayanıklılık sıfırın altına düşerse seviye puanı düşer
        }
        System.out.println("Güncel Dayanıklılık: " + this.dayaniklilik);
        System.out.println("Güncel Seviye Puanı: " + this.seviyePuani);
    }
}
