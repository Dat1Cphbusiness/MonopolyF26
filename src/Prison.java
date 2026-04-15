public class Prison extends Field implements IOption{

    public Prison(int ID, String label, int cost){
        super(ID, label, cost, 0);
    }

    @Override
    public String onAccept(Player p) {
        p.setWildcard(false);
        String msg = "Du har kontakter hos Politiet og løslades.";
        return msg;
    }

    @Override
    public String onReject(Player p) {
        p.imprison();
        String msg = "Du skal i fængsel. \n " +
                "Næste gang det bliver din tur, kan du vælge om du vil betale dig ud eller prøve at slå et dobbeltslag. " +
                "\nNår du har siddet over i tre omgange, er du løsladt";
        return msg;
    }

    @Override
    public String onLand(Player p){
        String message = super.onLand(p);
        message+= "Du er arresteret, og skal i fængsel";
        if(p.getWildcard()){
            message+= "Vil du bruge dit wildcard? Y/N";
        }else{
            p.imprison();
            message+= "Næste gang det bliver din tur, kan du vælge om du vil betale dig ud eller prøve at slå et dobbeltslag. " +
                    "\nNår du har siddet over i tre omgange, er du løsladt";
        }
        return message;
    }


}
