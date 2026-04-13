public class Field {

    private String label;
    private int id;
    private int cost;
    private int income;
    private String option;

    public Field(int id, String label, int cost, int income){
        this.id = id;
        this.label = label;
        this.cost = cost;
        this.income = income;
    }

    @Override
    public String toString() {
        return id +", "+ label;
    }

    public String onLand(Player player){
        return player.getName() + " er landet på felt: "+ id + ", "+ label;

        // man lander på et land/property
        // hvis ejendom ikke har en ejer, SÅ giv nuværende spiller mulighed for at købe ejendom

        // ellers hvis ejedomsejer IKKE er nuværende spillers ejendom, så skal nuværende spiller
        //betale husleje til ejer
    }
}
