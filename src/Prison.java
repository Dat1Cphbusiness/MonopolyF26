public class Prison extends Field implements IOption {

    public Prison(int ID, String label, int cost) {
        super(ID, label, cost, 0);
    }

    @Override
    public String onAccept(Player p) {
        p.setWildcard(false);
        String msg = "\n Du har kontakter hos Politiet og løslades";
        return msg;
    }



    @Override
    public String onReject(Player p) {
        p.imprision();
        return "\n Du er kommet i fængsel." +
                "\n Næste gang det bliver din tur, kan du vælge, om du vil betale dig ud eller prøve at slå et dobbeltslag." +
                "\n Når du har siddet over i tre omgange, er du løsladt.";
    }

    @Override
    public String onLand(Player p) {

        String msg = super.onLand(p);
        msg += "\n Du er arresteret, og skal i fængsel";

        if (p.getWildcard()) {
            return msg += "\n Vil du bruge dit Wildcard? (Y/N)";
        } else {
            p.imprision();
            return msg += "\n næste gange det bliver din tur, kan du vælge om du vil betale dig ud eller prøve at slå et dobbeltslag.\n" +
                    " Når du har siddet over i tre omgange er du løsladt";

        }

    }

}


