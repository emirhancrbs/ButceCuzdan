package Entity.Kullanici;

public class Kullanici  {
    private String tc,ad,soyad,sifre;

    public Kullanici(String tc, String ad, String soyad, String sifre){
        this.sifre=sifre;
        this.ad=ad;
        this.soyad=soyad;
        this.tc=tc;
    }
    public Kullanici(String tc,String sifre){
        this.tc=tc;
        this.sifre=sifre;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
