public class Prison extends Field implements IOption {

    public Prison(int ID, String label, int cost) {
        super(ID, label, cost, 0);
    }

    @Override
    public String onAccept(Player p) {
        return "";
    }

    @Override
    public String onReject(Player p) {
        return "";
    }

    @Override
    public String onLand(Player p) {
        String msg = super.onLand(p) + "\n Du er arresteret, og skal i fængsel";
        return msg;
    }

    // Tjek om spilleren har wildcard
   p.getWildcard();


    String msg;

if(wildCard)

    {
        msg = "\n Vil du bruge dit wildcard? (Y/N)";
    } else

    {
        p.imprison();
        msg = "\n Næste gang det bliver din tur, kan duu vælge om du vil betale dig ud eller prøve at slå et dobbeltslag. Når du har siddet over i tre omgange er du løsladt.";

    }

      return msg;

}



}
