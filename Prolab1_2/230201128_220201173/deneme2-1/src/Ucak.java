// Uçak Sınıfı
public class Ucak extends HavaAraclari {

    private int dayaniklilik;
    private int vurus;
    private String sinif;
    private String altSinif;
    private int karaVurusAvantaji;


    // Constructor
    public Ucak() {
        super();
        this.setVurus(10);
        this.setDayaniklilik(20);
        this.setAltSinif("Ucak");
        this.setKaraVurusAvantaji(10);
    }

    public Ucak(int i) {
        super();
        this.setVurus(10);
        this.setDayaniklilik(20);
        this.setAltSinif("Ucak");
        this.setKaraVurusAvantaji(10);
        this.setIsim("ucak"+i);
    }

    public Ucak(int dayaniklilik, int vurus, int seviyePuani, int karaVurusAvantaji) {
        super(seviyePuani); // HavaAraclari sınıfındaki constructor'ı çağırır
        this.dayaniklilik = dayaniklilik;
        this.vurus = vurus;
        this.sinif = "Hava"; // Varsayılan değer
        this.altSinif = "Uçak"; // Alt sınıf bilgisi
        this.karaVurusAvantaji = karaVurusAvantaji;
    }

    // Getter ve Setter Metotları
    @Override
    public String getIsim() {return this.isim;}

    @Override
    public void setIsim(String isim) {this.isim = isim;}

    @Override
    public int getDayaniklilik() {return dayaniklilik;}

    @Override
    public void setDayaniklilik(int dayaniklilik) {this.dayaniklilik = dayaniklilik;}

    @Override
    public String getSinif() {return sinif;}

    @Override
    public void setSinif(String sinif) {this.sinif = sinif;}

    @Override
    public int getVurus() {return vurus;}

    @Override
    public void setVurus(int vurus) {this.vurus = vurus;}

    @Override
    public String getAltSinif() {return altSinif;}

    @Override
    public void setAltSinif(String altSinif) {this.altSinif = altSinif;}

    @Override
    public int getKaraVurusAvantaji() {return karaVurusAvantaji;}

    @Override
    public void setKaraVurusAvantaji(int karaVurusAvantaji) {this.karaVurusAvantaji = karaVurusAvantaji;}


    // KartPuaniGoster metodunun özelleştirilmesi
    @Override
    public void KartPuaniGoster() {
        super.KartPuaniGoster(); // Üst sınıftaki bilgileri gösterir
        System.out.println("Uçak Özellikleri:");
        System.out.println("Alt Sınıf: " + altSinif);
        System.out.println("Kara Vuruş Avantajı: " + karaVurusAvantaji);
        System.out.println("Seviye Puanı: " + seviyePuani);
    }

    // DurumGuncelle metodunun özelleştirilmesi
    @Override
    public void DurumGuncelle(int saldırıDegeri) {
        System.out.println("Uçak saldırıya uğruyor! Saldırı Değeri: " + saldırıDegeri);
        this.dayaniklilik -= saldırıDegeri; // Dayanıklılık saldırı değeri kadar azalır
        if (this.dayaniklilik > 0) {
            this.seviyePuani += 20; // Dayanıklılık pozitifse seviye puanı artar
        } else {
            this.seviyePuani -= 15; // Dayanıklılık sıfırın altına düşerse seviye puanı düşer
        }
        System.out.println("Güncel Dayanıklılık: " + this.dayaniklilik);
        System.out.println("Güncel Seviye Puanı: " + this.seviyePuani);
    }
}
