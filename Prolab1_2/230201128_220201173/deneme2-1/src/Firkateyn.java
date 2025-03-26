// Fırkateyn Sınıfı
public class Firkateyn extends DenizAraclari {
    private int dayaniklilik;
    private int vurus;
    private String sinif;
    private String altSinif;
    private int havaVurusAvantaji;


    // Constructor
    public Firkateyn() {
        super();
        this.setVurus(10);
        this.setDayaniklilik(25);
        this.setAltSinif("Firkateyn");
        this.setHavaVurusAvantaji(5);
    }

    public Firkateyn(int dayaniklilik, int vurus, int seviyePuani, int havaVurusAvantaji) {
        super(seviyePuani); // DenizAraçları constructor'ını çağırır
        this.dayaniklilik = dayaniklilik;
        this.vurus = vurus;
        this.sinif = "Deniz"; // Varsayılan sınıf
        this.altSinif = "Firkateyn"; // Alt sınıf bilgisi
        this.havaVurusAvantaji = havaVurusAvantaji;
    }

    public Firkateyn(int i) {
        super();
        this.setVurus(10);
        this.setDayaniklilik(25);
        this.setAltSinif("Firkateyn");
        this.setHavaVurusAvantaji(5);
        this.setIsim("firkateyn"+i);
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
    public int getHavaVurusAvantaji() {
        return havaVurusAvantaji;
    }

    @Override
    public void setHavaVurusAvantaji(int havaVurusAvantaji) {this.havaVurusAvantaji = havaVurusAvantaji;}


    // KartPuaniGoster metodunun özelleştirilmesi
    @Override
    public void KartPuaniGoster() {
        super.KartPuaniGoster(); // Üst sınıftaki bilgileri gösterir
        System.out.println("Fırkateyn Özellikleri:");
        System.out.println("Alt Sınıf: " + altSinif);
        System.out.println("Hava Vuruş Avantajı: " + havaVurusAvantaji);
        System.out.println("Seviye Puanı: " + seviyePuani);
    }

    // DurumGuncelle metodunun özelleştirilmesi
    @Override
    public void DurumGuncelle(int saldırıDegeri) {
        System.out.println("Fırkateyn saldırıya uğruyor! Saldırı Değeri: " + saldırıDegeri);
        this.dayaniklilik -= saldırıDegeri; // Dayanıklılık saldırı değeri kadar azalır
        if (this.dayaniklilik > 0) {
            this.seviyePuani += 25; // Dayanıklılık pozitifse seviye puanı artar
        } else {
            this.seviyePuani -= 15; // Dayanıklılık sıfırın altına düşerse seviye puanı düşer
        }
        System.out.println("Güncel Dayanıklılık: " + this.dayaniklilik);
        System.out.println("Güncel Seviye Puanı: " + this.seviyePuani);
    }
}
