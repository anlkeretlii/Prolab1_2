import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Oyun {


    public static class Main {
        public static void main(String[] args) {
            System.out.println("Hello world!");


            Init Test = new Init();


            for (SavasAraclari arac : Test.kullaniciKartlari) {
                System.out.println("Arac İsmi: " + arac.getIsim() + arac.kullanim);
            }



        }
    }

}

