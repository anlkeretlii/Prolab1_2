// Sida Sınıfı
public class Sida extends DenizAraclari {
    private int dayaniklilik;
    private int vurus;
    private String altSinif;
    private int havaVurusAvantaji;
    private int karaVurusAvantaji;

    public Sida() {
        super();
        this.setVurus(10);
        this.setDayaniklilik(15);
        this.setAltSinif("Sida");
        this.setHavaVurusAvantaji(10);
        this.setKaraVurusAvantaji(10);
    }

    public Sida(int i) {
        super();
        this.setVurus(10);
        this.setDayaniklilik(15);
        this.setAltSinif("Sida");
        this.setHavaVurusAvantaji(10);
        this.setKaraVurusAvantaji(10);
        this.setIsim("sida"+i);
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


    public int getKaraVurusAvantaji() {
        return karaVurusAvantaji;
    }

    public void setKaraVurusAvantaji(int karaVurusAvantaji) {
        this.karaVurusAvantaji = karaVurusAvantaji;
    }

    // KartPuaniGoster metodunun özelleştirilmesi
    @Override
    public void KartPuaniGoster() {
        super.KartPuaniGoster(); // Üst sınıftaki bilgileri gösterir
        System.out.println("Obüs Özellikleri:");
        System.out.println("Alt Sınıf: " + altSinif);
        System.out.println("Hava Vuruş Avantajı: " + havaVurusAvantaji);
        System.out.println("Kara Vuruş Avantajı: " + karaVurusAvantaji);
        System.out.println("Seviye Puanı: " + seviyePuani);
    }

    // DurumGuncelle metodunun özelleştirilmesi
    @Override
    public void DurumGuncelle(int saldırıDegeri) {
        System.out.println("Sida saldırıya uğruyor! Saldırı Değeri: " + saldırıDegeri);
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

