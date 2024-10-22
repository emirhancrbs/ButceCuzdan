import Entity.Kullanici.Kullanici;
import Entity.Kullanici.KullaniciManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GirisEkrani  extends JFrame{
    private JPanel panel1;
    private JTextField tfTcNo;
    private JButton btnkayit;
    private JPasswordField pfSifre;
    private JButton btnGiris;

    public GirisEkrani(){
        add(panel1);
        Dimension ekranBoyutu = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(ozelOlcu(ekranBoyutu));
        setTitle("Bütçe Yönetim");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        btnkayit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            KayiEkrani kayiEkrani = new KayiEkrani();
            kayiEkrani.setVisible(true);
                PencereKapat();

            }
        });
        btnGiris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                KullaniciManager kullaniciManager = new KullaniciManager();
                String tc = tfTcNo.getText();
                String sifre = Arrays.toString(pfSifre.getPassword());
                Kullanici kullanici = new Kullanici(tc,sifre);
                if (kullaniciManager.KullaniciGiris(kullanici)) {
                    AnaSayfa anaSayfa = new AnaSayfa(kullanici.getTc());
                    anaSayfa.setVisible(true);

                    PencereKapat();
                }else{
                    JOptionPane.showMessageDialog(panel1,
                            "Giriş Yapılamadı Lütfen Tekrar Deneyiniz.",
                            "Giriş Yapılamadı",
                            JOptionPane.ERROR_MESSAGE);
                    System.out.println("Giriş Yapılamadı.");
                }

            }
        });
    }

    private Dimension ozelOlcu(Dimension d) {
        return new Dimension(d.width / 2, d.height / 2);
    }
    private void PencereKapat(){
        this.setVisible(false);
    }

}
