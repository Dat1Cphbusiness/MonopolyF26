public class Prison extends Field implements IOption{

    private int ID;
    private String label;

    public Prison(int ID, String label){
        this.ID=ID;
        this.label=label;
    }

    @Override
    public String onAccept(Player p){
        return "test";
    }
    @Override
    public String onReject(Player p){
        return "test";
    }

}
