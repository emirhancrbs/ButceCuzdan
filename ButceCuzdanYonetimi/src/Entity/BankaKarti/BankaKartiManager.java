package Entity.BankaKarti;

import Entity.Kullanici.Kullanici;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BankaKartiManager {
    public Boolean KartEkle(BankaKarti bankaKarti, String tc){
        String db_connect_url = "jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\db\\butcecuzdan.db";

        try {
            Connection baglanti = DriverManager.getConnection( db_connect_url );
            Statement sorgu_nesnesi = baglanti.createStatement();
            String sqlSorgu="INSERT INTO bankakarti(tc,ay,yil,cvc,banka,odeme,iban,kartno) VALUES ('"+tc+"','"
                    +bankaKarti.getSonKullanmaTarihiAy()+"','"
                    +bankaKarti.getSonKullanmaTarihiYil()+"','"
                    +bankaKarti.getCvc()+"','"
                    +bankaKarti.getBanka()+"','"
                    +bankaKarti.getOdemeYontemi()+"','"
                    +bankaKarti.getIban()+"','"
                    +bankaKarti.getKartNo() +"')";

            System.out.println(sqlSorgu);
            sorgu_nesnesi.executeUpdate(sqlSorgu);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
