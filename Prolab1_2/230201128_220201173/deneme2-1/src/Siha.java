// Siha Sınıfı
public class Siha extends HavaAraclari {
    private int dayaniklilik;
    private int vurus;
    private String sinif;
    private String altSinif;
    private int karaVurusAvantaji;
    private int denizVurusAvantaji;

    // Constructor
    public Siha() {
        super();
        this.setVurus(10);
        this.setDayaniklilik(15);
        this.setAltSinif("Siha");
        this.setKaraVurusAvantaji(10);
        this.setDenizVurusAvantaji(10);
    }

    public Siha(int dayaniklilik, int vurus, int seviyePuani, int denizVurusAvantaji) {
        super(seviyePuani); // HavaAraçları constructor'ını çağırır
        this.dayaniklilik = dayaniklilik;
        this.vurus = vurus;
        this.sinif = "Hava"; // Varsayılan sınıf
        this.altSinif = "SİHA"; // Alt sınıf bilgisi
        this.karaVurusAvantaji = karaVurusAvantaji;
        this.denizVurusAvantaji = denizVurusAvantaji;
    }

    public Siha(int i) {
        super();
        this.setVurus(10);
        this.setDayaniklilik(15);
        this.setAltSinif("Siha");
        this.setKaraVurusAvantaji(10);
        this.setDenizVurusAvantaji(10);
        this.setIsim("siha"+i);
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


    public int getDenizVurusAvantaji() {
        return denizVurusAvantaji;
    }

    public void setDenizVurusAvantaji(int denizVurusAvantaji) {this.denizVurusAvantaji = denizVurusAvantaji;}

    // KartPuaniGoster metodunun özelleştirilmesi
    @Override
    public void KartPuaniGoster() {
        super.KartPuaniGoster(); // Üst sınıftaki bilgileri gösterir
        System.out.println("SİHA Özellikleri:");
        System.out.println("Alt Sınıf: " + altSinif);
        System.out.println("Deniz Vuruş Avantajı: " + denizVurusAvantaji);
        System.out.println("Seviye Puanı: " + seviyePuani);
    }

    // DurumGuncelle metodunun özelleştirilmesi
    @Override
    public void DurumGuncelle(int saldırıDegeri) {
        System.out.println("SİHA saldırıya uğruyor! Saldırı Değeri: " + saldırıDegeri);
        this.dayaniklilik -= saldırıDegeri; // Dayanıklılık saldırı değeri kadar azalır
        if (this.dayaniklilik > 0) {
            this.seviyePuani += 30; // Dayanıklılık pozitifse seviye puanı artar
        } else {
            this.seviyePuani -= 20; // Dayanıklılık sıfırın altına düşerse seviye puanı düşer
        }
        System.out.println("Güncel Dayanıklılık: " + this.dayaniklilik);
        System.out.println("Güncel Seviye Puanı: " + this.seviyePuani);
    }
}
