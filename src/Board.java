public class Board {

    private Field[] fields;
    private CardDeck carddeck;

    public Board(String[] fielddata, String[] carddata){
        fields = new Field[fielddata.length];
        createFields(fielddata);
        this.carddeck = new CardDeck(carddata);
    }

    private void createFields(String[] data){
        //Header - Id, FieldType, Label, Cost, Income, Series ID

        for(String s:data){
           String [] splitData = s.split(",");
           int ID = Integer.parseInt(splitData[0].trim());
            System.out.println(ID);
            String fieldType = splitData[1].trim().toLowerCase();
           String label = splitData[2].trim();
           int cost = Integer.parseInt(splitData[3].trim());
           int income = Integer.parseInt(splitData[4].trim());
           int seriesID = Integer.parseInt(splitData[5].trim());

           Field f = new Field(ID, label, cost, income);

           fields[ID-1] = f;

        }

    }

    public Field getField(int id){

        return fields[id-1];
    }
}
