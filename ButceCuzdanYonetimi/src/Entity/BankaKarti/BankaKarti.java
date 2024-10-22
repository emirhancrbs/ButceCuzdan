package Entity.BankaKarti;

import Entity.Kartlar.Kartlar;

public class BankaKarti extends Kartlar {


    private double Bakiye;

    public BankaKarti(String Kartno, int sktAy, int sktYil, int cvc, String banka, String odeme, String Iban) {
        super(Kartno, sktAy, sktYil, cvc, banka, odeme, Iban);

    }

    public double getBakiye() {
        return Bakiye;
    }

    public void setBakiye(double bakiye) {
        Bakiye = bakiye;
    }
}
