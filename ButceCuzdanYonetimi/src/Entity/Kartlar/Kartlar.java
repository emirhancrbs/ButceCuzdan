package Entity.Kartlar;

public class Kartlar {
    private String KartNo;
    private String KartIsim;
    private String KartSoyIsim;
    private int SonKullanmaTarihiAy;
    private int SonKullanmaTarihiYil;
    private int Cvc;
    Banka banka;
    OdemeYontemi odemeYontemi;
    private String Iban;

    private enum Banka {
        VAKIF_BANK, ZIRAAT_BANK, IS_BANK, GARANTI_BANK, YAPI_KREDI_BANK, AK_BANK
    }
    private enum OdemeYontemi{
        VISA,
        MASTER_CARD,
        TROY
    }
    public Kartlar(String Kartno,int sktAy,int sktYil,int cvc,String banka,String odeme,String Iban){
        this.KartNo = Kartno;
        this.SonKullanmaTarihiAy=sktAy;
        this.SonKullanmaTarihiYil=sktYil;
        this.Cvc=cvc;
        this.banka= Banka.valueOf(banka);
        this.odemeYontemi= OdemeYontemi.valueOf(odeme);
        this.Iban=Iban;

    }


    public String getKartNo() {
        return KartNo;
    }

    public void setKartNo(String kartNo) {
        KartNo = kartNo;
    }

    public String getKartIsim() {
        return KartIsim;
    }

    public void setKartIsim(String kartIsim) {
        KartIsim = kartIsim;
    }

    public String getKartSoyIsim() {
        return KartSoyIsim;
    }

    public void setKartSoyIsim(String kartSoyIsim) {
        KartSoyIsim = kartSoyIsim;
    }

    public int getSonKullanmaTarihiAy() {
        return SonKullanmaTarihiAy;
    }

    public void setSonKullanmaTarihiAy(int sonKullanmaTarihiAy) {
        SonKullanmaTarihiAy = sonKullanmaTarihiAy;
    }

    public int getSonKullanmaTarihiYil() {
        return SonKullanmaTarihiYil;
    }

    public void setSonKullanmaTarihiYil(int sonKullanmaTarihiYil) {
        SonKullanmaTarihiYil = sonKullanmaTarihiYil;
    }

    public int getCvc() {
        return Cvc;
    }

    public void setCvc(int cvc) {
        Cvc = cvc;
    }

    public Banka getBanka() {
        return banka;
    }

    public void setBanka(Banka banka) {
        this.banka = banka;
    }

    public OdemeYontemi getOdemeYontemi() {
        return odemeYontemi;
    }

    public void setOdemeYontemi(OdemeYontemi odemeYontemi) {
        this.odemeYontemi = odemeYontemi;
    }

    public String getIban() {
        return Iban;
    }

    public void setIban(String iban) {
        Iban = iban;
    }
}
