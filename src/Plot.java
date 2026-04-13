public class Plot extends Property{

    public Plot(int id, String label, int cost, int income, int seriesID) {
        super(id, label, cost, income, seriesID);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String onLand(Player player) {
        return super.onLand(player);

        // Man lander på en ejendom
        // Hvis ejeren er nuværende spiller, så er feltet monopolized
        // og giv mulighed for at bygge videre
    }


}
