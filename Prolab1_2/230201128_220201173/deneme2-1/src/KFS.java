
public class KFS extends KaraAraclari {
    private int dayaniklilik;
    private int vurus;
    private String sinif;
    private String altSinif;
    private int denizVurusAvantaji;
    private int havaVurusAvantaji;

    // Constructor
    public KFS() {
        super();
        this.setDayaniklilik(10);
        this.setVurus(10);
        this.setAltSinif("KFS");
        this.setDenizVurusAvantaji(10);
        this.setHavaVurusAvantaji(20);
    }

    public KFS(int dayaniklilik, int vurus, int seviyePuani, int denizVurusAvantaji) {
        super(seviyePuani); // KaraAraçları constructor'ını çağırır
        this.dayaniklilik = dayaniklilik;
        this.vurus = vurus;
        this.sinif = "KaraAraçları"; // Varsayılan sınıf
        this.altSinif = "KFS"; // Alt sınıf bilgisi
        this.denizVurusAvantaji = denizVurusAvantaji;
        this.havaVurusAvantaji = 0;
    }

    public KFS(int i) {
        super();
        this.setDayaniklilik(10);
        this.setVurus(10);
        this.setAltSinif("KFS");
        this.setDenizVurusAvantaji(10);
        this.setHavaVurusAvantaji(20);
        this.setIsim("KFS"+i);
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
    public String getSinif() {
        return sinif;
    }

    @Override
    public void setSinif(String sinif) {
        this.sinif = sinif;
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
    public void setDenizVurusAvantaji(int havaVurusAvantaji) {
        this.denizVurusAvantaji = denizVurusAvantaji;
    }
    public double getHavaVurusAvantaji() {
        return havaVurusAvantaji;
    }

    public void setHavaVurusAvantaji(int havaVurusAvantaji) {
        this.havaVurusAvantaji = havaVurusAvantaji;
    }

    // KartPuaniGoster metodunun özelleştirilmesi
    @Override
    public void KartPuaniGoster() {
        super.KartPuaniGoster(); // Üst sınıftaki bilgileri gösterir
        System.out.println("Obüs Özellikleri:");
        System.out.println("Alt Sınıf: " + altSinif);
        System.out.println("Deniz Vuruş Avantajı: " + denizVurusAvantaji);
        System.out.println("hava Vuruş Avantajı: " + havaVurusAvantaji);
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
