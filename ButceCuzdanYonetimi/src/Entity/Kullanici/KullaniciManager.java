package Entity.Kullanici;
import java.sql.*;

public class KullaniciManager  {

    public void KullaniciEkle(Kullanici kullanici) {

        String db_connect_url = "jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\db\\butcecuzdan.db";

        try {
            Connection baglanti = DriverManager.getConnection( db_connect_url );
            Statement sorgu_nesnesi = baglanti.createStatement();
            String sqlSorgu="INSERT INTO kullanicilar( tc , ad,soyad,sifre ) VALUES ('"+kullanici.getTc()+"','"+kullanici.getAd()+"','"+kullanici.getSoyad()+"','"+kullanici.getSifre()+"')";

            System.out.println(sqlSorgu);
            sorgu_nesnesi.executeUpdate(sqlSorgu);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean KullaniciGiris(Kullanici kullanici){
        String db_connect_url = "jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\db\\butcecuzdan.db";
        Connection baglanti = null;

        try {
            baglanti = DriverManager.getConnection( db_connect_url );
            Statement sorgu_nesnesi = baglanti.createStatement();
            ResultSet sonuc = sorgu_nesnesi.executeQuery("SELECT * FROM kullanicilar");


            while(sonuc.next()){

                if (sonuc.getString("tc").equals( kullanici.getTc()))
                {
                    if (sonuc.getString("sifre").equals(kullanici.getSifre())){
                        System.out.println(sonuc.getString("tc")+"   "+kullanici.getTc());
                        System.out.println(sonuc.getString("sifre")+"    "+kullanici.getSifre());
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }


}
