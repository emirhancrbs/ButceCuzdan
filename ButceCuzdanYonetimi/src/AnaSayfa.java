import Entity.BankaKarti.BankaKarti;
import Entity.BankaKarti.BankaKartiManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.*;

public class AnaSayfa extends JFrame {
    private JPanel panel1;
    private JLabel lblKart;
    private JTabbedPane tabbedPane1;
    private JTextField kartNoTextField;
    private JTextField ibanTextField;
    private JComboBox bankaComboBox;
    private JTextField ayTextField;
    private JTextField yilTextField;
    private JButton ekleButton;
    private JButton silButton;
    private JTextField cvcTextField;
    private JComboBox ödemeComboBox;
    private JTabbedPane tabbedPane2;

    public AnaSayfa(String tc){

        add(panel1);
        Dimension ekranBoyutu = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(ozelOlcu(ekranBoyutu));
        setTitle("Bütçe Yönetim");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        lblKart.setHorizontalTextPosition(JLabel.CENTER);
        lblKart.setVerticalTextPosition(JLabel.CENTER);
        lblKart.setVisible(false);

        //combo boxa girilen itemleri bankanın enumundan çek
        ödemeComboBox.addItem("VISA");
        ödemeComboBox.addItem("MASTERCARD");
        ödemeComboBox.addItem("TROY");

        bankaComboBox.addItem("ZIRAAT_BANK");
        bankaComboBox.addItem("VAKIF_BANK");
        bankaComboBox.addItem("GARANTI_BANK");
        bankaComboBox.addItem("IS_BANK");
        bankaComboBox.addItem("YAPI_KREDI_BANK");
        bankaComboBox.addItem("AK_BANK");

        String db_connect_url = "jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\db\\butcecuzdan.db";
        try {
            Connection baglanti = DriverManager.getConnection( db_connect_url );
            Statement sorgu_nesnesi = baglanti.createStatement();
            ResultSet kullanici = sorgu_nesnesi.executeQuery("SELECT * FROM kullanicilar WHERE tc="+tc);
            ResultSet banka = sorgu_nesnesi.executeQuery("SELECT * FROM bankakarti WHERE tc="+tc);
            if(banka.next()){
             lblKart.setText("<html><br><pre><br>"+banka.getString("kartno")  +
            "<br>"+kullanici.getString("ad")+" "+kullanici.getString("soyad")+ "          "+banka.getString("ay")+"/"+banka.getString("yil")+"</pre></html>");
             lblKart.setVisible(true);
}
                   } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ekleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String Kartno = kartNoTextField.getText();
                int sktAy = Integer.parseInt(ayTextField.getText());
                int sktYil = Integer.parseInt(yilTextField.getText());
                int cvc = Integer.parseInt(cvcTextField.getText());
                String banka =  bankaComboBox.getSelectedItem().toString();
                String odeme = ödemeComboBox.getSelectedItem().toString();
                String iban = ibanTextField.getText();
                BankaKartiManager bankaKartiManager = new BankaKartiManager();

                BankaKarti bankaKarti = new BankaKarti(Kartno,sktAy,sktYil,cvc,banka,odeme,iban);
                bankaKartiManager.KartEkle(bankaKarti,tc);

            }
        });
    }
    private Dimension ozelOlcu(Dimension d) {
        return new Dimension(d.width / 2, d.height / 2);
    }


}
