public class ShippingLine extends Property{
    public ShippingLine(int ID, String label, int cost, int income, int seriesID) {
        super(ID, label, cost, income, seriesID);
    }
    /*
    * Når et købstilbud accepteres, tjek om der er monopol på serien
    *  - indkomsten skal i så fald fordobles på dette og alle de øvrige redderier
    *
    * */
}
