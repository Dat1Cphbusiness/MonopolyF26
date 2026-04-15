public class Board {

    private Field[] fields;
    private CardDeck carddeck;


    public Board(String[] fielddata, String[] carddata){
        fields = new Field[fielddata.length];
        createFields(fielddata);
        this.carddeck = new CardDeck(carddata);
        // Chance.cardDeck = new CardDeck(carddata);
    }

    public Field[] getFields() {
        return fields;
    }

    private void createFields(String[] data){
        //Header - Id, FieldType, Label, Cost, Income, Series ID

        for(String s:data){
           String [] splitData = s.split(",");
           int ID = Integer.parseInt(splitData[0].trim());
           String fieldType = splitData[1].trim();

           String label = splitData[2].trim();
           int cost = Integer.parseInt(splitData[3].trim());
           int income = Integer.parseInt(splitData[4].trim());
           int seriesID = Integer.parseInt(splitData[5].trim());
            System.out.println(fieldType);
            Field f = null;

           switch(fieldType){
               case"StartField": f = new Start(ID, label, income);
                   break;
               case"Plot": f = new Plot(ID, label, income, cost, seriesID);
                   break;
               case"Chance": f = new Chance(ID, label);
                   break;
               case"Tax": f = new Tax(ID, label, cost);
                   break;
               case"ShippingLine": f = new ShippingLine(ID, label, cost, income, seriesID);
                   break;
               case"Visit": f = new Visit(ID, label);
                   break;
               case"Brewery": f = new Brewery(ID, label, cost, income, seriesID);
                   break;
               case"Parking": f = new Parking(ID, label);
                   break;
               case"Prison": f = new Prison(ID, label, cost);
                   break;
               default:
                   f = new Field(0, "", 0, 0);
                   System.out.println(ID+" No such type available");
           }

           fields[ID-1] = f;

        }

    }

    public Field getField(int id){

        return fields[id-1];
    }
}
