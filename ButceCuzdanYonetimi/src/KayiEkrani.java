import Entity.Kullanici.Kullanici;
import Entity.Kullanici.KullaniciManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;

public class KayiEkrani extends JFrame {
    private JTextField tfKayitTcNo;
    private JTextField tfKayitAd;
    private JTextField tfKayitSoyAd;
    private JPasswordField tfKayitSifre;
    private JButton btnKayitKayitOl;
    private JPanel kayitEkrani;

    public KayiEkrani(){

        add(kayitEkrani);
        Dimension ekranBoyutu = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(ozelOlcu(ekranBoyutu));
        setTitle("Bütçe Yönetim");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);


        btnKayitKayitOl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GirisEkrani girisEkrani = new GirisEkrani();
                girisEkrani.setVisible(true);
                PencereKapat();

                String tc = tfKayitTcNo.getText();
                String ad = tfKayitAd.getText();
                String soyad = tfKayitSoyAd.getText();
                String sifre = Arrays.toString(tfKayitSifre.getPassword());

                KullaniciManager kullaniciManager = new KullaniciManager();

                Kullanici kullanici = new Kullanici(tc,ad,soyad,sifre);
                kullaniciManager.KullaniciEkle(kullanici);


            }
        });
    }
    private void PencereKapat(){
        this.setVisible(false);
    }
    private Dimension ozelOlcu(Dimension d) {
        return new Dimension(d.width / 2, d.height / 2);
    }
}
