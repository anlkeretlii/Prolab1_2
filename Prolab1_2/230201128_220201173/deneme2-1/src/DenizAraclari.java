// Abstract DenizAraçları Sınıfı
public abstract class DenizAraclari extends SavasAraclari {
    protected String sinif;
    // Abstract özellikler
    public abstract String getAltSinif();
    public abstract void setAltSinif(String altSinif);

    public abstract int getHavaVurusAvantaji();
    public abstract void setHavaVurusAvantaji(int havaVurusAvantaji);

    // Constructor
    public DenizAraclari() {
        super();
        this.setSinif("Deniz");
    }

    public DenizAraclari(int seviyePuani) {
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
