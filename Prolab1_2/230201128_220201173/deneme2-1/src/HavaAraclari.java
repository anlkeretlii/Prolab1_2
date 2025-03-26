// Abstract Hava Sınıfı
public abstract class HavaAraclari extends SavasAraclari {
    protected String sinif;

    // Abstract özellikler
    public abstract String getAltSinif();
    public abstract void setAltSinif(String altSinif);

    public abstract int getKaraVurusAvantaji();
    public abstract void setKaraVurusAvantaji(int karaVurusAvantaji);

    // Constructor
    public HavaAraclari() {
        super();
        this.setSinif("Hava");
    }
    public HavaAraclari(int seviyePuani) {
        super(seviyePuani); // Üst sınıfın constructor'ını çağırır
    }

    @Override
    public String getSinif() {
        return sinif;
    }

    @Override
    public void setSinif(String sinif) {
        this.sinif = sinif;
    }
}
