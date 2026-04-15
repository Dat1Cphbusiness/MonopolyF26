public class Prison extends Field implements IOption{

    public Prison(int ID, String label, int cost){
        super(ID, label, cost, 0);
    }

    @Override
    public String onAccept(Player p) {
        p.setWildcard(false);
        return "\n du har kontakter hos politiet og løslades";

    }

    @Override
    public String onReject(Player p) {
        p.imprison();
        String message = "\n Du er arresteret, og skal i fængsel";
        message += "\n Næste gang det bliver din tur, kan du vælge om du vil betale dig ud, eller prøve at slå et dobbeltslag." +
                "\n Når du har siddet over i tre omgange er du løsladt";
        return message;
    }

    @Override
    public String onLand(Player p){
        String message = super.onLand(p);
        message += "\n Du er arrresteret, og skal i fængsel";

        if (p.getWildcard()){
            setOption("PrisonWildcard");
            message += "\n Vil du bruge dit wildcard? (Y/N)";
        }
        else {
            p.imprison();
            message += "\n Næste gang det bliver din tur, kan du vælge om du vil betale dig ud, eller prøve at slå et dobbeltslag." +
                    "\n Når du har siddet over i tre omgange er du løsladt";
        }

        return message;

    }
}
