import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Init {

    static Kullanici kullanici ;
    static Bilgisayar bilgisayar;

    /*
    static ArrayList<String> kullanici_kart_isimleri;
    static ArrayList<String> bilgisayar_kart_isimleri;
*/
    static ArrayList<SavasAraclari> kullaniciKartlari;
    static ArrayList<SavasAraclari> bilgisayarKartlari;

    static int kullanici_ucak;
    static int bilgisayar_ucak;
    static int kullanici_obus;
    static int bilgisayar_obus;
    static int kullanici_firkateyn;
    static int bilgisayar_firkateyn;
    static int kullanici_sida;
    static int bilgisayar_sida;
    static int kullanici_siha;
    static int bilgisayar_siha;
    static int kullanici_KFS;
    static int bilgisayar_KFS;

    public static int kullaniciKartSayisiniArtir(String kart) {
        switch (kart) {
            case "ucak":
                return kullanici_ucak++;
            case "obus":
                return kullanici_obus++;
            case "firkateyn":
                return kullanici_firkateyn++;
            case "sida":
                return kullanici_sida++;
            case "siha":
                return kullanici_siha++;
            case "KFS":
                return kullanici_KFS++;
            default:
                return -1;
        }
    }

    public static int bilgisayarKartSayisiniArtir(String kart) {
        switch (kart) {
            case "ucak":
                return bilgisayar_ucak++;
            case "obus":
                return bilgisayar_obus++;
            case "firkateyn":
                return bilgisayar_firkateyn++;
            case "sida":
                return bilgisayar_sida++;
            case "siha":
                return bilgisayar_siha++;
            case "KFS":
                return bilgisayar_KFS++;
            default:
                return -1;
        }

    }

    public static SavasAraclari kartOlustur(String kart, int i ) {
        switch (kart) {
            case "ucak":
                return new Ucak(i);
            case "obus":
                return new Obus(i);
            case "firkateyn":
                return new Firkateyn(i);
            case "sida":
                return new Sida(i);
            case "siha":
                return new Siha(i);
            case "KFS":
                return new KFS(i);
            default:
                throw new IllegalArgumentException("Bilinmeyen kart: " + kart);
        }
    }

    Init() {

        kullanici = new Kullanici();
        bilgisayar = new Bilgisayar();

        //kullanici_kart_isimleri = new ArrayList<String>();
        //bilgisayar_kart_isimleri = new ArrayList<String>();

        kullaniciKartlari = new ArrayList<SavasAraclari>();
        bilgisayarKartlari = new ArrayList<SavasAraclari>();

        kullanici_ucak = 1;
        bilgisayar_ucak = 1;
        kullanici_obus = 1;
        bilgisayar_obus = 1;
        kullanici_firkateyn = 1;
        bilgisayar_firkateyn = 1;
        kullanici_sida = 1;
        bilgisayar_sida = 1;
        kullanici_siha = 1;
        bilgisayar_siha = 1;
        kullanici_KFS = 1;
        bilgisayar_KFS = 1;

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "ucak", "obus", "firkateyn", "sida", "siha", "KFS");

        Random random = new Random();
        String kart;

        for (int i = 0; i < 6; i++) {
            if (kullanici.getSkor() < 20) {
                // İlk 3 elemandan rastgele doldurma
                kart = list.get(random.nextInt(3));
                int temp = kullaniciKartSayisiniArtir(kart);
                //kullanici_kart_isimleri.add(kart + temp);
                kullaniciKartlari.add(kartOlustur(kart,temp));
            } else {
                // Listenin tüm elemanlarından rastgele doldurma
                kart = list.get(random.nextInt(list.size()));
                int temp = kullaniciKartSayisiniArtir(kart);
                //kullanici_kart_isimleri.add(kart + temp);
                kullaniciKartlari.add(kartOlustur(kart,temp));
                //System.out.println(kullaniciKartlari.getLast().getIsim());
            }
            if (bilgisayar.getSkor() < 20) {
                // İlk 3 elemandan rastgele doldurma
                kart = list.get(random.nextInt(3));
                int temp = bilgisayarKartSayisiniArtir(kart);
                //bilgisayar_kart_isimleri.add(kart + temp);
                bilgisayarKartlari.add(kartOlustur(kart,temp));
            } else {
                // Listenin tüm elemanlarından rastgele doldurma
                kart = list.get(random.nextInt(list.size()));
                int temp = bilgisayarKartSayisiniArtir(kart);
                //bilgisayar_kart_isimleri.add(kart + temp);
                bilgisayarKartlari.add(kartOlustur(kart,temp));
                //System.out.println(bilgisayarKartlari.getLast().getIsim());
            }
        }
    }
}

