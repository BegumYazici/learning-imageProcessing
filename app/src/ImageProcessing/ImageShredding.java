package ImageProcessing;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageShredding {

    public static void main(String[] args) throws IOException {
        //Resim okunuyor
        FileInputStream fis = new FileInputStream("C:/Users/asus1/Desktop/android.jpg");
        BufferedImage image = ImageIO.read(fis);

        int satir = 10;
        int kolon = 10;
        int resimSayisi = satir * kolon;

        int yeniResimGenislik = image.getWidth() / kolon;
        int yeniResimYukseklik = image.getHeight() / satir;
        int resimNo = 0;
        BufferedImage imgs[] = new BufferedImage[resimSayisi];

        for (int x = 0; x < satir; x++) {
            for (int y = 0; y < kolon; y++) {

                imgs[resimNo] = new BufferedImage(yeniResimGenislik, yeniResimYukseklik, 1);

                Graphics2D gr = imgs[resimNo++].createGraphics();
                gr.drawImage(image, 0, 0, yeniResimGenislik, yeniResimYukseklik, yeniResimGenislik
                                * y, yeniResimYukseklik * x, yeniResimGenislik * y + yeniResimGenislik,
                        yeniResimYukseklik * x + yeniResimYukseklik, null);
                gr.dispose();
            }
        }
        System.out.println("Resim parcalandi");

        // Resimler dosyaya yaziliyor.
        for (int i = 0; i < imgs.length; i++) {
            ImageIO.write(imgs[i], "jpg", new File("C:/Users/asus1/Desktop/javaTest/img/img" + i + ".jpg"));
        }
        System.out.println("Islem tamamlandi");

        ImageIO.write(imgs[3], "jpg", new File("C:/Users/asus1/Desktop/javaTest/" + ".jpg"));
        System.out.println("Bir resim");

        //piksellere ayrılmış resimlerin her biri imgs[] dizisinin içerisindedir.
    }
}

