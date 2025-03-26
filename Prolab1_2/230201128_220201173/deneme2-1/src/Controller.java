import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {
    public Label kart1;
    public Label kart2;
    public ImageView bilgisayar_resim_1, bilgisayar_resim_2, bilgisayar_resim_3, bilgisayar_resim_4;
    public ImageView bilgisayar_resim_5, bilgisayar_resim_6, bilgisayar_resim_7, bilgisayar_resim_8, bilgisayar_resim_9;
    public ImageView kullanici_resim_1, kullanici_resim_2, kullanici_resim_3, kullanici_resim_4;
    public ImageView kullanici_resim_5, kullanici_resim_6, kullanici_resim_7, kullanici_resim_8, kullanici_resim_9;
    public Label bilgisayar_skor, kullanici_skor;
    public AnchorPane anchor_pane;

    private ArrayList<SavasAraclari> kullaniciKartlari;
    private ArrayList<SavasAraclari> bilgisayarKartlari;

    public Controller() {
        this.kullaniciKartlari = Init.kullaniciKartlari;
        this.bilgisayarKartlari = Init.bilgisayarKartlari;
    }

    public void initialize() throws FileNotFoundException {
        // Arka planı ayarla
        this.anchor_pane.setStyle("-fx-background-image: url(arkaplan.jpg);-fx-background-size: 1360 720;");

        // Kartları yerleştir
        yerlesimKartlari(kullaniciKartlari, true);  // Kullanıcı için
        yerlesimKartlari(bilgisayarKartlari, false); // Bilgisayar için
    }

    private void yerlesimKartlari(ArrayList<SavasAraclari> kartlar, boolean kullanici) throws FileNotFoundException {
        ImageView[] resimler = kullanici
                ? new ImageView[]{kullanici_resim_1, kullanici_resim_2, kullanici_resim_3, kullanici_resim_4, kullanici_resim_5, kullanici_resim_6, kullanici_resim_7, kullanici_resim_8, kullanici_resim_9}
                : new ImageView[]{bilgisayar_resim_1, bilgisayar_resim_2, bilgisayar_resim_3, bilgisayar_resim_4, bilgisayar_resim_5, bilgisayar_resim_6, bilgisayar_resim_7, bilgisayar_resim_8, bilgisayar_resim_9};

        for (int i = 0; i < kartlar.size(); i++) {
            SavasAraclari kart = kartlar.get(i);
            String kartAdi = kart.getIsim();
            String imagePath = "images/" + kartAdi + ".png";

            // İlgili ImageView'e resim yükle
            resimler[i].setImage(new Image(new FileInputStream(imagePath), 150, 200, false, false));
        }
    }

    public void clicked(MouseEvent mouseEvent) {
        try {
            final ImageView imageView = (ImageView) mouseEvent.getSource();
            int index = getImageViewIndex(imageView); // Kullanıcının tıkladığı kartın index'i
            SavasAraclari kullaniciKart = kullaniciKartlari.get(index);

            // Bilgisayar kartını rastgele seç
            int bilgisayarIndex = (int) (Math.random() * bilgisayarKartlari.size());
            SavasAraclari bilgisayarKart = bilgisayarKartlari.get(bilgisayarIndex);

            // Görselleri eşleştir
            ImageView bilgisayarImageView = getBilgisayarImageView(bilgisayarIndex);

            // Kartları karşılaştırma
            int kullaniciPuan = kullaniciKart.getGuc();
            int bilgisayarPuan = bilgisayarKart.getGuc();

            // Animasyon ve skoru güncelleme
            oynatAnimasyon(imageView, bilgisayarImageView, kullaniciPuan, bilgisayarPuan, kullaniciKart, bilgisayarKart);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getImageViewIndex(ImageView imageView) {
        ImageView[] kullaniciResimler = {kullanici_resim_1, kullanici_resim_2, kullanici_resim_3, kullanici_resim_4,
                kullanici_resim_5, kullanici_resim_6, kullanici_resim_7, kullanici_resim_8, kullanici_resim_9};

        for (int i = 0; i < kullaniciResimler.length; i++) {
            if (kullaniciResimler[i] == imageView) return i;
        }
        return -1;
    }

    private ImageView getBilgisayarImageView(int index) {
        ImageView[] bilgisayarResimler = {bilgisayar_resim_1, bilgisayar_resim_2, bilgisayar_resim_3, bilgisayar_resim_4,
                bilgisayar_resim_5, bilgisayar_resim_6, bilgisayar_resim_7, bilgisayar_resim_8, bilgisayar_resim_9};
        return bilgisayarResimler[index];
    }

    private void oynatAnimasyon(ImageView kullaniciImageView, ImageView bilgisayarImageView,
                                int kullaniciPuan, int bilgisayarPuan,
                                SavasAraclari kullaniciKart, SavasAraclari bilgisayarKart) {
        TranslateTransition transition1 = new TranslateTransition(Duration.seconds(0.3), kullaniciImageView);
        transition1.setToX(bilgisayarImageView.getLayoutX() - kullaniciImageView.getLayoutX());
        transition1.setToY(bilgisayarImageView.getLayoutY() - kullaniciImageView.getLayoutY());

        TranslateTransition transition2 = new TranslateTransition(Duration.seconds(0.3), bilgisayarImageView);
        transition2.setToX(kullaniciImageView.getLayoutX() - bilgisayarImageView.getLayoutX());
        transition2.setToY(kullaniciImageView.getLayoutY() - bilgisayarImageView.getLayoutY());

        transition1.play();
        transition2.play();

        transition1.setOnFinished(event -> {
            if (kullaniciPuan > bilgisayarPuan) {
                Init.kullanici.setSkor(Init.kullanici.getSkor() + 10);
                kullanici_skor.setText(String.valueOf(Init.kullanici.getSkor()));
                bilgisayarImageView.setVisible(false);
            } else if (kullaniciPuan < bilgisayarPuan) {
                Init.bilgisayar.setSkor(Init.bilgisayar.getSkor() + 10);
                bilgisayar_skor.setText(String.valueOf(Init.bilgisayar.getSkor()));
                kullaniciImageView.setVisible(false);
            } else {
                kullaniciImageView.setVisible(false);
                bilgisayarImageView.setVisible(false);
            }

            kullaniciKartlari.remove(kullaniciKart);
            bilgisayarKartlari.remove(bilgisayarKart);

            if (kullaniciKartlari.isEmpty() || bilgisayarKartlari.isEmpty()) {
                bitisIslemleri();
            }
        });
    }

    public void ResmiBuyut(MouseEvent mouseEvent) {
        ImageView imageView = (ImageView) mouseEvent.getSource();
        ScaleTransition transition = new ScaleTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(imageView);
        transition.setToX(1.15);
        transition.setToY(1.15);
        transition.play();
    }

    public void ResmiKucult(MouseEvent mouseEvent) {
        ImageView imageView = (ImageView) mouseEvent.getSource();
        ScaleTransition transition = new ScaleTransition();
        transition.setDuration(Duration.seconds(0.05));
        transition.setNode(imageView);
        transition.setToX(1.0);
        transition.setToY(1.0);
        transition.play();
    }

    public void bitisIslemleri() {
        boolean kazanmaDurumu = Init.kullanici.getSkor() > Init.bilgisayar.getSkor();
        Alert mesaj = new Alert(AlertType.INFORMATION);
        mesaj.setTitle("SONUÇ");

        if (Init.kullanici.getSkor() == Init.bilgisayar.getSkor()) {
            mesaj.setContentText("BERABERE!");
        } else if (kazanmaDurumu) {
            mesaj.setContentText("KAZANDINIZ!");
        } else {
            mesaj.setContentText("KAYBETTİNİZ!");
        }

        mesaj.show();
        mesaj.setOnHiding(dialogEvent -> Platform.exit());
    }
}