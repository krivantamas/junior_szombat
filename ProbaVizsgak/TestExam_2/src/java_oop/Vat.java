package java_oop;

public enum Vat {

    AUSTRIA(20),
    ESTONIA(20),
    GREECE(24),
    HUNGARY(27),
    LUXEMBOURG(17);

    public final int VAT_RATE;

    Vat(int vatRate) {
        this.VAT_RATE = vatRate;
    }
}
