

// Abstract Savaş Araçları Sınıfı
public abstract class SavasAraclari {
    // Abstract özellikler
    protected int seviyePuani; // Normal bir özellik (abstract olmayan)
    protected String isim;
    protected boolean kullanim;

    public abstract String getIsim();
    public abstract void setIsim(String isim);

    public abstract int getDayaniklilik();
    public abstract void setDayaniklilik(int dayaniklilik);

    public abstract String getSinif();
    public abstract void setSinif(String sinif);

    public abstract int getVurus();
    public abstract void setVurus(int vurus);


    // Constructor
    public SavasAraclari(){
        seviyePuani = 0;
        isim="?";
        kullanim=false;
    }
    public SavasAraclari(int seviyePuani) {
        this.seviyePuani = seviyePuani;
    }

    // Kart puanı gösterme metodu
    public void KartPuaniGoster() {
        System.out.println("Dayanıklılık: " + getDayaniklilik());
        System.out.println("Sınıf: " + getSinif());
        System.out.println("Vuruş: " + getVurus());
        System.out.println("Seviye Puanı: " + seviyePuani);
    }

    // Abstract durum güncelleme metodu
    public abstract void DurumGuncelle(int saldırıDegeri);

    public int getGuc() {
        return seviyePuani;
    }
}
