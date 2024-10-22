package Entity.KrediKarti;

import Entity.Kartlar.Kartlar;

public class KrediKarti extends Kartlar {
    private double AltLimit;

    public KrediKarti(String Kartno, int sktAy, int sktYil, int cvc, String banka, String odeme, String Iban,double altLimit) {
        super(Kartno, sktAy, sktYil, cvc, banka, odeme, Iban);
        this.AltLimit=altLimit;
    }

    public double getAltLimit() {
        return AltLimit;
    }

    public void setAltLimit(double altLimit) {
        AltLimit = altLimit;
    }


}
