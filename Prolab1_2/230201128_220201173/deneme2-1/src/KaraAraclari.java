// Abstract KaraAraçları Sınıfı
public abstract class KaraAraclari extends SavasAraclari {

    protected String sinif;

    // Abstract özellikler
    public abstract String getAltSinif();
    public abstract void setAltSinif(String altSinif);

    public abstract int getDenizVurusAvantaji();
    public abstract void setDenizVurusAvantaji(int denizVurusAvantaji);

    // Constructor
    public KaraAraclari() {
        super();
        this.setSinif("Kara");
    }

    public KaraAraclari(int seviyePuani) {
        super(seviyePuani); // Üst sınıfın constructor'ını çağırır
    }

    @Override
    public String getSinif() {
        return sinif;
    }

    @Override
    public void setSinif(String sinif) {
        sinif = sinif;
    }


}
